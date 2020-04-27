package cdi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Proyecto implements Serializable {

    @Id
    private Long id;
    
    private String nombre;
    private String requisitos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private boolean estado;
  
    @OneToMany(mappedBy = "pertenece_a")
    private List<Actividad> conformado_por;
    
    @ManyToOne
    private PDI es_creado_por;

    public List<Actividad> getConformado_por() {
        return conformado_por;
    }

    public void setConformado_por(List<Actividad> conformado_por) {
        this.conformado_por = conformado_por;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto proyecto = (Proyecto) o;
        return id.equals(proyecto.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }


}
