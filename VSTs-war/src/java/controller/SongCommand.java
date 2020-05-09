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
import ejbs.Playlist;
import ejbs.Song;
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
    private Playlist playlist;


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

        
            /*if(!request.getParameter("peticion").equals("")){
            
            String userSong = request.getParameter("peticion");
        
            //Song song1 = new Song("Depression & obsession",144);
            //Song song2 = new Song("Ninety",458);
            //Song song3 = new Song("Like a movie",140);
            Song song1 = new Song(userSong);
            
            playlist = new Playlist();
        
            playlist.addSongToPlaylist(song1);
            //playlist.addSongToPlaylist(song2);
            //playlist.addSongToPlaylist(song3);
            
            
            if (session.isNew()) {
            session.setAttribute("playlist", playlist);
            
            } else {
            session.removeAttribute("playlist");
            Song otra = new Song(request.getParameter("peticion"));
            playlist.addSongToPlaylist(otra);
            if (session.getAttribute("playlist") == null) {
            session.setAttribute("playlist", playlist);
            } else {
            session.setAttribute("playlist", playlist);
            }
            }*/
            Song soong = new Song(request.getParameter("product"));
            
            
            vstCartLocal cart = (vstCartLocal) session.getAttribute("Cart");
            
            if(cart == null) {
                try {
                    cart = (vstCartLocal) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/vstCart!ejbs.vstCartLocal");
                    session.setAttribute("Cart", cart);
                    counter.newUser(session.getId());
                } catch (NamingException ex) {
                    Logger.getLogger(EjemploServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            /*
            if(soong.getName() != null && soong.getName().equals("remove")){
                cart.remove();
                session.setAttribute("Cart", null);
            }*/
            
            cart.addProduct(soong);
            counter.newProduct(session.getId());
         }  
    }


