package model;
// Generated 06/08/2018 21:12:34 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Entregador generated by hbm2java
 */
@Entity
@Table(name="entregador"
    ,schema="public"
)
public class Entregador  implements java.io.Serializable {


     private int pessoaId;
     private Pessoa pessoa;
     private String placa;
     private Set pedidos = new HashSet(0);

    public Entregador() {
    }

	
    public Entregador(Pessoa pessoa, String placa) {
        this.pessoa = pessoa;
        this.placa = placa;
    }
    public Entregador(Pessoa pessoa, String placa, Set pedidos) {
       this.pessoa = pessoa;
       this.placa = placa;
       this.pedidos = pedidos;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="pessoa"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="pessoa_id", unique=true, nullable=false)
    public int getPessoaId() {
        return this.pessoaId;
    }
    
    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn
    public Pessoa getPessoa() {
        return this.pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
    @Column(name="placa", nullable=false, length=7)
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="entregador")
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }




}


