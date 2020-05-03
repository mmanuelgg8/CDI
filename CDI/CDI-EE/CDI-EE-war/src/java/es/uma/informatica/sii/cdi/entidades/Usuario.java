/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
/**
 *
 * @author mmanu
 */
@Entity
public class Usuario implements Serializable {
    @Id
     Long id;
    String username;
    private String password;
    String nombre;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_prefer;
    private String ambito_prefer;
    private String trabajo_prefer;
    private int telefono;
    private String cadenaValidacion;
    
    
    public Usuario(){
        
    }
    public Usuario(String username,String password){
        this.username=username;
        this.password=password;
          
    }
    
    public Usuario(String nombre,String email,int tlf, String username,String password){
        this.nombre=nombre;
        this.telefono=tlf;
        this.email=email;
        this.username=username;
        this.password=password;
        
    }
        
    @OneToMany(mappedBy = "pertenece_a")
    private List<Inscripcion> esta_inscrito_en;
    
    @OneToMany(mappedBy = "es_elegida_por")
    private List<Actividad> elige;

    public List<Inscripcion> getInscripcion() {
        return esta_inscrito_en;
    }

    public void setInscripcion(List<Inscripcion> esta_inscrito_en) {
        this.esta_inscrito_en = esta_inscrito_en;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_prefer() {
        return fecha_prefer;
    }

    public void setFecha_prefer(Date fecha_prefer) {
        this.fecha_prefer = fecha_prefer;
    }

    public String getAmbito_prefer() {
        return ambito_prefer;
    }

    public void setAmbito_prefer(String ambito_prefer) {
        this.ambito_prefer = ambito_prefer;
    }

    public String getTrabajo_prefer() {
        return trabajo_prefer;
    }

    public void setTrabajo_prefer(String trabajo_prefer) {
        this.trabajo_prefer = trabajo_prefer;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Inscripcion> getEsta_inscrito_en() {
        return esta_inscrito_en;
    }

    public void setEsta_inscrito_en(List<Inscripcion> esta_inscrito_en) {
        this.esta_inscrito_en = esta_inscrito_en;
    }

    public List<Actividad> getElige() {
        return elige;
    }

    public void setElige(List<Actividad> elige) {
        this.elige = elige;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.username);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", email=" + email + '}';
    }

    public void setCadenaValidacion(String generarCadenaAleatoria) {
        this.cadenaValidacion = generarCadenaAleatoria;
    }

    public String getCadenaValidacion() {
        return cadenaValidacion;
    }

    

    
    
}
