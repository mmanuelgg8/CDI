/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.Temporal;

/**
 *
 * @author Andres
 */
public class EditarPerfil {
    private Usuario us;
    private String email;
    private String username;
    private String password;
    private String nombre;
    private int telefono;
    
    private List<Usuario> usuarios;
    @Inject
    private ControlAutorizacion ctrl;
    
    public EditarPerfil(){
        usuarios=new ArrayList<>();
        us.setNombre("naruto");
  
        Usuario u1 = new Usuario("awa","awa");
        Usuario u2 = new Usuario("awaa","awa");
        Usuario u3 = new Usuario("awaaa","awa");
        u1.setEmail("naruto@love.sasuke");
        u1.setNombre("naruto");
        u1.setTelefono(69);
        us=u1;
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
       
    }
    
    private void guardarCambios(){
        int pos=usuarios.indexOf(us);
        Usuario u=usuarios.get(pos);
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);
        u.setNombre(nombre);
        u.setTelefono(telefono);
        usuarios.add(pos,u);
        ctrl.home();
    }
    
    

    public Usuario getUserpriv() {
        return us;
    }

    public void setUserpriv(Usuario userpriv) {
        this.us = userpriv;
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
    
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
   
    
    
    
}
