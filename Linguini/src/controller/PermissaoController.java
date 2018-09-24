package controller;

import dao.MensagemRetorno;
import dao.PermissaoDAO;
import java.util.List;
import javax.swing.JTable;
import model.Permissao;

/**
 * @author guilherme-souza
 */
public class PermissaoController implements Controller<Permissao> {

    PermissaoDAO permissaoDAO;
    String tabela = "Permissao";
    
    public PermissaoController(){
        this.permissaoDAO = new PermissaoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Permissao permissao) {
        return this.permissaoDAO.salvar(permissao);
    }

    @Override
    public MensagemRetorno excluir(Permissao permissao) {
        return this.permissaoDAO.excluir(permissao);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.permissaoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.permissaoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.permissaoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MensagemRetorno consultarPorGrupo(int idGrupo){
        return this.permissaoDAO.consultarPorGrupo(idGrupo, this.tabela);
    }
}
