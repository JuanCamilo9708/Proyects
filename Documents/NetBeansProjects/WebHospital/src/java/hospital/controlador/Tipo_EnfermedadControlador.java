
package hospital.controlador;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hospital.mediador.Tipo_EnfermedadMediador;
import hospital.utilidad.ValueObject;
import hospital.vo.tipo_enfermedadVO;

public class Tipo_EnfermedadControlador {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private tipo_enfermedadVO vo;
    private Tipo_EnfermedadMediador mediador;
    private String msj;
    private ArrayList lista;

    public Tipo_EnfermedadControlador(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.vo = new tipo_enfermedadVO();
        this.mediador = new Tipo_EnfermedadMediador();
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
        
    }

    public String getMsj() {
        return msj;
    }

    public ArrayList getLista() {
        return lista;
    }
    
}
