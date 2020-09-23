package modelo;

import db.Conexion;
import general.ModeloGeneral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase se encarga de administrar todos lo metodos que corresponden a la
 * funcionalidad ModuloxFuncionalidad
 *
 * @author Camilo Méndez, Adrian Sanchez, Erick Vasquez
 */
public class ModeloModFun extends general.ModeloGeneral {

    Conexion con;

    public ModeloModFun() {
        try {
            con = new Conexion();
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
     * Este metodo hace una busqueda en la base de datos para listar los Modulos
     * existentes en la Base de datos
     *
     * @param datos son los datos que trae del request para ser validado.
     *
     */
    public void listarModulo(HashMap datos) {
        listar("datos", "mo.mod_id,mo.mod_nombre,mo.mod_descripcion", "public.modulo as mo", "", datos);
    }

    
    /**
     * Este metodo inserta en la tabla modulo los campos mod_nombre y
     * mod_descripcion en la base de datos.
     *
     * @param datos son los datos que trae del request para ser validado.
     *
     */
    public void crearModulo(HashMap datos) {
        insertar("modulo", "mod_nombre,mod_descripcion", datos);
    }

    
    /**
     * Este metodo lista el modulo consultado para posteriormente ser
     * modificado.
     *
     * @param datos son los datos que trae del request para ser validado.
     *
     */
    public void consultarActualizarModulo(HashMap datos) {
        listarActualizarForm("modulos", "mod_id,mod_nombre,mod_descripcion", "mod_id,mod_nombre,mod_descripcion", "m.mod_id,m.mod_nombre,m.mod_descripcion", "modulo as m ", "", datos);
    }

    
    /**
     * Este metodo llama a la funcion actualizar para modificar dichos campos.
     *
     * @param datos son los datos(mod_id,mod_nombre,mod_descripcion,mod_id) que
     * trae del request para ser validado.
     *
     */
    public void modificarModulo(HashMap datos) {
        actualizar("modulo", "mod_id,mod_nombre,mod_descripcion,mod_id", datos);
    }

    
    /**
     * Este metodo elimina el modulo selecionado en el radioButton.
     *
     * @param datos son los datos del modulo (mod_id) que trae del request para
     * ser validado.
     *
     */
    public void eliminarModulo(HashMap datos) {
        eliminar("modulo", "mod_id", datos);
    }

    
    /**
     * Este metodo inserta una funcionalidad al modulo selecionado por medio del
     * RadioButton.
     *
     * @param datos son los datos(fun_nombre,fun_ruta,fun_descripcion,mod_id)
     * que trae del request para ser validado.
     *
     */
    public void insertarFuncionalidad(HashMap datos) {
        insertar("funcionalidad", "fun_nombre,fun_ruta,fun_descripcion,mod_id", datos);
    }

    
    /**
     * Este metodo elimina la funcionalidad adscrita al modulo selecionado por
     * medio del RadioButton.
     *
     * @param datos son los datos(fun_id) que trae del request para ser
     * validado.
     *
     */
    public void eliminarFuncionalidad(HashMap datos) {
        eliminar("funcionalidad", "fun_id", datos);
    }
    

    /**
     * Este metodo lista el modulo consultado para posteriormente ser
     * modificado.
     *
     * @param datos son los datos que trae del request para ser validado.
     *
     */
    public void consultarActualizarFuncionalidad(HashMap datos) {
        listarActualizarForm("funcionalidad", "fun_id,fun_nombre,fun_ruta,fun_descripcion",
                "fun_id,fun_nombre,fun_ruta,fun_descripcion", "f.fun_id,f.fun_nombre,f.fun_ruta,f.fun_descripcion",
                "funcionalidad as f", "", datos);
    }

    
    /**
     * Este metodo llama a la funcion actualizar para modificar dichos campos de
     * la funcionalidad del modulo.
     *
     * @param datos son los
     * datos(fun_id,fun_nombre,fun_ruta,fun_descripcion,fun_id) que trae del
     * request para ser validado.
     *
     */
    public void modificarFuncionalidad(HashMap datos) {
        actualizar("funcionalidad", "fun_id,fun_nombre,fun_ruta,fun_descripcion,fun_id", datos);
    }

    
    /**
     * Este metodo hace una busqueda en la base de datos para listar las
     * funcionalidades existentes del modulo correspondiente de la Base de datos
     *
     * @param datos son los
     * datos(fu.mod_id,fu.fun_id,fu.fun_nombre,fu.fun_ruta,fu.fun_descripcion)
     * que trae del request para ser validado.
     *
     */
    public void listarFuncionalidad(HashMap datos) {
        listar("funcionalidad", "fu.mod_id,fu.fun_id,fu.fun_nombre,fu.fun_ruta,fu.fun_descripcion", "funcionalidad as fu,modulo as mo", "fu.mod_id=mo.mod_id", datos);
    }

}
