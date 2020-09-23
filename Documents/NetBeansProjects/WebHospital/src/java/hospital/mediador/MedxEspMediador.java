
package hospital.mediador;

import java.util.ArrayList;
import hospital.dao.MedxEspDAO;
import hospital.interfaz.PatronInterface;

public class MedxEspMediador implements PatronInterface{

    public MedxEspMediador() {
    }
    public ArrayList listar(Object obj){
        ArrayList lista = null;
        MedxEspDAO dao = new MedxEspDAO();
        lista = dao.listar(obj);    
        return lista;
        
    }    
    public String registrar(Object obj){
        String msj = "";
        MedxEspDAO dao = new MedxEspDAO();
        msj = dao.registrar(obj);
        return msj;
    }
    public String editar(Object obj){
        String msj = "";
        MedxEspDAO dao = new MedxEspDAO();
        msj = dao.editar(obj);
        return msj;       
    }
    public String borrar(Object obj){
        String msj = "";
        MedxEspDAO dao = new MedxEspDAO();
        msj = dao.borrar(obj);
        return msj;   
    }
    public ArrayList buscar(Object obj){
        ArrayList lista = null;
        MedxEspDAO dao = new MedxEspDAO();
        lista = dao.buscar(obj);      
        return lista;        
    }   
}
