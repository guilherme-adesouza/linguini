package controller;

import dao.CozinhaDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.Cozinha;

/**
 * @author guilherme-souza
 */
public class CozinhaController implements Controller<Cozinha>{

    CozinhaDAO cozinhaDAO;
    String tabela = "Cozinha";
    
    public CozinhaController(){
        this.cozinhaDAO = new CozinhaDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Cozinha cozinha) {
        return this.cozinhaDAO.salvar(cozinha);
    }

    @Override
    public MensagemRetorno excluir(Cozinha cozinha) {
        return this.cozinhaDAO.excluir(cozinha);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.cozinhaDAO.excluir(id ,this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.cozinhaDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.cozinhaDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
