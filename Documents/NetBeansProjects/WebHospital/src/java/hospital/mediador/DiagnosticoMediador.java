
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.DiagnosticoDAO;
import hospital.interfaz.PatronInterface;

public class DiagnosticoMediador implements PatronInterface{

    public DiagnosticoMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        DiagnosticoDAO dao = new DiagnosticoDAO();
        lista = dao.listar(obj);    
        return lista;
        
    }    
    public String registrar(Object obj){
        String msj = "";
        DiagnosticoDAO dao = new DiagnosticoDAO();
        msj = dao.registrar(obj);
        return msj;
    }
    public ArrayList EnferXTipListar(Object obj){
        ArrayList lista = null;
        DiagnosticoDAO dao = new DiagnosticoDAO();
        lista = dao.EnferXTipListar(obj);    
        return lista;
        
    } 
    public String editar(Object obj){
        String msj = "";
        DiagnosticoDAO dao = new DiagnosticoDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        DiagnosticoDAO dao = new DiagnosticoDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        DiagnosticoDAO dao = new DiagnosticoDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
}
