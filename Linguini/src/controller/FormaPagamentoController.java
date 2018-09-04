package controller;

import dao.FormaPagamentoDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.FormaPagamento;

/**
 * @author guilherme-souza
 */
public class FormaPagamentoController implements Controller<FormaPagamento>{

    FormaPagamentoDAO formaPagamentoDAO;
    String tabela = "FormaPagamento";
    
    public FormaPagamentoController(){
        this.formaPagamentoDAO = new FormaPagamentoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(FormaPagamento formaPagamento) {
        return this.formaPagamentoDAO.salvar(formaPagamento);
    }

    @Override
    public MensagemRetorno excluir(FormaPagamento formaPagamento) {
        return this.formaPagamentoDAO.excluir(formaPagamento);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.formaPagamentoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.formaPagamentoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.formaPagamentoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
