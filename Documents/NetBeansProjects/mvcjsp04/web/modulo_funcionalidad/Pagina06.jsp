
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap temp = (HashMap) request.getAttribute("funcionalidad");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp" method="get">

            <div>
                <input type="hidden" name="fun_id" id="fun_id_old"  size="50" maxlength="30" value="<%=temp.get("fun_id")%>"/>
                <input type="hidden" name="fun_id" id="fun_id"  size="50" maxlength="30" value="<%=temp.get("fun_id")%>"/>
            </div>
            <div>
                <label for="fun_nombre">Nombre</label>
                <div>
                    <input type="text" name="fun_nombre" id="fun_nombre"  size="50" maxlength="50" value="<%=temp.get("fun_nombre")%>"/>
                </div>
            </div>
            <div>
                <label for="fun_ruta">Ruta</label>
                <div>
                    <input type="text" name="fun_ruta" id="fun_ruta"  size="50" maxlength="150" value="<%=temp.get("fun_ruta")%>"/>
                </div>
            </div>
            <div>
                <label for="fun_descripcion">Descripcion</label>
                <div>
                    <input type="text" name="fun_descripcion" id="fun_descripcion"  size="50" maxlength="150" value="<%=temp.get("fun_descripcion")%>"/>
                </div>
            </div>
            <input type="hidden" name="mod_id" id="mod_id"  size="50" maxlength="150" value="<%=temp.get("mod_id")%>"/>
            <input type="submit" name="btnaccion" value="Modificar"/>
            <input type="submit" name="btnaccion" value="Volver">
        </form>
    </body>
</html>
