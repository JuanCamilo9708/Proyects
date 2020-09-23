
package hospital.controlador;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hospital.mediador.DiagnosticoMediador;
import hospital.utilidad.ValueObject;
import hospital.vo.diagnosticoVO;

public class DiagnosticoControlador {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private diagnosticoVO vo;
    private DiagnosticoMediador mediador;
    private String msj;
    private ArrayList lista;

    public DiagnosticoControlador(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.vo = new diagnosticoVO();
        this.mediador = new DiagnosticoMediador();
        this.msj = "";
        this.lista = null;  
        this.vo.setDiag_rxp(3);
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
     public void EnferXTipListar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.lista = this.mediador.EnferXTipListar(this.vo);
        
    }
    public void editar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.msj = this.mediador.editar(this.vo); 
    }
    public void borrar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.msj = this.mediador.borrar(this.vo);        
    }
    public void buscar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.lista = this.mediador.buscar(this.vo); 
    }

    public String getMsj() {
        return msj;
    }

    public ArrayList getLista() {
        return lista;
    }
    public int getRxp() {
        return this.vo.getDiag_rxp();
    } 
}
