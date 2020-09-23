
<%@page import="java.util.ArrayList"%>
<%@page import="hospital.controlador.MedxEspControlador"%>
<%@page import="hospital.vo.MedxEspVO"%>
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
                MedxEspVO vo = null;
                MedxEspControlador con = new MedxEspControlador(request, response);
                con.listar();
                ArrayList lista = con.getLista();
                if(lista!=null){
                    for(int k = 0; k < lista.size(); k++){
                        vo = (MedxEspVO)lista.get(k);
                        out.print(vo.getMed().getMed_id()+" ");
                        out.print(vo.getMed().getMed_nombre()+" ");
                        out.print(vo.getEsp().getEsp_id()+" ");
                        out.print("<br>");                
                    }                                    
                }
            }catch(Exception ex){
                out.print(ex.getMessage());
            }
        %>
    </body>
</html>
