    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.CDIException;
import es.uma.informatica.sii.cdi.modelo.PasswordInvalidaException;
import es.uma.informatica.sii.cdi.modelo.UsernameInactivoException;
import es.uma.informatica.sii.cdi.modelo.UsernameInexistenteException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Saúl
 */

@Named(value = "login")
@SessionScoped
public class Login implements Serializable{
    
    @Inject
    private CDI cdi;
    
    @Inject
    private ControlAutorizacion ctrl;

    private Usuario usuario;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuario = new Usuario();
    }
     
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String autenticar() {
        try{
            cdi.compruebaLogin(usuario);
            ctrl.setUsuario(cdi.refrescarUsuario(usuario));
            return ctrl.home();
        } catch (UsernameInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (PasswordInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (UsernameInactivoException e) {
            FacesMessage fm = new FacesMessage("La cuenta existe pero no está activa");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (CDIException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
        
        
        
        // Implementar este método
        
        /*
        String res = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (this.usuario.length() == 0) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Introduzca el usuario", "Introduzca el usuario"));
        } else {
            Usuario actual = null;
            for (Usuario user : usuarios) {
                if (user.getUsername().equals(this.usuario)) {
                    actual = user;
                }
            }
            if (actual == null) {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no existe", "El usuario no existe"));
            } else if (!password.contentEquals(actual.getPassword())) {
                ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrasenia incorrecta", "Contrasenia incorrecta"));
            } else {
                ctrl.setUsuario(actual);
                res = ctrl.home();
            }
        }
        return res;
        */
    }

}
