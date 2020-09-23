<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.ModeloModFun"%>
<%@page import="general.ControladorGeneral"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HashMap datos = new HashMap();
    ControladorGeneral control = new ControladorGeneral(request, datos);
    String btnaccion = control.capturarComando();
    ModeloModFun modelo = new ModeloModFun();

    try {
        if (btnaccion == null || btnaccion.equalsIgnoreCase("Volver") || btnaccion.equalsIgnoreCase("listar")) {
            modelo.listarModulo(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Crear modulo")) {
            pageContext.forward("Pagina02.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Enviar")) {
            control.capturarParametros();
            modelo.crearModulo(datos);
            modelo.listarModulo(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Modificar modulo")) {
            control.capturarParametros();
            modelo.consultarActualizarModulo(datos);
            HashMap x = (HashMap) datos.get("modulos");
            request.setAttribute("modulos", x);
            pageContext.forward("Pagina03.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Guardar")) {
            control.capturarParametros();
            modelo.modificarModulo(datos);
            modelo.listarModulo(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Eliminar modulo")) {
            control.capturarParametros();
            modelo.eliminarModulo(datos);
            modelo.listarModulo(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Funcionalidades")) {
            control.capturarParametros();
            modelo.listarFuncionalidad(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina04.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Crear funcionalidad")) {
            control.capturarParametros();
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina05.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Agregar")) {
            control.capturarParametros();
            modelo.insertarFuncionalidad(datos);
            request.setAttribute("datos", datos);
            modelo.listarFuncionalidad(datos);
            pageContext.forward("Pagina04.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Modificar funcionalidad")) {
            control.capturarParametros();
            modelo.consultarActualizarFuncionalidad(datos);
            HashMap x = (HashMap) datos.get("funcionalidad");
            x.put("mod_id", datos.get("fun_id"));
            request.setAttribute("funcionalidad", x);
            pageContext.forward("Pagina06.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Modificar")) {
            control.capturarParametros();
            modelo.modificarFuncionalidad(datos);
            modelo.listarFuncionalidad(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina04.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Eliminar funcionalidad")) {
            control.capturarParametros();
            modelo.eliminarFuncionalidad(datos);
            modelo.listarFuncionalidad(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina04.jsp");
        }

    } catch (Exception e) {
        out.print(e.getMessage());
    }

%>
