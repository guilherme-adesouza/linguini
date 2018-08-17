package controller;

import dao.FornecedorDAO;
import dao.MensagemRetorno;
import dao.SoftDelete;
import model.Fornecedor;

/**
 *
 * @author VitinNote
 */
public class FornecedorController {
   private FornecedorDAO fornecedorDao;
   private Fornecedor fornecedor;
   
   public FornecedorController(){
       this.fornecedorDao = new FornecedorDAO();
       //para ja atualizar meu list
       //pesquisar();
   }
   
   public MensagemRetorno salvar(Fornecedor fornecedor){
      return this.fornecedorDao.salvar(fornecedor);
   } 
   
   public MensagemRetorno excluir(Fornecedor fornecedor){
       return this.fornecedorDao.excluir(fornecedor);
   }
   
   public MensagemRetorno excluir(SoftDelete fornecedor){
       return this.fornecedorDao.excluir(fornecedor);
   }
   
   public MensagemRetorno pesquisarTodos(){
       return this.fornecedorDao.consultarTodos("Fornecedor");
   }
}




