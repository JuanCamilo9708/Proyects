<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <form method="POST" action="index.jsp" name="form1">
          
                <legend>Acceso a la plataforma</legend>
                <p>
                    <label>Usuario</label>
                    <br>
                    <input type="text" name="per_id"  id="per_id">
                <p>
                    <label>Clave</label>
                    <br>
                    <input type="password" name="usu_clave" id="usu_clave">
                <p>
                    <input type="reset" name="limpiar" value="Limpiar">
                    <input type="submit" name="btnaccion" value="Acceder"><br>
                    <%
                        HashMap datos = new HashMap();
                        datos = (HashMap) request.getAttribute("datos");                     
                    %>
        </form>
            <input type="button" onclick="location.href = '../index.jsp'" value="Volver" name="Volver">
    </center>
            
</body>
</html>