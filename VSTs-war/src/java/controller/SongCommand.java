/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import control.EjemploServlet;
import ejbs.Counter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import ejbs.VST;
import ejbs.vstCartLocal;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author zuzu
 */
public class SongCommand extends FrontCommand {
    
    
    Counter counter;
    
    private HttpSession session;


    @Override
    public void process() throws IOException{
        session = request.getSession(true);

        try {
            counter = (Counter) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/Counter!ejbs.Counter");
        } catch (NamingException ex) {
            Logger.getLogger(SongCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getVST();
        try {
            forward("/web/song.jsp");
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SongCommand.class.getName()).log(Level.SEVERE, null, ex); 
        }
        
    }
    
    private void getVST(){

        
            
            VST soong = new VST(request.getParameter("product"));
            
            
            vstCartLocal cart = (vstCartLocal) session.getAttribute("Cart");
            
            if(cart == null) {
                try {
                    cart = (vstCartLocal) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/vstCart!ejbs.vstCartLocal");
                    session.setAttribute("Cart", cart);
                    //counter = (Counter) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/Counter!ejbs.Counter");
                    counter.newUser(session.getId());
                } catch (NamingException ex) {
                    Logger.getLogger(EjemploServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            cart.addProduct(soong);
            counter.newProduct(session.getId());
         }  
    }


