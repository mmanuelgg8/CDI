package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
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
 * @author Saúl y Manuel
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findProyectoByName", query = "select p from Proyecto p where p.nombre = :pname"),
    @NamedQuery(name = "mostrarProyectos", query = "select p from Proyecto p")
})
public class Proyecto implements Serializable {

    @Id @GeneratedValue
    private Long id;
    @Column (unique = true)
    private String nombre;
    private String requisitos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private boolean estado;
    
    @OneToMany(mappedBy = "pertenece_a")
    private List<Actividad> conformado_por;
    
    @ManyToOne
    private PDI es_creado_por;
    
    public Proyecto(){
        
    }
    public Proyecto(String nombre,String requisitos,Date fecha,boolean estado){
        this.nombre=nombre;
        this.requisitos=requisitos;
        this.fecha=fecha;
        this.estado=estado;
        this.conformado_por=new ArrayList<>();
    }
  
    public List<Actividad> getConformado_por() {
        return conformado_por;
    }

    public void setConformado_por(List<Actividad> conformado_por) {
        this.conformado_por = conformado_por;
    }

    public PDI getEs_creado_por() {
        return es_creado_por;
    }

    public void setEs_creado_por(PDI es_creado_por) {
        this.es_creado_por = es_creado_por;
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

    // Equals usa nombre temporalmente antes de haber implementado la BBDD
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto proyecto = (Proyecto) o;
        return nombre.equals(proyecto.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode()*7;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    


}
