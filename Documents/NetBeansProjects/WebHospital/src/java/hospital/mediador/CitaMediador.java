
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.CitaDAO;
import hospital.interfaz.PatronInterface;

public class CitaMediador implements PatronInterface{

    public CitaMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        CitaDAO dao = new CitaDAO();
        lista = dao.listar(obj);    
        return lista;
        
    }  
    public ArrayList MedXEsplistar(Object obj){
        ArrayList lista = null;
        CitaDAO dao = new CitaDAO();
        lista = dao.MedXEsplistar(obj);    
        return lista;
        
    } 
    public String registrar(Object obj){
        String msj = "";
        CitaDAO dao = new CitaDAO();
        msj = dao.registrar(obj);
        return msj;
    }
     public ArrayList listarPagina(Object obj){
        ArrayList lista = null;
        CitaDAO dao = new CitaDAO();
        lista = dao.listarPagina(obj);      
        return lista;
    }
    public String editar(Object obj){
        String msj = "";
        CitaDAO dao = new CitaDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        CitaDAO dao = new CitaDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        CitaDAO dao = new CitaDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
}
