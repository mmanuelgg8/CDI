/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Alumno;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.PAS;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.CDIException;
import es.uma.informatica.sii.cdi.modelo.UsernameRepetidoException;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Saúl
 */
@Named(value = "registro")
@RequestScoped
public class Registro {
    
    //@Inject
    @EJB
    private CDI cdi;
    
    private Usuario user;
    private String passwordrepeat;
    private String clase;
    
    private String cuenta;
    private String code;
    private boolean validado;
    private String mensajeval;
    
    public Registro(){
        user = new Usuario();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getPasswordrepeat() {
        return passwordrepeat;
    }

    public void setPasswordrepeat(String passwordrepeat) {
        this.passwordrepeat = passwordrepeat;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public String getMensajeval() {
        return mensajeval;
    }

    public void setMensajeval(String mensajeval) {
        this.mensajeval = mensajeval;
    }
    
    
    
    
    
    public String aniadirusuario(){
       //if(password.equals(passwordrepeat)){
        //System.out.println(user.getUsername().length());
        //System.out.println(password);
        if (user.getUsername().length()==0){
            FacesMessage fm = new FacesMessage("Introduzca un usuario");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);
            return null;
        }
        if (user.getPassword().length()==0){
            FacesMessage fm = new FacesMessage("Introduzca una contraseña");
            FacesContext.getCurrentInstance().addMessage("registro:pass", fm);
            return null;
        }
        if (!user.getPassword().equals(passwordrepeat)) {
            FacesMessage fm = new FacesMessage("Las contraseñas deben coincidir");
            FacesContext.getCurrentInstance().addMessage("registro:pass", fm);
            return null;
        }
        
        try{
            cdi.registrarUsuario(user, clase);
        } catch (UsernameRepetidoException e){
            FacesMessage fm = new FacesMessage("El usuario ya existe");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);
            return null;
        } catch (CDIException e){    
            
        }
          
       //}
	   return "validar.xhtml";
    }
    
    public String validarCuenta() {
        try {
            if (cuenta != null && code != null) {
                cdi.validarCuenta(cuenta, code);
            }
            mensajeval = "La validación ha sido correcta, ahora puede acceder con este usuario.";
            validado = true;
        } catch (CDIException e) {
            mensajeval = "Ha habido un error con la validación, compruebe que la URL es correcta.";
            validado = false;
        }
        return null;
    }
    
}
