/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejbs.Catalogue;
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
public class CatalogueCommand extends FrontCommand {
    
    private Catalogue catalogue;
    private HttpSession session;
    
    @Override
    public void process() throws ServletException, IOException {
        try {
            catalogue = (Catalogue) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/Catalogue!ejbs.Catalogue");
        } catch (NamingException ex) {
            Logger.getLogger(CatalogueCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        showCatalogue();
        forward("/web/catalogue.jsp");
    }

    private void showCatalogue() {
        catalogue.getCatalogue();
        session.setAttribute("catalogue",catalogue);
    }
    
}

