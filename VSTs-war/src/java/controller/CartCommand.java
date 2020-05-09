/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ejbs.Playlist;
import ejbs.Song;
import ejbs.vstCartLocal;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

/**
 *
 * @author zuzu
 */
public class CartCommand extends FrontCommand {

    private HttpSession session;
    @Override
    public void process() throws ServletException, IOException {
        session = request.getSession(true);
        addToCart();
        forward("/web/song.jsp");
    }

    private void addToCart() {
        vstCartLocal cart = (vstCartLocal) session.getAttribute("Cart");

        String product = request.getParameter("product");
        
        Song song1 = new Song (product);
        
        Playlist playlist = new Playlist();
        playlist.addSongToPlaylist(song1);

        cart.addProduct(song1);
    }
    
}
