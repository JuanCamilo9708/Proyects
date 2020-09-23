<%@page import="hospital.controlador.CitaControlador"%>
<%@page import="hospital.html.PaginacionCajaSeleccion"%>
<%@page import="hospital.vo.CitaVO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String btn = String.valueOf(request.getParameter("botonCitaListar")).trim(); 

if (btn.equalsIgnoreCase("Nuevo")) {
%>
<jsp:forward page="../Cita/CitaNuevo.jsp"/>
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
            frm.action ="../Cita/CitaBorrar.jsp";
            frm.submit();
        } 
        function Actualizar(frm){
            frm.action ="../Cita/CitaActualizar.jsp";
            frm.submit();
        } 
        function Pagina(frm){
            frm.action ="../Cita/CitaListar.jsp";
            frm.submit();
        }  
        function Diagnostico(frm){
            frm.action ="../Diagnostico/DiagnosticoListar.jsp";
            frm.submit();
        }   
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container"> 
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="glyphicon glyphicon-user"></i> Gestionar Cita
                </div>                         
                <div class="panel-body">
                <div class="buscar">
                    <form name="frmBuscarCita" method="POST" action="../Cita/CitaListar.jsp"> 
                        <div class="form-group">     
                                <div class="row">                         
                                <div class="col-md-7">                        
                                    <input type="submit" class="btn btn-primary input-sm" name="botonCitaListar" value="Nuevo" />         
                                    <input type="button" class="btn btn-primary input-sm" name="botonCitaListar" value="Borrar" onclick="return Borrar(document.forms['frmCitaListar']);" />         
                                    <input type="button" class="btn btn-primary input-sm" name="botonCitaListar" value="Editar" onclick="return Actualizar(document.forms['frmCitaListar']);"/>         
                                    <input type="button" class="btn btn-primary input-sm" name="botonDiagnosticoListar" value="Diagnostico" onclick="return Diagnostico(document.forms['frmCitaListar']);" /> 
                                </div>      
                                <div class="col-md-5 bg-primary" style="padding: 5px; margin-left: -15px">
                                    <div class="input-group">
                                            <span class="input-group-addon" title='¿Qué le gustaría buscar?'> <span class="glyphicon glyphicon-search"></span></span>                                    
                                            <input type="text" name="buscar"  title='¿Qué le gustaría buscar?' class="form-control input-sm" id="buscar" value="" placeholder="" size="20" maxlength="20"/>
                                            <span class="input-group-btn"><input type="submit" class="btn btn-success input-sm" name="botonCitaListar" value="Buscar"/> </span>                       
                                    </div>
                                </div>
                                </div>
                        </div>                                    
                    </form>                          
                </div>
               
                <div class="lista row">  
                    <form name="frmCitaListar" method="POST" action="../Cita/CitaListar.jsp"> 
                        <input type="hidden" name="buscar" value="<%=((request.getParameter("buscar")==null)?"":request.getParameter("buscar")) %>">
        <%
            try{
                CitaVO vo = null;
                CitaControlador con = new CitaControlador(request, response);
                con.listar();
                ArrayList lista = con.getLista();
        %>
                <div class="Paginar row">
                    <div class="col-sm-7">
                    </div>
                    <label for="Pag_id" class="col-sm-2 control-label">P&aacute;gina</label>
                    <div class="col-sm-3">
                        <select id="cit_pagina" name="cit_pagina" class="form-control input-sm" onchange="return Pagina(document.forms['frmCitaListar']);">
                    <%
                        try{
                            if(lista!=null)
                                out.print(PaginacionCajaSeleccion.lista(lista.size(), con.getRxp(), request.getParameter("cit_pagina")));
                        }catch(Exception ex){

                        }
                    %> 
                    </select>
                    </div>
                </div>
            <div class="col-md-12 listar">            
        <table class="table table-condensed table-striped tablaListar">
        <thead>   
          <tr>
            <th colspan="6">
                <label class="col-md-12">
                    <div class="col-md-2">#&nbsp;&nbsp;&nbsp;IdCita</div>
                    <div class="col-md-2">Costo Cita</div>  
                    <div class="col-md-2">Nombre paciente</div> 
                    <div class="col-md-2">Nombre Medico</div>  
                    <div class="col-md-2">Especialidad</div>  


                </label>
            </th>   
          </tr>         
        </thead>        
        <tbody>          
        <%
            con.listarPagina();
                lista = con.getLista();
                if(lista!=null){
                    boolean sw =  false;            
                    for(int k = 0; k < lista.size(); k++){
                        vo = (CitaVO)lista.get(k);
                        out.print("<tr>");
                        out.print("<td  colspan=\"6\">");
                        
                        out.print("<label class=\"col-md-12\">");
                        
                        out.print("<div class=\"col-md-2\">");
                        out.print("<input type='radio' name='cit_id' id='cit_id' value='"+vo.getCit_id()+"' onclick="+((char)34)+"javascript:Estado(document.forms['form1'])"+((char)34));
                        if(request.getParameter("cit_id")==null || String.valueOf(request.getParameter("cit_id")).equalsIgnoreCase("")){ 
                            if(k==0){
                                out.print(" checked="+((char)34)+((char)34)+" />");
                                out.print("<input type='hidden' name='estado' value='2' />");                                
                                sw = true;
                            }else{
                                out.print("/>");                                
                            }
                        }else{
                           if(vo.getCit_id().equalsIgnoreCase(request.getParameter("cit_id"))){
                                out.print(" checked="+((char)34)+((char)34)+" />");             
                                out.print("<input type='hidden' name='estado' value='2' />");
                                sw = true;
                           }else{
                                out.print("/>");                               
                           }
                        } 

                        out.print("&nbsp;&nbsp;");                        
                        out.print(vo.getCit_id()+" ");
                        out.print("</div>");
                        
                                                
                        out.print("<div class=\"col-md-2\">");
                        out.print(vo.getCit_costo()+" ");
                        out.print("</div>");
                        
                        out.print("<div class=\"col-md-2\">");
                        out.print(vo.getPac().getPac_nombre()+" ");
                        out.print(vo.getPac().getPac_apellido()+" ");
                        out.print("</div>");
                        
                        out.print("<div class=\"col-md-2\">");
                        out.print(vo.getMxe().getMed().getMed_nombre()+" ");
                        out.print(vo.getMxe().getMed().getMed_apellido()+" ");
                        out.print("</div>");
                        
                        out.print("<div class=\"col-md-2\">");
                        out.print(vo.getMxe().getEsp().getEsp_nombre()+" ");
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
