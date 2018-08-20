/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Funcionario;

/**
 *
 * @author guilherme-souza
 */
public class FuncionarioDAO extends GenericoDAO<Funcionario>{
    @Override
    public MensagemRetorno excluir(int id, String tabela){
        return new PessoaDAO().excluir(id);
    }
    
    @Override
    public MensagemRetorno excluir(Funcionario funcionario){
        return new PessoaDAO().excluir(funcionario.getPessoa());
    }
}
