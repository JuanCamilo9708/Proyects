<%@page import="hospital.controlador.CitaControlador"%>
<%@page import="hospital.vo.CitaVO"%>
<%@page import="hospital.controlador.DiagnosticoControlador"%>
<%@page import="hospital.html.PaginacionCajaSeleccion"%>
<%@page import="hospital.vo.diagnosticoVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String btn = String.valueOf(request.getParameter("botonDiagnosticoListar")).trim(); 

if (btn.equalsIgnoreCase("Nuevo")) {
%>
<jsp:forward page="../Diagnostico/DiagnosticoNuevo.jsp"/>
<%
}
%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">   
        <link href="../css/main.css" rel="stylesheet">  
        <script language="JavaScript">
        function Borrar(frm){
            frm.action ="../Diagnostico/DiagnosticoBorrar.jsp";
            frm.submit();
        } 
         function Actualizar(frm){
            frm.action ="../Diagnostico/DiagnosticoActualizar.jsp";
            frm.submit();
        }
        function Volver(frm){
            frm.action ="../Cita/CitaListar.jsp";
            frm.submit();
        }        
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container"> 
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="glyphicon glyphicon-user"></i> Gestionar Diagnostico
                </div>           
                <div class="infoAnt">
                <%
            
                ArrayList lista1 =  null;           
                CitaControlador con1 = new CitaControlador(request, response);
                con1.buscar();
                lista1 = con1.getLista();  
                CitaVO vo1 = (CitaVO)lista1.get(0);
              
              %>
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
                    <form name="frmBuscarDiagnostico" method="POST" action="../Diagnostico/DiagnosticoListar.jsp"> 
                        <div class="form-group">     
                                <div class="row">                         
                                <div class="col-md-12">                        
                                    <input type="submit" class="btn btn-primary input-sm" name="botonDiagnosticoListar" value="Nuevo" />         
                                    <input type="button" class="btn btn-primary input-sm" name="botonDiagnosticoListar" value="Borrar" onclick="return Borrar(document.forms['frmDiagnosticoListar']);" />         
                                    <input type="button" class="btn btn-primary input-sm" name="botonDiagnosticoListar" value="Editar" onclick="return Actualizar(document.forms['frmDiagnosticoListar']);" />         
                                    <input type="button" class="btn btn-primary input-sm" name="botonDiagnosticoListar" value="volver" onclick="return Volver(document.forms['frmDiagnosticoListar']);" />         
                                </div>      
                                <div class="col-sm-4 bg-primary" style="padding: 5px; margin-left: 700px">
                                    <div class="input-group">
                                            <span class="input-group-addon" title='¿Qué le gustaría buscar?'> <span class="glyphicon glyphicon-search"></span></span>                                    
                                            <input type="text" name="cit id"  title='¿Qué le gustaría buscar?' class="form-control input-sm" id="cit_id" value="" placeholder="" size="20" maxlength="20"/>
                                            <span class="input-group-btn"><input type="submit" class="btn btn-success input-sm" name="botonDiagnosticoListar" value="Buscar"/> </span>                       
                                    </div>
                                </div>
                                </div>
                            <div>
                                <input type="hidden" name="cit_id" value="<%=vo1.getCit_id()%>" size="50" maxlength="100" class="form-control input-sm"/>
                            </div>    
                        </div>                                    
                    </form>                          
                </div>
               
                <div class="lista row">  
                    <form name="frmDiagnosticoListar" method="POST" action="../Diagnostico/DiagnosticoListar.jsp"> 
                        <input type="hidden" name="buscar" value="<%=((request.getParameter("cit_id")==null)?"":request.getParameter("cit_id")) %>">
        <%
            try{
                diagnosticoVO vo = null;
                DiagnosticoControlador con = new DiagnosticoControlador(request, response);
                con.listar();
                ArrayList lista = con.getLista();
        %>
             <%--   <div class="Paginar row">
                    <div class="col-sm-7">
                    </div>
                    <label for="cita_id" class="col-sm-2 control-label">P&aacute;gina</label>
                    <div class="col-sm-3">
                        <select id="cit_pagina" name="cit_pagina" class="form-control input-sm" onchange="return Pagina(document.forms['frmDiagnosticoListar']);">
                    <%
                        try{
                            if(lista!=null)
                                out.print(PaginacionCajaSeleccion.lista(lista.size(), con.getRxp(), request.getParameter("buscar")));
                        }catch(Exception ex){

                        }
                    %> 
                    </select>
                    </div>
                </div>--%>
            <div class="col-md-12 listar">            
        <table class="table table-condensed table-striped tablaListar">
        <thead>   
          <tr>
            <th colspan="6">
                <label class="col-md-12">
                    <div class="col-md-2">#&nbsp;&nbsp;&nbsp;IdDiagnostico</div>
                    <div class="col-md-2">Nombre de Diagnostico</div>  
                    <div class="col-md-2">Tipo de enfermedad</div>
                    <div class="col-md-2">Nombre Enfermedad</div>  
                        <div>
                                <input type="hidden" name="cit_id" value="<%=vo1.getCit_id()%>" size="50" maxlength="100" class="form-control input-sm"/>
                        </div> 
                </label>
            </th>   
          </tr>         
        </thead>        
        <tbody>          
        <%
                if(lista!=null){
                    boolean sw =  false;            
                    for(int k = 0; k < lista.size(); k++){
                        vo = (diagnosticoVO)lista.get(k);
                        out.print("<tr>");
                        out.print("<td  colspan=\"6\">");
                        
                        out.print("<label class=\"col-md-12\">");
                        
                        out.print("<div class=\"col-md-2\">");
                        out.print("<input type='radio' name='diag_id' id='diag_id' value='"+vo.getDiag_id()+"' onclick="+((char)34)+"javascript:Estado(document.forms['form1'])"+((char)34));
                        if(request.getParameter("diag_id")==null || String.valueOf(request.getParameter("diag_id")).equalsIgnoreCase("")){ 
                            if(k==0){
                                out.print(" checked="+((char)34)+((char)34)+" />");
                                out.print("<input type='hidden' name='estado' value='2' />");                                
                                sw = true;
                            }else{
                                out.print("/>");                                
                            }
                        }else{
                           if(vo.getDiag_id().equalsIgnoreCase(request.getParameter("diag_id"))){
                                out.print(" checked="+((char)34)+((char)34)+" />");             
                                out.print("<input type='hidden' name='estado' value='2' />");
                                sw = true;
                           }else{
                                out.print("/>");                               
                           }
                        } 

                        out.print("&nbsp;&nbsp;");                        
                        out.print(vo.getDiag_id()+" ");
                        out.print("</div>");
                        
                                                
                        out.print("<div class=\"col-md-2\">");
                        out.print(vo.getDiag_nombre()+" ");
                        out.print("</div>");
                        
                        out.print("<div class=\"col-md-2\">");
                        out.print(vo.getTip().getTip_nombre()+" ");
                        out.print("</div>");
                        
                        out.print("<div class=\"col-md-2\">");
                        out.print(vo.getEnfer().getEnfer_nombre()+" ");
                        out.print("</div>");
                        
                        
                                              
                     
                        out.print("</label>");
                        
                        out.print("</td>");
                        out.print("</tr>");       
                    }
                    for(int k=0; k<10-lista.size(); k++){
                        out.print("<tr>");
                        out.print("<td  colspan=\"6\">");
                        
                        out.print("<label class=\"col-md-12\">"); 
                        out.print("</label>");
                        
                        out.print("</td>");
                        out.print("</tr>");                                                   
                    }                    
                    
                }else{
                    for(int k=0; k<10; k++){
                        out.print("<tr>");
                        out.print("<td  colspan=\"6\">");
                        
                        out.print("<label class=\"col-md-12\">"); 
                        out.print("</label>");
                        
                        out.print("</td>");
                        out.print("</tr>");                                                   
                    }
                }
%>
        </tbody>
        </table>      
            </div>  
<%
            }catch(Exception ex){
                out.print(ex.getMessage());
            }
        %>
                </form>
                </div>
                </div>
            </div>
        </div>          
    </body>
</html>
