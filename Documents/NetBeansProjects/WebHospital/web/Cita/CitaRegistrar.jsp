<%-- 
    Document   : PersonaListar
    Created on : 3/04/2017, 07:48:08 AM
    Author     : Usuario
--%>
<%@page import="hospital.controlador.CitaControlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <%--<img class="icon_titulo col-lg-1" src="../img/regi.png"/> --%>
                </div>
                <div class="panel-body">
                    <div class="buscar">
                        <form name="frmBuscarCita" method="POST" action="../Cita/CitaRegistrar.jsp"> 
                            <div class="form-group">     
                                    <div class="row">                         
                                        <div class="col-sm-12">
                                            <a href="/WebHospital/Cita/CitaNuevo.jsp" class="btn btn-primary input-sm" name="botonCitaNuevo" value="MENU">VOLVER A INSERTAR</a>
                                            <a href="/WebHospital/Cita/CitaListar.jsp" class="btn btn-primary input-sm" name="botonCitaListar" value="MENU">VOLVER A LISTAR</a>

                                        </div> 
                                    </div>
                            </div>
                        </form>   
                    </div>
        <%
            try{
                CitaControlador con = new CitaControlador(request, response);
                con.registrar();
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
