package controller;

import dao.ContasReceberDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.ContasReceber;

/**
 * @author guilherme-souza
 */
public class ContasReceberController implements Controller<ContasReceber>{

    ContasReceberDAO contasReceberDAO;
    String tabela = "ContasReceber";
    
    public ContasReceberController(){
        this.contasReceberDAO = new ContasReceberDAO();
    }
    
    @Override
    public MensagemRetorno salvar(ContasReceber contasReceber) {
        return this.contasReceberDAO.salvar(contasReceber);
    }

    @Override
    public MensagemRetorno excluir(ContasReceber contasReceber) {
        return this.contasReceberDAO.excluir(contasReceber);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.contasReceberDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.contasReceberDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.contasReceberDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
