<%@page import="java.util.ArrayList"%>
<%@page import="modelo.ModeloLogin"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina03</title>
    </head>
    <style>
        ul {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
    </style>
    <body>
    <center>
        <h3>LISTA DE FUNCIONALIDADES</h3>
        <hr>

        <% try {
                HashMap datos = new HashMap();
                datos = (HashMap) request.getAttribute("datos");
                ArrayList<HashMap> listarFuncionalidad = (ArrayList) datos.get("datos1");
                ArrayList mod = new ArrayList();
        %> 
        <ul> 
            <%
                for (int i = 0; i < listarFuncionalidad.size(); i++) {
                    mod.add(listarFuncionalidad.get(i).get("fun_nombre"));
            %>   


            <li >
                <%
                        out.print(mod.get(i));
                    }
                %> 
            </li>

        </ul>


    </form>
    <%
        } catch (Exception e) {
            out.print(e.getMessage());
        }
    %>

    <p>
    <form action="index.jsp" method="POST">
        <input type="submit" name="btnaccion" value="Cerrar sesion"/>
    </form>
</center>
</body>
</html>

