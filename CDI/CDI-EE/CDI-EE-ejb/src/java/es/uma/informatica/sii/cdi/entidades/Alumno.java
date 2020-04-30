/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author mmanu
 */
@Entity
public class Alumno extends Usuario implements Serializable  {
   //ewfn
    private String apellido1;
    private String apellido2;
    private String grado;
    private String curso;
    private int pref_Cuatrimestre;
    private String dni;
    @ManyToMany(mappedBy="tiene_a")
    private List<Asignatura> matriculado_en;

    public List<Asignatura> getMatriculado_en() {
        return matriculado_en;
    }

    public void setMatriculado_en(List<Asignatura> matriculado_en) {
        this.matriculado_en = matriculado_en;
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

    public String getGrado_estudio() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getPref_Cuatrimestre() {
        return pref_Cuatrimestre;
    }

    public void setPrefer_Cuatrimestre(int pref_Cuatrimestre) {
        this.pref_Cuatrimestre = pref_Cuatrimestre;
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
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdi.Alumno[ id=" + id + " ]";
    }
    
}
