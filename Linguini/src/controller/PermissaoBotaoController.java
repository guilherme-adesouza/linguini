package controller;

import dao.MensagemRetorno;
import dao.PermissaoBotaoDAO;
import java.util.List;
import javax.swing.JTable;
import model.PermissaoBotao;

/**
 * @author guilherme-souza
 */
public class PermissaoBotaoController implements Controller<PermissaoBotao> {

    PermissaoBotaoDAO permissaoBotaoDAO;
    String tabela = "PermissaoBotao";
    
    public PermissaoBotaoController(){
        this.permissaoBotaoDAO = new PermissaoBotaoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(PermissaoBotao permissaoBotao) {
        return this.permissaoBotaoDAO.salvar(permissaoBotao);
    }

    @Override
    public MensagemRetorno excluir(PermissaoBotao permissaoBotao) {
        return this.permissaoBotaoDAO.excluir(permissaoBotao);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.permissaoBotaoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.permissaoBotaoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.permissaoBotaoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public MensagemRetorno consultarPorGrupo(int idGrupo){
        return this.permissaoBotaoDAO.consultarPorGrupo(idGrupo, this.tabela);
    }
}
