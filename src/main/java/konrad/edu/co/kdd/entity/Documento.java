package konrad.edu.co.kdd.entity;

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
 * @author Grupo 2
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d"),
    @NamedQuery(name = "Documento.findByNumeroRadicado", query = "SELECT d FROM Documento d WHERE d.numeroRadicado = :numeroRadicado"),
    @NamedQuery(name = "Documento.findByTitulo", query = "SELECT d FROM Documento d WHERE d.titulo = :titulo"),
    @NamedQuery(name = "Documento.findByFechaDocumento", query = "SELECT d FROM Documento d WHERE d.fechaDocumento = :fechaDocumento"),
    @NamedQuery(name = "Documento.findByFechaRadicado", query = "SELECT d FROM Documento d WHERE d.fechaRadicado = :fechaRadicado"),
    @NamedQuery(name = "Documento.findByOrigen", query = "SELECT d FROM Documento d WHERE d.origen = :origen"),
    @NamedQuery(name = "Documento.findByComentarios", query = "SELECT d FROM Documento d WHERE d.comentarios = :comentarios"),
    @NamedQuery(name = "Documento.findByAnexo", query = "SELECT d FROM Documento d WHERE d.anexo = :anexo")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero_radicado")
    private Integer numeroRadicado;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "fecha_documento")
    private String fechaDocumento;
    @Column(name = "fecha_radicado")
    private String fechaRadicado;
    @Column(name = "origen")
    private String origen;
    @Column(name = "comentarios")
    private String comentarios;
    @Column(name = "anexo")
    private String anexo;
    @JoinColumn(name = "asunto", referencedColumnName = "id_asunto")
    @ManyToOne
    private Asunto asunto;
    @JoinColumn(name = "destino", referencedColumnName = "id_funcionario")
    @ManyToOne
    private Funcionario destino;
    @JoinColumn(name = "usaurio_recibe", referencedColumnName = "id_usuario")
    @ManyToOne
    private Ventanilla usaurioRecibe;

    public Documento() {
    }

    public Documento(Integer numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public Integer getNumeroRadicado() {
        return numeroRadicado;
    }

    public void setNumeroRadicado(Integer numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(String fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public String getFechaRadicado() {
        return fechaRadicado;
    }

    public void setFechaRadicado(String fechaRadicado) {
        this.fechaRadicado = fechaRadicado;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Asunto getAsunto() {
        return asunto;
    }

    public void setAsunto(Asunto asunto) {
        this.asunto = asunto;
    }

    public Funcionario getDestino() {
        return destino;
    }

    public void setDestino(Funcionario destino) {
        this.destino = destino;
    }

    public Ventanilla getUsaurioRecibe() {
        return usaurioRecibe;
    }

    public void setUsaurioRecibe(Ventanilla usaurioRecibe) {
        this.usaurioRecibe = usaurioRecibe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroRadicado != null ? numeroRadicado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.numeroRadicado == null && other.numeroRadicado != null) || (this.numeroRadicado != null && !this.numeroRadicado.equals(other.numeroRadicado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "konrad.edu.co.kdd.entity.Documento[ numeroRadicado=" + numeroRadicado + " ]";
    }
    
}
