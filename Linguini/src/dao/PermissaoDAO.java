package dao;

import model.Permissao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistence.HibernateUtil;

/**
 * @author guilherme-souza
 */
public class PermissaoDAO extends GenericoDAO<Permissao> {
    
    public MensagemRetorno consultarPorGrupo(int idGrupo, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela+" WHERE grupo_id = :idParam");

            query.setInteger("idParam", idGrupo);
            
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
    
//    public void popularCombo(String tabela, JComboBox combo) {
//        
//        combo.addItem(itemSelecione());
//
//        try {
//            MensagemRetorno msg = this.consultarTodos("Cidade");
//            if(msg.isSucesso()){
//                for (Object object : msg.getLista()) {
//                    Permissao c = (Permissao) object;
//                    ComboItens item = new ComboItens();
//                    item.setCodigo(c.getId());
//                    item.setDescricao(c.getNome());
//                    combo.addItem(item);
//                }
//                definirItemCombo(combo, itemSelecione());
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao popular Combo Cidade = " + e.toString());
//            e.printStackTrace();
//        }
//    }
//
//    public void definirItemCombo(JComboBox combo, ComboItens item) {
//        for (int i = 0; i < combo.getItemCount(); i++) {
//            if (((ComboItens) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
//                combo.setSelectedIndex(i);
//                return;
//            }
//        }
//    }
//    
//    public void limpaSelecao(JComboBox combo) {
//        combo.setSelectedItem(itemSelecione());
//    }
//    
//    private ComboItens itemSelecione() {
//        ComboItens item = new ComboItens();
//        item.setCodigo(0);
//        item.setDescricao("Selecione");
//        return item;
//    }
}
