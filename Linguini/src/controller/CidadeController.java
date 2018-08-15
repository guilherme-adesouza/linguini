package controller;

import dao.CidadeDAO;
import dao.MensagemRetorno;
import model.Cidade;

/**
 *
 * @author VitinNote
 */
public class CidadeController {
    CidadeDAO cidadeDao;
    
    public CidadeController(){
    this.cidadeDao = new CidadeDAO();
    }
    
    public MensagemRetorno salvar(Cidade cidade){
        return cidadeDao.salvar(cidade);
    }
    
    public MensagemRetorno excluir(Cidade cidade){
        return cidadeDao.excluir(cidade);
    }
}
