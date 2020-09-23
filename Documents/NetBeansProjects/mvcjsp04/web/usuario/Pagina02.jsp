<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INSERTAR NUEVO USUARIO</title>
    </head>
    <body>
        <form action="index.jsp" method="post" name="form_insertar" id="form_insertar">
            <table>
                <tr>
                    <td>
                        <label>Codigo de la persona</label>
                    </td>
                    <td>
                        <input type="text" name="per_id" id="per_id">
                    </td>

                    <td>
                        <label>Nombre</label>
                    </td>
                    <td>
                        <input type="text" name="per_nombre" id="per_nombre">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Apellido</label>
                    </td>
                    <td>
                        <input type="text" name="per_apellido" id="per_apellido">
                    </td>

                    <td>
                        <label>Fecha nacimiento</label>
                    </td>
                    <td>
                        <input type="date" name="per_fecha_nacimiento" id="per_fecha_nacimiento">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Direccion</label>
                    </td>
                    <td>
                        <input type="text" name="per_direccion" id="per_direccion">
                    </td>

                    <td>
                        <label>Correo</label>
                    </td>

                    <td>
                        <input type="text" name="per_correo" id="per_correo">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>usuario</label>
                    </td>
                    <td>
                        <input type="text" name="per_id" id="per_id">
                    </td>
                    <td>
                        <label>Contraseña</label>
                    </td>
                    <td>
                        <input type="password" name="usu_clave" id="usu_clave">
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" name="btnaccion" value="Enviar" >
            <input type="submit" name="btnaccion" id="Volver" value="Volver">
            <br>
        </form>
    </body>
</html>
