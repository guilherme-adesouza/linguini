package model;
// Generated 10/08/2018 00:28:47 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ItemPedido generated by hbm2java
 */
@Entity
@Table(name="item_pedido"
    ,schema="public"
)
public class ItemPedido  implements java.io.Serializable {


     private ItemPedidoId id;
     private Pedido pedido;
     private Produto produto;
     private BigDecimal valor;
     private int quantidade;
     private BigDecimal desconto;

    public ItemPedido() {
    }

	
    public ItemPedido(ItemPedidoId id, Pedido pedido, Produto produto, BigDecimal valor, int quantidade) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    public ItemPedido(ItemPedidoId id, Pedido pedido, Produto produto, BigDecimal valor, int quantidade, BigDecimal desconto) {
       this.id = id;
       this.pedido = pedido;
       this.produto = produto;
       this.valor = valor;
       this.quantidade = quantidade;
       this.desconto = desconto;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="pedidoId", column=@Column(name="pedido_id", nullable=false) ), 
        @AttributeOverride(name="produtoId", column=@Column(name="produto_id", nullable=false) ) } )
    public ItemPedidoId getId() {
        return this.id;
    }
    
    public void setId(ItemPedidoId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pedido_id", nullable=false, insertable=false, updatable=false)
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="produto_id", nullable=false, insertable=false, updatable=false)
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    @Column(name="valor", nullable=false, precision=10)
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    
    @Column(name="quantidade", nullable=false)
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    @Column(name="desconto", precision=10)
    public BigDecimal getDesconto() {
        return this.desconto;
    }
    
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }




}


