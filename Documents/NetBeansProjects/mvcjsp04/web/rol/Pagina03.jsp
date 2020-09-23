<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloRol"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap temp = (HashMap) request.getAttribute("listarol");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Rol</h1>
        <form action="index.jsp" method="get">
            <table>
                <tr>
                <input type="hidden" name="rol_id" id="rol_id" value="<%=temp.get("id")%>">
                <input type="hidden" name="rol_id_old" id="rol_id_old" value="<%=temp.get("id")%>">
                <td>
                    <label>Nombre</label>
                </td>
                <td>
                    <input type="text" name="rol_nombre" id="rol_nombre" value="<%=temp.get("nombre")%>">
                </td>
                </tr>
                <tr>
                    <td>
                        <label>Descripcion</label>
                    </td>
                    <td>
                        <input type="text" name="rol_descripcion" id="rol_descripcion" value="<%=temp.get("descripcion")%>">
                    </td>
            </table>

            <input type="submit" name="btnaccion" value="Modificarrol" /> 
            <input name="btnaccion" type="submit" value="Volver"  />  
            
        </form>

    </body>
</html>
