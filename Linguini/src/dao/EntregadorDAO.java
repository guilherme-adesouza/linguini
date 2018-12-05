package dao;

import javax.swing.JComboBox;
import model.Entregador;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;
import utils.view.ComboItens;

/**
 * @author guilherme-souza
 */
public class EntregadorDAO extends GenericoDAO<Entregador>{
    
    @Override
    public MensagemRetorno salvar(Entregador entregador){
        MensagemRetorno retorno = new PessoaDAO().salvar(entregador.getPessoa());
        Session sessao = null;
        if(retorno.isSucesso()){
            try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);

            sessao.saveOrUpdate(entregador);
            t.commit();

            retorno.setSucesso(true);
            retorno.setMensagem("Salvo com sucesso!");
            } catch (HibernateException he) {
                retorno.setMensagem(he.getMessage());
                he.printStackTrace();
            } finally {
                sessao.close();
            }
        }      
        return retorno; 
    }
    
    @Override
    public MensagemRetorno excluir(int id, String tabela){
        return new PessoaDAO().excluir(id);
    }
    
    @Override
    public MensagemRetorno excluir(Entregador entregador){
        return new PessoaDAO().excluir(entregador.getPessoa());
    }
    
    @Override
    public MensagemRetorno consultarPorId(int id, String tabela) {
        
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;
        
        try {

            sessao = HibernateUtil.getSessionFactory().openSession();
            
            sessao.beginTransaction();

            Query query = sessao.createQuery("FROM " + tabela+" WHERE pessoa_id = :idParam");

            query.setInteger("idParam", id);
            
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
            MensagemRetorno msg = this.consultarTodos("Entregador");
            if(msg.isSucesso()){
                for (Object object : msg.getLista()) {
                    Entregador c = (Entregador) object;
                    ComboItens item = new ComboItens();
                    item.setCodigo(c.getPessoaId().intValue());
                    item.setDescricao(c.getPessoa().getNome());
                    combo.addItem(item);
                }
                definirItemCombo(combo, itemSelecione());
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo Entregador = " + e.toString());
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
