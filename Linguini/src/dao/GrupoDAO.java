package dao;

import javax.swing.JComboBox;
import model.Grupo;
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
}
