<%@page import="general.VistaGeneral"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloLogin"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap datos = new HashMap();
    datos = (HashMap) request.getAttribute("datos");
    VistaGeneral vista = new VistaGeneral();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body
        <h1> Rol</h1>
        <br>
        <br>
        
        <form action="index.jsp" method="post">    

            <%              
                ArrayList<HashMap> listaroles;
                listaroles = (ArrayList<HashMap>) datos.get("datos");
                String html = vista.generarTablaRadio(listaroles, "rol_nombre-defecto,rol_descripcion-defecto,rol_id-radio-rol_id").toString();
                out.print(html);
            %>

            <br>
            <input name="btnaccion" type="submit" value="Crear"  /> 
            <input name="btnaccion" type="submit" value="Eliminar"  />
            <input name="btnaccion" type="submit" value="Modificar" />
            <input name="btnaccion" type="submit" value="Permisos" />
            <input type="button" onclick="location.href = '../index.jsp'" value="Volver" name="Volver">

        </form>

    </body>
</html>
