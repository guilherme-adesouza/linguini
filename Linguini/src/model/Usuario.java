package model;
// Generated 06/08/2018 21:12:34 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,schema="public"
)
public class Usuario  implements java.io.Serializable {


     private int id;
     private Grupo grupo;
     private String nome;
     private String senha;
     private boolean situacao;
     private Set auditorias = new HashSet(0);
     private Set pedidosForCaixaId = new HashSet(0);
     private Set pedidosForAtendenteId = new HashSet(0);
     private Set funcionarios = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(int id, Grupo grupo, String nome, String senha, boolean situacao) {
        this.id = id;
        this.grupo = grupo;
        this.nome = nome;
        this.senha = senha;
        this.situacao = situacao;
    }
    public Usuario(int id, Grupo grupo, String nome, String senha, boolean situacao, Set auditorias, Set pedidosForCaixaId, Set pedidosForAtendenteId, Set funcionarios) {
       this.id = id;
       this.grupo = grupo;
       this.nome = nome;
       this.senha = senha;
       this.situacao = situacao;
       this.auditorias = auditorias;
       this.pedidosForCaixaId = pedidosForCaixaId;
       this.pedidosForAtendenteId = pedidosForAtendenteId;
       this.funcionarios = funcionarios;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grupo_id", nullable=false)
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
    @Column(name="nome", nullable=false, length=150)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    @Column(name="senha", nullable=false, length=150)
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    @Column(name="situacao", nullable=false)
    public boolean isSituacao() {
        return this.situacao;
    }
    
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getAuditorias() {
        return this.auditorias;
    }
    
    public void setAuditorias(Set auditorias) {
        this.auditorias = auditorias;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuarioByCaixaId")
    public Set getPedidosForCaixaId() {
        return this.pedidosForCaixaId;
    }
    
    public void setPedidosForCaixaId(Set pedidosForCaixaId) {
        this.pedidosForCaixaId = pedidosForCaixaId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuarioByAtendenteId")
    public Set getPedidosForAtendenteId() {
        return this.pedidosForAtendenteId;
    }
    
    public void setPedidosForAtendenteId(Set pedidosForAtendenteId) {
        this.pedidosForAtendenteId = pedidosForAtendenteId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionarios(Set funcionarios) {
        this.funcionarios = funcionarios;
    }




}


