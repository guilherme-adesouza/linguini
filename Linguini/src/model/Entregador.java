package model;
// Generated 09/08/2018 21:15:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Entregador generated by hbm2java
 */
public class Entregador  implements java.io.Serializable {


     private int pessoaId;
     private Pessoa pessoa;
     private String placa;
     private Set pedidos = new HashSet(0);

    public Entregador() {
    }

	
    public Entregador(Pessoa pessoa, String placa) {
        this.pessoa = pessoa;
        this.placa = placa;
    }
    public Entregador(Pessoa pessoa, String placa, Set pedidos) {
       this.pessoa = pessoa;
       this.placa = placa;
       this.pedidos = pedidos;
    }
   
    public int getPessoaId() {
        return this.pessoaId;
    }
    
    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }




}


