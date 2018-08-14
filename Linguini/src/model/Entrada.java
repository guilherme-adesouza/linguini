package model;
// Generated Aug 13, 2018 9:27:05 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entrada generated by hbm2java
 */
@Entity
@Table(name="entrada"
    ,schema="public"
)
public class Entrada  implements java.io.Serializable {


     private long id;
     private Produto produto;
     private int quantidade;
     private Date data;

    public Entrada() {
    }

    public Entrada(long id, Produto produto, int quantidade, Date data) {
       this.id = id;
       this.produto = produto;
       this.quantidade = quantidade;
       this.data = data;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produto_id", nullable=false)
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    @Column(name="quantidade", nullable=false)
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data", nullable=false, length=13)
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }




}


