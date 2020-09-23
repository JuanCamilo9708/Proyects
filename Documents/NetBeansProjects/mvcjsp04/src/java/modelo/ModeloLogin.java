package modelo;

import db.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import general.ModeloGeneral;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de administrar todos lo metodos que corresponden a la
 * funcionalidad Login
 *
 * @author Camilo Méndez, Adrian Sanchez, Erick Vasquez
 */
public class ModeloLogin extends general.ModeloGeneral {

    Conexion con;

    public ModeloLogin() {
        try {

            con = new Conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloRol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este método se encarga de validar los usuarios cuando inician sesión, el
     * cual recibe tres parámetros, el primero hace referencia al nombre de la
     * tabla, la cual es la tabla donde esta los usuarios registrados del
     * sistema, la segunda entrada es de campos, el cual hace referencia al
     * usuario y clave de las personas, el tercer hace referencia a los datos
     * que trae y envía del request para ser validado.
     *
     * @param datos son los datos que trae del request para ser validado.
     * @return un boolean, si es true el usuario es valido y un false el
     * usuario. no es valido
     */
    public boolean verificarUsuario(HashMap datos) {
        if (verificar("usuario", "usu_clave,per_id", datos)) {
            return true;
        }
        return false;
    }

    
    /**
     * Este metodo hace una busqueda en la base de datos para buscar el usuario
     * ingresado
     *
     * @param datos son los datos que trae del request para ser validado.
     *
     */
    public void buscarUsuario(HashMap datos) {
        buscar("listarRoles", "ro.rol_id,ro.rol_nombre",
                "usuario as usu, rol as ro, usuarioxrol as usr",
                "usu.per_id=usr.per_id and ro.rol_id=usr.rol_id",
                "usu_usuario", datos);
    }

    
    /**
     * Este metodo hace la busqueda de las funcionalidades que estan asociadas a
     * dicho rol
     *
     * @param x son los datos que trae del request para ser buscado.
     *
     */
    public void desplegable_rolxfuncionalidad(HashMap x) {
        HashMap temp;
        try {
            ResultSet rs;
            String sql = "select * from rolxfuncionalidad as rf, funcionalidad as ro "
                    + "where ro.fun_id=rf.fun_id and rf.rol_id='" + x.get("rol_id") + "' ";

            rs = this.con.consultarSql(sql);
            ArrayList<HashMap> listaroles = new ArrayList<HashMap>();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    temp = new HashMap();
                    temp.put("fun_id", rs.getString("fun_id"));
                    temp.put("fun_nombre", rs.getString("fun_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos1", listaroles);
        } catch (SQLException e) {
        }
    }
}
