/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findByCodCidade", query = "SELECT c FROM Cidade c WHERE c.codCidade = :codCidade")
    , @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cidade.findBySituacao", query = "SELECT c FROM Cidade c WHERE c.situacao = :situacao")
    , @NamedQuery(name = "Cidade.findByCep", query = "SELECT c FROM Cidade c WHERE c.cep = :cep")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_cidade", nullable = false)
    private Long codCidade;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean situacao;
    @Column(length = 9)
    private String cep;
    @JoinColumn(name = "estado_cod_estado", referencedColumnName = "cod_estado", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Estado estadoCodEstado;
    @OneToMany(mappedBy = "cidadeId", fetch = FetchType.EAGER)
    private List<Pessoa> pessoaList;

    public Cidade() {
    }

    public Cidade(Long codCidade) {
        this.codCidade = codCidade;
    }

    public Cidade(Long codCidade, String nome, boolean situacao) {
        this.codCidade = codCidade;
        this.nome = nome;
        this.situacao = situacao;
    }

    public Long getCodCidade() {
        return codCidade;
    }

    public void setCodCidade(Long codCidade) {
        this.codCidade = codCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estado getEstadoCodEstado() {
        return estadoCodEstado;
    }

    public void setEstadoCodEstado(Estado estadoCodEstado) {
        this.estadoCodEstado = estadoCodEstado;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCidade != null ? codCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.codCidade == null && other.codCidade != null) || (this.codCidade != null && !this.codCidade.equals(other.codCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cidade[ codCidade=" + codCidade + " ]";
    }
    
}
