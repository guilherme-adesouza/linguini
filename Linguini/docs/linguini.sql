--CREATE DATABASE linguini;

-- -----------------------------------------------------
-- Table "cidade"
-- -----------------------------------------------------
CREATE TABLE  "cidade" (
  "id" INT NOT NULL,
  "nome" VARCHAR(45) NOT NULL,
  "situacao" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "telefone"
-- -----------------------------------------------------
CREATE TABLE  "telefone" (
  "id" INT NOT NULL,
  "telefone" VARCHAR(45) NOT NULL,
  "descricao" VARCHAR(150) NULL,
  "situacao" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "pessoa"
-- -----------------------------------------------------
CREATE TABLE  "pessoa" (
  "id" INT NOT NULL ,
  "telefone_id" INT NOT NULL,
  "cidade_id" INT NOT NULL,
  "nome" VARCHAR(150) NOT NULL,
  "logradouro" VARCHAR(150) NULL,
  "bairro" VARCHAR(150) NULL,
  "numero" INT NULL,
  "complemento" VARCHAR(150) NULL,
  "observacao" VARCHAR(150) NULL,
  "situacao" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_cliente_telefone1"
    FOREIGN KEY ("telefone_id")
    REFERENCES "telefone" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_cliente_cidade1"
    FOREIGN KEY ("cidade_id")
    REFERENCES "cidade" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "grupo"
-- -----------------------------------------------------
CREATE TABLE  "grupo" (
  "id" INT NOT NULL ,
  "descricao" VARCHAR(60) NOT NULL,
  "modulo_financeiro" BOOLEAN NOT NULL,
  "modulo_gestao" BOOLEAN NOT NULL,
  "modulo_caixa" BOOLEAN NOT NULL,
  "modulo_cozinha" BOOLEAN NOT NULL,
  "modulo_atendente" BOOLEAN NOT NULL,
  "modulo_admin" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "usuario"
-- -----------------------------------------------------
CREATE TABLE  "usuario" (
  "id" INT NOT NULL ,
  "grupo_id" INT NOT NULL,
  "nome" VARCHAR(150) NOT NULL,
  "senha" VARCHAR(150) NOT NULL,
  "situacao" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_usuario_grupo1"
    FOREIGN KEY ("grupo_id")
    REFERENCES "grupo" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "funcionario"
-- -----------------------------------------------------
CREATE TABLE  "funcionario" (
  "pessoa_id" INT NOT NULL,
  "usuario_id" INT NOT NULL,
  "cpf" VARCHAR(45) NOT NULL,
  "salario" DECIMAL(10,2) NULL,
  PRIMARY KEY ("pessoa_id"),
  CONSTRAINT "fk_funcionario_pessoa1"
    FOREIGN KEY ("pessoa_id")
    REFERENCES "pessoa" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_funcionario_usuario1"
    FOREIGN KEY ("usuario_id")
    REFERENCES "usuario" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "fornecedor"
-- -----------------------------------------------------
CREATE TABLE  "fornecedor" (
  "id" INT NOT NULL,
  "nome_fantasia" VARCHAR(45) NOT NULL,
  "razao_social" VARCHAR(45) NULL,
  "cnpj" CHAR(14) NULL,
  "situacao" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "classificacao"
-- -----------------------------------------------------
CREATE TABLE  "classificacao" (
  "id" INT NOT NULL ,
  "classificacao" VARCHAR(150) NOT NULL,
  "situacao" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "produto"
-- -----------------------------------------------------
CREATE TABLE  "produto" (
  "id" INT NOT NULL ,
  "classificacao_id" INT NOT NULL,
  "fornecedor_id" INT NOT NULL,
  "descricao" VARCHAR(500) NOT NULL,
  "valor" DECIMAL(10,2) NOT NULL,
  "quantidade" INT NOT NULL,
  "tempo_preparo" INT NOT NULL,
  "cozinha" BOOLEAN NOT NULL,
  "estoque_minimo" INT NOT NULL,
  "insumo" BOOLEAN NOT NULL,
  "unidade_medida" CHAR(3) NULL,
  "valor_promocao" DECIMAL(10,2) NULL,
  "data_fim_promocao" DATE NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_produto_classificacao"
    FOREIGN KEY ("classificacao_id")
    REFERENCES "classificacao" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_produto_fornecedor1"
    FOREIGN KEY ("fornecedor_id")
    REFERENCES "fornecedor" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "entregador"
-- -----------------------------------------------------
CREATE TABLE  "entregador" (
  "pessoa_id" INT NOT NULL,
  "placa" CHAR(7) NOT NULL,
  PRIMARY KEY ("pessoa_id"),
  CONSTRAINT "fk_entregador_pessoa1"
    FOREIGN KEY ("pessoa_id")
    REFERENCES "pessoa" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "pedido"
-- -----------------------------------------------------
CREATE TABLE  "pedido" (
  "id" INT NOT NULL ,
  "pessoa_id" INT NULL,
  "caixa_id" INT NOT NULL,
  "atendente_id" INT NOT NULL,
  "entregador_pessoa_id" INT NULL,
  "data_hora" TIMESTAMP NOT NULL,
  "data_hora_fechado" TIMESTAMP NULL,
  "valor" DECIMAL(10,2) NOT NULL,
  "mesa" INT NULL,
  "logradouro" VARCHAR(150) NULL,
  "bairro" VARCHAR(150) NULL,
  "complemento" VARCHAR(150) NULL,
  "numero" INT NULL,
  "tempo_deslocamento" INT NULL,
  "status" CHAR(1) NULL,
  "observacao" TEXT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_pedido_pessoa1"
    FOREIGN KEY ("pessoa_id")
    REFERENCES "pessoa" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_pedido_usuario1"
    FOREIGN KEY ("caixa_id")
    REFERENCES "usuario" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_pedido_usuario2"
    FOREIGN KEY ("atendente_id")
    REFERENCES "usuario" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_pedido_entregador1"
    FOREIGN KEY ("entregador_pessoa_id")
    REFERENCES "entregador" ("pessoa_id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "item_pedido"
-- -----------------------------------------------------
CREATE TABLE  "item_pedido" (
  "pedido_id" INT NOT NULL,
  "produto_id" INT NOT NULL,
  "valor" DECIMAL(10,2) NOT NULL,
  "quantidade" INT NOT NULL,
  "desconto" DECIMAL(10,2) NULL,
  PRIMARY KEY ("pedido_id", "produto_id"),
  CONSTRAINT "fk_pedido_has_produto_pedido1"
    FOREIGN KEY ("pedido_id")
    REFERENCES "pedido" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_pedido_has_produto_produto1"
    FOREIGN KEY ("produto_id")
    REFERENCES "produto" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "auditoria"
-- -----------------------------------------------------
CREATE TABLE  "auditoria" (
  "id" INT NOT NULL ,
  "usuario_id" INT NOT NULL,
  "ip" VARCHAR(50) NOT NULL,
  "sql" TEXT NOT NULL,
  "data_hora" TIMESTAMP NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_auditoria_usuario1"
    FOREIGN KEY ("usuario_id")
    REFERENCES "usuario" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "entrada"
-- -----------------------------------------------------
CREATE TABLE  "entrada" (
  "id" INT NOT NULL,
  "produto_id" INT NOT NULL,
  "quantidade" INT NOT NULL,
  "data" DATE NOT NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_entrada_produto1"
    FOREIGN KEY ("produto_id")
    REFERENCES "produto" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "forma_pagamento"
-- -----------------------------------------------------
CREATE TABLE  "forma_pagamento" (
  "id" INT NOT NULL ,
  "descricao" VARCHAR(150) NOT NULL,
  "prazo" INT NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "contas_receber"
-- -----------------------------------------------------
CREATE TABLE  "contas_receber" (
  "id" INT NOT NULL ,
  "pedido_id" INT NOT NULL,
  "forma_pagamento_id" INT NOT NULL,
  "valor_final" DECIMAL(10,2) NOT NULL,
  "data_prevista" DATE NOT NULL,
  "data_pagamento" DATE NULL,
  "desconto" DECIMAL(10,2) NULL,
  "acrescimo" DECIMAL(10,2) NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_contas_receber_pedido1"
    FOREIGN KEY ("pedido_id")
    REFERENCES "pedido" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_contas_receber_forma_pagamento1"
    FOREIGN KEY ("forma_pagamento_id")
    REFERENCES "forma_pagamento" ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "cozinha"
-- -----------------------------------------------------
CREATE TABLE  "cozinha" (
  "id" INT NOT NULL,
  "capacidade" INT NOT NULL,
  PRIMARY KEY ("id"));


DROP SEQUENCE IF EXISTS "pessoa_id_sequence";
CREATE SEQUENCE  "pessoa_id_sequence";
ALTER TABLE "pessoa" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"pessoa_id_sequence"');
DROP SEQUENCE IF EXISTS "grupo_id_sequence";
CREATE SEQUENCE  "grupo_id_sequence";
ALTER TABLE "grupo" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"grupo_id_sequence"');
DROP SEQUENCE IF EXISTS "usuario_id_sequence";
CREATE SEQUENCE  "usuario_id_sequence";
ALTER TABLE "usuario" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"usuario_id_sequence"');
DROP SEQUENCE IF EXISTS "classificacao_id_sequence";
CREATE SEQUENCE  "classificacao_id_sequence";
ALTER TABLE "classificacao" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"classificacao_id_sequence"');
DROP SEQUENCE IF EXISTS "produto_id_sequence";
CREATE SEQUENCE  "produto_id_sequence";
ALTER TABLE "produto" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"produto_id_sequence"');
DROP SEQUENCE IF EXISTS "pedido_id_sequence";
CREATE SEQUENCE  "pedido_id_sequence";
ALTER TABLE "pedido" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"pedido_id_sequence"');
DROP SEQUENCE IF EXISTS "auditoria_id_sequence";
CREATE SEQUENCE  "auditoria_id_sequence";
ALTER TABLE "auditoria" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"auditoria_id_sequence"');
DROP SEQUENCE IF EXISTS "forma_pagamento_id_sequence";
CREATE SEQUENCE  "forma_pagamento_id_sequence";
ALTER TABLE "forma_pagamento" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"forma_pagamento_id_sequence"');
DROP SEQUENCE IF EXISTS "contas_receber_id_sequence";
CREATE SEQUENCE  "contas_receber_id_sequence";
ALTER TABLE "contas_receber" ALTER COLUMN "id" SET DEFAULT NEXTVAL('"contas_receber_id_sequence"');
