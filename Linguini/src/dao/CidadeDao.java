package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Cidade;
import java.util.List;
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
            //Transaction t = sessao.beginTransaction();
            sessao.getTransaction().begin();
            if (cidade.getId() != null) {
                //carrego os dados da cidade
                cidade = (Cidade) sessao.merge(cidade);
            }
            //salva
            cidade.setSituacao(true);
            sessao.persist(cidade);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

    }

    public void excluir(Cidade cidade) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            //Transaction t = sessao.beginTransaction();
            sessao.getTransaction().begin();
            cidade = (Cidade) sessao.merge(cidade);
            cidade.setSituacao(false);
            sessao.persist(cidade);
            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

    }

    public List<Cidade> pesquisar(Cidade cidade) {
        //tem um pequeno bug
        List resultado = null;
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            //1=1 para não precisar ficar verifcando se já foi colocado o where ou não
            StringBuilder q = new StringBuilder(" from Cidade c "
                    + "where 1 = 1");
            if (cidade.getId() != null) {
                q.append(" and c.id = :id");
            }
            if (cidade.getNome() != null && !cidade.getNome().equals("")) {
                q.append(" and c.nome like :nome");
            }
            org.hibernate.Query sql = sessao.createQuery(q.toString());
            if (cidade.getId() != null) {
                sql.setParameter("id", cidade.getId());
            }

            if (cidade.getNome() != null && !cidade.getNome().equals("")) {
                sql.setParameter("nome", "%" + cidade.getNome());
            }
            return sql.list();

//            for (Object o : resultado) {
//                Cidade s = (Cidade) o;
//                System.out.print("id: " + s.getId() + " ");
//                System.out.println("nome: " + s.getNome());
//            }
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }
}
