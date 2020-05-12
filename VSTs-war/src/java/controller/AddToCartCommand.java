/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejbs.Counter;
import ejbs.VST;
import ejbs.vstCartLocal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zuzu
 */
public class AddToCartCommand extends FrontCommand {

    private VST vst;
    private HttpSession session;
    private Counter counter;
    
    @Override
    public void process() throws ServletException, IOException {
        session = request.getSession(true);
        try {
            counter = (Counter) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/Counter!ejbs.Counter");
        } catch (NamingException ex) {
            Logger.getLogger(AddToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        addToCart();
        forward("/web/catalogue.jsp");
    }

    private void addToCart() {
        
        vst = new VST(request.getParameter("vst"));
        
        vstCartLocal cart = (vstCartLocal) session.getAttribute("Cart");
        
        if(cart == null) {
            try {
                cart = (vstCartLocal) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/vstCart!ejbs.vstCartLocal");
                session.setAttribute("Cart", cart);
                
                counter.newUser(session.getId());
                
            } catch (NamingException ex) {
                Logger.getLogger(AddToCartCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
            cart.addProduct(vst);
            counter.newProduct(session.getId());
            
    }
    
}
