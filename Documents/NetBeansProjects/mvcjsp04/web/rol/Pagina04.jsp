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
        <title>Funcionalidades Roles</title>
    </head>
    <body>
        <%           
            out.print("<table>");
            out.print("<thead>");
            out.print("<tr>");
            out.print("<th>");
            out.print("Nombre");
            out.print("</th>");           
            out.print("</tr>");
            out.print("</thead>");
            out.print("<tbody>");
            out.print("<tr>");          
            out.print("<th>");
            out.print(temp.get("rol_id"));
            out.print("</th>");
            out.print("</tr>");
            out.print("</tbody>");
            out.print("</table>");
        %>

        <form action="index.jsp" method="get" name="form_permisos">
            <input type="hidden" name="rol_id" value="<%=temp.get("rol_id")%>">

            <%
                ArrayList<HashMap> al = (ArrayList<HashMap>) temp.get("datos1");
                ArrayList<HashMap> al2 = (ArrayList<HashMap>) temp.get("datos2");
            %>

            <table>
                <tr>
                    <th>
                        <%
                            x = vista.generarComboBox(al, "id", "nombre", "fun_id").toString();
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
                            x = vista.generarComboBox(al2, "id", "nombre", "fun_id").toString();
                            out.print(x);
                        %>
                    </th>
                </tr>
            </table>
            <input type="submit" name="btnaccion" value="Volver">
        </form>

    </body>
</html>

