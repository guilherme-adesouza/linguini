package dao;

import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import model.Grupo;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;
import utils.view.ComboItens;

/**
 * @author guilherme-souza
 */
public class GrupoDAO extends GenericoDAO<Grupo>{
    public void popularCombo(String tabela, JComboBox combo) {
        
        combo.addItem(itemSelecione());

        try {
            MensagemRetorno msg = this.consultarTodos("Grupo");
            if(msg.isSucesso()){
                for (Object object : msg.getLista()) {
                    Grupo c = (Grupo) object;
                    ComboItens item = new ComboItens();
                    item.setCodigo(c.getId());
                    item.setDescricao(c.getNome());
                    combo.addItem(item);
                }
                definirItemCombo(combo, itemSelecione());
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo Grupo = " + e.toString());
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
    
    public MensagemRetorno consultarPorNome(String nome){
        MensagemRetorno retorno = new MensagemRetorno();
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM Grupo g "
                                           + "WHERE g.nome = :nome");

            query.setString("nome", nome);
            retorno.setObjeto(query.uniqueResult());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally {
            sessao.close();
        }        
        return retorno;
    }
}
