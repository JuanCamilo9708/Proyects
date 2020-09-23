<%@page import="hospital.controlador.CitaControlador"%>
<%@page import="hospital.vo.CitaVO"%>
<%@page import="hospital.controlador.DiagnosticoControlador"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">   
        <link href="../css/main.css" rel="stylesheet"> 
        <script type="text/javascript" src="../js/jquery-2.1.4.min.js"></script> 
        <script language="JavaScript">
            function Volver(frm){
            frm.action ="../Diagnostico/DiagnosticoListar.jsp";
            frm.submit();
        }
        </script>
    </head>
    <body>
        <div class="container"> 
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="glyphicon glyphicon-user"></i>
                </div>
                <div class="panel-body">
                    <div class="buscar">
                        <div class="container">             
                                    
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
                        <form name="frmDiagnosticoRegistrar" method="POST" action="../Diagnostico/DiagnosticoBorrar.jsp"> 
                            <div class="form-group">     
                                    <div class="row">                         
                                        <div class="col-sm-12">
                                            <div>
                                                <input type="hidden" name="cit_id" value="<%=vo1.getCit_id()%>" size="50" maxlength="100" class="form-control input-sm"/>
                                           </div> 
                                           <input type="button" class="btn btn-primary input-sm" name="botonDiagnosticoListar" value="Volver a listar" onclick="return Volver(document.forms['frmDiagnosticoRegistrar']);" />  
                                            </div> 
                                    </div>
                            </div>
                        </form>   
                    </div>
    <body>
        <%
            try{
                DiagnosticoControlador con = new DiagnosticoControlador(request, response);
                con.registrar();
                String msj = con.getMsj();
                out.print(msj);
            }catch(Exception ex){
                out.print(ex.getMessage());
            }
        %>
    </body>
</html>
