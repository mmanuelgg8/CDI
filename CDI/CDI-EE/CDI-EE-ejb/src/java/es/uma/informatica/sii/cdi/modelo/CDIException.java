/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.cdi.modelo;

/**
 *
 * @author mmanu
 */
public class CDIException extends Exception {

    public CDIException(){
        
    }
    
    public CDIException(String msg) {
        super(msg);
    }
    
    @Override
    public String getMessage() {
        return super.getMessage(); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
