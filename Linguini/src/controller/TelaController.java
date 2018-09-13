package controller;

import dao.MensagemRetorno;
import dao.TelaDAO;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import model.Telas;

/**
 * @author guilherme-souza
 */
public class TelaController implements Controller<Telas>{

    TelaDAO telaDAO;
    String tabela = "Telas";
    
    public TelaController(){
        this.telaDAO = new TelaDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Telas tela) {
        return this.telaDAO.salvar(tela);
    }

    @Override
    public MensagemRetorno excluir(Telas tela) {
        return this.telaDAO.excluir(tela);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.telaDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.telaDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.telaDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void popularCombo(JComboBox combo){
        this.telaDAO.popularCombo("Cidade", combo);
    }
}
