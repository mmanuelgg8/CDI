/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import es.uma.informatica.sii.cdi.entidades.Informe;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;


/**
 *
 * @author elena y julio 
 */
@Local
public interface InformesLocal {
    public void crearInformes(Date fecha, boolean repor, String comentarios);
    public void eliminarInformes(Long id);
    public List<Informe> mostrarInformes();
    public Informe devuelveInformes(Long id);
    
}
