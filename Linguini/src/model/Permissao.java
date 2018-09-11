/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guilherme-souza
 */
@Entity
@Table(name = "permissao", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permissao.findAll", query = "SELECT p FROM Permissao p")
    , @NamedQuery(name = "Permissao.findById", query = "SELECT p FROM Permissao p WHERE p.id = :id")
    , @NamedQuery(name = "Permissao.findByVisivel", query = "SELECT p FROM Permissao p WHERE p.visivel = :visivel")})
public class Permissao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "visivel", nullable = false)
    private boolean visivel;
    @JoinColumn(name = "grupo_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Grupo grupoId;
    @JoinColumn(name = "telas_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Telas telasId;

    public Permissao() {
    }

    public Permissao(Integer id) {
        this.id = id;
    }

    public Permissao(Integer id, boolean visivel) {
        this.id = id;
        this.visivel = visivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public Grupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Grupo grupoId) {
        this.grupoId = grupoId;
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
        if (!(object instanceof Permissao)) {
            return false;
        }
        Permissao other = (Permissao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Permissao[ id=" + id + " ]";
    }
    
}
