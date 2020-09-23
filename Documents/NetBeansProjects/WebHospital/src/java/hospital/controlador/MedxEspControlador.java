
package hospital.controlador;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hospital.mediador.MedxEspMediador;
import hospital.utilidad.ValueObject;
import hospital.vo.MedxEspVO;

public class MedxEspControlador {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private MedxEspVO vo;
    private MedxEspMediador mediador;
    private String msj;
    private ArrayList lista;

    public MedxEspControlador(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.vo = new  MedxEspVO();
        this.mediador = new MedxEspMediador();
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
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.msj = this.mediador.borrar(this.vo);        
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
