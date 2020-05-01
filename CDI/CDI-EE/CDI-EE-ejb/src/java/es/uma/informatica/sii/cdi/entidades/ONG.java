/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.entidades;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class ONG extends Usuario {
    
    private String ubicacion;
    private String web;
    private String nombre;
    private String email;
    private int telefono;
    private String username;
    private String password;
    
    public ONG(){
        
    }
    public ONG(String username,String psw){
        super(username,psw);
    }
    
    public ONG(String ubicacion,String web,String nombre,String email,int tlf, String username,String psw){
        super(nombre,email,tlf,username,psw);
        this.ubicacion=ubicacion;
        this.web=web;
    }
    
    @OneToMany(mappedBy = "es_gestionada_por")
    private List<Actividad> gestiona;
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.username);
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
        final ONG other = (ONG) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ONG{" + "web=" + web + ", nombre=" + nombre + '}';
    }


   
    
}
