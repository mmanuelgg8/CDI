/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.backingbeans;
import es.uma.informatica.sii.cdi.entidades.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
/**
 *
 * @author elena y julio
 */
@Named(value= "login")
@RequestScoped
public class Login {
   
    private String usuario;
    private String contrasenia;
    private List <Usuario> usuarios;
    private List<ONG> ongs;
    private List<Alumno> alumnos;
    private List<PAS> lpas;
    private List<PDI> lpdi;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<ONG> getOngs() {
        return ongs;
    }

    public void setOngs(List<ONG> ongs) {
        this.ongs = ongs;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<PAS> getLpas() {
        return lpas;
    }

    public void setLpas(List<PAS> lpas) {
        this.lpas = lpas;
    }

    public List<PDI> getLpdi() {
        return lpdi;
    }

    public void setLpdi(List<PDI> lpdi) {
        this.lpdi = lpdi;
    }
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        usuarios = new ArrayList<>();
        Usuario naruto= new Usuario("Naruto","naruto@gmail.com",667667676,"narutito","pswnaruto");
        PAS pas=new PAS("García", "Pérez","265463788x","conserje","Juan","juan@gmail.com",667667677,"juanillo","pswpas");
        PDI pdi=new PDI("Sánchez","Romero","250367489z","ingeriero informatico","lenguaje de la computacion",205,"Carlos","carlos@gmail.com",666382922,"carlitos","pswpdi",false);
        PDI gestor=new PDI("Zapatero","Rajoy","250367485t","licenciado en medicina","anatomia",205,"Pedro","pedro@gmail.com",666382992,"pedrito","pswgestor",true);
        ONG ong1= new ONG("España", "MedicoSinFronteras.com","MedicoSinFronteras","medicos@gmail.com",667667679,"ONGmed","pswONG");     
        usuarios.add(naruto);
        usuarios.add(ong1);
        usuarios.add(pas);
        usuarios.add(pdi);
        usuarios.add(gestor);
        
    }
    
     public String autenticar() {
        // Implementar este método
        for(int u=0;u<usuarios.size();u++){
            if(usuarios.get(u).getNombre().equals(usuario)){
                if(usuarios.get(u).getPassword().equals(contrasenia)){
                    ctrl.setUsuario(usuarios.get(u));
                    return ctrl.home();
                }
            }
        }
        
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no está registrado o contraseña incorrecta", "El usuario no está registrado o contraseña incorrecta"));
        return null;
    
    }
    

     
    
}
