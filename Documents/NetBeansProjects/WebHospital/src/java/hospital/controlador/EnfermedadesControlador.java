
package hospital.controlador;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hospital.mediador.EnfermedadesMediador;
import hospital.utilidad.ValueObject;
import hospital.vo.enfermedadesVO;

public class EnfermedadesControlador {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private enfermedadesVO vo;
    private EnfermedadesMediador mediador;
    private String msj;
    private ArrayList lista;

    public EnfermedadesControlador(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.vo = new enfermedadesVO();
        this.mediador = new EnfermedadesMediador();
        this.msj = "";
        this.lista = null;    
    }
    public void registrar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.msj = this.mediador.registrar(this.vo);
    }
    public void listar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.lista = this.mediador.listar(this.vo);
    }
   
    
    public void editar(){
        
    }
    public void borrar(){
        
    }
    public void buscar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.lista = this.mediador.buscar(this.vo);}

    public String getMsj() {
        return msj;
    }

    public ArrayList getLista() {
        return lista;
    }
    
}
