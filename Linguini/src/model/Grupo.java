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
import javax.persistence.FetchType;
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
 * @author vitorolavo
 */
@Entity
@Table(catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
    , @NamedQuery(name = "Grupo.findById", query = "SELECT g FROM Grupo g WHERE g.id = :id")
    , @NamedQuery(name = "Grupo.findByDescricao", query = "SELECT g FROM Grupo g WHERE g.descricao = :descricao")
    , @NamedQuery(name = "Grupo.findByModuloFinanceiro", query = "SELECT g FROM Grupo g WHERE g.moduloFinanceiro = :moduloFinanceiro")
    , @NamedQuery(name = "Grupo.findByModuloGestao", query = "SELECT g FROM Grupo g WHERE g.moduloGestao = :moduloGestao")
    , @NamedQuery(name = "Grupo.findByModuloCaixa", query = "SELECT g FROM Grupo g WHERE g.moduloCaixa = :moduloCaixa")
    , @NamedQuery(name = "Grupo.findByModuloCozinha", query = "SELECT g FROM Grupo g WHERE g.moduloCozinha = :moduloCozinha")
    , @NamedQuery(name = "Grupo.findByModuloAtendente", query = "SELECT g FROM Grupo g WHERE g.moduloAtendente = :moduloAtendente")
    , @NamedQuery(name = "Grupo.findByModuloAdmin", query = "SELECT g FROM Grupo g WHERE g.moduloAdmin = :moduloAdmin")})
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @Column(nullable = false, length = 60)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "modulo_financeiro", nullable = false)
    private boolean moduloFinanceiro;
    @Basic(optional = false)
    @Column(name = "modulo_gestao", nullable = false)
    private boolean moduloGestao;
    @Basic(optional = false)
    @Column(name = "modulo_caixa", nullable = false)
    private boolean moduloCaixa;
    @Basic(optional = false)
    @Column(name = "modulo_cozinha", nullable = false)
    private boolean moduloCozinha;
    @Basic(optional = false)
    @Column(name = "modulo_atendente", nullable = false)
    private boolean moduloAtendente;
    @Basic(optional = false)
    @Column(name = "modulo_admin", nullable = false)
    private boolean moduloAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoId", fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;

    public Grupo() {
    }

    public Grupo(Long id) {
        this.id = id;
    }

    public Grupo(Long id, String descricao, boolean moduloFinanceiro, boolean moduloGestao, boolean moduloCaixa, boolean moduloCozinha, boolean moduloAtendente, boolean moduloAdmin) {
        this.id = id;
        this.descricao = descricao;
        this.moduloFinanceiro = moduloFinanceiro;
        this.moduloGestao = moduloGestao;
        this.moduloCaixa = moduloCaixa;
        this.moduloCozinha = moduloCozinha;
        this.moduloAtendente = moduloAtendente;
        this.moduloAdmin = moduloAdmin;
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

    public boolean getModuloFinanceiro() {
        return moduloFinanceiro;
    }

    public void setModuloFinanceiro(boolean moduloFinanceiro) {
        this.moduloFinanceiro = moduloFinanceiro;
    }

    public boolean getModuloGestao() {
        return moduloGestao;
    }

    public void setModuloGestao(boolean moduloGestao) {
        this.moduloGestao = moduloGestao;
    }

    public boolean getModuloCaixa() {
        return moduloCaixa;
    }

    public void setModuloCaixa(boolean moduloCaixa) {
        this.moduloCaixa = moduloCaixa;
    }

    public boolean getModuloCozinha() {
        return moduloCozinha;
    }

    public void setModuloCozinha(boolean moduloCozinha) {
        this.moduloCozinha = moduloCozinha;
    }

    public boolean getModuloAtendente() {
        return moduloAtendente;
    }

    public void setModuloAtendente(boolean moduloAtendente) {
        this.moduloAtendente = moduloAtendente;
    }

    public boolean getModuloAdmin() {
        return moduloAdmin;
    }

    public void setModuloAdmin(boolean moduloAdmin) {
        this.moduloAdmin = moduloAdmin;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Grupo[ id=" + id + " ]";
    }
    
}
