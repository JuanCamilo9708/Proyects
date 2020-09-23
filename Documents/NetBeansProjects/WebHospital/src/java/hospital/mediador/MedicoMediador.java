
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.MedicoDAO;
import hospital.interfaz.PatronInterface;

public class MedicoMediador implements PatronInterface{

    public MedicoMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        MedicoDAO dao = new MedicoDAO();
        lista = dao.listar(obj);    
        return lista;
        
    }    
    public String registrar(Object obj){
        String msj = "";
        MedicoDAO dao = new MedicoDAO();
        msj = dao.registrar(obj);
        return msj;
    }
    public String editar(Object obj){
        String msj = "";
        MedicoDAO dao = new MedicoDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        MedicoDAO dao = new MedicoDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        MedicoDAO dao = new MedicoDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
}
