<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloModFun"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap temp = (HashMap) request.getAttribute("modulos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Modulo</h1>
        <form action="index.jsp" method="get">
            <table>
                <tr>
                <input type="hidden" name="mod_id" id="mod_id" value="<%=temp.get("mod_id")%>">
                <input type="hidden" name="mod_id_old" id="mod_id_old" value="<%=temp.get("mod_id")%>">
                <td>
                    <label>Nombre</label>
                </td>
                <td>
                    <input type="text" name="mod_nombre" id="mod_nombre" value="<%=temp.get("mod_nombre")%>">
                </td>
                </tr>
                <tr>
                    <td>
                        <label>Descripcion</label>
                    </td>
                    <td>
                        <input type="text" name="mod_descripcion" id="mod_descripcion" value="<%=temp.get("mod_descripcion")%>">
                    </td>
            </table>
            <input type="submit" name="btnaccion" value="Guardar" /> 
            <input name="btnaccion" type="submit" value="Volver"  />  
        </form>

    </body>
</html>
