package dao;

import java.util.List;
import javax.swing.JComboBox;
import model.Botoes;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;
import view.ComboItens;

/**
 * @author guilherme-souza
 */
public class BotaoDAO extends GenericoDAO<Botoes>{
    
    
    public MensagemRetorno consultarPorTela(int idTela, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela+" WHERE telas_id = :idParam");

            query.setInteger("idParam", idTela);
            
            retorno.setLista((List) query.list());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally {
            sessao.close();
        }

        return retorno;
    }
    
    
    public void popularCombo(int idTela, String tabela, JComboBox combo) {
        
        combo.addItem(itemSelecione());

        try {
            MensagemRetorno msg = this.consultarPorTela(idTela, "Botoes");
            if(msg.isSucesso()){
                for (Object object : msg.getLista()) {
                    Botoes c = (Botoes) object;
                    ComboItens item = new ComboItens();
                    item.setCodigo(c.getId());
                    item.setDescricao(c.getNome());
                    combo.addItem(item);
                }
                definirItemCombo(combo, itemSelecione());
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo Tela = " + e.toString());
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
}
