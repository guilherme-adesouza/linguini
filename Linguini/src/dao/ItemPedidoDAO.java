package dao;

import java.util.List;
import model.ItemPedido;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

/**
 * @author guilherme-souza
 */
public class ItemPedidoDAO extends GenericoDAO<ItemPedido> {

    public MensagemRetorno salvarItem(Object o) {

        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);

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

    public MensagemRetorno consultarPedidoProduto(String tabela, int pedido, int produto) {

        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela + " WHERE pedido_id = :idParam and produto_id = :idPParam");

            query.setInteger("idParam", pedido);
            query.setInteger("idPParam", produto);

            retorno.setObjeto((Object) query.uniqueResult());
            if (retorno.getObjeto() != null) {
                retorno.setSucesso(true);
            }
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }

        return retorno;
    }

    public MensagemRetorno consultarPorIdTodos(String tabela, int id) {

        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();

            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela + " WHERE pedido_id = :idParam");

            query.setInteger("idParam", id);

            retorno.setLista((List) query.list());
            if (retorno.getObjeto() != null) {
                retorno.setSucesso(true);
            }
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }

        return retorno;
    }

}
