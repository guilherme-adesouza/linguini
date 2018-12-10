package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author guilherme-souza
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Release.findAll", query = "SELECT r FROM Release r")
    , @NamedQuery(name = "Release.findById", query = "SELECT r FROM Release r WHERE r.id = :id")
    , @NamedQuery(name = "Release.findByData", query = "SELECT r FROM Release r WHERE r.data = :data")
    , @NamedQuery(name = "Release.findByVersao", query = "SELECT r FROM Release r WHERE r.versao = :versao")
    , @NamedQuery(name = "Release.findByDescricao", query = "SELECT r FROM Release r WHERE r.descricao = :descricao")
    , @NamedQuery(name = "Release.findByLido", query = "SELECT r FROM Release r WHERE r.lido = :lido")})
public class Release implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    private String versao;
    @Basic(optional = false)
    private String descricao;
    @Basic(optional = false)
    private boolean lido;

    public Release() {
    }

    public Release(Long id) {
        this.id = id;
    }

    public Release(Long id, Date data, String versao, String descricao, boolean lido) {
        this.id = id;
        this.data = data;
        this.versao = versao;
        this.descricao = descricao;
        this.lido = lido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getLido() {
        return lido;
    }

    public void setLido(boolean lido) {
        this.lido = lido;
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
        if (!(object instanceof Release)) {
            return false;
        }
        Release other = (Release) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Release[ id=" + id + " ]";
    }

}
