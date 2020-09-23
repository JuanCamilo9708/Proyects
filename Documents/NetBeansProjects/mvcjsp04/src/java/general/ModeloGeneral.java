package general;

import db.Conexion;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ModeloModFun;

/**
 * Esta clase contiene todos los metodos generales que van a ser usados por los
 * modelos
 *
 * @author Camilo Méndez, Adrian Sanchez, Erick Vasquez
 */
public class ModeloGeneral {
/**
 * 
 * El constructor de la clase ModeloGeneral se manejan las excepciones del atributo conexion que a su vez viene de la clase
 * conexion.
 * 
 */
    protected Conexion conexion;

    public ModeloGeneral() {
        try {
            conexion = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloModFun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que busca en la base de datos capturados en los campos de usuario
     * y contraseña por el login y deja acceder al usuario si retorna true, en
     * caso contrario muestra mensaje de error.
     *
     * @param nombretabla {String} Es una cadena que representa el nombre de la tabla dada que
     * se desea buscar la Informacion.
     * en este caso busca en la tabla usuario
     * @param campos {String} Es una cadena que va separado por comas(,) que busca sobre los campos usu_clave y per_id
     * @param datos HashMap con los datos que se capturaron. Su estructura es esta: {btnaccion=, usu_clave=, per_id=}
     * @return Si se encuentra la informacion se devuelve True y si no es así
     * devuelve False
     */
    public boolean verificar(String nombretabla, String campos, HashMap datos) {
        try {            
            String[] campo = campos.split(",");
            String strsql = "select * "
                    + "from " + nombretabla
                    + " where ";

            for (int i = 0; i < campo.length; i++) {
                strsql = strsql + campo[i] + " = '" + datos.get(datos.keySet().toArray()[i + 1]) + "'";
                if (i < campo.length - 1) {
                    strsql = strsql + " and ";
                }
            }
            ResultSet rs;
            rs = conexion.consultarSql(strsql);
            if (rs.isBeforeFirst()) {
                return true;
            }
            rs.close();
        } catch (SQLException ex) {
        }
        return false;
    }

    /**
     * Método que inserta en la base de datos segun la tabla especificada con
     * los campos asignados previamente
     *
     * @param tabla String con el Nombre de la tabla a la que se le insertarán los datos
     * @param campos String es una cadena con el nombre de los campos que se van a insertar en la tabla especificada, van }
     *              separados por comas
     * @param datos HashMap con los datos que se van a insertar junto el nombre de los campos de dicha tabla. {btnaccion= , camposainsertar=}
     * 
     */
    public void insertar(String tabla, String campos, HashMap datos) {
        try {
            String[] campos_separados = campos.split(",");
            StringBuilder sql = new StringBuilder();
            sql.append("insert into ").append(tabla).append("(").append(campos).append(") values (");
            for (int i = 0; i < campos_separados.length; i++) {
                sql.append("'").append(datos.get(campos_separados[i])).append("'");

                if (i != (campos_separados.length - 1)) {
                    sql.append(",");
                }
            }
            sql.append(")");
            int rs;
            rs = this.conexion.ejecutarSql(sql.toString());
            if (rs > 0) {
                datos.put("mensaje", "Registrado");
            } else {
                datos.put("mensaje", "No registrado");
            }

        } catch (SQLException ex) {
        }
    }

    /**
     * Método que lista la informacion segun la tabla especificada
     *
     * @param nombreLista String con el Nombre que identifica al metodo listar
     * @param select String que contiene una cadena de los campos consultados que se van a mostrar y estan separados comas
     * @param from String del nombre de la tabla a consultar
     * @param union String con las relaciones entre tablas a consultar
     * @param datos Informacion que contiene el nombre del modulo y la informacion del modulo(mod_nombre, mod_descripcion). Su 
     *              estructura es: {btnaccion=, mod_nombre=, mod_descripcion=}
     * listar
     */
    public void listar(String nombreLista, String select, String from, String union, HashMap datos) {         
        StringBuilder sql = new StringBuilder();
        try {
            String sc[] = select.split(",");
            String selec = select.replace(".", ",");
            String c[] = selec.split(",");
            if (union.equals("")) {
                sql.append("select ").append(select).append(" from ").append(from);

            } else {
                sql.append("select ").append(select).append(" from ").append(from).append(" where ");
            }

            if (!union.isEmpty()) {
                sql.append(union);
            }
            ResultSet rs;
            rs = this.conexion.consultarSql(sql.toString());
            ArrayList<HashMap> listaDatos = new ArrayList<HashMap>();
            HashMap r;
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    r = new HashMap();
                    for (int i = 0; i < c.length; i++) {
                        if (i % 2 != 0) {
                            r.put(c[i], rs.getString(c[i]));
                        }
                    }
                    listaDatos.add(r);
                }
            }
            datos.put(nombreLista, listaDatos);
            rs.close();
        } catch (Exception e) {
        }

    }

    /**
     * Método que lista la informacion que se va a actualizar.
     *
     * @param nombreLista String con el nombre que identifica al metodo listarActualizarForm
     * @param camposT String con los nombres de las variables donde se van a almacenar los datos, estan separados por comas
     * @param camposDB String con los nombres de los campos donde se van a almacenar los datos en dicha Base de datos, van separados por comas
     * @param select String con los campos que se seleccionan en la consulta separados por comas
     * @param from String con el nombre de la tabla a consultar
     * @param union String con la relación de las tablas
     * @param datos HashMap con la llave primaria de la tabla a actualizar, su estructura es: {PK=, btnaccion=Modificar}
     */
    public void listarActualizarForm(String nombreLista, String camposT, String camposDB, String select, String from, String union, HashMap datos) {
        StringBuilder sql = new StringBuilder();
        try {
            String selec = select.replace(".", ",");
            String[] campos_separados = selec.split(",");
            String[] nombre_separados = camposT.split(",");
            String[] nombre_separadosDB = camposDB.split(",");
            String c[] = union.split("=");
            if (union.equals("")) {

                sql.append("select *").append(" from ").append(from).append(" where ").append(nombre_separadosDB[0]).append(" = ").append("'").append(datos.get(campos_separados[1])).append("'");

            } else {
                sql.append("select *").append(" from ").append(from).append(" where ");
            }
            if (!union.isEmpty()) {

                sql.append(union).append(" and ").append(c[1]).append(" = ").append("'").append(datos.get(campos_separados[1])).append("'");

            }

            ResultSet rs;
            rs = this.conexion.consultarSql(sql.toString());
            HashMap r = new HashMap();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    r = new HashMap();
                    for (int i = 0; i < nombre_separados.length; i++) {
                        r.put(nombre_separados[i], rs.getString(nombre_separadosDB[i]));

                    }

                }
            }

            datos.put(nombreLista, r);
            rs.close();
        } catch (Exception e) {
        }

    }

    /**
     * Método que elimina un registro de una tabla especificada
     *
     * @param tabla String con el nombre de la tabla a la que se le eliminará el registro
     * @param campos String con el campo de la llave primaria de la tabla que se va a eliminar
     * @param datos HashMap con la llave primaria de la tabla a eliminar el registro, su estructura es: {PK=, btnaccion=Eliminar, mensaje=Eliminado}
     */
    public void eliminar(String tabla, String campos, HashMap datos) {

        try {
            String[] campos_separados = campos.split(",");
            StringBuilder sql = new StringBuilder();
            sql.append("delete from ").append(tabla).append(" where ");
            for (int i = 0; i < campos_separados.length; i++) {
                sql.append(campos_separados[i]).append("=");
                sql.append("'").append(datos.get(campos_separados[i])).append("'");
                if (i != (campos_separados.length - 1)) {
                    sql.append(" and ");
                }
            }
            sql.append("");
            int rs;
            rs = this.conexion.ejecutarSql(sql.toString());
            if (rs > 0) {
                datos.put("mensaje", "Eliminado");
            } else {
                datos.put("mensaje", "No Eliminado");
            }
            

        } catch (SQLException ex) {
        }
    }

    /**
     * Método que actualiza la informacion en la base de datos según la tabla
     * especificada
     *
     * @param tabla String con el nombre de la tabla a la cual se le realizarán los cambios
     * @param campos String con los campos que contienen la informacion a actualizar, informacion separada por comas
     * @param datos HashMap con los Campos provenientes del formulario a actualizar y sus atributos
     */
    public void actualizar(String tabla, String campos, HashMap datos) {

        try {
            String[] campos_separados = campos.split(",");
            StringBuilder sql = new StringBuilder();
            sql.append("update ").append(tabla).append(" set ");
            for (int i = 1; i < campos_separados.length; i++) {
                sql.append(campos_separados[i]).append("=");
                sql.append("'").append(datos.get(campos_separados[i])).append("'");
                if (i != (campos_separados.length - 1)) {
                    sql.append(",");
                }
            }
            sql.append(" where ").append(campos_separados[0]).append("=").append("'").append(datos.get(campos_separados[0])).append("'");

            int rs;
            rs = this.conexion.ejecutarSql(sql.toString());
        } catch (SQLException ex) {
        }
    }

    /**
     * Metodo que busca y almacena la información del usuario accedido
     *
     * @param nombreLista String que identifica al método
     * @param select String separado por comas de los campos de la tabla que se van a imprimir
     * @param from String con el Nombre de la tabla a buscar
     * @param union String de la Relación entre tablas
     * @param campo String con el campo a buscar
     * @param datos HashMap que contiene la informacion del usuario requerido.Su estrutura es esta: {btnaccion=, camposrequeridos}
     */
    public void buscar(String nombreLista, String select, String from, String union, String campo, HashMap datos) {

        StringBuilder sql = new StringBuilder();
        try {

            String campos[] = campo.split(",");

            String selec = select.replace(".", ",");
            String c[] = selec.split(",");
            String cadena_a = campo.substring(4, 10);
            sql.append("select ").append(select).append(" from ").append(from).append(" where ");

            if (!union.isEmpty()) {
                sql.append(union).append(" and ");
            }

            for (int i = 0; i < campos.length; i++) {
                sql.append(campos[i]).append(" = '").append(datos.get(cadena_a)).append("'");

                if (i < campos.length - 1) {
                    sql.append(" and ");
                }
            }
            
            ResultSet rs;
            rs = this.conexion.consultarSql(sql.toString());
            ArrayList<HashMap> listaDatos = new ArrayList<HashMap>();
            HashMap r;
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    r = new HashMap();
                    for (int i = 0; i < c.length; i++) {
                        if (i % 2 != 0) {
                            r.put(c[i], rs.getString(c[i]));
                        }
                    }
                    listaDatos.add(r);
                }
            }
            datos.put(nombreLista, listaDatos);
            rs.close();
        } catch (Exception e) {
        }
    }
}
