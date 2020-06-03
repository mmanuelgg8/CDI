/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author elena y julio
 */
@Local
public interface Actividades {
    public void crearActividades(String nombre, String requisitos,Date fecha,boolean estado,int tipo,String zona,String horario,String informacion,ONG ong);
    public void modificarActividades(String nombre, String requisitos,Date fecha,boolean estado,int tipo,String zona,String horario,String informacion);
    public void eliminarActividades(String nombre);
    public List<Actividad> mostrarActividades();
    public Actividad devuelveActividad(String nombre);
    public List<ONG> mostrarONGs();
    
}
