/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vitorolavo
 */
@Entity
@Table(name = "contas_receber", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContasReceber.findAll", query = "SELECT c FROM ContasReceber c")
    , @NamedQuery(name = "ContasReceber.findById", query = "SELECT c FROM ContasReceber c WHERE c.id = :id")
    , @NamedQuery(name = "ContasReceber.findByValorFinal", query = "SELECT c FROM ContasReceber c WHERE c.valorFinal = :valorFinal")
    , @NamedQuery(name = "ContasReceber.findByDataPrevista", query = "SELECT c FROM ContasReceber c WHERE c.dataPrevista = :dataPrevista")
    , @NamedQuery(name = "ContasReceber.findByDataPagamento", query = "SELECT c FROM ContasReceber c WHERE c.dataPagamento = :dataPagamento")
    , @NamedQuery(name = "ContasReceber.findByDesconto", query = "SELECT c FROM ContasReceber c WHERE c.desconto = :desconto")
    , @NamedQuery(name = "ContasReceber.findByAcrescimo", query = "SELECT c FROM ContasReceber c WHERE c.acrescimo = :acrescimo")})
public class ContasReceber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_final", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorFinal;
    @Basic(optional = false)
    @Column(name = "data_prevista", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPrevista;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Column(precision = 10, scale = 2)
    private BigDecimal desconto;
    @Column(precision = 10, scale = 2)
    private BigDecimal acrescimo;
    @JoinColumn(name = "forma_pagamento_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private FormaPagamento formaPagamentoId;
    @JoinColumn(name = "pedido_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido pedidoId;

    public ContasReceber() {
    }

    public ContasReceber(Long id) {
        this.id = id;
    }

    public ContasReceber(Long id, BigDecimal valorFinal, Date dataPrevista) {
        this.id = id;
        this.valorFinal = valorFinal;
        this.dataPrevista = dataPrevista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Date getDataPrevista() {
        return dataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public FormaPagamento getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(FormaPagamento formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContasReceber)) {
            return false;
        }
        ContasReceber other = (ContasReceber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ContasReceber[ id=" + id + " ]";
    }
    
}
