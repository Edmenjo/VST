/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import javax.ejb.Stateless;

/**
 *
 * @author zuzu
 */
@Stateless
public class Mensaje2 implements Mensaje2Local {

    @Override
    public String getMessage(String m) {
        return "Mensaje2::getMessage(" + m + ")";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
