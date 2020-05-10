<%-- 
    Document   : cart
    Created on : 09-may-2020, 18:25:25
    Author     : zuzu
--%>

<%@page import="java.util.HashMap"%>
<%@page import="ejbs.Counter"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ejbs.vstCartLocal"%>
<%@page import="ejbs.VST"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/VSTs-war/web/resource/main.css"/>
        <title>Cart</title>
    </head>
    <body>
        <jsp:include page="resource/header.jsp" />
        <div class="forms">
        <h1>Cart</h1>
        
        <%
            String cartP = "";
        vstCartLocal cart = (vstCartLocal) session.getAttribute("Cart");
        
        for(VST cartContent: cart.getProducts()){%>
        <h3><%=cartContent%></h3>
        <%
        }
        %>
        <h2> Estadísticas de Compras </h2>
            
            <%
                Counter counter = (Counter) InitialContext.doLookup("java:global/VSTs/VSTs-ejb/Counter!ejbs.Counter");
                HashMap<String, Integer> map = counter.getMap();
            %> <h3> Número de carritos: <%=map.size()-2%> </h3> <%
                for(HashMap.Entry<String, Integer> ent: map.entrySet()) {
                    %> <h3> <%=ent.getKey()%>: <%=ent.getValue()%> </h3> 
                    <%
                        
                }
                    %> 
        </div>
        <jsp:include page="resource/footer.jsp" />
    </body>
</html>
