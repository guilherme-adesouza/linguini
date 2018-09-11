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
 * @author guilherme-souza
 */
@Entity
@Table(name = "caixa", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")
    , @NamedQuery(name = "Caixa.findById", query = "SELECT c FROM Caixa c WHERE c.id = :id")
    , @NamedQuery(name = "Caixa.findByDataEntrada", query = "SELECT c FROM Caixa c WHERE c.dataEntrada = :dataEntrada")
    , @NamedQuery(name = "Caixa.findByDataSaida", query = "SELECT c FROM Caixa c WHERE c.dataSaida = :dataSaida")
    , @NamedQuery(name = "Caixa.findByValorInicial", query = "SELECT c FROM Caixa c WHERE c.valorInicial = :valorInicial")
    , @NamedQuery(name = "Caixa.findByValorFinal", query = "SELECT c FROM Caixa c WHERE c.valorFinal = :valorFinal")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "data_entrada", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEntrada;
    @Column(name = "data_saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSaida;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_inicial", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorInicial;
    @Column(name = "valor_final", precision = 10, scale = 2)
    private BigDecimal valorFinal;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuarioId;

    public Caixa() {
    }

    public Caixa(Long id) {
        this.id = id;
    }

    public Caixa(Long id, Date dataEntrada, BigDecimal valorInicial) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.valorInicial = valorInicial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
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
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Caixa[ id=" + id + " ]";
    }
    
}
