/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konrad.edu.co.kdd.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author julia
 */
@Entity
@Table(name = "ventanilla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventanilla.findAll", query = "SELECT v FROM Ventanilla v"),
    @NamedQuery(name = "Ventanilla.findByIdUsuario", query = "SELECT v FROM Ventanilla v WHERE v.idUsuario = :idUsuario"),
    @NamedQuery(name = "Ventanilla.findByNombre", query = "SELECT v FROM Ventanilla v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Ventanilla.findByContrase\u00f1a", query = "SELECT v FROM Ventanilla v WHERE v.contrase\u00f1a = :contrase\u00f1a")})
public class Ventanilla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a")
    private String contraseña;

    public Ventanilla() {
    }

    public Ventanilla(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Ventanilla(Integer idUsuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.contraseña = contraseña;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventanilla)) {
            return false;
        }
        Ventanilla other = (Ventanilla) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.edu.co.kdd.entity.Ventanilla[ idUsuario=" + idUsuario + " ]";
    }
    
}
