package model;
// Generated 06/08/2018 21:12:34 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
 * ContasReceber generated by hbm2java
 */
@Entity
@Table(name="contas_receber"
    ,schema="public"
)
public class ContasReceber  implements java.io.Serializable {


     private int id;
     private FormaPagamento formaPagamento;
     private Pedido pedido;
     private BigDecimal valorFinal;
     private Date dataPrevista;
     private Date dataPagamento;
     private BigDecimal desconto;
     private BigDecimal acrescimo;

    public ContasReceber() {
    }

	
    public ContasReceber(int id, FormaPagamento formaPagamento, Pedido pedido, BigDecimal valorFinal, Date dataPrevista) {
        this.id = id;
        this.formaPagamento = formaPagamento;
        this.pedido = pedido;
        this.valorFinal = valorFinal;
        this.dataPrevista = dataPrevista;
    }
    public ContasReceber(int id, FormaPagamento formaPagamento, Pedido pedido, BigDecimal valorFinal, Date dataPrevista, Date dataPagamento, BigDecimal desconto, BigDecimal acrescimo) {
       this.id = id;
       this.formaPagamento = formaPagamento;
       this.pedido = pedido;
       this.valorFinal = valorFinal;
       this.dataPrevista = dataPrevista;
       this.dataPagamento = dataPagamento;
       this.desconto = desconto;
       this.acrescimo = acrescimo;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="forma_pagamento_id", nullable=false)
    public FormaPagamento getFormaPagamento() {
        return this.formaPagamento;
    }
    
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pedido_id", nullable=false)
    public Pedido getPedido() {
        return this.pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    
    @Column(name="valor_final", nullable=false, precision=10)
    public BigDecimal getValorFinal() {
        return this.valorFinal;
    }
    
    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_prevista", nullable=false, length=13)
    public Date getDataPrevista() {
        return this.dataPrevista;
    }
    
    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_pagamento", length=13)
    public Date getDataPagamento() {
        return this.dataPagamento;
    }
    
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
    @Column(name="desconto", precision=10)
    public BigDecimal getDesconto() {
        return this.desconto;
    }
    
    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    
    @Column(name="acrescimo", precision=10)
    public BigDecimal getAcrescimo() {
        return this.acrescimo;
    }
    
    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }




}


