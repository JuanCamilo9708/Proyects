<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloLogin"%>
<%@page import="general.VistaGeneral"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String x;
    VistaGeneral vista = new VistaGeneral();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina02</title>
    </head>
    <body>
    <center>
        <hr>
        <h3>LISTA DE ROLES</h3>
        <hr>
        <form name="form1" action="index.jsp" method="POST" >
            <%                
                HashMap datos = new HashMap();
                datos = (HashMap) request.getAttribute("datos");
                ArrayList<HashMap> listarRoles = (ArrayList) datos.get("listarRoles");
                x = vista.generarComboBox(listarRoles, "rol_id", "rol_nombre", "rol_id").toString();
                out.print(x);
            %>

            <p>
                <input type="submit" name="btnaccion" value="Funcionalidades"/>
            </p>
        </form>
        <hr>
        <form action="index.jsp" method="POST">
            <input type="submit" name="btnaccion" value="Cerrar sesion" />
        </form>
    </center>
</body>
</html>
