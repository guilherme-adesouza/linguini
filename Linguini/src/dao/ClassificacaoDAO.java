/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JComboBox;
import model.Classificacao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;
import utils.view.ComboItens;

/**
 *
 * @author guilherme-souza
 */
public class ClassificacaoDAO extends GenericoDAO<Classificacao> implements SoftDelete{

    public MensagemRetorno excluir(int id){
        return this.inativar(id);
    }
    
    @Override
    public MensagemRetorno excluir(Classificacao c){
        return this.inativar(Integer.parseInt(c.getId().toString()));
    }
    
    @Override
    public MensagemRetorno inativar(int id) {
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            Query query = sessao.createQuery("UPDATE Classificacao c SET c.situacao=false WHERE id = :idParam");
            int qtd = query.setParameter("idParam", (long) id).executeUpdate();

            t.commit();
            retorno.setSucesso(true);
            retorno.setMensagem("Registro excluído com sucesso!");
        } catch (HibernateException he) {
            retorno.setMensagem(he.getMessage());
            he.printStackTrace();
        } finally {
            sessao.close();
        }
        return retorno;
    }
    
    public void popularCombo(String tabela, JComboBox combo) {
        
        combo.addItem(itemSelecione());

        try {
            MensagemRetorno msg = this.consultarTodos("Classificacao");
            if(msg.isSucesso()){
                for (Object object : msg.getLista()) {
                    Classificacao c = (Classificacao) object;
                    ComboItens item = new ComboItens();
                    item.setCodigo(c.getId().intValue());
                    item.setDescricao(c.getClassificacao());
                    combo.addItem(item);
                }
                definirItemCombo(combo, itemSelecione());
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo Classificacao = " + e.toString());
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
