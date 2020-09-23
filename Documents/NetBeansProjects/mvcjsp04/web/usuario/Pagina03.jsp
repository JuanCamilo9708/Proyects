<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap temp = (HashMap) request.getAttribute("datos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ACTUALIZAR USUARIO</title>
    </head>
    <body>
        <form action="index.jsp" method="post" name="form_insertar" id="form_insertar">
            <table>
                <tr>
                    <td>
                        <label>Codigo de la persona</label>
                    </td>
                    <td>
                        <input type="text" name="per_id" id="per_id" value="<%=temp.get("id")%>">
                        <input type="hidden" name="per_id_old" id="per_id_old" value="<%=temp.get("id")%>">
                    </td>
                    <td>
                        <label>Nombre</label>
                    </td>
                    <td>
                        <input type="text" name="per_nombre" id="per_nombre" value="<%=temp.get("nombre")%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Apellido</label>
                    </td>
                    <td>
                        <input type="text" name="per_apellido" id="per_apellido" value="<%=temp.get("apellido")%>">
                    </td>
                    <td>
                        <label>Fecha nacimiento</label>
                    </td>
                    <td>
                        <input type="date" name="per_fecha_nacimiento" id="per_fecha_nacimiento" value="<%=String.valueOf(temp.get("nacimiento"))%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Direccion</label>
                    </td>
                    <td>
                        <input type="text" name="per_direccion" id="per_direccion" value="<%=temp.get("direccion")%>">
                    </td>

                    <td>
                        <label>Correo</label>
                    </td>
                    <td>
                        <input type="text" name="per_correo" id="per_correo" value="<%=temp.get("correo")%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Usuario</label>
                    </td>
                    <td>
                        <input type="text" name="usu_usuario" id="usu_usuario" value="<%=temp.get("usuario")%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Digite su clave anterior</label>
                    </td>
                    <td>
                        <input type="hidden" name="usu_clave" id="usu_clave" value="<%=temp.get("clave")%>">
                        <input type="password" name="usu_clave_old" id="usu_clave_old">
                    </td>
                    <td>
                        <label>Digite su nueva clave</label>
                    </td>
                    <td>
                        <input type="password" name="usu_clave_new" id="usu_clave_new">
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" name="btnaccion" id="update" value="Actualizar_usuario">
            <input type="submit" name="btnaccion" id="Volver" value="Volver">
            <br>
        </form>
    </body>
</html>
