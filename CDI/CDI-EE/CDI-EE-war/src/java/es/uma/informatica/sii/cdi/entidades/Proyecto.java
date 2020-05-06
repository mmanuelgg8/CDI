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
    private List<Actividad> actividades;
    
    public Proyecto(){
        
    }
    public Proyecto(String nombre,String requisitos,Date fecha,boolean estado){
        this.nombre=nombre;
        this.requisitos=requisitos;
        this.fecha=fecha;
        this.estado=estado;
        actividades=new ArrayList<>();
        
    }
  
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
    public List<Actividad> getListaActividades(){
        return actividades;
    }
    public void setListaActividades(List<Actividad> actividades){
        this.actividades=actividades;
    }
    public void addActividades(Long id){
        for(Actividad a: actividades){
            if(a.getId()==id){
                actividades.add(a);
            }
        }
        
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
        return nombre.hashCode()*7;
    }


}
