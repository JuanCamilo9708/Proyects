<%@page import="general.VistaGeneral"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    VistaGeneral vista = new VistaGeneral();
    HashMap datos = new HashMap();
    datos = (HashMap) request.getAttribute("datos");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Funcionalidades</title>
    </head>
    <body>
        <form action="index.jsp" method="post">    

            <%
                ArrayList<HashMap> listafuncionalidades;
                listafuncionalidades = (ArrayList<HashMap>) datos.get("funcionalidad");
                String html = vista.generarTablaRadio(listafuncionalidades, "fun_nombre-defecto,fun_descripcion-defecto,fun_id-radio-fun_id").toString();

                out.print(html);
            %>

            <br>

            <input type="hidden" name="mod_id" id="mod_id"  size="50" maxlength="30" value="<%=datos.get("mod_id")%>"/>
            <input type="submit" value="Crear funcionalidad" name="btnaccion" />
            <input type="submit" value="Modificar funcionalidad" name="btnaccion" />
            <input type="submit" value="Eliminar funcionalidad" name="btnaccion" />
            <input type="button" onclick="location.href = 'index.jsp'" value="Volver" name="Volver">

        </form>
    </body>
</html>
