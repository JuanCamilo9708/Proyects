
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.Tipo_EnfermedadDAO;
import hospital.interfaz.PatronInterface;

public class Tipo_EnfermedadMediador implements PatronInterface{

    public Tipo_EnfermedadMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        Tipo_EnfermedadDAO dao = new Tipo_EnfermedadDAO();
        lista = dao.listar(obj);      
        return lista;
    }    
    public String registrar(Object obj){
        String msj = "";
        Tipo_EnfermedadDAO dao = new Tipo_EnfermedadDAO();
        msj = dao.registrar(obj);
        return msj;
    }
    public String editar(Object obj){
        String msj = "";
        Tipo_EnfermedadDAO dao = new Tipo_EnfermedadDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        Tipo_EnfermedadDAO dao = new Tipo_EnfermedadDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        Tipo_EnfermedadDAO dao = new Tipo_EnfermedadDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
}
