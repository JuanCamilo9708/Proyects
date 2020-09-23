<%@page import="hospital.controlador.CitaControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String btn = String.valueOf(request.getParameter("botonCitaListar")).trim(); 

if (btn.equalsIgnoreCase("Volver a listar")) {
%>
<jsp:forward page="../Cita/CitaListar.jsp"/>
<%
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">   
        <link href="../css/main.css" rel="stylesheet"> 
    </head>
    <body>
        <div class="container"> 
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="glyphicon glyphicon-user"></i>
                </div> 
                <div class="panel-body">
                    <div class="buscar">
                        <form name="frmCitaactualizar" method="POST" action="../Cita/CitaEditar.jsp"> 
                            <div class="form-group">     
                                    <div class="row">                         
                                        <div class="col-sm-12">
                                                <input type="submit" class="btn btn-primary input-sm" name="botonCitaListar" value="Volver a listar" />
                                            </div> 
                                    </div>
                            </div>
                        </form>   
                    </div>
<html>
    <body>
        <%
            try{
                CitaControlador con = new CitaControlador(request, response);
                con.editar();
                String msj = con.getMsj();
                out.print(msj);
            }catch(Exception ex){
                out.print(ex.getMessage());
            }
        %>
        </div> 
            </div>  
    </div>  
    </body>
</html>