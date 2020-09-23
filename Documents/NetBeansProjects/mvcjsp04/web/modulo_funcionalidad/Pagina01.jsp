<%@page import="general.VistaGeneral"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloRol"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    VistaGeneral vista = new VistaGeneral();
    HashMap datos = (HashMap) request.getAttribute("datos");
    ArrayList<HashMap> temp = (ArrayList<HashMap>) datos.get("datos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body
        <h1>MÓDULO X FUNCIONALIDAD</h1>
        <br>
        <br>        
        <form action="index.jsp" method="post">    

            <%
                ArrayList<HashMap> listamodulos;
                listamodulos = (ArrayList<HashMap>) datos.get("datos");
                String html = vista.generarTablaRadio(listamodulos, "mod_nombre-defecto,mod_descripcion-defecto,mod_id-radio-mod_id").toString();
                out.print(html);
            %>

            <br>

            <input name="btnaccion" type="submit" value="Crear modulo"  /> 
            <input name="btnaccion" type="submit" value="Modificar modulo"  />
            <input name="btnaccion" type="submit" value="Eliminar modulo" />
            <input name="btnaccion" type="submit" value="Funcionalidades" />
            <input type="button" onclick="location.href = '../index.jsp'" value="Volver" name="Volver">

        </form>

    </body>
</html>
