/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Asignatura;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.modelo.CDI;
import es.uma.informatica.sii.cdi.modelo.CDIException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Nico y andre
 */
@Named(value = "mostrarAsignaturas")
@SessionScoped
public class mostrarAsignaturas implements Serializable {
    private Asignatura a;
    
    @Inject
    private ControlAutorizacion ctrl;
    
    @EJB
    private CDI asig;


    public mostrarAsignaturas() {
        a = new Asignatura();
    }

    public Asignatura getA() {
        return a;
    }

    public void setA(Asignatura a) {
        this.a = a;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    public String aniadir(){
        return "crearAsignatura.xhtml";
    }
    public String crear(){
        List<PDI> lista;
        PDI admin = (PDI) ctrl.getUsuario();
        asig.crearAsignaturas(a.getId(), a.getNombre(), a.getGrado(), a.getCurso());
        Asignatura aux = asig.devuelveAsignatura(a.getNombre());
        lista=aux.getEs_gestionada_por();
        lista.add(admin);
        aux.setEs_gestionada_por(lista);
        return "asignaturas.xhtml";
    }
    
    public String eliminar(String nombre){
        asig.eliminarAsignatura(nombre);
        return "asignaturas.xhtml";
    }
    public String modificar(String nombre){
        a = asig.devuelveAsignatura(nombre);
        return "modificarAsignatura.xhtml";
    }
    public String editando(){
        asig.refreshAsignatura(a);
        return "asignaturas.xhtml";
    }
    public List<Asignatura> mostrarAsignaturas(){
        return asig.mostrarAsignaturas();
    }

    
}