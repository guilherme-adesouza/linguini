package dao;

import model.ItemPedido;
import org.hibernate.HibernateException;
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

}
