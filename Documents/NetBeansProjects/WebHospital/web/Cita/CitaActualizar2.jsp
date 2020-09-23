<%@page import="hospital.html.MedxEspCajaSeleccion"%>
<%@page import="hospital.html.EspecialidadCajaSeleccion"%>
<%@page import="hospital.html.MedicoCajaSeleccion"%>
<%@page import="hospital.controlador.MedxEspControlador"%>
<%@page import="hospital.controlador.EspecialidadControlador"%>
<%@page import="hospital.controlador.MedicoControlador"%>
<%@page import="hospital.controlador.CitaControlador"%>
<%@page import="hospital.vo.CitaVO"%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String btn = String.valueOf(request.getParameter("botonCitaNuevo")).trim(); 

if (btn.equalsIgnoreCase("Actualizar")) {
%>
<jsp:forward page="../Cita/CitaEditar.jsp"/>
<%
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">   
        <link href="../css/main.css" rel="stylesheet">  
        <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script> 
        <script type="text/javascript" src="../js/jquery.validate.js"></script> 
        <script language="JavaScript">
            function Especialidad(frm){
            $("#medico").html('<div class="col-md-12" ><img src="./../img/loading.gif" width="18px" height="18px"/>Cargando...</div>');    
            $.ajax({
                url: "../MedxEsp/MedxEspListarCaja.jsp",
                type: "POST",
                data: jQuery.parseJSON('{"Esp_id" : "'+frm.Esp_id.value+'"}'),
                success: function(datos)
                {
                    $("#medico").html(datos);
                }
            });
        }
        function Volver(frm){
            frm.action ="../Cita/CitaListar.jsp";
            frm.submit();
        }
        </script> 
        <style type="text/css">
             .error {color: #f00}
            </style>
<script type="text/javascript">
            $().ready(function (){ 
                $("#frm1").validate({
                    rules: {
                        cit_id: {
                            number:true,
                            required: true,
                            digits:true,
                        },cit_fecha_generada:{
                            required:true,
                            date:true,
                        },cit_fecha_asistencia:{
                            required:true,
                            date:true,
                        },cit_costo: {
                            number:true,
                            required: true,
                            digits:true,
                        },pac_id: {
                            number:true,
                            required: true,
                            digits:true,
                        },Esp_id:{
                            required:true,
                        },med_id:{
                            required:true,
                        }
                    }
                });
            });
    </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container"> 
            <form name="frmCitaActaulizar" id="frm1" action="../Cita/CitaActualizar.jsp" method="GET">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="glyphicon glyphicon-user"></i> Actualizar Cita
                </div>          
                <div class="row col-sm-12">
                        <%
                            ArrayList lista1 = null;
                            CitaVO vo1;
                            CitaControlador con1 = new CitaControlador(request, response);
                            con1.buscar();
                            lista1 = con1.getLista(); 
                            vo1=(CitaVO)lista1.get(0);
                        %> 
                    </div>     
                <div class="panel-body">
                <div class="buscar">
                    <div class="col-sm-12">
                        <input type="submit" class="btn btn-primary input-sm" name="botonCitaActaulizar" value="Actualizar" />  
                        <input type="button" class="btn btn-primary input-sm" name="botonCitaActaulizar" value="Volver" onclick="return Volver(document.forms['frmCitaActaulizar']);" /> 
                          
                    </div>                          
                </div>
                <div class="nuevo">    
                        <div class="row form-group">
                          <input type="hidden" name="buscar" id="buscar" value="<%=vo1.getCit_id()%>" size="20" maxlength="20" class="form-control input-sm" />
                        </div>                    
                        <div class="row form-group">                          
                            <label for="cit_id" class="col-sm-2 control-label">Id Cita</label>
                            <div class="col-sm-8">
                                <input type="text" name="cit_id" id="cit_id" value="<%=vo1.getCit_id()%>" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                        <div class="row form-group">                          
                            <label for="cit_fecha_generada" class="col-sm-2 control-label">Fecha Generada</label>
                            <div class="col-sm-8">
                                <input type="date" name="cit_fecha_generada" id="cit_fecha_generada" value="<%=vo1.getCit_fecha_generada()%>" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                         <div class="row form-group">                          
                            <label for="cit_fecha_asistencia" class="col-sm-2 control-label">Fecha de asistencia</label>
                            <div class="col-sm-8">
                                <input type="date" name="cit_fecha_asistencia" id="cit_fecha_asistencia" value="<%=vo1.getCit_fecha_asistencia()%>" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                         <div class="row form-group">                          
                            <label for="cit_costo" class="col-sm-2 control-label">Costo</label>
                            <div class="col-sm-8">
                                <input type="text" name="cit_costo" id="cit_costo" value="<%=vo1.getCit_costo()%>" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                         <div class="row form-group">                          
                            <label for="pac_id" class="col-sm-2 control-label">Paciente</label>
                            <div class="col-sm-8">
                                <input type="text" name="pac_id" id="pac_id" value="<%=vo1.getPac().getPac_id() %>" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                        <div class="row form-group"> 
                            <label for="Esp_id" class="col-sm-2 control-label">Especialidad</label>
                            <div class="col-sm-8">
            
                       <select name="Esp_id" id="Esp_id" class="form-control input-sm" onchange="Especialidad(document.forms['frmNuevaCita'])">                     
            
            <%
            try{
                ArrayList lista = null;                 
                EspecialidadControlador con = new EspecialidadControlador(request, response);
                con.listar();
                lista = con.getLista();
                out.print(EspecialidadCajaSeleccion.lista(lista, vo1.getEsp_id()));
                
            }catch(Exception ex){
                out.print(ex.getMessage());                
            }
            %>
            </select>
                            </div>
                        </div>
                        <div class="row form-group"> 
                            <label for="med_id" class="col-sm-2 control-label">Medico</label>
                                <div class="col-sm-8">
                                <div id="medico">
                                    
                            <select name="med_id" id="med_id" class="form-control input-sm">      
                  <%
                        try{
                    CitaControlador con2 = new CitaControlador(request, response);

                    con2.MedXEsplistar();

                    ArrayList lista2 = con2.getLista();
                    if(lista2!=null){
                    out.print(MedxEspCajaSeleccion.lista(lista2, vo1.getMed_id()));
                    }
                        }catch(Exception ex){

                        }
                    %>
                                
                        </select>
                     </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                    </form>                
        </div>
    </body>
</html>
