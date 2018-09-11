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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author guilherme-souza
 */
@Entity
@Table(name = "entregador", catalog = "linguini", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregador.findAll", query = "SELECT e FROM Entregador e")
    , @NamedQuery(name = "Entregador.findByPessoaId", query = "SELECT e FROM Entregador e WHERE e.pessoaId = :pessoaId")
    , @NamedQuery(name = "Entregador.findByPlaca", query = "SELECT e FROM Entregador e WHERE e.placa = :placa")})
public class Entregador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pessoa_id", nullable = false)
    private Long pessoaId;
    @Basic(optional = false)
    @Column(name = "placa", nullable = false, length = 7)
    private String placa;
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pessoa pessoa;
    @OneToMany(mappedBy = "entregadorPessoaId")
    private List<Pedido> pedidoList;

    public Entregador() {
    }

    public Entregador(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Entregador(Long pessoaId, String placa) {
        this.pessoaId = pessoaId;
        this.placa = placa;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaId != null ? pessoaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregador)) {
            return false;
        }
        Entregador other = (Entregador) object;
        if ((this.pessoaId == null && other.pessoaId != null) || (this.pessoaId != null && !this.pessoaId.equals(other.pessoaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Entregador[ pessoaId=" + pessoaId + " ]";
    }
    
}
