package controller;

import dao.CidadeDAO;
import dao.EstadoDAO;
import dao.MensagemRetorno;
import model.Cidade;
import model.Estado;

/**
 *
 * @author VitinNote
 */
public class CidadeController {

    CidadeDAO cidadeDao;
    private final EstadoDAO estadoDao;

    public CidadeController() {
        this.cidadeDao = new CidadeDAO();
        this.estadoDao = new EstadoDAO();
    }

    public MensagemRetorno salvar(Cidade cidade) {
        return cidadeDao.salvar(cidade);
    }

    public MensagemRetorno excluir(Cidade cidade) {
        return cidadeDao.excluir(cidade);
    }

    public MensagemRetorno pesquisar(String valor){
        return cidadeDao.consultarComCriterio("Cidade", "nome", valor);
    }
    
    public MensagemRetorno obterEstado(Cidade cidade){
        return estadoDao.consultarPorId(cidade.getEstado().getCodEstado(), "Estado");
    }
}
