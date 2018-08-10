package model;
// Generated 09/08/2018 21:15:58 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cidade generated by hbm2java
 */
public class Cidade  implements java.io.Serializable {


     private int id;
     private String nome;
     private boolean situacao;
     private Set pessoas = new HashSet(0);

    public Cidade() {
    }

	
    public Cidade(int id, String nome, boolean situacao) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
    }
    public Cidade(int id, String nome, boolean situacao, Set pessoas) {
       this.id = id;
       this.nome = nome;
       this.situacao = situacao;
       this.pessoas = pessoas;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public boolean isSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    public Set getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Set pessoas) {
        this.pessoas = pessoas;
    }




}


