/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ONG extends Usuario implements Serializable{

    @Id
    private String ubicacion;
    private String web;
    private List<Inscripcion> se_encarga_de;

    public List<Inscripcion> getSe_encarga_de() {
        return se_encarga_de;
    }

    public void setSe_encarga_de(List<Inscripcion> se_encarga_de) {
        this.se_encarga_de = se_encarga_de;
    }

    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

     @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
    	// TODO: Warning - this method won't work in the case the id fields are not set
        if (!(o instanceof ONG)) {
            return false;
        }
        ONG other = (ONG) o;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "cdi.ONG[ id=" + id + " ]";
    }
   
    
}
