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
    private String departamento;
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
 
    public PDI(){
        
    }
    public PDI(String username,String psw){
        super(username,psw);
        gestiona = new ArrayList();
        crea = new ArrayList();
        administra = new ArrayList();
        enseña_en = new ArrayList();
    }
    
    public PDI(String ap1,String ap2,String dni,String titulacion,String dpto,int despacho,String nombre,String email,int tlf, String username,String psw,boolean rol){
        super(nombre,email,tlf,username,psw);
        this.apellido1=ap1;
        this.apellido2=ap2;
        this.dni=dni;
        this.titulacion=titulacion;
        this.departamento=dpto;
        this.despacho=despacho;
        this.rol_gestor=rol;
        gestiona = new ArrayList();
        crea = new ArrayList();
        administra = new ArrayList();
        enseña_en = new ArrayList();
    }
    
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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

    public List<Actividad> getGestiona() {
        return gestiona;
    }

    public void setGestiona(List<Actividad> gestiona) {
        this.gestiona = gestiona;
    }

    public List<Proyecto> getCrea() {
        return crea;
    }

    public void setCrea(List<Proyecto> crea) {
        this.crea = crea;
    }

    public List<Inscripcion> getAdministra() {
        return administra;
    }

    public void setAdministra(List<Inscripcion> administra) {
        this.administra = administra;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final PDI other = (PDI) obj;
        if (!Objects.equals(this.getUsername(), other.getUsername())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PDI{" + "apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + this.getNombre() + '}';
    }

    


    
}
