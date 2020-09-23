<%@page import="general.ControladorGeneral"%>
<%@page import="modelo.ModeloLogin"%>
<%@page import="java.util.HashMap"%>
<%
    HashMap datos = new HashMap();
    String btnaccion = request.getParameter("btnaccion");
    ModeloLogin modelo = new ModeloLogin();
    ControladorGeneral control = new ControladorGeneral(request, datos);
    try {
        if (btnaccion == null || btnaccion.isEmpty()) {
            pageContext.forward("Pagina01.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Acceder")) {
            control.capturarParametros();
            if (modelo.verificarUsuario(datos)) {
                session = request.getSession(true);
                session.getId();
                control.capturarParametros();
                modelo.buscar("listarRoles", "ro.rol_id,ro.rol_nombre", "usuario as usu, rol as ro, usuarioxrol as usr", "usu.per_id=usr.per_id and ro.rol_id=usr.rol_id", "usu.per_id", datos);
                request.setAttribute("datos", datos);
                pageContext.forward("Pagina02.jsp");
            } else {
                session.invalidate();
                datos.put("Error", "Usuario o clave incorrectos.!! Por favor,intente de nuevo.");
                request.setAttribute("datos", datos);
                pageContext.forward("Pagina01.jsp");
            }

        }

        if (btnaccion.equalsIgnoreCase("Cerrar sesion")) {
            session = request.getSession(false);
            if (session != null) {
                session.invalidate();
                request.setAttribute("datos", datos);
                pageContext.forward("Pagina01.jsp");
            }
        }

        if (btnaccion.equalsIgnoreCase("Funcionalidades")) {
            control.capturarParametros();
            modelo.desplegable_rolxfuncionalidad(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina03.jsp");
        }

        if (btnaccion.equalsIgnoreCase("Elegir Rol")) {
            control.capturarParametros();
            modelo.buscarUsuario(datos);
            request.setAttribute("datos", datos);
            pageContext.forward("Pagina02.jsp");
        }

    } catch (Exception e) {
        out.print(e.getMessage());
    }

%>
