/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Saúl
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "mostrarInscripciones", query = "select i from Inscripcion i where i.pertenece_a = :user "),
    @NamedQuery(name = "mostrarActividadesByInscripcion", query = "select distinct a from Inscripcion i join i.esta_asociada_a a where i.pertenece_a = :user"),
    @NamedQuery(name = "findInscripcionByUsuarioActividad", query = "select i from Inscripcion i where i.pertenece_a.nombre = :user and i.esta_asociada_a.nombre = :actividad")
})
public class Inscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean estado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @OneToMany(mappedBy = "contenido")
    private List<Informe> contiene;
    
    @ManyToOne
    private Actividad esta_asociada_a;

    @ManyToOne
    private Usuario pertenece_a;

    @ManyToOne
    private PDI es_administrada_por;
    
    public Inscripcion(){
        
    }
    public Inscripcion(Date fecha,boolean estado){
        this.fecha=fecha;
        this.estado=estado;
        this.contiene = new ArrayList<>();
    }

    public Inscripcion(Date fecha,boolean estado, Usuario u, Actividad a){
        this.fecha=fecha;
        this.estado=estado;
        this.esta_asociada_a=a;
        this.pertenece_a=u;
        this.es_administrada_por = esta_asociada_a.getPertenece_a().getEs_creado_por();
        this.contiene = new ArrayList<>();
    }
    
    public List<Informe> getContiene() {
        return contiene;
    }

    public Actividad getEsta_asociada_a() {
        return esta_asociada_a;
    }

    public void setEsta_asociada_a(Actividad esta_asociada_a) {
        this.esta_asociada_a = esta_asociada_a;
    }

    public Usuario getPertenece_a() {
        return pertenece_a;
    }

    public void setPertenece_a(Usuario pertenece_a) {
        this.pertenece_a = pertenece_a;
    }

    public PDI getEs_administrada_por() {
        return es_administrada_por;
    }

    public void setEs_administrada_por(PDI es_administrada_por) {
        this.es_administrada_por = es_administrada_por;
    }

    public void setContiene(List<Informe> contiene) {
        this.contiene = contiene;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Inscripcion)) {
            return false;
        }
        Inscripcion other = (Inscripcion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdi.Inscripcion[ id=" + id + " ]";
    }
    
}
