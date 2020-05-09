 <%-- 
    Document   : index
    Created on : 29-abr-2020, 20:34:30
    Author     : zuzu
--%>

<%@page import="ejbs.vstCartLocal"%>
<%@page import="ejbs.Playlist"%>
<%@page import="ejbs.Song"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ejbs.Counter"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NO ES SONG.JSP</title>
    </head>
    <body>
        <h1>Cpmpra carrito</h1>
        
        <form action ="EjemploServlet">
            <input type="text" name="product">
            <input type="submit">
        </form>
        
        <form action ="EjemploServlet">
            <input type="hidden" name="command" value="remove">
            <input type="submit" value="Terminar">
        </form>
        
        <% 
            Song song1 = new Song ("Ninety");
            Song song2 = new Song ("Yellow");
            Song array[] = {song1, song2};
            Playlist playlist = new Playlist();
            playlist.addSongToPlaylist(song1);
            playlist.addSongToPlaylist(song2);
            
            vstCartLocal cart = (vstCartLocal) session.getAttribute("Cart");
            if(cart != null){
                %>
                <form action ="EjemploServlet">
                    <%for(Song product: array) {
                    %> <h3> <%=product%> </h3>
                    <input type="hidden" name="product" value="<%product.getName();%>" </input>
                           <button type="submit" >Submit</button>
                    
                    
                </form>
                
                    <%    
                }
            }
            
            %>
        
            <h2> Estadísticas de Compras </h2>
            
            <%
                Counter counter = (Counter) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/Counter!ejbs.Counter");
                HashMap<String, Integer> map = counter.getMap();
            %> <h3> Número de carritos: <%=map.size()%> </h3> <%
                for(HashMap.Entry<String, Integer> ent: map.entrySet()) {
                    %> <h3> <%=ent.getKey()%>: <%=ent.getValue()%> </h3> <%
                }
            %>
            
    </body>
</html>
