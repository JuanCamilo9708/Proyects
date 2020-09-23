<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloRol"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Crear Rol</h1>
        <form action="index.jsp" method="post"> 

            <p>NOMBRE DEL ROL:<input type="text" name="rol_nombre" /></p>
            <p>DESCRIPCION DEL ROL:<input type="text" name="rol_descripcion" /></p>
            <input type="submit" name="btnaccion" value="Crearrol" /> 
            <input name="btnaccion" type="submit" value="Volver"  /> 
            
        </form>

    </body>
</html>
