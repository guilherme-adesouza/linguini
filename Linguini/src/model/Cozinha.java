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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guilherme-souza
 */
@Entity
@Table(name = "cozinha", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cozinha.findAll", query = "SELECT c FROM Cozinha c")
    , @NamedQuery(name = "Cozinha.findById", query = "SELECT c FROM Cozinha c WHERE c.id = :id")
    , @NamedQuery(name = "Cozinha.findByCapacidade", query = "SELECT c FROM Cozinha c WHERE c.capacidade = :capacidade")
    , @NamedQuery(name = "Cozinha.findByAuditoria", query = "SELECT c FROM Cozinha c WHERE c.auditoria = :auditoria")})
public class Cozinha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(name = "capacidade", nullable = false)
    private int capacidade;
    @Column(name = "auditoria")
    private Boolean auditoria;

    public Cozinha() {
    }

    public Cozinha(Long id) {
        this.id = id;
    }

    public Cozinha(Long id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Boolean getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(Boolean auditoria) {
        this.auditoria = auditoria;
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
        if (!(object instanceof Cozinha)) {
            return false;
        }
        Cozinha other = (Cozinha) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cozinha[ id=" + id + " ]";
    }
    
}
