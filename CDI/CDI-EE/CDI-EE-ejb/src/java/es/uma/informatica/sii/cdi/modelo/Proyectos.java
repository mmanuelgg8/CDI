/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import es.uma.informatica.sii.cdi.entidades.Proyecto;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Saúl
 */
@Local
public interface Proyectos {
    public void crearProyectos(String nombre,String requisitos,Date fecha,boolean estado, Usuario user);
    public void modificarProyectos(String nombre,String requisitos,Date fecha,boolean estado);
    public void eliminarProyectos(String nombre);
    public List<Proyecto> mostrarProyectos();
    public Proyecto devuelveProyecto(String nombre);
}
