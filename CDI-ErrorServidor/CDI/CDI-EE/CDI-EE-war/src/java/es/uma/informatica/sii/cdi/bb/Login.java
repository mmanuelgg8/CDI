/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Alumno;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import es.uma.informatica.sii.cdi.entidades.PAS;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.entidades.ONG;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author elena y julio
 */

@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String password;
    private List<Usuario> usuarios;

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
        usuarios.add(new Usuario("luis", "luis"));

    }

    public String getUsuario() {
        return usuario;
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
   
    public String autenticar() {
        // Implementar este método
        String res = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (this.usuario.length() == 0) {
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Introduzca el usuario", "Introduzca el usuario"));
        } else {
            Usuario actual = null;
            for (Usuario user : usuarios) {
                if (user.equals(new Usuario(this.usuario, this.password))) {
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
