/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

import es.uma.informatica.sii.cdi.entidades.Actividad;
import es.uma.informatica.sii.cdi.entidades.Alumno;
import es.uma.informatica.sii.cdi.entidades.Inscripcion;
import es.uma.informatica.sii.cdi.entidades.ONG;
import es.uma.informatica.sii.cdi.entidades.PAS;
import es.uma.informatica.sii.cdi.entidades.PDI;
import es.uma.informatica.sii.cdi.entidades.Usuario;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Saúl
 */
@Stateless
public class CDIImpl implements CDI {

    private static final int TAM_CADENA_VALIDACION = 20;

    @PersistenceContext(unitName = "CDIPU")
    private EntityManager em;

    @Override
    public void registrarUsuario(Usuario u, String clase) throws CDIException {
        Usuario user = em.find(Usuario.class, u.getUsername());
        if (user != null) {
            throw new UsernameRepetidoException();
        }
        u.setCadenaValidacion(generarCadenaAleatoria());
        switch (clase) {
            case "Alumno":
                Alumno a = new Alumno();
                a.setUsername(u.getUsername());
                a.setPassword(u.getPassword());
                a.setNombre(u.getNombre());
                a.setCadenaValidacion(u.getCadenaValidacion());
                a.setEmail(u.getEmail());
                a.setTelefono(u.getTelefono());
                em.persist(a);
                break;
            case "PDI":
                PDI p = new PDI();
                p.setUsername(u.getUsername());
                p.setPassword(u.getPassword());
                p.setNombre(u.getNombre());
                p.setCadenaValidacion(u.getCadenaValidacion());
                p.setEmail(u.getEmail());
                p.setTelefono(u.getTelefono());
                em.persist(p);
                break;
            case "PAS":
                PAS pa = new PAS();
                pa.setUsername(u.getUsername());
                pa.setPassword(u.getPassword());
                pa.setNombre(u.getNombre());
                pa.setCadenaValidacion(u.getCadenaValidacion());
                pa.setEmail(u.getEmail());
                pa.setTelefono(u.getTelefono());
                em.persist(pa);
                break;
            case "ONG":
                ONG o = new ONG();
                o.setUsername(u.getUsername());
                o.setPassword(u.getPassword());
                o.setNombre(u.getNombre());
                o.setCadenaValidacion(u.getCadenaValidacion());
                o.setEmail(u.getEmail());
                o.setTelefono(u.getTelefono());
                em.persist(o);
                break;
        }

        String url_validacion = "http://localhost:1527/CDIEE-war/faces/validar.xhtml?username="
                + u.getUsername() + "&codigoValidacion=" + u.getCadenaValidacion();

        System.out.println(u.getCadenaValidacion());
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
    public void validarCuenta(String cuenta, String validacion) throws CDIException {
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
     * Puede lanzar las excepciones CuentaInexistenteException,
     * CuentaInactivaException y ContraseniaInvalidaException
     *
     * @param u
     * @throws es.uma.informatica.sii.cdi.modelo.CDIException
     */
    @Override
    public void compruebaLogin(Usuario u) throws CDIException {

        Usuario aux = em.find(Usuario.class, u.getUsername());

        //validarCuenta(aux.getCuenta(), aux.getCadenaValidacion());
        if (aux == null) {
            throw new UsernameInexistenteException();
        }

        if (aux.getCadenaValidacion() != null) {
            throw new UsernameInactivoException();
        }

        if (!u.getPassword().equals(aux.getPassword())) {
            throw new PasswordInvalidaException();
        }

    }

    /**
     * Este método debe comprobar que el usuario que se le pasa como parámetro
     * es un usuario existente y con contraseña correcta (ya que estamos en la
     * capa de negocio con un Session Bean de tipo @Stateless, debemos comprobar
     * todos los accesos a la capa de nogocio). En caso negativo debe devolver
     * debe devolver la excepción que corresponda, en caso afirmativo debe
     * devolver una entidad usuario tal con la información existe ahora mismo en
     * la BBDD.
     *
     * @param u
     * @return
     * @throws es.uma.informatica.sii.cdi.modelo.CDIException
     */
    @Override
    public Usuario refrescarUsuario(Usuario u) throws CDIException {
        // TODO
        compruebaLogin(u);

        Usuario usuarioAuxiliar = em.find(Usuario.class, u.getUsername());
        em.refresh(usuarioAuxiliar);
        return usuarioAuxiliar;

    }

    @Override
    public void modificarUsuario(Usuario u) throws CDIException {
        Usuario user = em.find(Usuario.class, u.getUsername());
        if (user == null) {
            throw new UsernameInexistenteException();
        }
        em.merge(u);
    }

    @Override
    public void eliminarUsuario(Usuario u) throws CDIException {
        Usuario user = em.find(Usuario.class, u.getUsername());
        if (user == null) {
            throw new UsernameInexistenteException();
        }
        em.remove(user);
    }

    @Override
    public void solicitaCode(Usuario u) throws CDIException {
        Usuario user = em.find(Usuario.class, u.getUsername());
        if (user == null) {
            throw new UsernameInexistenteException();
        }
        PDI p = (PDI) user;
        p.setRol_gestor(true);
        em.merge(p);
    }

    @Override
    public void inscribirUsuario(Actividad a, Usuario u) {
        Inscripcion i = new Inscripcion(new Date(), true, u, a);
        em.persist(i);
        /*
        List<Inscripcion> ins = u.getEsta_inscrito_en();
        ins.add(i);
        u.setEsta_inscrito_en(ins);
        em.merge(u);
         */
        List<Usuario> users = a.getEs_elegida_por();
        users.add(u);
        a.setEs_elegida_por(users);
        em.merge(a);
        /*
        
        List<Inscripcion> insc = a.getLista_de_inscritos();
        insc.add(i);
        a.setLista_de_inscritos(insc);
         */
    }

    @Override
    public List<Inscripcion> mostrarInscripciones(Usuario user) {
        return em.createNamedQuery("mostrarInscripciones").setParameter("user", user).getResultList();

    }

    @Override
    public boolean estaInscrito(String a, Usuario u) {
        Actividad act = (Actividad) em.createNamedQuery("findActividadByName").setParameter("aname", a).getSingleResult();
        return act.getEs_elegida_por().contains(u);
    }

    public void eliminarInscripcion(Inscripcion i) {
        Inscripcion ins = em.find(Inscripcion.class, i.getId());
        if (ins == null) {
            try {
                throw new CDIException();
            } catch (CDIException ex) {
                Logger.getLogger(CDIImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        em.remove(ins);
    }
}
