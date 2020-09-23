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
                    <i class="glyphicon glyphicon-user"></i> Registrar Persona
                </div>                         
                <div class="panel-body">
                <div class="buscar">
                    <div class="col-sm-12">
                        <input type="submit" class="btn btn-primary input-sm" name="botonPersonaNuevo" value="Registrar" />         
                        <input type="submit" class="btn btn-primary input-sm" name="botonPersonaNuevo" value="Volver" />         
                    </div>                          
                </div>
                <div class="nuevo">    
                    <form name="frmNuevo" id="frm1" action="" method="GET">
                        <div class="row form-group">                          
                            <label for="Per_id" class="col-sm-2 control-label">ID</label>
                            <div class="col-sm-8">
                                <input type="text" name="Per_id" id="Per_id" value="" size="20" maxlength="20" class="form-control input-sm" />
                            </div>
                        </div>
                        <div class="row form-group"> 
                            <label for="Tid_id" class="col-sm-2 control-label">Tipo de documento</label>
                            <div class="col-sm-8">
            <select name="Tid_id" id="Tid_id" class="form-control input-sm">            
            <%

            %>
            </select>
                            </div>
                        </div>
            <div class="row form-group"> 
                <label for="Per_nombre" class="col-sm-2 control-label">Nombre</label>
                <div class="col-sm-8">
            <input type="text" name="Per_nombre" id="Per_nombre" value="" size="50" maxlength="100" class="form-control input-sm"/>
                </div>
            </div>
            <div class="row form-group"> 
                <label for="Per_apellido" class="col-sm-2 control-label">Apellido</label>
                <div class="col-sm-8">
            <input type="text" name="Per_apellido" id="Per_apellido"value="" size="50" maxlength="100" class="form-control input-sm"/>
                </div>
            </div>
            <div class="row form-group"> 
                <label for="Per_telefono" class="col-sm-2 control-label">Tel&eacute;fono</label>
                <div class="col-sm-8">
            <input type="text" name="Per_telefono" id="Per_telefono" value="" size="50" maxlength="50" class="form-control input-sm"/>
                </div>
            </div>
            <div class="row form-group"> 
                <label for="Per_email" class="col-sm-2 control-label">Correo electr&oacute;nico</label>
                <div class="col-sm-8">
            <input type="text" name="Per_email" id="Per_email" value="" size="50" maxlength="100" class="form-control input-sm"/>            
                </div>
            </div>
            <div class="row form-group"> 
                <label for="Gen_id" class="col-sm-2 control-label">Genero</label>
                <div class="col-sm-8">
            <select name="Gen_id" id="Gen_id" class="form-control input-sm">            
            <%
            %>
            </select>
                </div>
            </div>
            <div class="row form-group"> 
                <label for="Per_direccion" class="col-sm-2 control-label">Direcci&oacute;n</label>
                <div class="col-sm-8">
            <input type="text" name="Per_direccion" id="Per_direccion"  value="" size="50" maxlength="100" class="form-control input-sm"/>            
                </div>
            </div>
            <div class="row form-group"> 
                <label for="Dep_id" class="col-sm-2 control-label">Departamento</label>
                <div class="col-sm-8">
            <input type="text" name="Dep_id" id="Dep_id" value="" size="50" maxlength="100" class="form-control input-sm"/>            
                </div>
            </div>
            <div class="row form-group"> 
                <label for="Mun_id" class="col-sm-2 control-label">Municipio</label>
                <div class="col-sm-8">
            <input type="text" name="Mun_id" id="Mun_id" value="" size="50" maxlength="100" class="form-control input-sm"/>            
                </div>
            </div>          
                    </form>    
                </div>
                </div>
            </div>
        </div>
    </body>
</html>
