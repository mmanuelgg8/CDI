
package es.uma.informatica.sii.cdi.modelo;


import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author francis
 */
@Local
public interface CDI {
    public void registrarUsuario(Usuario u, String clase)throws CDIException;
    public void validarCuenta(String cuenta, String validacion) throws CDIException;
    public void compruebaLogin(Usuario u) throws CDIException;
    public Usuario refrescarUsuario(Usuario u) throws CDIException;
    public void modificarUsuario(Usuario u) throws CDIException;
    public void eliminarUsuario(Usuario u) throws CDIException;
    public void solicitaCode(Usuario u) throws CDIException;
    public void inscribirUsuario(Actividad a, Usuario u);


}

