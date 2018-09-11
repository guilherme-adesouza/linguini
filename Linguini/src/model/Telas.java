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
@Table(name = "telas", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telas.findAll", query = "SELECT t FROM Telas t")
    , @NamedQuery(name = "Telas.findById", query = "SELECT t FROM Telas t WHERE t.id = :id")
    , @NamedQuery(name = "Telas.findByTela", query = "SELECT t FROM Telas t WHERE t.tela = :tela")})
public class Telas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tela", nullable = false, length = 2147483647)
    private String tela;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telasId")
    private List<Permissao> permissaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "telasId")
    private List<Botoes> botoesList;

    public Telas() {
    }

    public Telas(Integer id) {
        this.id = id;
    }

    public Telas(Integer id, String tela) {
        this.id = id;
        this.tela = tela;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTela() {
        return tela;
    }

    public void setTela(String tela) {
        this.tela = tela;
    }

    @XmlTransient
    public List<Permissao> getPermissaoList() {
        return permissaoList;
    }

    public void setPermissaoList(List<Permissao> permissaoList) {
        this.permissaoList = permissaoList;
    }

    @XmlTransient
    public List<Botoes> getBotoesList() {
        return botoesList;
    }

    public void setBotoesList(List<Botoes> botoesList) {
        this.botoesList = botoesList;
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
        if (!(object instanceof Telas)) {
            return false;
        }
        Telas other = (Telas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Telas[ id=" + id + " ]";
    }
    
}
