package model;
// Generated 09/08/2018 21:15:58 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Entrada generated by hbm2java
 */
public class Entrada  implements java.io.Serializable {


     private int id;
     private Produto produto;
     private int quantidade;
     private Date data;

    public Entrada() {
    }

    public Entrada(int id, Produto produto, int quantidade, Date data) {
       this.id = id;
       this.produto = produto;
       this.quantidade = quantidade;
       this.data = data;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }




}


