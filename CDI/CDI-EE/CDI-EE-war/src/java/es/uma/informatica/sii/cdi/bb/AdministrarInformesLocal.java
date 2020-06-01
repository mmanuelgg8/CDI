/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.bb;

import es.uma.informatica.sii.cdi.entidades.Informe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author elena y julio
 */
@Local
public interface AdministrarInformesLocal {
    public void crearInformes();
    public void modificarInformes(Long id);
    public void eliminarInformes(Long id);
    public void mostrarInformes();
    public List<String> informes();
    
}
