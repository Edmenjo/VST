<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>VST Plugins for your beats</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        
        <link rel="stylesheet" href="/VSTs-war/web/resource/main.css"/>
        
        
    </head>
    <body>
 
          
        
        <jsp:include page="resource/header.jsp" />
        <div class="forms">
        <div class="form1">
            
        <form action="/VSTs-war/FrontController">
            <input type="text" name="peticion" placeholder="Look for an ilustration...">
            <input type="hidden" name="command" value="CatalogueCommand"><br>
            
            <button type="submit" class="btn btn-primary btn-block">Go to catalogue</button>
                    
            
        </form><br>
        </div>
        <div class="form2">
        <form action="/VSTs-war/FrontController">
            <input type="text" name="peticion" placeholder="Look for a VST Plugin...">
            <input type="hidden" name="command" value="VstCommand"><br>
            
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    
        </form>
        </div>
            <form action=FrontController>
            <input type="text" name="peticion" placeholder="UnknownCommand">
            <input type="hidden" name="command" value="fallo"><br>
            
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
                    
            
        </form><br>
        </div>
        
        
        <jsp:include page="resource/footer.jsp" />
    </body>
</html>
