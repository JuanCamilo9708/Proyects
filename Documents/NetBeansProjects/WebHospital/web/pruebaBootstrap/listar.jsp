<%-- 
    Document   : listar
    Created on : 4/04/2017, 07:21:57 AM
    Author     : Estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">   
        <link href="../css/main.css" rel="stylesheet">   
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="glyphicon glyphicon-user"></i> Gestionar Persona
                </div> 
                <div class="panel-body">
                <div class="buscar">
                    <form name="form2" method="POST" action="../pruebaBootstrap/listar.jsp"> 
                        <div class="form-group">     
                                <div class="row">                         
                                <div class="col-md-7">                        
                                    <input type="submit" class="btn btn-primary input-sm" name="botonPersonaListar" value="Nuevo" />         
                                </div>      
                                <div class="col-md-5 bg-primary" style="padding: 5px; margin-left: -15px">
                                    <div class="input-group">
                                            <span class="input-group-addon" title='¿Qué le gustaría buscar?'> <span class="glyphicon glyphicon-search"></span></span>                                    
                                            <input type="text" name="Per_buscar"  title='¿Qué le gustaría buscar?' class="form-control input-sm" id="Per_buscar" value="" placeholder="" size="20" maxlength="20"/>
                                            <span class="input-group-btn"><input type="submit" class="btn btn-success input-sm" name="botonPersonaListar" value="Buscar"/> </span>                       
                                    </div>
                                </div>
                                </div>
                        </div>                                    
                    </form>                          
                </div>
                    <div class="lista row">
                        <div class="col-md-12 listar">   
                        <table class="table table-striped table-condensed tablaListar">
                            <thead>
                                <tr>
                                    <th colspan="3">
                                        <label class="col-md-12">
                                            <div class="col-md-2">#&nbsp;&nbsp;&nbsp;Identificaci&oacute;n</div>
                                            <div class="col-md-6">Persona</div>  
                                            <div class="col-md-2">Lugar</div>  
                                        </label>
                                    </th>   
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for(int i=1;i<30;i++){
                                        out.print("<tr>");
                                        out.print("<td colspan=\"3\">");
                                        out.print("<label class=\"col-md-12\">");
                                        out.print("<div class=\"col-md-2\">");    
                        out.print("<input type='radio' name='Per_id' id='Pac_id' value='"+i+"' onclick=\"javascript:Estado(document.forms['form1'])\" />");
                                        out.print("&nbsp;&nbsp;");    
                                        out.print(i);
                                        out.print("</div>");
                                        out.print("<div class=\"col-md-6\">");  
                                        out.print("Persona"+i);
                                        out.print("</div>");
                                        out.print("<div class=\"col-md-4\">"); 
                                        out.print("Lugar"+i);
                                        out.print("</div>");
                                        out.print("</label>");
                                        out.print("</td>");
                                        out.print("</tr>");
                                    }
                                %>
                            </tbody>
                        </table>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
