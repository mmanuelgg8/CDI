/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;


/**
 *
 * @author mmanu
 */
@Entity
public class PAS extends Usuario implements Serializable {
    
    private String apellido1;
    private String apellido2;
    private String dni;
    private String puesto;
    private String nombre;
    private String email;
    private int telefono;
    private String username;
    private String password;
    
    public PAS(){
        
    }
    
    public PAS(String username,String psw){
        super(username,psw);
    }
    
    public PAS(String ap1,String ap2,String dni,String puesto,String nombre,String email,int tlf, String username,String psw){
        super(nombre,email,tlf,username,psw);
        this.apellido1=ap1;
        this.apellido2=ap2;
        this.dni=dni;
        this.puesto=puesto;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.username);
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
        final PAS other = (PAS) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PAS{" + "apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + nombre + '}';
    }


    
}
