<%@page import="java.util.ArrayList"%>
<%@page import="general.VistaGeneral"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HashMap datos = (HashMap) request.getAttribute("datos");
    ArrayList<HashMap> temp1 = (ArrayList<HashMap>) datos.get("datos");
    ArrayList<HashMap> temp2 = (ArrayList<HashMap>) datos.get("datos2");
    VistaGeneral vista = new VistaGeneral();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="index.jsp" method="post">    
            <div>
                <input type="text" name="buscar" id="buscar"  size="50" maxlength="50"/>
            </div>

            <input name="btnaccion" type="submit" value="buscar"  /> <br><br><br>
            <%              
                if (temp1 == null) {
                    String html = vista.generarTablaRadio(temp2, "per_id-defecto,per_nombre-defecto,per_id-radio-per_id").toString();
                    out.print(html);
                } else {
                    String html = vista.generarTablaRadio(temp1, "per_id-defecto,per_nombre-defecto,per_id-radio-per_id").toString();
                    out.print(html);
                }
            %>

            <input name="btnaccion" type="submit" value="Registrar"  /> 
            <input name="btnaccion" type="submit" value="Eliminar"  />
            <input name="btnaccion" type="submit" value="Actualizar" />
            <input name="btnaccion" type="submit" value="Permisos" />
            <input type="button" onclick="location.href = '../index.jsp'" value="Volver" name="Volver">

        </form>

    </body>
</html>