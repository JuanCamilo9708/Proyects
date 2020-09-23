<%@page import="java.util.ArrayList"%>
<%@page import="hospital.controlador.EnfermedadesControlador"%>
<%@page import="hospital.vo.enfermedadesVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try{
                enfermedadesVO vo = null;
                EnfermedadesControlador con = new EnfermedadesControlador(request, response);
                con.listar();
                ArrayList lista = con.getLista();
                if(lista!=null){
                    for(int k = 0; k < lista.size(); k++){
                        vo = (enfermedadesVO)lista.get(k);
                        out.print(vo.getEnfer_id()+" ");
                        out.print(vo.getEnfer_nombre()+" ");
                        out.print(vo.getEnfer_sintomas()+" ");
                        out.print(vo.getTip_id()+" ");
                        out.print("<br>");                
                    }                                    
                }
            }catch(Exception ex){
                out.print(ex.getMessage());
            }
        %>
    </body>
</html>
