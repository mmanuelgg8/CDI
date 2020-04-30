/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.backingbeans;

import es.uma.informatica.sii.cdi.entidades.*;
import javax.faces.context.FacesContext;

/**
 *
 * @author nicol
 */
public class ControlAutorizacion {
    private Usuario usuario;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String home() {
        // Implementar el método
        // Devuelve la página Home dependiendo del rol del usuario
        // Si no hay usuario debe devolver la página de login
        // Si el usuario es el administrador debe devolver la página admin.xhtml
        // Si el usuario es un usuario normal debe devolver la página normal.xhtml
       
        if(usuario instanceof PDI ){
            PDI aux = (PDI) usuario;
            if(aux.isRol_gestor()){
                return "HomeGestor.xhtml";
            }else{
                return "Home.xtml";
            }
        }else{
            return "Home.xhtml";
        }
    }
    
    public String logout()
    {
        // Destruye la sesión (y con ello, el ámbito de este bean)
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        usuario = null;
        return "login.xhtml";
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlAutorizacion() {
    }
}
