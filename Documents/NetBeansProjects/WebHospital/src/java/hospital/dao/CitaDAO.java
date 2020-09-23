package hospital.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hospital.conexion.Conexion;
import hospital.interfaz.PatronInterface;
import hospital.vo.CitaVO;
import hospital.vo.MedxEspVO;


public class CitaDAO implements PatronInterface{
    Conexion conexion;

    public CitaDAO() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList listar(Object obj){
            CitaVO vo = (CitaVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
          sql = "select * from cita, paciente, medxesp, medico, especialidad "
                    +"where cita.pac_id = paciente.pac_id "
                    +"and cita.med_id = medxesp.med_id "
                    +"and cita.esp_id = medxesp.esp_id "
                    +"and medxesp.med_id = medico.med_id "
                    +"and medxesp.esp_id = especialidad.esp_id "
                    + "and "
                    + "( "
                    + "lower(cita.cit_id) like '%' || trim(lower(?)) || '%' or "
                    + "lower(paciente.pac_nombre) like '%' || trim(lower(?)) || '%' or "
                    + "lower(paciente.pac_apellido) like '%' || trim(lower(?)) || '%' or "
                    + "lower(medico.med_nombre) like '%' || trim(lower(?)) || '%' or "
                    + "lower(medico.med_apellido) like '%' || trim(lower(?)) || '%' )"
                    + "order by cita.cit_id ";
            
           
            ps = this.conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new CitaVO();
                    vo.setCit_id(rs.getString("cit_id"));
//                    vo.setCit_fecha_generada(rs.getDate("cit_fecha_generada"));
//                    vo.setCit_fecha_asistencia(rs.getDate("cit_fecha_asistencia"));
                    vo.setCit_costo(rs.getInt("cit_costo"));
                    vo.getPac().setPac_nombre(rs.getString("pac_nombre"));
                    vo.getPac().setPac_apellido(rs.getString("pac_apellido"));
                    vo.getMxe().getMed().setMed_nombre(rs.getString("med_nombre"));
                    vo.getMxe().getMed().setMed_apellido(rs.getString("med_apellido"));
                    vo.getMxe().getEsp().setEsp_nombre(rs.getString("esp_nombre"));
                    lista.add(vo);
                }
            }
            rs.close();
            ps.close();
            conexion.getConexion().close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    public ArrayList MedXEsplistar(Object obj){
            CitaVO vo = (CitaVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
          sql = "select medico.med_id, medico.med_nombre,medico.med_apellido, espe.esp_id "   +               
                    "from " +
                    "(select  medico.med_id, medico.med_nombre,med_apellido, medxesp.esp_id " +
                    "from medxesp, medico " +
                    "where medxesp.med_id = medico.med_id " +
                    ") as medico right join( " +
                    "select especialidad.esp_id, especialidad.esp_nombre " +
                    "from cita, especialidad, medxesp, medico " +
                    "where cita.esp_id = medxesp.esp_id and medxesp.esp_id = especialidad.esp_id " +
                    "and cita.med_id = medxesp.med_id and medxesp.med_id = medico.med_id  " +
                    "and cita.cit_id = ? ) as espe " +
                    "on medico.esp_id = espe.esp_id ";
                    
            ps = this.conexion.getConexion().prepareStatement(sql); 
            ps.setString(index++, vo.getCit_id());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                MedxEspVO vo1;
                
                while(rs.next()){
                    vo1 = new MedxEspVO();
                    vo1.setEsp_id(rs.getString("esp_id"));
                    vo1.setMed_id(rs.getString("med_id"));
                    vo1.getMed().setMed_nombre(rs.getString("med_nombre"));
                    vo1.getMed().setMed_id(rs.getString("med_id"));
                    vo1.getMed().setMed_apellido(rs.getString("med_apellido"));
                    
                    lista.add(vo1);
                }
            }
            rs.close();
            ps.close();
            conexion.getConexion().close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        return lista;
    }
    public String registrar(Object obj){
        String msj = "";
        CitaVO vo = (CitaVO) obj;
        PreparedStatement ps;
        int rs;
        String sql;
        int index =1;
        
        try{
            
            sql = "insert into cita "
                    + "values (?,?,?,?,?,?,?) ";            
            ps = conexion.getConexion().prepareStatement(sql);            
            ps.setString(index++, vo.getCit_id());
            ps.setDate(index++, vo.getCit_fecha_generada());
            ps.setDate(index++, vo.getCit_fecha_asistencia());
            ps.setInt(index++, vo.getCit_costo());
            ps.setString(index++, vo.getPac_id());
            ps.setString(index++, vo.getMed_id());
            ps.setString(index++, vo.getEsp_id());
            
            rs = ps.executeUpdate();
            
            if(rs>0) msj = "Cita registrada";

            ps.close();
            conexion.getConexion().close();
        }catch(SQLException ex){
            msj = ex.getMessage();
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }        
        return msj;

    }
    public String editar(Object obj){
        String msj = "";
        CitaVO vo = (CitaVO) obj;
        PreparedStatement ps;
        int rs;
        String sql;
        int index =1;
        
        try{
            
            sql = "update cita set "
                    + "cit_id = ?, "
                    + "cit_fecha_generada = ?, "
                    + "cit_fecha_asistencia = ?, "
                    + "cit_costo = ?, "
                    + "pac_id = ?, "
                    + "med_id = ?, "
                    + "esp_id = ? "
                    + "where cit_id = ? ";            
            ps = conexion.getConexion().prepareStatement(sql);  
            ps.setString(index++, vo.getCit_id());
            ps.setDate(index++, vo.getCit_fecha_generada());
            ps.setDate(index++, vo.getCit_fecha_asistencia());
            ps.setInt(index++, vo.getCit_costo());
            ps.setString(index++, vo.getPac_id());
            ps.setString(index++, vo.getMed_id());
            ps.setString(index++, vo.getEsp_id());
            ps.setString(index++, vo.getBuscar());
            
            rs = ps.executeUpdate();
            
            if(rs>0) msj = "Cita Actualizada";

            ps.close();
            conexion.getConexion().close();
        }catch(SQLException ex){
            msj = ex.getMessage();
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }        
        return msj;

    }
    public String borrar(Object obj){
        String msj = "";
        CitaVO vo = (CitaVO) obj;
        PreparedStatement ps;
        int rs;
        String sql;
        int index =1;
        
        try{
            sql = "delete from cita "
                    + "where cit_id = ? ";
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, vo.getCit_id());
            
            rs = ps.executeUpdate();

            if(rs>0) msj = "Cita eliminada";
            else msj = "La cita no existe";

            ps.close();
            conexion.getConexion().close();
        }catch(SQLException ex){
            msj = ex.getMessage();
        }
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }        
        return msj;
    }
    public ArrayList buscar(Object obj){
        CitaVO vo = (CitaVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
          sql = "select * from cita, paciente, medxesp, medico, especialidad "
                    +"where cita.pac_id = paciente.pac_id "
                    +"and cita.med_id = medxesp.med_id "
                    +"and cita.esp_id = medxesp.esp_id "
                    +"and medxesp.med_id = medico.med_id "
                    +"and medxesp.esp_id = especialidad.esp_id "
                    + "and cita.cit_id  = ? "
                    + "order by cita.cit_id ";
            
            ps = this.conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, String.valueOf(vo.getCit_id()));System.out.println("lllll"+vo.getCit_id());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new CitaVO();
                    vo.setCit_id(rs.getString("cit_id"));
                    vo.setCit_fecha_generada(rs.getDate("cit_fecha_generada"));
                    vo.setCit_fecha_asistencia(rs.getDate("cit_fecha_asistencia"));
                    vo.setCit_costo(rs.getInt("cit_costo"));
                    vo.setEsp_id(rs.getString("esp_id"));
                    vo.getPac().setPac_id(rs.getString("pac_id"));
                    vo.getPac().setPac_nombre(rs.getString("pac_nombre"));
                    vo.getPac().setPac_apellido(rs.getString("pac_apellido"));
                    vo.getMxe().getMed().setMed_nombre(rs.getString("med_nombre"));
                    vo.getMxe().getMed().setMed_apellido(rs.getString("med_apellido"));
                    vo.getMxe().getEsp().setEsp_nombre(rs.getString("esp_nombre"));
                    vo.setMed_id(rs.getString("med_id"));
                    lista.add(vo);
                }
            }
            rs.close();
            ps.close();
            conexion.getConexion().close();
           
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    public ArrayList listarPagina(Object obj){
            CitaVO vo = (CitaVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
          sql = "select * from cita, paciente, medxesp, medico, especialidad "
                    +"where cita.pac_id = paciente.pac_id "
                    +"and cita.med_id = medxesp.med_id "
                    +"and cita.esp_id = medxesp.esp_id "
                    +"and medxesp.med_id = medico.med_id "
                    +"and medxesp.esp_id = especialidad.esp_id "
                    + "and "
                    + "( "
                    + "lower(cita.cit_id) like '%' || trim(lower(?)) || '%' or "
                    + "lower(paciente.pac_nombre) like '%' || trim(lower(?)) || '%' or "
                    + "lower(paciente.pac_apellido) like '%' || trim(lower(?)) || '%' or "
                    + "lower(medico.med_nombre) like '%' || trim(lower(?)) || '%' or "
                    + "lower(medico.med_apellido) like '%' || trim(lower(?)) || '%' )"
                    + "order by cita.cit_id"
                    + " limit ? offset ?*? ";
            
           
            ps = this.conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setString(index++, String.valueOf(vo.getBuscar()));
            ps.setInt(index++, vo.getCit_rxp());
            ps.setInt(index++, vo.getCit_pagina());
            ps.setInt(index++, vo.getCit_rxp());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new CitaVO();
                    vo.setCit_id(rs.getString("cit_id"));
//                    vo.setCit_fecha_generada(rs.getDate("cit_fecha_generada"));
//                    vo.setCit_fecha_asistencia(rs.getDate("cit_fecha_asistencia"));
                    vo.setCit_costo(rs.getInt("cit_costo"));
                    vo.getPac().setPac_nombre(rs.getString("pac_nombre"));
                    vo.getPac().setPac_apellido(rs.getString("pac_apellido"));
                    vo.getMxe().getMed().setMed_nombre(rs.getString("med_nombre"));
                    vo.getMxe().getMed().setMed_apellido(rs.getString("med_apellido"));
                    vo.getMxe().getEsp().setEsp_nombre(rs.getString("esp_nombre"));
                    lista.add(vo);
                }
            }
            rs.close();
            ps.close();
            conexion.getConexion().close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return lista;
    }
}
