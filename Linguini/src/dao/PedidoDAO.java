package dao;

import java.util.List;
import javax.swing.JComboBox;
import model.Pedido;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;
import utils.controller.GeradorLog;
import utils.view.ComboItens;

/**
 * @author guilherme-souza
 */
public class PedidoDAO extends GenericoDAO<Pedido> {

    public MensagemRetorno consultarComandas(String tabela) {

        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();

            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela + " WHERE mesa is not null and situacao = true and data_hora_fechado is null");

            //query.setInteger("idParam", pedido);
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

    public void popularCombo(String tabela, JComboBox combo) {

        combo.addItem("Selecione");
        combo.addItem(1);
        combo.addItem(2);
        combo.addItem(3);
        combo.addItem(4);
        combo.addItem(5);
        combo.addItem(6);
        combo.addItem(7);
        combo.addItem(8);

        try {
            MensagemRetorno msg = this.consultarComandas(tabela);
            for (Object object : msg.getLista()) {
                Pedido p = (Pedido) object;
                for (int i = 0; i < combo.getItemCount(); i++) {
                    if (combo.getItemAt(i) == p.getMesa()) {
                        combo.removeItemAt(i);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo Pedido = " + e.toString());
            e.printStackTrace();
        }
    }

    public void definirItemCombo(JComboBox combo, ComboItens item) {
        for (int i = 0; i < combo.getItemCount(); i++) {
            if (((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
                combo.setSelectedIndex(i);
                return;
            }
        }
    }

    public void limpaSelecao(JComboBox combo) {
        combo.setSelectedItem(itemSelecione());
    }

    private ComboItens itemSelecione() {
        ComboItens item = new ComboItens();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        return item;
    }

    public MensagemRetorno consultarAtivosComCriterioAberto(String tabela, String[] camposPesquisa, String valor, String pago, String orderBy) {

        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            String order = " id";
            if(pago.equals("todos")){
                pago="situacao=true";
            }
            if(pago.equals("pago")){
                pago="data_hora_fechado is not null";
            }
            if(pago.equals("npago")){
                pago="data_hora_fechado is null";
            }
            
            if (orderBy != null && !orderBy.isEmpty()) {
                order = orderBy;
            }
            if (valor.equals("Delivery")) {
                org.hibernate.Query q = sessao.createQuery("FROM " + tabela + " WHERE entregador_pessoa_id is not null and situacao=true and "+pago+" ORDER BY " + order);
                retorno.setLista((List) q.list());
            } else if (valor.equals("mesa")) {
                org.hibernate.Query q = sessao.createQuery("FROM " + tabela + " WHERE mesa is not null and situacao=true and "+pago+" ORDER BY " + order);
                retorno.setLista((List) q.list());
            } else {
                org.hibernate.Query q = sessao.createQuery("FROM " + tabela + " WHERE situacao=true and "+pago+" ORDER BY " + order);
                retorno.setLista((List) q.list());
            }
            //retorno.setLista((List) q.list());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            new GeradorLog(he);
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }

}
