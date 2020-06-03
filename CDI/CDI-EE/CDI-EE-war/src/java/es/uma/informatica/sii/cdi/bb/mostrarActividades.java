/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import es.uma.informatica.sii.cdi.modelo.CDI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author elena y julio
 */
@Named(value = "mostrarActividades")
@SessionScoped
public class mostrarActividades implements Serializable{


    private List<Actividad> actividades;
    private List<Actividad> filtro;
    private List<String> nombresFiltro;
    @Inject
    private ControlAutorizacion ctrl;
    @Inject
    private CDI cdi;
    //Datos para crearProyecto()
    private String nombre;
    private String requisitos;
    private String zona;
    private String hora;
    private String info;
    private ONG ong;

    public List<Actividad> getActividades() {
        
        Set<Actividad> set = new HashSet<>();
        //nombresFiltro.add("Actividad1");
        if (!nombresFiltro.isEmpty()) {
            for (Actividad a : actividades) {
                for (String s : nombresFiltro) {
                    if (a.getNombre().equals(s)) {
                        set.add(a);
                    }
                }
            }
            filtro = new ArrayList<>(set);
            return filtro;
        }
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public ControlAutorizacion getCtrl() {
        return ctrl;
    }

    public void setCtrl(ControlAutorizacion ctrl) {
        this.ctrl = ctrl;
    }
    
    public String eliminar(String name){
        Actividad target = null;
        for(Actividad a: actividades){
            if(a.getNombre().equals(name)){
                target = a;
            }
        }
        if(target!=null) actividades.remove(target);
        return "actividades.xhtml";
    }
    
    public String crear(){
        Actividad target = new Actividad(nombre, requisitos, new Date(2020,06,20) ,true, 1, zona, hora, info, ong);
        actividades.add(target);
        return "actividades.xhtml";
    }
    
    
    
    public void modificar(){
        //TO BE IMPLEMENTED WHEN THE DATABASE ARRIVES (or be translated to other class)
    }
    
    public void inscribir(Actividad a, Usuario u){
        //TO BE IMPLEMENTED WHEN THE DATABASE ARRIVES (or take it and move it SOMEWHERE ELSE?)
        
    }
    
    public String anadir(){
        return "crearActividades.xhtml";
    }

    public List<Actividad> getFiltro() {
        return filtro;
    }

    public void setFiltro(List<Actividad> filtro) {
        this.filtro = filtro;
    }

    public List<String> getNombresFiltro() {
        return nombresFiltro;
    }

    public void setNombresFiltro(List<String> nombresFiltro) {
        this.nombresFiltro = nombresFiltro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ONG getOng() {
        return ong;
    }

    public void setOng(ONG ong) {
        this.ong = ong;
    }

    
    
     
    //Para el tipo de actividad consideramos que el tipo=0 corresponde con actividad de voluntariado
    //y tipo=1 corresponde con actividd aprendizaje-servicio
    public mostrarActividades() {
        actividades= new ArrayList<>();
        nombresFiltro = new ArrayList<>();
        ong = new ONG("Málaga","www.ong-malaga.es","ong-malaga","malaga@ong.es",777777771,"mlgong","mlgong");
        Actividad a1 = new Actividad("Actividad1","conocimientos sobre vacunas",(new Date(2020,06,03)),true,1,"Marbella","actividad de mañana","vacunar a los niños en centros escolares",ong);
        Actividad a2 = new Actividad("Actividad2"," no hace falta ningún conocimiento para realizar la actividad",(new Date(2020,02,06)),true,0,"Madrid","actividad de tarde","ayudar a los necesitados ",ong);
        actividades.add(a1);
        actividades.add(a2);
        
       
    }
    
    public String lista_actividades(){  //
        
         return ctrl.actividades();
        
        
        
    }  
    
}
