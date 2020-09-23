package hospital.interfaz;

import java.util.ArrayList;

public interface PatronInterface {
    public ArrayList listar(Object obj);    
    public String registrar(Object obj);
    public String editar(Object obj);
    public String borrar(Object obj);
    public ArrayList buscar(Object obj);    
}
