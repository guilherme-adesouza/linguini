/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guilherme-souza
 */
@Entity
@Table(name = "botoes", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Botoes.findAll", query = "SELECT b FROM Botoes b")
    , @NamedQuery(name = "Botoes.findById", query = "SELECT b FROM Botoes b WHERE b.id = :id")
    , @NamedQuery(name = "Botoes.findByNome", query = "SELECT b FROM Botoes b WHERE b.nome = :nome")})
public class Botoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 2147483647)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "botoesId")
    private List<PermissaoBotao> permissaoBotaoList;
    @JoinColumn(name = "telas_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Telas telasId;

    public Botoes() {
    }

    public Botoes(Integer id) {
        this.id = id;
    }

    public Botoes(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<PermissaoBotao> getPermissaoBotaoList() {
        return permissaoBotaoList;
    }

    public void setPermissaoBotaoList(List<PermissaoBotao> permissaoBotaoList) {
        this.permissaoBotaoList = permissaoBotaoList;
    }

    public Telas getTelasId() {
        return telasId;
    }

    public void setTelasId(Telas telasId) {
        this.telasId = telasId;
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
        if (!(object instanceof Botoes)) {
            return false;
        }
        Botoes other = (Botoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Botoes[ id=" + id + " ]";
    }
    
}
