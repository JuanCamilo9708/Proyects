
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.EnfermedadesDAO;
import hospital.interfaz.PatronInterface;

public class EnfermedadesMediador implements PatronInterface{

    public EnfermedadesMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        EnfermedadesDAO dao = new EnfermedadesDAO();
        lista = dao.listar(obj);      
        return lista;
    }    
    public String registrar(Object obj){
        String msj = "";
        EnfermedadesDAO dao = new EnfermedadesDAO();
        msj = dao.registrar(obj);
        return msj;
    }
    public String editar(Object obj){
        String msj = "";
        EnfermedadesDAO dao = new EnfermedadesDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        EnfermedadesDAO dao = new EnfermedadesDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        EnfermedadesDAO dao = new EnfermedadesDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
     

}