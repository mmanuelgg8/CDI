/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author elena y julio
 */
@Local
public interface AdministrarProyectoLocal {
    public void crearProyectos();
    public void modificarProyectos(Long id,String nombre,String requisitos,Date fecha,boolean estado);
    public void eliminarProyectos(Long id);
    public void mostrarProyectos();
}