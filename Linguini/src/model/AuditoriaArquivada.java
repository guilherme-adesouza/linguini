package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author guilherme-souza
 */
@Entity
@Table(name = "filed_logged_actions", catalog = "linguini", schema = "audit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaArquivada.findAll", query = "SELECT b FROM AuditoriaArquivada b")
    , @NamedQuery(name = "AuditoriaArquivada.findById", query = "SELECT b FROM AuditoriaArquivada b WHERE b.id = :id")})
public class AuditoriaArquivada implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "schema_name", nullable = false, length = 2147483647)
    private String schema_name;
    @Basic(optional = false)
    @Column(name = "table_name", nullable = false, length = 2147483647)
    private String table_name;
    @Column(name = "user_name", length = 2147483647)
    private String user_name;
    @Basic(optional = false)
    @Column(name = "action_tstamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date action_tstamp;
    @Basic(optional = false)
    @Column(name = "action", nullable = false, length = 2147483647)
    private String action;
    @Column(name = "original_data", length = 2147483647)
    private String original_data;
    @Column(name = "new_data", length = 2147483647)
    private String new_data;
    @Column(name = "query", length = 2147483647)
    private String query;

    public AuditoriaArquivada() {
    }

    public AuditoriaArquivada(Integer id) {
        this.id = id;
    }

    public AuditoriaArquivada(Integer id, String schema_name, String table_name, Date action_tstamp, String action) {
        this.id = id;
        this.schema_name = schema_name;
        this.table_name = table_name;
        this.action_tstamp = action_tstamp;
        this.action = action;
    }

    public AuditoriaArquivada(Integer id, String schema_name, String table_name, String user_name, Date action_tstamp, String action, String original_data, String new_data, String query) {
        this.id = id;
        this.schema_name = schema_name;
        this.table_name = table_name;
        this.user_name = user_name;
        this.action_tstamp = action_tstamp;
        this.action = action;
        this.original_data = original_data;
        this.new_data = new_data;
        this.query = query;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchema_name() {
        return schema_name;
    }

    public void setSchema_name(String schema_name) {
        this.schema_name = schema_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Date getAction_tstamp() {
        return action_tstamp;
    }

    public void setAction_tstamp(Date action_tstamp) {
        this.action_tstamp = action_tstamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOriginal_data() {
        return original_data;
    }

    public void setOriginal_data(String original_data) {
        this.original_data = original_data;
    }

    public String getNew_data() {
        return new_data;
    }

    public void setNew_data(String new_data) {
        this.new_data = new_data;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
        if (!(object instanceof AuditoriaArquivada)) {
            return false;
        }
        AuditoriaArquivada other = (AuditoriaArquivada) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AuditoriaArquivada[ id=" + id + " ]";
    }
}
