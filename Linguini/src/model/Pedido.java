/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vitorolavo
 */
@Entity
@Table(catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id")
    , @NamedQuery(name = "Pedido.findByDataHora", query = "SELECT p FROM Pedido p WHERE p.dataHora = :dataHora")
    , @NamedQuery(name = "Pedido.findByDataHoraFechado", query = "SELECT p FROM Pedido p WHERE p.dataHoraFechado = :dataHoraFechado")
    , @NamedQuery(name = "Pedido.findByValor", query = "SELECT p FROM Pedido p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pedido.findByMesa", query = "SELECT p FROM Pedido p WHERE p.mesa = :mesa")
    , @NamedQuery(name = "Pedido.findByLogradouro", query = "SELECT p FROM Pedido p WHERE p.logradouro = :logradouro")
    , @NamedQuery(name = "Pedido.findByBairro", query = "SELECT p FROM Pedido p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "Pedido.findByComplemento", query = "SELECT p FROM Pedido p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "Pedido.findByNumero", query = "SELECT p FROM Pedido p WHERE p.numero = :numero")
    , @NamedQuery(name = "Pedido.findByTempoDeslocamento", query = "SELECT p FROM Pedido p WHERE p.tempoDeslocamento = :tempoDeslocamento")
    , @NamedQuery(name = "Pedido.findByStatus", query = "SELECT p FROM Pedido p WHERE p.status = :status")
    , @NamedQuery(name = "Pedido.findByObservacao", query = "SELECT p FROM Pedido p WHERE p.observacao = :observacao")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "data_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Column(name = "data_hora_fechado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraFechado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;
    private Integer mesa;
    @Column(length = 150)
    private String logradouro;
    @Column(length = 150)
    private String bairro;
    @Column(length = 150)
    private String complemento;
    private Integer numero;
    @Column(name = "tempo_deslocamento")
    private Integer tempoDeslocamento;
    private Character status;
    @Column(length = 2147483647)
    private String observacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId", fetch = FetchType.EAGER)
    private List<ItemPedido> itemPedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId", fetch = FetchType.EAGER)
    private List<ContasReceber> contasReceberList;
    @JoinColumn(name = "entregador_pessoa_id", referencedColumnName = "pessoa_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Entregador entregadorPessoaId;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa pessoaId;
    @JoinColumn(name = "caixa_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario caixaId;
    @JoinColumn(name = "atendente_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario atendenteId;

    public Pedido() {
    }

    public Pedido(Long id) {
        this.id = id;
    }

    public Pedido(Long id, Date dataHora, BigDecimal valor) {
        this.id = id;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Date getDataHoraFechado() {
        return dataHoraFechado;
    }

    public void setDataHoraFechado(Date dataHoraFechado) {
        this.dataHoraFechado = dataHoraFechado;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getTempoDeslocamento() {
        return tempoDeslocamento;
    }

    public void setTempoDeslocamento(Integer tempoDeslocamento) {
        this.tempoDeslocamento = tempoDeslocamento;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }

    @XmlTransient
    public List<ContasReceber> getContasReceberList() {
        return contasReceberList;
    }

    public void setContasReceberList(List<ContasReceber> contasReceberList) {
        this.contasReceberList = contasReceberList;
    }

    public Entregador getEntregadorPessoaId() {
        return entregadorPessoaId;
    }

    public void setEntregadorPessoaId(Entregador entregadorPessoaId) {
        this.entregadorPessoaId = entregadorPessoaId;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Usuario getCaixaId() {
        return caixaId;
    }

    public void setCaixaId(Usuario caixaId) {
        this.caixaId = caixaId;
    }

    public Usuario getAtendenteId() {
        return atendenteId;
    }

    public void setAtendenteId(Usuario atendenteId) {
        this.atendenteId = atendenteId;
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
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pedido[ id=" + id + " ]";
    }
    
}
