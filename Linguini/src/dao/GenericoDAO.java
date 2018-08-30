/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import persistence.HibernateUtil;
import utils.Sessao;

/**
 *
 * @author guilherme-souza
 * @param <Object>
 */
public class GenericoDAO<Object> {
    
    public MensagemRetorno salvar(Object o) {

        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);

            sessao.saveOrUpdate(o);
            t.commit();

            retorno.setSucesso(true);
            retorno.setMensagem("Salvo com sucesso!");
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public MensagemRetorno excluir(Object o) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);
            
            sessao.delete(o);
            t.commit();
            retorno.setSucesso(true);
            retorno.setMensagem("Registro excluído com sucesso!");
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public MensagemRetorno excluir(int id, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);
            
            Query query = sessao.createQuery("DELETE FROM " + tabela+" WHERE id = :idParam");
            query.setInteger("idParam", id).executeUpdate();
            t.commit();
            
            retorno.setSucesso(true);
            retorno.setMensagem("Registro excluído com sucesso!");
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public MensagemRetorno consultarTodos(String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {            
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela);

            retorno.setLista((List) query.list());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        
        return retorno;
    }

    public MensagemRetorno atualizar(Object o) {

        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);

            sessao.update(o);
            t.commit();

            retorno.setSucesso(true);

        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }

    public MensagemRetorno consultarPorId(int id, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela+" WHERE id = :idParam");

            query.setInteger("idParam", id);
            
            retorno.setObjeto((Object) query.uniqueResult());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally {
            sessao.close();
        }

        return retorno;
    }
    
    
    public MensagemRetorno consultarComCriterio(String tabela, String campoPesquisa, String valor){
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("FROM " +tabela+" WHERE "+campoPesquisa+" LIKE :campoPesquisa");
            
            q.setString("campoPesquisa", "%"+valor+"%");
            
            retorno.setLista((List) q.list());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally{
            sessao.close();
        }

        return retorno;    
    }
    
    public MensagemRetorno consultarComCriterio(String tabela, String[] camposPesquisa, String valor, String orderBy){
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String camposPesquisados = "";
            for(int i=0; i < camposPesquisa.length; i++) {
                if(i>0){
                    camposPesquisados +=" OR ";
                }
                camposPesquisados += "UPPER("+camposPesquisa[i]+") LIKE UPPER(:campoPesquisa)";
            }
            
            String order = " id";

            if(orderBy != null && !orderBy.isEmpty()){
                order = orderBy;
            }
            org.hibernate.Query q = sessao.createQuery("FROM " +tabela+" WHERE "+camposPesquisados+" ORDER BY "+order);
            
            q.setString("campoPesquisa", "%"+valor+"%");
            
            retorno.setLista((List) q.list());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally{
            sessao.close();
        }
        return retorno;    
    }    
    
    public MensagemRetorno consultarAtivosComCriterio(String tabela, String[] camposPesquisa, String valor, String orderBy){
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String camposPesquisados = " AND (";
            for(int i=0; i < camposPesquisa.length; i++) {
                if(i>0){
                    camposPesquisados +=" OR ";
                }
                camposPesquisados += "UPPER("+camposPesquisa[i]+") LIKE UPPER(:campoPesquisa)";
            }
            camposPesquisados += ")";
            
            String order = " id";

            if(orderBy != null && !orderBy.isEmpty()){
                order = orderBy;
            }
            org.hibernate.Query q = sessao.createQuery("FROM " +tabela+" WHERE situacao=:situacao "+camposPesquisados+" ORDER BY "+order);
            
            q.setString("campoPesquisa", "%"+valor+"%");
            q.setBoolean("situacao", true);
            
            retorno.setLista((List) q.list());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally{
            sessao.close();
        }
        return retorno;    
    }  
    
    public void setParametroSessao(Session sessao){
        sessao.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                CallableStatement call = connection.prepareCall("{ call set_session_user(?) }");
                call.setLong(1, Sessao.getUsuario().getId());
                call.execute();
            }
        });
    }
}
