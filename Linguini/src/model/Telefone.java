package model;
// Generated 06/08/2018 21:12:34 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Telefone generated by hbm2java
 */
@Entity
@Table(name="telefone"
    ,schema="public"
)
public class Telefone  implements java.io.Serializable {


     private int id;
     private String telefone;
     private String descricao;
     private boolean situacao;
     private Set pessoas = new HashSet(0);

    public Telefone() {
    }

	
    public Telefone(int id, String telefone, boolean situacao) {
        this.id = id;
        this.telefone = telefone;
        this.situacao = situacao;
    }
    public Telefone(int id, String telefone, String descricao, boolean situacao, Set pessoas) {
       this.id = id;
       this.telefone = telefone;
       this.descricao = descricao;
       this.situacao = situacao;
       this.pessoas = pessoas;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="telefone", nullable=false, length=45)
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    @Column(name="descricao", length=150)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Column(name="situacao", nullable=false)
    public boolean isSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="telefone")
    public Set getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Set pessoas) {
        this.pessoas = pessoas;
    }




}

