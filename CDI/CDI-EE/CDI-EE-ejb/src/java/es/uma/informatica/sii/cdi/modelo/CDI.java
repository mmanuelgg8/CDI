
package es.uma.informatica.sii.cdi.modelo;


import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.Informe;
import es.uma.informatica.sii.cdi.entidades.Inscripcion;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Saúl
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
    public List<Inscripcion> mostrarInscripciones(Usuario user);
    public boolean estaInscrito(String a, Usuario u);
    public void eliminarInscripcion(Inscripcion i);
    public void eliminarInforme(Informe i);
    public List<Informe> mostrarInformes(Inscripcion i);
    public void crearInformes(Date fecha, boolean reportado,String comentarios);


}

