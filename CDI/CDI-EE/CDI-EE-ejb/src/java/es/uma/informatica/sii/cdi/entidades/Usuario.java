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
    private String nombre;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_prefer;
    private String ambito_prefer;
    private String trabajo_prefer;
    private int telefono;
    private String username;
    private String password;
    
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
    
    public Long getId() {
        return id;
    }

    public void setId(long ID) {
        this.id = ID;
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
    
}
