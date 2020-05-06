/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author mmanu
 */
@Entity
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String requisitos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private boolean estado;
    private int tipo;
    private String Zona;
    private String horario;
    private String informacion;
    
    public Actividad(){
        
    }

    public Actividad(String nombre, String requisitos,Date fecha,boolean estado,int tipo,String zona,String horario,String informacion,ONG ong){
        this.nombre=nombre;
        this.requisitos=requisitos;
        this.fecha=fecha;
        this.estado=estado;
        this.tipo=tipo;
        this.Zona=zona;
        this.horario=horario;
        this.informacion=informacion;
        this.es_gestionada_por=ong;
        
    }

    @ManyToOne
    private Proyecto pertenece_a;
    
    @ManyToOne
    private Usuario es_elegida_por;

    @ManyToOne
    private ONG es_gestionada_por;
    
    @ManyToOne
    private PDI es_gestionada;
    
    @OneToMany(mappedBy = "esta_asociada_a")
    private List<Inscripcion> lista_de_inscritos;
    
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
    
    public ONG getONG(){
        return es_gestionada_por;
    }
    
    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    @OneToMany
    private List<Inscripcion> inscripciones;
    
    
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String Zona) {
        this.Zona = Zona;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
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
    
    //Equals usa temporalmente nombre hasta que se implemente la BBDD
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdi.Actividad[ id=" + id + " ]";
    }
    
}
