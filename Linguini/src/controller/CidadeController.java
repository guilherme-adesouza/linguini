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

    public MensagemRetorno pesquisarCCriterio(String valor){
        return cidadeDao.consultarComCriterio("Cidade", "nome", valor);
    }
    public MensagemRetorno pesquisarPorId(int valor){
        return cidadeDao.consultarPorId(valor, "Cidade");
    }
    
    public String obterEstado(Cidade cidade){
        MensagemRetorno msg = estadoDao.consultarPorId(cidade.getEstado().getCodEstado(), "Estado");
        Estado estado = (Estado) msg.getObjeto();
        return cidade.getNome() + " " + estado.getSigla();
       }
}
