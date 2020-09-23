
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.PacienteDAO;
import hospital.interfaz.PatronInterface;

public class PacienteMediador implements PatronInterface{

    public PacienteMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        PacienteDAO dao = new PacienteDAO();
        lista = dao.listar(obj);    
        return lista;
        
    }    
    public String registrar(Object obj){
        String msj = "";
        PacienteDAO dao = new PacienteDAO();
        msj = dao.registrar(obj);
        return msj;
    }
    public String editar(Object obj){
        String msj = "";
        PacienteDAO dao = new PacienteDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        PacienteDAO dao = new PacienteDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        PacienteDAO dao = new PacienteDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
}
