/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.swing.JComboBox;
import model.Fornecedor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;
import view.ComboItens;

/**
 * @author VitinNote
 */
public class FornecedorDAO extends GenericoDAO<Fornecedor> implements SoftDelete {

    @Override
    public MensagemRetorno inativar(int id) {
        MensagemRetorno retorno = new MensagemRetorno(false);
        Session sessao = null;

        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();
            this.setParametroSessao(sessao);

            Query query = sessao.createQuery("UPDATE Fornecedor f SET f.situacao=false WHERE id = :idParam");
            int qtd = query.setParameter("idParam", (long) id).executeUpdate();
            t.commit();
            retorno.setSucesso(true);
            retorno.setMensagem("Registro excluído com sucesso!");
        } catch (Exception he) {
            new GeradorLog(he);
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
            MensagemRetorno msg = this.consultarTodos("Fornecedor");
            if(msg.isSucesso()){
                for (Object object : msg.getLista()) {
                    Fornecedor p = (Fornecedor) object;
                    ComboItens item = new ComboItens();
                    item.setCodigo(p.getId().intValue());
                    item.setDescricao(p.getNomeFantasia());
                    combo.addItem(item);
                }
                definirItemCombo(combo, itemSelecione());
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo Fornecedor = " + e.toString());
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
