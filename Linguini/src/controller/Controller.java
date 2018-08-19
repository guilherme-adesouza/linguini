package controller;

import dao.MensagemRetorno;
import java.util.List;
import javax.swing.JTable;


/**
 * @author guilherme-souza
 */
public interface Controller<T> {
    public MensagemRetorno salvar(T objeto);
    public MensagemRetorno excluir(T objeto);
    public MensagemRetorno excluir(int id);
    public void popularTabela(JTable tabela, String criterio, String ordenacao);    
    public MensagemRetorno consultarTodos();
    public MensagemRetorno consultarPorID(int id);
    public List<CampoOrdenavel> getOrdenacao();
}
