/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;


import es.uma.informatica.sii.cdi.entidades.Usuario;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author francis
 */
@Stateless
public class CDIImpl implements CDI {

    private static final int TAM_CADENA_VALIDACION = 20;

    //@PersistenceContext(unitName = "CDIPU")
    private EntityManager em;

    @Override
    public void registrarUsuario(Usuario u) throws CDIException {
        Usuario user = em.find(Usuario.class, u.getUsername());
        if (user != null) {
            try {
                // El usuario ya existe
                throw new UsernameRepetidoException();
            } catch (UsernameRepetidoException ex) {
                Logger.getLogger(CDIImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        u.setCadenaValidacion(generarCadenaAleatoria());
        em.persist(u);
        String url_validacion = "http://localhost:8080/CDIEE-war/faces/validarCuenta.xhtml?username="
                + u.getUsername() + "&codigoValidacion=" + u.getCadenaValidacion();

        System.out.println(url_validacion);
    }

    private String generarCadenaAleatoria() {
        Random rnd = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < TAM_CADENA_VALIDACION; i++) {
            int v = rnd.nextInt(62);
            if (v < 26) {
                sb.append((char) ('a' + v));
            } else if (v < 52) {
                sb.append((char) ('A' + v - 26));
            } else {
                sb.append((char) ('0' + v - 52));
            }
        }

        return sb.toString();

    }

    @Override
    public void validarCuenta(String cuenta, String validacion) throws CDIException{
        Usuario u = em.find(Usuario.class, cuenta);
        if (u == null) {
            try {
                throw new UsernameInexistenteException();
            } catch (UsernameInexistenteException ex) {
                Logger.getLogger(CDIImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (u.getCadenaValidacion() == null) {
            // la cuenta ya está activa
            return;
        }

        if (!u.getCadenaValidacion().equals(validacion)) {
            try {
                throw new ValidacionIncorrectaException();
            } catch (ValidacionIncorrectaException ex) {
                Logger.getLogger(CDIImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // else
        // Eliminamos la cadena de validación, indicando que ya está activa la cuenta
        u.setCadenaValidacion(null);
    }

    /**
     * Este método debe comprobar que el nombre de usuario y contraseña que
     * recibe en el objeto u pertenecen a un usuario que existe en la BBDD y que
     * está validado (un usuario está validado cuando su cadena de validación es
     * nula).
     * 
     * Puede lanzar las excepciones CuentaInexistenteException, CuentaInactivaException
     * y ContraseniaInvalidaException
     *
     * @param u
     * @return
     */
    @Override
    public void compruebaLogin(Usuario u)  throws CDIException {
        // TODO
        Usuario aux = em.find(Usuario.class, u.getUsername());
        
        //validarCuenta(aux.getCuenta(), aux.getCadenaValidacion());
        
        if(aux.getCadenaValidacion() != null){
            try {
                throw new UsernameInactivoException();
            } catch (UsernameInactivoException ex) {
                Logger.getLogger(CDIImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (!(u.getUsername().equals(aux.getUsername()) && 
                u.getPassword().equals(aux.getPassword()))){
            try {
                throw new PasswordInvalidaException();
            } catch (PasswordInvalidaException ex) {
                Logger.getLogger(CDIImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Este método debe comprobar que el usuario que se le pasa como parámetro
     * es un usuario existente y con contraseña correcta (ya que estamos en la capa
     * de negocio con un Session Bean de tipo @Stateless, debemos comprobar
     * todos los accesos a la capa de nogocio). En caso negativo debe devolver debe devolver 
     * la excepción que corresponda,
     * en caso afirmativo debe devolver una entidad usuario tal con la información
     * existe ahora mismo en la BBDD.
     * @param u
     * @return 
     */
    @Override
    public Usuario refrescarUsuario(Usuario u) throws CDIException {
        // TODO
        compruebaLogin(u);
        
        Usuario usuarioAuxiliar = em.find(Usuario.class, u.getUsername());
        em.refresh(usuarioAuxiliar);
        return usuarioAuxiliar;

    }



}
