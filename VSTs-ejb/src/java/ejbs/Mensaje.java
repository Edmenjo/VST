 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author zuzu
 */
@Stateless
@LocalBean
public class Mensaje {

    @EJB
    Mensaje2Local mensaje2;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public String getMessage(String m){
        
        String m2 = mensaje2.getMessage(m);
        
        
        return "Mensaje::getMessage() <br>" + m2;
    }
    
    @PostConstruct
    public void init() {
        System.out.println("Mensaje::init() - @PostConstruct");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("Mensaje::destroy() - @PreDestroy");
    }
}
