package controller;

import dao.BotaoDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.Botoes;

/**
 * @author guilherme-souza
 */
public class BotaoController implements Controller<Botoes>{

    BotaoDAO botaoDAO;
    String tabela = "Botoes";
    
    public BotaoController(){
        this.botaoDAO = new BotaoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Botoes botao) {
        return this.botaoDAO.salvar(botao);
    }

    @Override
    public MensagemRetorno excluir(Botoes botao) {
        return this.botaoDAO.excluir(botao);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.botaoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.botaoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.botaoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
