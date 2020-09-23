<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear modulo</title>
    </head>
    <body>
        <form action="index.jsp" method="get">
            <div>
                <label for="mod_nombre">Nombre</label>
                <div>
                    <input type="text" name="mod_nombre" id="mod_nombre"  size="50" maxlength="50"/>
                </div>
            </div>
            <div>
                <label for="mod_descripcion">Descripcion</label>
                <div>
                    <input type="text" name="mod_descripcion" id="mod_descripcion"  size="50" maxlength="150"/>
                </div>
            </div>
            <input type="submit" name="btnaccion" value="Enviar"/>
            <input type="submit" name="btnaccion" value="Cancelar">
            <input type="button" onclick="location.href = 'index.jsp'" value="Volver" name="Volver">
        </form>

    </body>
</html>
