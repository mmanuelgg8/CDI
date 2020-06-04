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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "findActividadByName", query = "select a from Actividad a where a.nombre = :aname"),
    @NamedQuery(name = "mostrarActividades", query = "select a from Actividad a"),
})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private String requisitos;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    private boolean estado;
    private int tipo;
    private String Zona;
    private String horario;
    private String informacion;

    @ManyToOne
    private Proyecto pertenece_a;
    
    @ManyToMany
    private List<Usuario> es_elegida_por;

    @ManyToOne
    private ONG es_gestionada_por;
    
    @ManyToOne
    private PDI es_gestionada;
    
    @OneToMany(mappedBy = "esta_asociada_a")
    private List<Inscripcion> lista_de_inscritos;
    
    public Actividad(){
        this.es_elegida_por = new ArrayList<>();
        this.lista_de_inscritos = new ArrayList<>();
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
        this.es_elegida_por = new ArrayList<>();
        this.lista_de_inscritos = new ArrayList<>();
    }

    public List<Usuario> getEs_elegida_por() {
        return es_elegida_por;
    }

    public void setEs_elegida_por(List<Usuario> es_elegida_por) {
        this.es_elegida_por = es_elegida_por;
    }

    public Proyecto getPertenece_a() {
        return pertenece_a;
    }

    public void setPertenece_a(Proyecto pertenece_a) {
        this.pertenece_a = pertenece_a;
    }

    public ONG getEs_gestionada_por() {
        return es_gestionada_por;
    }

    public void setEs_gestionada_por(ONG es_gestionada_por) {
        this.es_gestionada_por = es_gestionada_por;
    }

    public PDI getEs_gestionada() {
        return es_gestionada;
    }

    public void setEs_gestionada(PDI es_gestionada) {
        this.es_gestionada = es_gestionada;
    }

    public List<Inscripcion> getLista_de_inscritos() {
        return lista_de_inscritos;
    }

    public void setLista_de_inscritos(List<Inscripcion> lista_de_inscritos) {
        this.lista_de_inscritos = lista_de_inscritos;
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
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdi.Actividad[ id=" + id + " ]";
    }
    
}
