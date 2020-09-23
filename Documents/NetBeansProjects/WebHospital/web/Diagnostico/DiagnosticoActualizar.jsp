<%@page import="hospital.html.EnfermedadesCajaSeleccion"%>
<%@page import="hospital.controlador.EnfermedadesControlador"%>
<%@page import="hospital.controlador.CitaControlador"%>
<%@page import="hospital.vo.CitaVO"%>
<%@page import="hospital.vo.enfermedadesVO"%>
<%@page import="hospital.controlador.DiagnosticoControlador"%>
<%@page import="hospital.html.PaginacionCajaSeleccion"%>
<%@page import="hospital.vo.diagnosticoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hospital.html.Tipo_enfermedadCajaSeleccion"%>
<%@page import="hospital.controlador.Tipo_EnfermedadControlador"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String btn = String.valueOf(request.getParameter("botonDiagnosticoNuevo")).trim(); 

if (btn.equalsIgnoreCase("Actualizar")) {
%>
<jsp:forward page="../Diagnostico/DiagnosticoEditar.jsp"/>
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
           function Tip_Enfermedad(frm){
            $("#enfermedad").html('<div class="col-md-12" ><img src="./../img/loading.gif" width="18px" height="18px"/>Cargando...</div>');    
            $.ajax({
                url: "../Enfermedades/EnfermedadListarCaja.jsp",
                type: "POST",
                data: jQuery.parseJSON('{"Tip_id" : "'+frm.Tip_id.value+'"}'),
                success: function(datos)
                {
                    $("#enfermedad").html(datos);
                }
            });
        }
        function Volver(frm){
            frm.action ="../Diagnostico/DiagnosticoListar.jsp";
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
                        diag_id: {
                            number:true,
                            required: true,
                            digits:true,
                        },diag_nombre:{
                            required:true,
                        },cit_id:{
                            number:true,
                            required: true,
                            digits:true,                     
                        },Tip_id:{
                            required:true,
                        },Enfer_id:{
                            required:true,
                        }
                    }
                });
            });
</script>        
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="container" style="width: 900px; height: 100px;"> 
            <form name="frmNuevoDiagnostico" id="frm1" action="../Diagnostico/DiagnosticoActualizar.jsp" method="GET">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="glyphicon glyphicon-user"></i> Actualizar Diagnostico
                </div>            
                <div class="infoAnt"> 
                        <%                        
                            ArrayList lista2 = null;
                            diagnosticoVO vo;
                            DiagnosticoControlador con2 = new DiagnosticoControlador(request, response);
                            con2.buscar();
                            lista2 = con2.getLista();
                            vo=(diagnosticoVO)lista2.get(0);
                        %>                         
                        &nbsp;               
                        <%
                        
                            ArrayList lista1 = null;
                            CitaVO vo1;
                            CitaControlador con1 = new CitaControlador(request, response);
                            con1.buscar();
                            lista1 = con1.getLista();
                            vo1=(CitaVO)lista1.get(0);
                        %> 
                        &nbsp;
                </div>    
                
                     <div class="infoAnt-6">                         
                        <label class="col-md-2 control-label">#&nbsp;&nbsp;&nbsp;IdCita: <%=vo1.getCit_id()%></label>
                        <label class="col-md-2 control-label">Costo Cita: <%=vo1.getCit_costo()%></label>
                        <label class="col-md-3 control-label">Paciente : <%=vo1.getPac().getPac_nombre()%> <%=vo1.getPac().getPac_apellido()%></label>
                        <label class="col-md-3 control-label">Medico : <%=vo1.getMxe().getMed().getMed_nombre()%> <%=vo1.getMxe().getMed().getMed_apellido()%></label>
                        <label class="col-md-2 control-label">Especialidad : <%=vo1.getMxe().getEsp().getEsp_nombre()%> </label>
                    </div>
                <div class="panel-body">
                <div class="buscar">
                    <div class="col-sm-12">
                        <input type="hidden" name="cit_id" id="cit_id" value="<%=vo1.getCit_id()%>" size="50" maxlength="100" class="form-control input-sm"/>
                        <input type="submit" class="btn btn-primary input-sm" name="botonDiagnosticoNuevo" value="Actualizar" />         
                        <input type="button" class="btn btn-primary input-sm" name="botonDiagnosticoNuevo" value="Volver" onclick="return Volver(document.forms['frmNuevoDiagnostico']);" />         
                    </div>                          
                </div>
                       
                <div class="nuevo">    
                        <div class="row form-group">
                          <input type="hidden" name="buscar" id="buscar" value="<%=vo1.getCit_id()%>" size="20" maxlength="20" class="form-control input-sm" />
                        </div> 
                        <div class="row form-group">
                          <input type="hidden" name="buscar" id="buscar" value="<%=vo.getTip_id()%>" size="20" maxlength="20" class="form-control input-sm" />
                        </div> 
                        <div class="row form-group">
                          <input type="hidden" name="buscar1" id="buscar1" value="<%=vo.getDiag_id()%>" size="20" maxlength="20" class="form-control input-sm" />
                        </div>
                        
                        <div class="row form-group">                          
                            <label for="diag_id" class="col-sm-2 control-label">Id Diagnostico</label>
                            <div class="col-sm-8">
                            <input type="text" name="diag_id" id="diag_id" value="<%=vo.getDiag_id()%>" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                        <div class="row form-group">                          
                            <label for="diag_nombre" class="col-sm-2 control-label">Nombre Diagnostico</label>
                            <div class="col-sm-8">
                            <input type="text" name="diag_nombre" id="diag_nombre" value="<%=vo.getDiag_nombre()%>" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                            <div class="row form-group"> 
                            <label for="cit_id" class="col-sm-2 control-label">Id Cita</label>
                            <div class="col-sm-8">
                            <input type="text" name="cit_id" id="cit_id" value="<%=vo1.getCit_id()%>" size="50" maxlength="100" class="form-control input-sm"/>
                            </div>
                        </div>
                        
                        <div class="row form-group"> 
                <label for="tip_id" class="col-sm-2 control-label">Tipo de enfermedad</label>
                <div class="col-sm-8">
                    <select name="Tip_id" id="Tid_id" class="form-control input-sm" onchange="Tip_Enfermedad(document.forms['frmNuevoDiagnostico'])">                     
            <%
            try{
                ArrayList lista = null;                
                Tipo_EnfermedadControlador con = new Tipo_EnfermedadControlador(request, response);
                con.listar();
                lista = con.getLista();
                out.print(Tipo_enfermedadCajaSeleccion.lista(lista, vo.getTip_id()));
                
            }catch(Exception ex){
                out.print(ex.getMessage());                
            }
            %>
            </select>
                </div>
            </div>
            <div class="row form-group"> 
                <label for="enfer_id" class="col-sm-2 control-label">Enfermedad</label>
                <div class="col-sm-8">
                    <div id="enfermedad">
            <select name="Enfer_id" id="enfer_id" class="form-control input-sm">    
                <%
                        try{
                    DiagnosticoControlador con3 = new DiagnosticoControlador(request, response);

                    con3.EnferXTipListar();

                    ArrayList lista3 = con3.getLista();
                    if(lista3!=null){
                    out.print(EnfermedadesCajaSeleccion.lista(lista3, vo.getEnfer_id()));
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
