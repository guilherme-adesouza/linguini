/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

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

            sessao.save(o);
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

            sessao.delete(o);
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
    
    //Soft Delete
    public MensagemRetorno excluir(SoftDelete o){
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            
            o.inativar();
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

        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally{
            sessao.close();
        }

        return retorno;    
    }
}
