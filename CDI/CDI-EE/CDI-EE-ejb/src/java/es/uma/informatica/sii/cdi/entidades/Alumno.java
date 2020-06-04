/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author mmanu
 */
@Entity
public class Alumno extends Usuario implements Serializable  {
    private String apellido1;
    private String apellido2;
    private String grado;
    private String curso;
    private int pref_Cuatrimestre;
    private String dni;
    
    @ManyToMany(mappedBy="tiene_a")
    private List<Asignatura> matriculado_en;
    
    public Alumno(){
        this.matriculado_en = new ArrayList<>();
    }
    public Alumno(String username,String psw){
        super(username,psw);
        this.matriculado_en = new ArrayList<>();
    }
    
    public Alumno(String ap1,String ap2,String grado,String curso,int cuat,String dni,String nombre,String email,int tlf, String username,String psw){
        super(nombre,email,tlf,username,psw);
        this.apellido1=ap1;
        this.apellido2=ap2;
        this.grado=grado;
        this.curso=curso;
        this.pref_Cuatrimestre=cuat;
        this.dni=dni;
        this.matriculado_en = new ArrayList<>();
    }

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
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.getUsername());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.getUsername(), other.getUsername())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Alumno{" + "apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + this.getNombre() + '}';
    }

    
    
}
