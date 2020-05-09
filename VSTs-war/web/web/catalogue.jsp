<%-- 
    Document   : comprueba
    Created on : 22-mar-2020, 20:42:49
    Author     : zuzu
--%>

<%@page import="ejbs.Catalogue"%>
<%@page import="ejbs.VST"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="resource/main.css"/>
        <title>VST Catalogue</title>
        
        
        
    </head>
    <body>
        <jsp:include page="resource/header.jsp" />
        <div class="forms">
        <h1>You've searched for the VST Catalogue</h1>
        
        <%
            Catalogue catalogue;
            catalogue = (Catalogue) session.getAttribute("catalogue");
            //for(VST vstCatalogue: Catalogue){
                
            //}
            
        %>        
        <h3><%=catalogue%></h3>
        
        </div>
        <div class="ilustrations">
            <img src="images/jaden.jpg" width="306" height="511" alt="Jaden Smith">
            
            <img src="images/x.jpg" width="602" height="339" alt="XXXTentacion">
        </div>
        
        
        <jsp:include page="resource/footer.jsp" />
    </body>
</html>
