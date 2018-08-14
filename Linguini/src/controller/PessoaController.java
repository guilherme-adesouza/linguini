package controller;

import dao.MensagemRetorno;
import dao.PessoaDAO;
import model.Pessoa;

/**
 * @author guilherme-souza
 */
public class PessoaController {
    PessoaDAO pessoaDAO;
    
    public PessoaController(){
        this.pessoaDAO = new PessoaDAO();
    }
    
    public MensagemRetorno salvar(Pessoa pessoa){
        return pessoaDAO.salvar(pessoa);
    }
}
