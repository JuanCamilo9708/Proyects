
package hospital.controlador;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hospital.mediador.CitaMediador;
import hospital.utilidad.ValueObject;
import hospital.vo.CitaVO;

public class CitaControlador {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private CitaVO vo;
    private CitaMediador mediador;
    private String msj;
    private ArrayList lista;

    public CitaControlador(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.vo = new CitaVO();
        this.mediador = new CitaMediador();
        this.msj = "";
        this.lista = null;  
        this.vo.setCit_rxp(3);
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
    public void MedXEsplistar(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.lista = this.mediador.MedXEsplistar(this.vo);
        
    }
       public void listarPagina(){
        ValueObject parametro = new ValueObject();
        parametro.setValueObject(this.request, this.vo);
        this.lista = this.mediador.listarPagina(this.vo);
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
        return this.vo.getCit_rxp();
    } 
}
