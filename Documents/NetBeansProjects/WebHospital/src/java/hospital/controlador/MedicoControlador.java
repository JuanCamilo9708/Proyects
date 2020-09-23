
package hospital.controlador;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hospital.mediador.MedicoMediador;
import hospital.utilidad.ValueObject;
import hospital.vo.MedicoVO;

public class MedicoControlador {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private MedicoVO vo;
    private MedicoMediador mediador;
    private String msj;
    private ArrayList lista;

    public MedicoControlador(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.vo = new MedicoVO();
        this.mediador = new MedicoMediador();
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
