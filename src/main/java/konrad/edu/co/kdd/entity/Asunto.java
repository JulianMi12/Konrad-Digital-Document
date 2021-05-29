package konrad.edu.co.kdd.entity;

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
 * @author Grupo 2
 */
@Entity
@Table(name = "asunto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asunto.findAll", query = "SELECT a FROM Asunto a"),
    @NamedQuery(name = "Asunto.findByIdAsunto", query = "SELECT a FROM Asunto a WHERE a.idAsunto = :idAsunto"),
    @NamedQuery(name = "Asunto.findByNombre", query = "SELECT a FROM Asunto a WHERE a.nombre = :nombre")})
public class Asunto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asunto")
    private Integer idAsunto;
    @Column(name = "nombre")
    private String nombre;

    public Asunto() {
    }

    public Asunto(Integer idAsunto) {
        this.idAsunto = idAsunto;
    }

    public Integer getIdAsunto() {
        return idAsunto;
    }

    public void setIdAsunto(Integer idAsunto) {
        this.idAsunto = idAsunto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsunto != null ? idAsunto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asunto)) {
            return false;
        }
        Asunto other = (Asunto) object;
        if ((this.idAsunto == null && other.idAsunto != null) || (this.idAsunto != null && !this.idAsunto.equals(other.idAsunto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.edu.co.kdd.entity.Asunto[ idAsunto=" + idAsunto + " ]";
    }
    
}
