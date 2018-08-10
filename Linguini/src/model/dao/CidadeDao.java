package model.dao;

import model.Cidade;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 *
 * @author VitinNote
 */
public class CidadeDao {

    public void salvarAtualizar(Cidade cidade) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            
                sessao.merge(cidade);

          
            sessao.persist(cidade);
            t.commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
    }
}
