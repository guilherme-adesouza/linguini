-- https://www.postgresql.org/docs/9.0/static/functions-info.html


-- PASSO A PASSO
-- CRIAR UM USUÁRIO user COM MENOS PERMISSÕES PARA ACESSAR O BD
-- CRIAR TABELA NO BANCO PARA GUARDAR AS INFORMAÇÕES E PODER DESATIVAR OPERAÇÃO
-- CRIAR 


CREATE schema audit;
REVOKE CREATE ON schema audit FROM public;
 
CREATE TABLE audit.logged_actions (
    schema_name text NOT NULL,
    TABLE_NAME text NOT NULL,
    user_name text,
    action_tstamp TIMESTAMP WITH TIME zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    action TEXT NOT NULL CHECK (action IN ('I','D','U')),
    original_data text,
    new_data text,
    query text
) WITH (fillfactor=100);
 
REVOKE ALL ON audit.logged_actions FROM public;
 
-- You may wish to use different permissions; this lets anybody
-- see the full audit data. In Pg 9.0 and above you can use column
-- permissions for fine-grained control.
GRANT SELECT ON audit.logged_actions TO public;
 
CREATE INDEX logged_actions_schema_table_idx 
ON audit.logged_actions(((schema_name||'.'||TABLE_NAME)::TEXT));
 
CREATE INDEX logged_actions_action_tstamp_idx 
ON audit.logged_actions(action_tstamp);
 
CREATE INDEX logged_actions_action_idx 
ON audit.logged_actions(action);
 
--
-- Now, define the actual trigger function:
--

CREATE OR REPLACE FUNCTION audit.if_modified_func() RETURNS TRIGGER AS $body$
DECLARE
    v_old_data TEXT;
    v_new_data TEXT;
BEGIN
    IF (SELECT auditoria FROM public.cozinha WHERE id=1) THEN
        IF (TG_OP = 'UPDATE') THEN
            v_old_data := ROW(OLD.*);
            v_new_data := ROW(NEW.*);
            INSERT INTO audit.logged_actions (schema_name,table_name,user_name,action,original_data,new_data,query) 
            VALUES (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,session_user::TEXT,substring(TG_OP,1,1),v_old_data,v_new_data, current_query());
            RETURN NEW;
        ELSIF (TG_OP = 'DELETE') THEN
            v_old_data := ROW(OLD.*);
            INSERT INTO audit.logged_actions (schema_name,table_name,user_name,action,original_data,query)
            VALUES (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,session_user::TEXT,substring(TG_OP,1,1),v_old_data, current_query());
            RETURN OLD;
        ELSIF (TG_OP = 'INSERT') THEN
            v_new_data := ROW(NEW.*);
            INSERT INTO audit.logged_actions (schema_name,table_name,user_name,action,new_data,query)
            VALUES (TG_TABLE_SCHEMA::TEXT,TG_TABLE_NAME::TEXT,session_user::TEXT,substring(TG_OP,1,1),v_new_data, current_query());
            RETURN NEW;
        ELSE
            RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - Other action occurred: %, at %',TG_OP,now();
            RETURN NULL;
        END IF;
    ELSE 
        RETURN NULL;
    END IF; 
EXCEPTION
    WHEN data_exception THEN
        RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - UDF ERROR [DATA EXCEPTION] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
    WHEN unique_violation THEN
        RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - UDF ERROR [UNIQUE] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
    WHEN OTHERS THEN
        RAISE WARNING '[AUDIT.IF_MODIFIED_FUNC] - UDF ERROR [OTHER] - SQLSTATE: %, SQLERRM: %',SQLSTATE,SQLERRM;
        RETURN NULL;
END;
$body$
LANGUAGE plpgsql
SECURITY DEFINER
SET search_path = pg_catalog, audit;
 
--
-- To add this trigger to a table, use:
-- CREATE TRIGGER tablename_audit
-- AFTER INSERT OR UPDATE OR DELETE ON tablename
-- FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();
--
-- To add this trigger to a table, use:
CREATE TRIGGER pessoa_audit
AFTER INSERT OR UPDATE OR DELETE ON pessoa
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();


CREATE TRIGGER classificacao_audit
AFTER INSERT OR UPDATE OR DELETE ON classificacao
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER funcionario_audit
AFTER INSERT OR UPDATE OR DELETE ON funcionario
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER cidade_audit
AFTER INSERT OR UPDATE OR DELETE ON cidade
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER fornecedor_audit
AFTER INSERT OR UPDATE OR DELETE ON fornecedor
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();

CREATE TRIGGER cozinha_audit
AFTER INSERT OR UPDATE OR DELETE ON cozinha
FOR EACH ROW EXECUTE PROCEDURE audit.if_modified_func();
