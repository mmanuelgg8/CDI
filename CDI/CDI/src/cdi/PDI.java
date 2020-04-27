/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author mmanu
 */
@Entity
public class PDI extends Usuario implements Serializable {
    
    private String apellido1;
    private String apellido2;
    private String dni;
    private String titulacion;
    private String deparatmento;
    private int despacho;
    private boolean rol_gestor;
    
    @OneToMany(mappedBy = "es_gestionada")
    private List<Actividad> gestiona;
    
    @OneToMany(mappedBy = "es_creado_por")
    private List<Proyecto> crea;

    @OneToMany(mappedBy = "es_administrada_por")
    private List<Inscripcion> administra;
    
    @ManyToMany(mappedBy="es_gestionada_por")
    private List<Asignatura> enseña_en;
    
    public void setEnseña_en(List<Asignatura> enseña_en) {
        this.enseña_en = enseña_en;
    }
    
    public List<Asignatura> getEnseña_en() {
        return enseña_en;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getDeparatmento() {
        return deparatmento;
    }

    public void setDeparatmento(String deparatmento) {
        this.deparatmento = deparatmento;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    public boolean isRol_gestor() {
        return rol_gestor;
    }

    public void setRol_gestor(boolean rol_gestor) {
        this.rol_gestor = rol_gestor;
    }

    
    
 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.id != null ? super.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PDI)) {
            return false;
        }
        PDI other = (PDI) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdi.PDI[ id=" + id + " ]";
    }

    
}
