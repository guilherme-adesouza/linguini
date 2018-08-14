package dao;

import model.Cidade;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import persistence.HibernateUtil;

/**
 *
 * @author VitinNote
 */
public class CidadeDao{

       
    public void salvarAtualizar(Cidade cidade) {

        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            //Transaction t = sessao.beginTransaction();
            sessao.getTransaction().begin();
            if (cidade.getCodCidade() != 0) {
                //carrego os dados da cidade
                cidade = (Cidade) sessao.merge(cidade);
            }
            //salva
            sessao.persist(cidade);

            sessao.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

    }

    public void excluirD(Cidade cidade) {
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
                    + "where situacao = true");
            if (cidade.getCodCidade() != 0) {
                q.append(" and c.id = :id");
            }
            if (cidade.getNome() != null && !cidade.getNome().equals("")) {
                q.append(" and c.nome like :nome");
            }
            q.append(" order by nome");
            org.hibernate.Query sql = sessao.createQuery(q.toString());
            if (cidade.getCodCidade() != 0) {
                sql.setParameter("id", cidade.getCodCidade());
            }

            if (cidade.getNome() != null && !cidade.getNome().equals("")) {
                sql.setParameter("nome", "%" + cidade.getNome() + "%");
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
