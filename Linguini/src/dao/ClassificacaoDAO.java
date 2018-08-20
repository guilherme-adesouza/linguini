/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Classificacao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 *
 * @author guilherme-souza
 */
public class ClassificacaoDAO extends GenericoDAO<Classificacao> implements SoftDelete{

    public MensagemRetorno excluir(int id){
        return this.inativar(id);
    }
    
    @Override
    public MensagemRetorno excluir(Classificacao c){
        return this.inativar((int) (c.getId()));
    }
    
    @Override
    public MensagemRetorno inativar(int id) {
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            Query query = sessao.createQuery("UPDATE Classificacao c SET c.situacao=false WHERE id = :idParam");
            int qtd = query.setParameter("idParam", (long) id).executeUpdate();

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
}
