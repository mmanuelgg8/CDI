
package es.uma.informatica.sii.cdi.modelo;


import es.uma.informatica.sii.cdi.entidades.Usuario;
import javax.ejb.Local;

/**
 *
 * @author francis
 */
@Local
public interface CDI {
    public void registrarUsuario(Usuario u)throws CDIException;
    public void validarCuenta(String cuenta, String validacion) throws CDIException;
    public void compruebaLogin(Usuario u) throws CDIException;
    public Usuario refrescarUsuario(Usuario u) throws CDIException;

}

