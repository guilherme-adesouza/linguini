package controller;

import dao.ItemPedidoDAO;
import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;
import model.ItemPedido;

/**
 * @author guilherme-souza
 */
public class ItemPedidoController implements Controller<ItemPedido>{

    ItemPedidoDAO itemPedidoDAO;
    String tabela = "ItemPedido";
    
    public ItemPedidoController(){
        this.itemPedidoDAO = new ItemPedidoDAO();
    }
    
    @Override
    public MensagemRetorno salvar(ItemPedido itemPedido) {
        return this.itemPedidoDAO.salvar(itemPedido);
    }

    @Override
    public MensagemRetorno excluir(ItemPedido itemPedido) {
        return this.itemPedidoDAO.excluir(itemPedido);
    }

    @Override
    public MensagemRetorno excluir(int id) {
        return this.itemPedidoDAO.excluir(id, this.tabela);
    }

    @Override
    public void popularTabela(JTable tabela, String criterio, String ordenacao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MensagemRetorno consultarTodos() {
        return this.itemPedidoDAO.consultarTodos(this.tabela);
    }

    @Override
    public MensagemRetorno consultarPorID(int id) {
        return this.itemPedidoDAO.consultarPorId(id, this.tabela);
    }

    @Override
    public List<CampoOrdenavel> getOrdenacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
