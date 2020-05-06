    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.*;
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
 * @author elena y julio
 */

@Named(value = "login")
@SessionScoped
public class Login implements Serializable{

    private String usuario;
    private String password;
    private List<Usuario> usuarios;
    
    
    //variables para hacer el registro
    private String email;
    private String apellidos;
    private String passwordrepeat;
    private String clase;
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<>();
        Alumno tony = new Alumno("Macaroni", "Peperoni", "Pizza", "42 A", 2, "66677789z", "Tony", "guacamoly@oof.com", 950123456, "tony", "funny");
        PAS pas = new PAS("García", "Pérez", "265463788x", "conserje", "Juan", "juan@gmail.com", 667667677, "juanillo", "pswpas");
        PDI pdi = new PDI("Sánchez", "Romero", "250367489z", "ingeriero informatico", "lenguaje de la computacion", 205, "Carlos", "carlos@gmail.com", 666382922, "carlitos", "pswpdi", false);
        PDI gestor = new PDI("Zapatero", "Rajoy", "250367485t", "licenciado en medicina", "anatomia", 205, "Pedro", "pedro@gmail.com", 666382992, "pedrito", "pswgestor", true);
        ONG ong1 = new ONG("España", "MedicoSinFronteras.com", "MedicoSinFronteras", "medicos@gmail.com", 667667679, "ONGmed", "pswONG");
        usuarios.add(tony);
        usuarios.add(ong1);
        usuarios.add(pas);
        usuarios.add(pdi);
        usuarios.add(gestor);


    }

    public String aniadirusuario(){
       //if(password.equals(passwordrepeat)){
        //System.out.println(usuario);
        //System.out.println(password);
        switch(clase){
            case "Alumno":
                Alumno a = new Alumno(usuario,password);
                a.setNombre(apellidos);
                usuarios.add(a);
                break;
            case "PDI":
                PDI p = new PDI(usuario,password);
                p.setNombre(apellidos);
                usuarios.add(p);
                break;
            case "PAS":
                PAS pa = new PAS(usuario,password);
                pa.setNombre(apellidos);
                usuarios.add(pa);
                break;
            case "ONG":
                ONG o = new ONG(usuario,password);
                o.setNombre(apellidos);
                usuarios.add(o);
                break;
        }
          
       //}
	   return "login.xhtml";
    }
     
    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPasswordrepeat() {
        return passwordrepeat;
    }

    public void setPasswordrepeat(String passwordrepeat) {
        this.passwordrepeat = passwordrepeat;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    public String autenticar() {
        // Implementar este método
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
    }

}
