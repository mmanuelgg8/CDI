/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.ONG;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author elena y julio
 */
@Local
public interface AdministrarActividadesLocal {
    public void crearActividades();
    public void modificarActividades(Long id,String nombre, String requisitos,Date fecha,boolean estado,int tipo,String zona,String horario,String informacion);
    public void eliminarActividades(Long id);
    public void mostrarActividades();
    
}
