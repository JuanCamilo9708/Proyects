package modelo;

import db.Conexion;
import general.ModeloGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Esta clase se encarga de administrar todos lo metodos que corresponden a la
 * funcionalidad ROL
 *
 * @author Camilo Méndez, Adrian Sanchez, Erick Vasquez
 */
public class ModeloRol extends ModeloGeneral {

    Conexion con;

    public ModeloRol() {
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
     * Este metodo lista los roles consultado en la base de datos.
     *
     * @param x son los datos (ro.rol_id,ro.rol_nombre,ro.rol_descripcion) que
     * trae del request para ser validado.
     *
     */
    public void listarRol(HashMap x) {
        listar("datos", "ro.rol_id,ro.rol_nombre,ro.rol_descripcion", "public.rol as ro", "", x);
    }

    
    /**
     * Este metodo elimina el rol selecionado por medio del RadioButton.
     *
     * @param datos son los datos (rol_id) que trae del request para ser validado.
     *
     */
    public void eliminarRol(HashMap datos) {
        eliminar("rol", "rol_id", datos);
    }

    
    /**
     * Este metodo inserta a la base de datos los campos nombre y descripcion
     * del Rol.
     *
     * @param datos son los datos (rol_nombre,rol_descripcion) que trae del request
     * para ser validado.
     *
     */
    public void insertarRol(HashMap datos) {
        insertar("rol", "rol_nombre,rol_descripcion", datos);
    }

    
    /**
     * Este metodo lista el rol consultado para posteriormente ser modificado.
     *
     * @param datos son los datos (rol_nombre,rol_derol_nombrescripcion) que trae
     * del request para ser validado.
     *
     */
    public void listarActualizarRol(HashMap datos) {
        listarActualizarForm("listarol", "id,nombre,descripcion",
                "rol_id,rol_nombre,rol_descripcion", "r.rol_id",
                "rol ", "", datos);
    }

    
    /**
     * Este metodo llama a la funcion actualizar para modificar dichos campos.
     *
     * @param datos son los datos (rol_nombre,rol_descripcion) que trae del request
     * para ser validado.
     *
     */
    public void modificarRol(HashMap datos) {
        actualizar("public.rol", "rol_id,rol_nombre,rol_descripcion", datos);
    }

    
    /**
     * Este metodo inserta al HashMap de entrada las funcionalidades que tiene
     * el rol seleccionado
     *
     * @param x son los datos (fun_id,rol_id) que trae del request para ser
     * validado.
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
                    temp.put("id", rs.getString("fun_id"));
                    temp.put("nombre", rs.getString("fun_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos1", listaroles);
        } catch (SQLException e) {
        }
    }

    
    /**
     * Este metodo inserta al HashMap como datos2, de entrada las
     * funcionalidades que NO tiene el rol seleccionado
     *
     * @param x son los datos (fun_id,rol_id) que trae del request para ser
     * validado.
     *
     */
    public void desplegable_rolxfuncionalidad_except(HashMap x) {
        HashMap temp;
        try {
            ResultSet rs;
            String sql = "select ro.fun_id,ro.fun_nombre from funcionalidad as ro "
                    + "except "
                    + "select ro.fun_id,ro.fun_nombre from rolxfuncionalidad as ur, funcionalidad as ro "
                    + "where ro.fun_id=ur.fun_id and ur.rol_id='" + x.get("rol_id") + "' ";
            
            rs = this.con.consultarSql(sql);
            ArrayList<HashMap> listaroles = new ArrayList<HashMap>();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    temp = new HashMap();
                    temp.put("id", rs.getString("fun_id"));
                    temp.put("nombre", rs.getString("fun_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos2", listaroles);
        } catch (SQLException e) {
        }
    }

    
    /**
     * Este metodo elimina la funcionalidad selecionada expuesta en el comboBox
     * relacionado con el rol.
     *
     * @param x son los datos (fun_id,rol_id) que trae del request para ser
     * validado.
     *
     */
    public void eliminar_funcionalidad(HashMap x) {
        PreparedStatement ps;
        try {
            String sql = "delete from rolxfuncionalidad "
                    + "where rol_id=?::integer and fun_id=?::integer ";

            ps = this.con.getConexion().prepareStatement(sql);
            ps.setString(1, (String) x.get("rol_id"));
            ps.setString(2, (String) x.get("fun_id"));
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    
    /**
     * Este metodo inserta la funcionalidad selecionada expuesta en el comboBox,
     * relacionado con el rol.
     *
     * @param x son los datos (fun_id,rol_id) que trae del request para ser
     * validado.
     *
     */
    public void insertar_funcionalidad(HashMap x) {
        PreparedStatement ps;
        try {
            String sql = "insert into rolxfuncionalidad values (?::integer,?::integer) ";
            ps = this.con.getConexion().prepareStatement(sql);
            ps.setString(1, (String) x.get("rol_id"));
            ps.setString(2, (String) x.get("fun_id"));
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

}
