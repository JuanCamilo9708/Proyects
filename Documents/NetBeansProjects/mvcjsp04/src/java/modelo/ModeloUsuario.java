package modelo;

import db.Conexion;
import general.ModeloGeneral;
import general.VistaGeneral;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * Esta clase se encarga de administrar todos lo metodos que corresponden a la
 * funcionalidad Usuario
 *
 * @author Camilo Méndez, Adrian Sanchez, Erick Vasquez
 *
 */
public class ModeloUsuario extends ModeloGeneral {

    public ModeloUsuario() {

    }

    /**
     * Este metodo inserta los datos
     * per_id,per_nombre,per_apellido,per_fecha_nacimiento,per_direccion,per_correo
     * en la tabla persona de la base de datos.
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     * y usuario que se desea insertar
     */
    public void insertarPersona(HashMap x) {
        insertar("persona", "per_id,per_nombre,per_apellido,per_fecha_nacimiento,per_direccion,per_correo", x);
    }

    
    /**
     * Este metodo inserta los datos per_id,usu_clave,usu_login en la tabla
     * usuario de la base de datos.
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     * y usuario que se desea insertar
     */
    public void insertarUsuario(HashMap x) {
        insertar("usuario", "per_id,usu_clave,usu_login", x);
    }

    
    /**
     * Este metodo elimina el usuario y la persona de la llave foranea
     * selecionada por medio del RadioButton
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     * y usuario que se desea insertar
     */
    public void eliminarUsuario(HashMap x) {
        eliminar("usuario", "per_id", x);
        eliminar("persona", "per_id", x);
    }

    
    /**
     * Este metodo llama a la funcion actualizar para modificar dichos campos de
     * Persona por medio del RadioButton
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     * y usuario que se desea insertar
     */
    public void actualizarPersona(HashMap x) throws ParseException {
        actualizar("persona", "per_id,per_nombre,per_apellido,per_fecha_nacimiento,per_direccion,per_correo", x);
    }

    
    /**
     * Este metodo llama a la funcion actualizar para modificar dichos campos de
     * Usuario por medio del RadioButton
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     * y usuario que se desea insertar
     */
    public void actualizarUsuario(HashMap x) {
        actualizar("usuario", "per_id,usu_clave,usu_login", x);
    }

    
    /**
     * Este metodo elimina el Permiso de el usuario selecionado por medio del
     * RadioButton
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla permiso
     * relacionada con las tablas persona y usuario
     */
    public void eliminarPermiso(HashMap x) {
        eliminar("usuarioxrol", "per_id,rol_id", x);
    }

    
    /**
     * Este metodo inserta el Permiso de el usuario selecionado por medio del
     * RadioButton
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla permiso
     * relacionada con las tablas persona y usuario
     */
    public void insertarPermiso(HashMap x) {
        insertar("usuarioxrol", "per_id,rol_id", x);
    }

    
    /**
     * Este metodo lista los usuarios que estan en la base da datos
     *
     * @param x HashMap que contendra cada uno de los campos de las tablas
     * persona
     *
     */
    public void listarUsuario(HashMap x) {
        listar("datos", "p.per_id,p.per_nombre", "usuario as u, persona as p", "u.per_id=p.per_id", x);
    }

    
    /**
     * Este metodo lista el rol consultado para posteriormente ser modificado.
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     * y usuario que se desea insertar
     */
    public void listarActulizarForm(HashMap x) {
        listarActualizarForm("valores", "id,nombre,apellido,fecha_nacimiento,direccion,correo,clave,usuario", "per_id,per_nombre,per_apellido,per_fecha_nacimiento,per_direccion,per_correo,usu_clave,usu_login", "per.per_id,per.per_nombre,per.per_apellido,per.per_per_fecha_nacimiento,per.per_direccion,per.per_correo,usu.usu_clave,usu.per_id", "usuario as usu,persona as per", "usu.per_id=per.per_id", x);
    }

    
    /**
     * Este metodo lista las funcionalidades del rol selecionado.
     *
     * @param x HashMap que contendra cada uno de los campos de la tabla persona
     */
    public void listaPersonaPermisos(HashMap x) {
        listarActualizarForm("datos", "id,nombre,usuario",
                "per_id,per_nombre,per_id",
                "per.per_id,per.per_nombre,usu.per_id",
                "usuario as usu,persona as per", "usu.per_id=per.per_id", x);
    }

    
    /**
     * Este metodo inserta al HashMap de entrada las funcionalidades que tiene
     * el rol seleccionado
     *
     * @param x son los datos (per_id,rol_id) que trae del request para ser
     * validado.
     *
     */
    public void desplegableUsuRol(HashMap x) {
        HashMap temp;
        try {
            ResultSet rs;
            String sql = "select * from usuarioxrol as ur, rol as ro "
                    + "where ro.rol_id=ur.rol_id and ur.per_id='" + x.get("per_id") + "' ";
            rs = super.conexion.consultarSql(sql);
            ArrayList<HashMap> listaroles = new ArrayList<HashMap>();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    temp = new HashMap();
                    temp.put("id", rs.getString("rol_id"));
                    temp.put("nombre", rs.getString("rol_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos1", listaroles);
        } catch (SQLException e) {
        }
    }

    
    /**
     * Este metodo inserta al HashMap de entrada las funcionalidades que NO
     * tiene el rol seleccionado
     *
     * @param x son los datos (per_id,rol_id) que trae del request para ser
     * validado.
     *
     */
    public void desplegableUsuRolExcept(HashMap x) {

        HashMap temp;
        try {
            ResultSet rs;
            String sql = "select ro.rol_id,ro.rol_nombre from rol as ro "
                    + "except "
                    + "select ro.rol_id,ro.rol_nombre from usuarioxrol as ur, rol as ro "
                    + "where ro.rol_id=ur.rol_id and ur.per_id='" + x.get("per_id") + "' ";
            rs = super.conexion.consultarSql(sql);
            ArrayList<HashMap> listaroles = new ArrayList<HashMap>();

            if (rs.isBeforeFirst())
            {
                while (rs.next()) {
                    temp = new HashMap();
                    temp.put("id", rs.getString("rol_id"));
                    temp.put("nombre", rs.getString("rol_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos2", listaroles);
        } catch (SQLException e) {
        }
    }

    
    /**
     * Este metodo buscar el caracter ingresado en la caja de texto y lo busca
     * si coincide con el id o el nombre de los usuarios en la base de datos
     *
     * @param x son los datos (per_id,per_nombre) que trae del request para ser
     * validado.
     *
     */
    public void buscar(HashMap x) {
        HashMap temp;
        try {
            ResultSet rs;
            String sql = ("select p.per_id,p.per_nombre from usuario as u, persona as p where u.per_id=p.per_id "
                    + "and ((u.per_id) like '%" + x.get("buscar") + "%' or lower(p.per_nombre) like lower('%" + x.get("buscar") + "%')) ");
            rs = super.conexion.consultarSql(sql);
            ArrayList<HashMap> listaroles = new ArrayList<HashMap>();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    temp = new HashMap();
                    temp.put("per_id", rs.getString("per_id"));
                    temp.put("per_nombre", rs.getString("per_nombre"));
                    listaroles.add(temp);
                }
            }
            x.put("datos2", listaroles);

        } catch (SQLException e) {
        }
    }
}
