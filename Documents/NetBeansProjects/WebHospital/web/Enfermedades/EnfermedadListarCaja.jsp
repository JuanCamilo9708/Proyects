<%@page import="hospital.html.EnfermedadesCajaSeleccion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hospital.controlador.EnfermedadesControlador"%>
<select name="enfer_id" id="enfer_id" class="form-control input-sm">
<%
EnfermedadesControlador con2 = new EnfermedadesControlador(request, response);

con2.listar();

ArrayList lista2 = con2.getLista();

if(lista2!=null){
out.print(EnfermedadesCajaSeleccion.lista(lista2, "null"));
}
%>
</select>