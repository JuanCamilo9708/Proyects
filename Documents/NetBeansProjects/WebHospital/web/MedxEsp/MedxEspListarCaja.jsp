<%@page import="hospital.html.MedxEspCajaSeleccion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="hospital.controlador.MedxEspControlador"%>
<select name="med_id" id="med_id" class="form-control input-sm">
<%
    try{
        MedxEspControlador con2 = new MedxEspControlador(request, response);

        con2.listar();

        ArrayList lista2 = con2.getLista();

        if(lista2!=null){
        out.print(MedxEspCajaSeleccion.lista(lista2, "null"));
        }
    }catch(Exception ex){

                        }
%>
</select>