/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Fornecedor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 *
 * @author VitinNote
 */
public class FornecedorDAO extends GenericoDAO<Fornecedor> implements SoftDelete {

    @Override
    public MensagemRetorno inativar(int id) {
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            Query query = sessao.createQuery("UPDATE Fornecedore f SET f.situacao=false WHERE id = :idParam");
            int qtd = query.setParameter("idParam", (long) id).executeUpdate();
            t.commit();
            retorno.setSucesso(true);
            retorno.setMensagem("Registro excluído com sucesso!");
        } catch (HibernateException he) {
            new GeradorLog(he.getMessage());
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
}
