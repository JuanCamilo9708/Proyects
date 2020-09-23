
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.EspecialidadDAO;
import hospital.interfaz.PatronInterface;

public class EspecialidadMediador implements PatronInterface{

    public EspecialidadMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        EspecialidadDAO dao = new EspecialidadDAO();
        lista = dao.listar(obj);      
        return lista;
    }    
    public String registrar(Object obj){
        String msj = "";
        EspecialidadDAO dao = new EspecialidadDAO();
        msj = dao.registrar(obj);
        return msj;
    }
    public String editar(Object obj){
        String msj = "";
        EspecialidadDAO dao = new EspecialidadDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        EspecialidadDAO dao = new EspecialidadDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        EspecialidadDAO dao = new EspecialidadDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
}
