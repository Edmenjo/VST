<%-- 
    Document   : comprueba
    Created on : 22-mar-2020, 20:42:49
    Author     : zuzu
--%>

<%@page import="ejbs.vstCartLocal"%>
<%@page import="ejbs.Catalogue"%>
<%@page import="ejbs.VST"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="/VSTs-war/web/resource/main.css"/>
        <title>VST Catalogue</title>
        
        
        
    </head>
    <body>
        <jsp:include page="resource/header.jsp" />
        <div class="forms">
        <h1>You've searched for the VST Catalogue</h1>
        
        <%
            vstCartLocal cart = (vstCartLocal) session.getAttribute("Cart");
            Catalogue catalogue;
            catalogue = (Catalogue) session.getAttribute("catalogue");
            if(cart!=null){
                for(VST vstCatalogue: catalogue.getCatalogue()){
           
            
            
            
            
        %>        
        <form onSubmit="if(!confirm('Do you really want to add to the cart?')){return false;}">
            <label> <%=vstCatalogue%> </label>
            <input type="hidden" name="command" value="CartCommand"></input>
            <input type="hidden" name="vst" value="<%=vstCatalogue%>">
            <button type="submit" >Add</button>
        </form>
        <%
                    
                }
            }
        %>
        </div>       
        
        <jsp:include page="resource/footer.jsp" />
    </body>
</html>
