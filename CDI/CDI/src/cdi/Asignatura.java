/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author mmanu
 */
@Entity
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String grado;
    private int curso;
    @OneToMany
    private List<Actividad> trabaja_en;
    @ManyToMany
    @JoinTable(name="matricula_asig_alum",
            joinColumns = @JoinColumn(name = "asignatura_fk"),
            inverseJoinColumns = @JoinColumn(name = "alumno_fk"))
    private List<Alumno> tiene_a;

    @ManyToMany
    @JoinTable(name="matricula_asig_pdi",
            joinColumns = @JoinColumn(name = "asignatura_fk"),
            inverseJoinColumns = @JoinColumn(name = "pdi_fk"))
    private List<PDI> es_gestionada_por;

    public List<PDI> getEs_gestionada_por() {
        return es_gestionada_por;
    }

    public void setEs_gestionada_por(List<PDI> es_gestionada_por) {
        this.es_gestionada_por = es_gestionada_por;
    }

    
    public List<Alumno> getTiene_a() {
        return tiene_a;
    }

    public void setTiene_a(List<Alumno> tiene_a) {
        this.tiene_a = tiene_a;
    }



    public List<Actividad> getTrabaja_en() {
        return trabaja_en;
    }

    public void setTrabaja_en(List<Actividad> trabaja_en) {
        this.trabaja_en = trabaja_en;
    }



    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cdi.Asignatura[ id=" + id + " ]";
    }
    
}
