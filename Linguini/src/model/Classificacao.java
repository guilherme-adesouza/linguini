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
 * Classificacao generated by hbm2java
 */
@Entity
@Table(name="classificacao"
    ,schema="public"
)
public class Classificacao  implements java.io.Serializable {


     private int id;
     private String classificacao;
     private boolean situacao;
     private Set produtos = new HashSet(0);

    public Classificacao() {
    }

	
    public Classificacao(int id, String classificacao, boolean situacao) {
        this.id = id;
        this.classificacao = classificacao;
        this.situacao = situacao;
    }
    public Classificacao(int id, String classificacao, boolean situacao, Set produtos) {
       this.id = id;
       this.classificacao = classificacao;
       this.situacao = situacao;
       this.produtos = produtos;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="classificacao", nullable=false, length=150)
    public String getClassificacao() {
        return this.classificacao;
    }
    
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    
    @Column(name="situacao", nullable=false)
    public boolean isSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="classificacao")
    public Set getProdutos() {
        return this.produtos;
    }
    
    public void setProdutos(Set produtos) {
        this.produtos = produtos;
    }




}

