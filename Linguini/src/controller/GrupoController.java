package controller;

import dao.GrupoDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.Grupo;

/**
 * @author guilherme-souza
 */
public class GrupoController implements Controller<Grupo> {

    private GrupoDAO grupoDAO;
    private String tabela = "Grupo";
    
    public GrupoController(){
        this.grupoDAO = new GrupoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Grupo objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno excluir(Grupo objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.grupoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
