/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejbs.VST;
import ejbs.WishList;
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
public class AddToWishCommand extends FrontCommand{
    private VST vst;
    private HttpSession session;
    
    @Override
    public void process() throws ServletException, IOException {
        session = request.getSession(true);
        addToWishList();
        forward("/web/catalogue.jsp");
    }

    private void addToWishList() {
        vst = new VST(request.getParameter("vst"));
        
        WishList wishList = (WishList) session.getAttribute("Wish");
        
        if(wishList == null) {
            try {
                wishList = (WishList) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/WishList!ejbs.WishList");
                session.setAttribute("Wish", wishList);
                
            } catch (NamingException ex) {
                Logger.getLogger(AddToWishCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }
            wishList.addProduct(vst);
    }
}
