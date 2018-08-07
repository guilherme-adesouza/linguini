package model;
// Generated 06/08/2018 21:12:34 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Produto generated by hbm2java
 */
@Entity
@Table(name="produto"
    ,schema="public"
)
public class Produto  implements java.io.Serializable {


     private int id;
     private Classificacao classificacao;
     private Fornecedor fornecedor;
     private String descricao;
     private BigDecimal valor;
     private int quantidade;
     private int tempoPreparo;
     private boolean cozinha;
     private int estoqueMinimo;
     private boolean insumo;
     private String unidadeMedida;
     private BigDecimal valorPromocao;
     private Date dataFimPromocao;
     private Set itemPedidos = new HashSet(0);
     private Set entradas = new HashSet(0);

    public Produto() {
    }

	
    public Produto(int id, Classificacao classificacao, Fornecedor fornecedor, String descricao, BigDecimal valor, int quantidade, int tempoPreparo, boolean cozinha, int estoqueMinimo, boolean insumo) {
        this.id = id;
        this.classificacao = classificacao;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
        this.tempoPreparo = tempoPreparo;
        this.cozinha = cozinha;
        this.estoqueMinimo = estoqueMinimo;
        this.insumo = insumo;
    }
    public Produto(int id, Classificacao classificacao, Fornecedor fornecedor, String descricao, BigDecimal valor, int quantidade, int tempoPreparo, boolean cozinha, int estoqueMinimo, boolean insumo, String unidadeMedida, BigDecimal valorPromocao, Date dataFimPromocao, Set itemPedidos, Set entradas) {
       this.id = id;
       this.classificacao = classificacao;
       this.fornecedor = fornecedor;
       this.descricao = descricao;
       this.valor = valor;
       this.quantidade = quantidade;
       this.tempoPreparo = tempoPreparo;
       this.cozinha = cozinha;
       this.estoqueMinimo = estoqueMinimo;
       this.insumo = insumo;
       this.unidadeMedida = unidadeMedida;
       this.valorPromocao = valorPromocao;
       this.dataFimPromocao = dataFimPromocao;
       this.itemPedidos = itemPedidos;
       this.entradas = entradas;
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
    @JoinColumn(name="classificacao_id", nullable=false)
    public Classificacao getClassificacao() {
        return this.classificacao;
    }
    
    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fornecedor_id", nullable=false)
    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }
    
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    
    @Column(name="descricao", nullable=false, length=500)
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    
    @Column(name="tempo_preparo", nullable=false)
    public int getTempoPreparo() {
        return this.tempoPreparo;
    }
    
    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    
    @Column(name="cozinha", nullable=false)
    public boolean isCozinha() {
        return this.cozinha;
    }
    
    public void setCozinha(boolean cozinha) {
        this.cozinha = cozinha;
    }

    
    @Column(name="estoque_minimo", nullable=false)
    public int getEstoqueMinimo() {
        return this.estoqueMinimo;
    }
    
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    
    @Column(name="insumo", nullable=false)
    public boolean isInsumo() {
        return this.insumo;
    }
    
    public void setInsumo(boolean insumo) {
        this.insumo = insumo;
    }

    
    @Column(name="unidade_medida", length=3)
    public String getUnidadeMedida() {
        return this.unidadeMedida;
    }
    
    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    
    @Column(name="valor_promocao", precision=10)
    public BigDecimal getValorPromocao() {
        return this.valorPromocao;
    }
    
    public void setValorPromocao(BigDecimal valorPromocao) {
        this.valorPromocao = valorPromocao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="data_fim_promocao", length=13)
    public Date getDataFimPromocao() {
        return this.dataFimPromocao;
    }
    
    public void setDataFimPromocao(Date dataFimPromocao) {
        this.dataFimPromocao = dataFimPromocao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produto")
    public Set getItemPedidos() {
        return this.itemPedidos;
    }
    
    public void setItemPedidos(Set itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="produto")
    public Set getEntradas() {
        return this.entradas;
    }
    
    public void setEntradas(Set entradas) {
        this.entradas = entradas;
    }




}

