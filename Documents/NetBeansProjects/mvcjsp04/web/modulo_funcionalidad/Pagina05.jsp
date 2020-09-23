<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    HashMap datos = new HashMap();
    datos = (HashMap) request.getAttribute("datos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp" method="get">

            <div>
                <label for="fun_nombre">Nombre</label>
                <div>
                    <input type="text" name="fun_nombre" id="fun_nombre"  size="50" maxlength="50"/>
                </div>
            </div>
            <div>
                <label for="fun_ruta">Ruta</label>
                <div>
                    <input type="text" name="fun_ruta" id="fun_ruta"  size="50" maxlength="80"/>
                </div>
            </div>
            <div>
                <label for="fun_descripcion">Descripcion</label>
                <div>
                    <input type="text" name="fun_descripcion" id="fun_descripcion"  size="50" maxlength="150"/>
                </div>
            </div>
            <div>
                <input type="hidden" name="mod_id" value="<%=datos.get("mod_id")%>"  size="50" maxlength="150"/>
            </div>
            <input type="submit" name="btnaccion" value="Agregar"/>
            <input type="submit" name="btnaccion" value="Volver">

        </form>

    </body>
</html>
