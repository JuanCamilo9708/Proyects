<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="modelo.ModeloRol"%>
<%@page import="general.ControladorGeneral"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HashMap datos = new HashMap();
    ModeloRol modelo = new ModeloRol();
    ControladorGeneral control = new ControladorGeneral(request, datos);
    String btnaccion = control.capturarComando();

    try {
        if (btnaccion == null || btnaccion.equalsIgnoreCase("Volver") || btnaccion.equalsIgnoreCase("listar")) {
            modelo.listarRol(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Crear")) {
            pageContext.forward("Pagina02.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Eliminar")) {
            control.capturarParametros();
            modelo.eliminarRol(datos);
            modelo.listarRol(datos);
            pageContext.forward("index.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Modificar")) {
            HashMap x;
            control.capturarParametros();
            modelo.listarActualizarRol(datos);
            x = (HashMap) datos.get("listarol");
            request.setAttribute("listarol", x);
            pageContext.forward("Pagina03.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Modificarrol")) {
            control.capturarParametros();
            modelo.modificarRol(datos);
            modelo.listarRol(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Crearrol")) {
            control.capturarParametros();
            modelo.insertarRol(datos);
            modelo.listarRol(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equals("Permisos")) {
            control.capturarParametros();
            modelo.desplegable_rolxfuncionalidad(datos);
            modelo.desplegable_rolxfuncionalidad_except(datos);
            request.setAttribute("datos", ((HashMap) datos.get("datos")));
            request.setAttribute("datos1", datos.get("datos1"));
            request.setAttribute("datos2", datos.get("datos2"));
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina04.jsp");
        }

        if (btnaccion.equals("Quitar")) {
            control.capturarParametros();
            modelo.eliminar_funcionalidad(datos);
            modelo.desplegable_rolxfuncionalidad(datos);
            modelo.desplegable_rolxfuncionalidad_except(datos);
            request.setAttribute("datos", ((HashMap) datos.get("datos")));
            request.setAttribute("datos1", datos.get("datos1"));
            request.setAttribute("datos2", datos.get("datos2"));
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina04.jsp");
        }

        if (btnaccion.equals("Asignar")) {
            control.capturarParametros();
            modelo.insertar_funcionalidad(datos);
            modelo.desplegable_rolxfuncionalidad(datos);
            modelo.desplegable_rolxfuncionalidad_except(datos);
            request.setAttribute("datos", ((HashMap) datos.get("datos")));
            request.setAttribute("datos1", datos.get("datos1"));
            request.setAttribute("datos2", datos.get("datos2"));
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina04.jsp");
        }

    } catch (Exception e) {
        out.print(e.getMessage());
    }
%>
