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
 * @author guilherme-souza
 */
@Entity
@Table(name = "produto", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
    , @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id")
    , @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao")
    , @NamedQuery(name = "Produto.findByValorCusto", query = "SELECT p FROM Produto p WHERE p.valorCusto = :valorCusto")
    , @NamedQuery(name = "Produto.findByValorVenda", query = "SELECT p FROM Produto p WHERE p.valorVenda = :valorVenda")
    , @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade")
    , @NamedQuery(name = "Produto.findByTempoPreparo", query = "SELECT p FROM Produto p WHERE p.tempoPreparo = :tempoPreparo")
    , @NamedQuery(name = "Produto.findByCozinha", query = "SELECT p FROM Produto p WHERE p.cozinha = :cozinha")
    , @NamedQuery(name = "Produto.findByEstoqueMinimo", query = "SELECT p FROM Produto p WHERE p.estoqueMinimo = :estoqueMinimo")
    , @NamedQuery(name = "Produto.findByInsumo", query = "SELECT p FROM Produto p WHERE p.insumo = :insumo")
    , @NamedQuery(name = "Produto.findByUnidadeMedida", query = "SELECT p FROM Produto p WHERE p.unidadeMedida = :unidadeMedida")
    , @NamedQuery(name = "Produto.findByValorPromocao", query = "SELECT p FROM Produto p WHERE p.valorPromocao = :valorPromocao")
    , @NamedQuery(name = "Produto.findByDataInicioPromocao", query = "SELECT p FROM Produto p WHERE p.dataInicioPromocao = :dataInicioPromocao")
    , @NamedQuery(name = "Produto.findByDataFimPromocao", query = "SELECT p FROM Produto p WHERE p.dataFimPromocao = :dataFimPromocao")
    , @NamedQuery(name = "Produto.findByCodigoBarra", query = "SELECT p FROM Produto p WHERE p.codigoBarra = :codigoBarra")
    , @NamedQuery(name = "Produto.findBySituacao", query = "SELECT p FROM Produto p WHERE p.situacao = :situacao")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_custo", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorCusto;
    @Basic(optional = false)
    @Column(name = "valor_venda", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorVenda;
    @Basic(optional = false)
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "tempo_preparo", nullable = false)
    private int tempoPreparo;
    @Basic(optional = false)
    @Column(name = "cozinha", nullable = false)
    private boolean cozinha;
    @Basic(optional = false)
    @Column(name = "estoque_minimo", nullable = false)
    private int estoqueMinimo;
    @Basic(optional = false)
    @Column(name = "insumo", nullable = false)
    private boolean insumo;
    @Column(name = "unidade_medida", length = 3)
    private String unidadeMedida;
    @Column(name = "valor_promocao", precision = 10, scale = 2)
    private BigDecimal valorPromocao;
    @Column(name = "data_inicio_promocao")
    @Temporal(TemporalType.DATE)
    private Date dataInicioPromocao;
    @Column(name = "data_fim_promocao")
    @Temporal(TemporalType.DATE)
    private Date dataFimPromocao;
    @Column(name = "codigo_barra")
    private Integer codigoBarra;
    @Basic(optional = false)
    @Column(name = "situacao", nullable = false)
    private boolean situacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<ItemPedido> itemPedidoList;
    @JoinColumn(name = "classificacao_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Classificacao classificacaoId;
    @JoinColumn(name = "fornecedor_id", referencedColumnName = "id")
    @ManyToOne
    private Fornecedor fornecedorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtoId")
    private List<Entrada> entradaList;

    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(Long id, String descricao, BigDecimal valorCusto, BigDecimal valorVenda, int quantidade, int tempoPreparo, boolean cozinha, int estoqueMinimo, boolean insumo, boolean situacao) {
        this.id = id;
        this.descricao = descricao;
        this.valorCusto = valorCusto;
        this.valorVenda = valorVenda;
        this.quantidade = quantidade;
        this.tempoPreparo = tempoPreparo;
        this.cozinha = cozinha;
        this.estoqueMinimo = estoqueMinimo;
        this.insumo = insumo;
        this.situacao = situacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public boolean getCozinha() {
        return cozinha;
    }

    public void setCozinha(boolean cozinha) {
        this.cozinha = cozinha;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public boolean getInsumo() {
        return insumo;
    }

    public void setInsumo(boolean insumo) {
        this.insumo = insumo;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public BigDecimal getValorPromocao() {
        return valorPromocao;
    }

    public void setValorPromocao(BigDecimal valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    public Date getDataInicioPromocao() {
        return dataInicioPromocao;
    }

    public void setDataInicioPromocao(Date dataInicioPromocao) {
        this.dataInicioPromocao = dataInicioPromocao;
    }

    public Date getDataFimPromocao() {
        return dataFimPromocao;
    }

    public void setDataFimPromocao(Date dataFimPromocao) {
        this.dataFimPromocao = dataFimPromocao;
    }

    public Integer getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(Integer codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    @XmlTransient
    public List<ItemPedido> getItemPedidoList() {
        return itemPedidoList;
    }

    public void setItemPedidoList(List<ItemPedido> itemPedidoList) {
        this.itemPedidoList = itemPedidoList;
    }

    public Classificacao getClassificacaoId() {
        return classificacaoId;
    }

    public void setClassificacaoId(Classificacao classificacaoId) {
        this.classificacaoId = classificacaoId;
    }

    public Fornecedor getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(Fornecedor fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    @XmlTransient
    public List<Entrada> getEntradaList() {
        return entradaList;
    }

    public void setEntradaList(List<Entrada> entradaList) {
        this.entradaList = entradaList;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ id=" + id + " ]";
    }
    
}
