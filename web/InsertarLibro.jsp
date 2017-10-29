<%-- 
    Document   : InsertarLibro
    Created on : 24/10/2017, 12:00:15 AM
    Author     : Juan Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html lang="en">
    
    <body>
          <head>
        <title>Home</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
        <meta name="description" content="Your description">
        <meta name="keywords" content="Your keywords">
        <meta name="author" content="Your name">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/preview.css" type="text/css">
        <script type="text/javascript" src="js/include_script.js"></script>
        <!--[if lt IE 9]>
                <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
            <link href="css/ie.css" rel="stylesheet" type="text/css">
    <![endif]-->
  
        <!--content wrapper-->
        <div id="wrapper">
            <section>
                <div class="container">
                    <div class="dynamicContent">
                        <!--content-->
                        <h1>Nuevo Libro</h1>
             <%
                        if (request.getAttribute("resultado") != null) {
                            Boolean resultado = (Boolean) request.getAttribute("resultado");
                            if (resultado.booleanValue() == true) {
                    %>
                    <h2> se ha registrado de manera exitosa</h2>
                    <%
                    } else {
                    %>     
                    <h2> llene los campos correctamente </h2>
                    <%
                            }
                        }
                    %>
                    
            
            <p>Ingrese la informacion solicitada</p>

            <form action=" ControlinserLibro" method="post">
                <div class="form_settings">
                    <p><span>Numero De Registro</span>
                        <input class="contact" type="text" name="id" value="" /></p>
                    <p><span>Nombre Libro</span>
                        <input class="contact" type="text" name="nombre" value="" /></p>
                    <p><span>Nombre Autor</span>
                        <input class="contact" type="text" name="autor" value="" /></p>
                    <p><span>Editorial</span>
                        <input class="contact" type="text" name="edi" value="" /></p>
                    <p><span>Precio</span>
                        <input class="contact" type="text" name="precio" value="" /></p>
                    <p><span>Estado</span>
                        <input class="contact" type="text" name="estado" value="" /></p>
                    <p style="padding-top: 15px"><span>&nbsp;</span><input class="submit" type="submit" name="contact_submitted" value="submit" /></p>
                </div>
                <h2><a href="index.jsp"> volver al menu</a></h2>
                <h2><a href="InserTabla"> Listar los Libros</a></h2>
                
                
                                     
            </form>
            <p><br>
            </p>
        
                    </div>
                </div>
            </section>
        </head>
        </div>
        <script type="text/javascript" src="js/bootstrap.js"></script>
    </body>
</html>