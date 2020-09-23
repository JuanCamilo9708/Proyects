package general;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta clase contiene todos los metodos de la vista general, que son los que generan el codigo para visualizar
 * los datos de las funcionalidades 
 *
 * @author Camilo Méndez, Adrian Sanchez, Erick Vasquez
 */


public class VistaGeneral {

    public VistaGeneral() {
    }
   // 
    /**
     * Método que genera un combobox recibiendo un ArrayList de hashmap con los datos, 
     * un string llamado recibe que tiene el valor que se quiere que lleve el value, 
     * el string muestra es el valor que se despliega dentro del los option, 
     * y nombre_select que es el nombre del desplegable.
     * 
     * @param datos array de HashMap que contiene la informacion necesaria del request
     * @param recibe es el campo de la base de datos que va a tener por valor los option en cada atributo value
     * @param muestra es el campo de la base de datos que va a mostrar cada uno de los option
     * @param nombre_select es el nombre del select que queremos generar
     * @return devuelve un String que contienen la instruccion completa html de un select con sus respectivos option
     * 
     */
    public StringBuilder generarComboBox(ArrayList<HashMap> datos,String recibe,String muestra,String nombre_select)
    {
        StringBuilder html=new StringBuilder("<select name=");
        html.append(nombre_select).append(" size=").append(datos.size()).append(">");
        for (int i = 0; i < datos.size(); i++) {
            html.append("<option value=").append(datos.get(i).get(recibe)).append(">").append(datos.get(i).get(muestra)).append("</option>");
        }
        html.append("</select>");
      
        return html;
    }
    
    /**
     * Metodo que genera una tabla con radioButton al listar los datos de la tabla consultada
     * 
     * @param y ArrayList(HashMap) arrayList de HashMap que contiene la informacion necesaria del request. Su estrutura es [{},{},{}] 
     *          donde se encontrará dentro de las llaves la informacion encontrada para listar.
     * @param cabecera_tipo es un String donde estan los campos de la tabla que queremos que se muestre 
     *                      junto al identificador de radiobutton, separados por comas(,) 
     * @return devulve un String que contienen la instruccion completa html para generar un radioButton de los 
     *         datos de dicha tabla .
     * 
     */
    public StringBuilder generarTablaRadio(ArrayList<HashMap> y,String cabecera_tipo)
    {
        String[] partsCabecera = cabecera_tipo.split(",");
        ArrayList<String> array_particionado = new ArrayList<>();
        StringBuilder html=new StringBuilder("<table><thead><tr>");
        for (int i = 0; i < partsCabecera.length; i++) {
            String[] aux=partsCabecera[i].split("-");
            for (int j = 0; j < aux.length; j++) {
                array_particionado.add(aux[j]);
                if(j==0)
                    html.append("<th>").append(aux[j]).append("</th>");               
            }
        }
        html.append("</tr></thead><tbody>");
        for (int i = 0; i < y.size(); i++) {
            html.append("<tr>");
            for (int j = 0; j < array_particionado.size(); j=j+2) {
               if(array_particionado.get(j+1).equalsIgnoreCase("defecto"))
                {
                    html.append("<td>").append(y.get(i).get(array_particionado.get(j))).append("</td>");
                }
                else if(array_particionado.get(j+1).equalsIgnoreCase("radio")) 
                {
                    html.append("<td>").append("<input type='radio' name=").
                        append(array_particionado.get(j)).append(" value=").
                        append(y.get(i).get(array_particionado.get(j+2))).append(" ></td>");
                    j=j+3;
                } 
            }
            html.append("</tr>");
        }
        html.append("</tbody></table>");
        return html;
    }
    
    
    
    /**
     * Metodo que genera una tabla con los datos a actualizar
     * 
     * @param y array de HashMap que contiene la informacion necesaria del request 
     * @param cabecera_tipo es un String donde estan los campos de la tabla que queremos que se muestre 
     *                      separados por comas(,) 
     * @return devulve un String que contienen la instruccion completa html para generar un formulario de los 
     *         datos a actualizar de dicha tabla .
     * 
     */
     public StringBuilder ListarActializarForm(ArrayList<HashMap> y,String cabecera_tipo)
    {
        String[] partsCabecera = cabecera_tipo.split(",");
        ArrayList<String> array_particionado = new ArrayList<>();
        StringBuilder html=new StringBuilder("<table><thead><tr>");
        for (int i = 0; i < partsCabecera.length; i++) {
            String[] aux=partsCabecera[i].split("-");
            for (int j = 0; j < aux.length; j++) {
                array_particionado.add(aux[j]);
                if(j==0)
                    html.append("<th>").append(aux[j]).append("</th>");               
            }
        }
        html.append("</tr></thead><tbody>");
        for (int i = 0; i < y.size(); i++) {
            html.append("<tr>");
            for (int j = 0; j < array_particionado.size(); j=j+2) {
               if(array_particionado.get(j+1).equalsIgnoreCase("defecto"))
                {
                    html.append("<td>").append(y.get(i).get(array_particionado.get(j))).append("</td>");
                }
                else if(array_particionado.get(j+1).equalsIgnoreCase("radio")) 
                {
                    html.append("<td>").append("<input type='radio' name=").
                        append(array_particionado.get(j)).append(" value=").
                        append(y.get(i).get(array_particionado.get(j+2))).append(" ></td>");
                    j=j+3;
                } 
            }
            html.append("</tr>");
        }
        html.append("</tbody></table>");
        return html;
    }
    
}
