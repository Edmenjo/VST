/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import ejbs.VST;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zuzu
 */
public class SearchCommand extends FrontCommand{

    private HttpSession session;
    VST vst1;
    
    @Override
    public void process() throws ServletException, IOException {
        session = request.getSession(true);
        checkSearch();
        forward("/web/vst.jsp");
    }
    
    private void checkSearch(){
        String product = request.getParameter("product");
        vst1  = new VST ("Ninety - MIDI Collection");
        
        if(product.equals("Ninety") || product.equals("ninety")){
            session.setAttribute("vst", vst1);
        } else {
            session.setAttribute("vst", null);
        }
    }
}
