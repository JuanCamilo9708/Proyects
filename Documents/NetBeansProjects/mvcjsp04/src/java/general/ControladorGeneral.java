package general;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 * Esta clase se encarga de controlar todos los datos provenientes de los
 * index,formularios y de los modelos
 *
 * @author Camilo Méndez, Adrian Sanchez, Erick Vasquez
 */
public class ControladorGeneral {

    public HttpServletRequest request;
    public HashMap datos;

    /**
     * @param request Recibe btnaccion
     * @param datos Recibe un HashMap con los datos provenientes de los
     * modelos,intex o paginas
     */
    public ControladorGeneral(HttpServletRequest request, HashMap datos) {
        this.datos = datos;
        this.request = request;
    }

    /**
     * Método que se encarga de capturar los parámetros deseados y el nombre del
     * Btnaccion y ponerlos en el HashMap datos. Al capturar el parametro del Boton obtenemos esto: {btnaccion= nombredelboton, espaciocapturado=}
     */
    public void capturarParametros() {
        HashMap mapa = (HashMap) this.request.getParameterMap();
        for (Object nom_parametro : mapa.keySet()) {
            String nombre = (String) nom_parametro;
            String[] valor = (String[]) mapa.get(nombre);
            for (int i = 0; i < valor.length; i++) {
                this.datos.put(nombre, valor[i]);
            }
        }
        
        System.out.println("MCAPTURAR PARAMETROS "+datos);
    }

    /**
     * Método que captura el botón btnaccion y si viene con valor "null" llama
     * al método listar de ModeloGeneral
     *
     * @return Devuelve el valor de btnaccion convertido en minusculas y sin
     * espacios ni al principio ni al final
     */
    public String capturarComando() {
        String btnaccion = request.getParameter("btnaccion");
        if (btnaccion == null) {
            btnaccion = "listar";
        } else {
            btnaccion.trim().toLowerCase().trim();
        }
        System.out.println("CAPTURARCOMANDO "+btnaccion);
        return btnaccion;
    }

//    
    /**
     * Metodo que obtiene los datos de los formularios
     *
     * @return Devuelve un objeto HttpServletRequest con los datos
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * Metodo que asigna el request
     *
     * @param request Recibe btnaccion
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * Metodo que obtiene los datos del HashMap
     *
     * @return HashMap de Datos
     */
    public HashMap getDatos() {
        return datos;
    }

    /**
     * Metodo que asigna los datos en el HashMap
     *
     * @param datos HashMap de Datos
     */
    public void setDatos(HashMap datos) {
        this.datos = datos;
    }
}
