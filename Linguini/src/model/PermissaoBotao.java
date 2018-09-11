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
@Table(name = "permissao_botao", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissaoBotao.findAll", query = "SELECT p FROM PermissaoBotao p")
    , @NamedQuery(name = "PermissaoBotao.findById", query = "SELECT p FROM PermissaoBotao p WHERE p.id = :id")
    , @NamedQuery(name = "PermissaoBotao.findByVisivel", query = "SELECT p FROM PermissaoBotao p WHERE p.visivel = :visivel")})
public class PermissaoBotao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "visivel", nullable = false)
    private boolean visivel;
    @JoinColumn(name = "botoes_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Botoes botoesId;
    @JoinColumn(name = "grupo_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Grupo grupoId;

    public PermissaoBotao() {
    }

    public PermissaoBotao(Integer id) {
        this.id = id;
    }

    public PermissaoBotao(Integer id, boolean visivel) {
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

    public Botoes getBotoesId() {
        return botoesId;
    }

    public void setBotoesId(Botoes botoesId) {
        this.botoesId = botoesId;
    }

    public Grupo getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Grupo grupoId) {
        this.grupoId = grupoId;
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
        if (!(object instanceof PermissaoBotao)) {
            return false;
        }
        PermissaoBotao other = (PermissaoBotao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PermissaoBotao[ id=" + id + " ]";
    }
    
}
