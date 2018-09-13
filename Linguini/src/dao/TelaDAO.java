package dao;

import javax.swing.JComboBox;
import model.Telas;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;
import view.ComboItens;

/**
 * @author guilherme-souza
 */
public class TelaDAO extends GenericoDAO<Telas>{
    
   
    public MensagemRetorno consultarPorNome(String nomeTela, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela+" WHERE tela = :nomeTelaParam");

            query.setString("nomeTelaParam", nomeTela);
            
            retorno.setObjeto((Object) query.uniqueResult());
            retorno.setSucesso(true);
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        }finally {
            sessao.close();
        }

        return retorno;
    }
    
    
    public void popularCombo(String tabela, JComboBox combo) {
        
        combo.addItem(itemSelecione());

        try {
            MensagemRetorno msg = this.consultarTodos("Telas");
            if(msg.isSucesso()){
                for (Object object : msg.getLista()) {
                    Telas c = (Telas) object;
                    ComboItens item = new ComboItens();
                    item.setCodigo(c.getId());
                    item.setDescricao(c.getTela());
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
