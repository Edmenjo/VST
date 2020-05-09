/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.ejb.Local;

/**
 *
 * @author zuzu
 */
@Local
public interface Mensaje2Local {
    
    public String getMessage(String m);
    
}
