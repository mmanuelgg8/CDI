/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Temporal;

/**
 *
 * @author Andres
 */
public class EditarPerfil {
    private Usuario userpriv;
    
    private String username;
    private String password;
    private String nombre;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_prefer;
    private String ambito_prefer;
    private String trabajo_prefer;
    private int telefono;
    private List<Usuario> usuariosawa;
    @Inject
    private ControlAutorizacion ctrl;
    
    public EditarPerfil(){
        usuariosawa=new ArrayList<>();
        
        Usuario u1 = new Usuario("awa","awa");
        Usuario u2 = new Usuario("awaa","awa");
        Usuario u3 = new Usuario("awaaa","awa");
        usuariosawa.add(u1);
        usuariosawa.add(u2);
        usuariosawa.add(u3);
       
    }
    
    private void guardarcambios(){
        int pos=usuariosawa.indexOf(userpriv);
        Usuario auxxaaa=usuariosawa.get(pos);
        auxxaaa.setFecha_prefer(fecha_prefer);
        auxxaaa.setTrabajo_prefer(trabajo_prefer);
        auxxaaa.setUsername(username);
        auxxaaa.setPassword(password);
        auxxaaa.setNombre(nombre);
        auxxaaa.setTelefono(telefono);
        auxxaaa.setAmbito_prefer(ambito_prefer);
        usuariosawa.add(pos,auxxaaa);
    }
    
    

    public Usuario getUserpriv() {
        return userpriv;
    }

    public void setUserpriv(Usuario userpriv) {
        this.userpriv = userpriv;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
   
    
    
    
}
