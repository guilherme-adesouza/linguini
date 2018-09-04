package controller;

import dao.CaixaDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.Caixa;

/**
 * @author guilherme-souza
 */
public class CaixaController implements Controller<Caixa> {
    
    CaixaDAO caixaDAO;
    String tabela = "Caixa";
    
    public CaixaController(){
        this.caixaDAO = new CaixaDAO();
    }

    @Override
    public MensagemRetorno salvar(Caixa caixa) {
        return this.caixaDAO.salvar(caixa);
    }

    @Override
    public MensagemRetorno excluir(Caixa caixa) {
        return this.caixaDAO.excluir(caixa);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.caixaDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.caixaDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.caixaDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
