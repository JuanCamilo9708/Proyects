<%@page import="general.VistaGeneral"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.ModeloUsuario"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    HashMap temp = (HashMap) request.getAttribute("datos");
    String x;
    VistaGeneral vista = new VistaGeneral();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Roles Usuario</title>
    </head>
    <body>
        <%             
            out.print("<table>");
            out.print("<thead>");
            out.print("<tr>");
            out.print("<th>");
            out.print("Codigo");
            out.print("</th>");
            out.print("<th>");
            out.print("Nombre");
            out.print("</th>");
            out.print("<th>");
            out.print("Usuario");
            out.print("</th>");
            out.print("</tr>");
            out.print("</thead>");
            out.print("<tbody>");
            out.print("<tr>");
            out.print("<th>");
            out.print(temp.get("id"));
            out.print("</th>");
            out.print("<th>");
            out.print(temp.get("nombre"));
            out.print("</th>");
            out.print("<th>");
            out.print(temp.get("usuario"));
            out.print("</th>");
            out.print("</tr>");
            out.print("</tbody>");
            out.print("</table>");
        %>

        <form action="index.jsp" method="get" name="form_permisos">
            <input type="hidden" name="per_id" value="<%=temp.get("id")%>">
            <%
                ArrayList<HashMap> al = (ArrayList<HashMap>) request.getAttribute("datos1");
                ArrayList<HashMap> al2 = (ArrayList<HashMap>) request.getAttribute("datos2");
            %>
            <table>
                <tr>
                    <th>
                        <%
                            x = vista.generarComboBox(al, "id", "nombre", "rol_id").toString();
                            out.print(x);
                        %>
                    </th>
                    <th>
                        <div>

                            <input type="submit" name="btnaccion" value="Asignar">
                        </div>
                        <br>
                        <div>
                            <input type="submit" name="btnaccion" value="Quitar">
                        </div>
                    </th>
                    <th>
                        <%
                            x = vista.generarComboBox(al2, "id", "nombre", "rol_id").toString();
                            out.print(x);
                        %>
                    </th>
                </tr>
            </table>
            <input type="submit" name="btnaccion" value="Volver">
        </form>

    </body>
</html>
