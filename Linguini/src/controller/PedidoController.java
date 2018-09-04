package controller;

import dao.MensagemRetorno;
import dao.PedidoDAO;
import java.util.List;
import javax.swing.JTable;
import model.Pedido;

/**
 * @author guilherme-souza
 */
public class PedidoController implements Controller<Pedido>{

    PedidoDAO pedidoDAO;
    String tabela = "Pedido";
    
    public PedidoController(){
        this.pedidoDAO = new PedidoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(Pedido pedido) {
        return this.pedidoDAO.salvar(pedido);
    }

    @Override
    public MensagemRetorno excluir(Pedido pedido) {
        return this.pedidoDAO.excluir(pedido);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.pedidoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.pedidoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.pedidoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
