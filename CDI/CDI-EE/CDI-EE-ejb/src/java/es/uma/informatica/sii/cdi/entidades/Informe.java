package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

@Entity
@NamedQueries({
    @NamedQuery(name = "mostrarInformesByInscripcion", query = "select i from Informe i where i.contenido = :inscripcion"),
    @NamedQuery(name = "mostrarInformes", query = "select i from Informe i"),
})
public class Informe implements Serializable {

    @Id
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private boolean reportado;
    private String comentarios;
    
    @ManyToOne
    private Inscripcion contenido;
    
    public Informe(){
        
    }
    
    public Informe(Date fecha, boolean repor, String comentarios){
        this.fecha=fecha;
        this.reportado=repor;
        this.comentarios=comentarios;
    }

    public Inscripcion getContenido() {
        return contenido;
    }

    public void setContenido(Inscripcion contenido) {
        this.contenido = contenido;
    }
    
   public Long getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isReportado() {
        return reportado;
    }

    public void setReportado(boolean reportado) {
        this.reportado = reportado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setId(Long id) {
        this.id = id;
    }
    


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Informe informe = (Informe) o;
        return id.equals(informe.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "cdi.Informe[ id=" + id + " ]";
    }
    
}
