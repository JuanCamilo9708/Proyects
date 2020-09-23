package hospital.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hospital.conexion.Conexion;
import hospital.interfaz.PatronInterface;
import hospital.vo.diagnosticoVO;
import hospital.vo.enfermedadesVO;
import hospital.vo.tipo_enfermedadVO;

public class DiagnosticoDAO implements PatronInterface{
    Conexion conexion;

    public DiagnosticoDAO() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList listar(Object obj){
            diagnosticoVO vo = (diagnosticoVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
          sql = "select * from diagnostico, cita, enfermedades, tipo_enfermedad "
                  + "where cita.cit_id = diagnostico.cit_id "
                  + "and tipo_enfermedad.tip_id = enfermedades.tip_id "
                  + "and diagnostico.enfer_id = enfermedades.enfer_id "
                  + "and diagnostico.tip_id =  enfermedades.tip_id "
                  + "and diagnostico.cit_id = ? "; 
                  
            ps = this.conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, String.valueOf(vo.getCit_id()));
            
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new diagnosticoVO();
                    vo.setDiag_id(rs.getString("diag_id"));
                    vo.setDiag_nombre(rs.getString("diag_nombre"));
                    vo.getCit().setCit_id(rs.getString("cit_id"));
                    vo.getTip().setTip_nombre(rs.getString("tip_nombre"));
                    vo.getEnfer().setEnfer_nombre(rs.getString("enfer_nombre"));
                    
                   
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

    public String registrar(Object obj){
        String msj = "";
        diagnosticoVO vo = (diagnosticoVO) obj;
        PreparedStatement ps;
        int rs;
        String sql;
        int index =1;
        
        try{
            
            sql = "insert into diagnostico  "
                    + "values (?,?,?,?,?) ";            
            ps = conexion.getConexion().prepareStatement(sql);            
            ps.setString(index++, vo.getDiag_id());
            ps.setString(index++, vo.getDiag_nombre());
            ps.setString(index++, vo.getCit_id());
            ps.setString(index++, vo.getEnfer_id());
             ps.setString(index++, vo.getTip_id());
            
//            ps.setString(index++, vo.getEnfer_id());
                       
            rs = ps.executeUpdate();
            
            if(rs>0) msj = "Diagnostico registrado";

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
        diagnosticoVO vo = (diagnosticoVO) obj;
        PreparedStatement ps;
        int rs;
        String sql;
        int index =1;
        
        try{
            
            sql = "update diagnostico set "
                    + "diag_id = ?, "
                    + "diag_nombre = ?, "
                    + "cit_id = ?, "
                    + "enfer_id = ?, "
                    + "tip_id = ?"                
                    + "where diag_id = ? ";            
            ps = conexion.getConexion().prepareStatement(sql);  
            ps.setString(index++, vo.getDiag_id());
            ps.setString(index++, vo.getDiag_nombre());
            ps.setString(index++, vo.getBuscar());
            ps.setString(index++, vo.getEnfer_id());
            ps.setString(index++, vo.getTip_id());
            ps.setString(index++, vo.getBuscar1());
           
            
            rs = ps.executeUpdate();
            
            if(rs>0) msj = "Diagnostico Actualizado";

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
        diagnosticoVO vo = (diagnosticoVO) obj;
        PreparedStatement ps;
        int rs;
        String sql;
        int index =1;
        
        try{
            sql = "delete from diagnostico "
                    + "where diag_id = ? ";
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, vo.getDiag_id());
            
            rs = ps.executeUpdate();

            if(rs>0) msj = "Diagnostico eliminado";
            
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
      diagnosticoVO vo = (diagnosticoVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
          sql = "select * from diagnostico "
                  + "where diag_id = ?"; 
            
           
            ps = this.conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, String.valueOf(vo.getDiag_id()));
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new diagnosticoVO();
                    vo.setDiag_id(rs.getString("diag_id"));
                    vo.setDiag_nombre(rs.getString("diag_nombre"));
                    vo.setTip_id(rs.getString("tip_id"));
                    vo.setEnfer_id(rs.getString("enfer_id"));
//                    vo.getCit().setCit_id(rs.getString("cit_id"));
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
    public ArrayList EnferXTipListar(Object obj){
            diagnosticoVO vo = (diagnosticoVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
              sql = "select enfer.tip_id,dia.tip_nombre,enfer.enfer_id,enfer.enfer_nombre " +
              "from " +
              "( " +
              "select enfermedades.tip_id, enfermedades.enfer_id,enfermedades.enfer_nombre " +
              "from enfermedades, tipo_enfermedad " +
              "where enfermedades.tip_id = tipo_enfermedad.tip_id " +
              ") as enfer right join " +
              "( " +
              "select tipo_enfermedad.tip_id,tipo_enfermedad.tip_nombre " +
              "from diagnostico, enfermedades, tipo_enfermedad " +
              "where diagnostico.enfer_id = enfermedades.enfer_id " +
              "and diagnostico.tip_id = enfermedades.tip_id " +
              "and enfermedades.tip_id = tipo_enfermedad.tip_id " +
              "and diagnostico.diag_id = ? " +
              ")as dia " +
              "on enfer.tip_id = dia.tip_id";
                    
            ps = this.conexion.getConexion().prepareStatement(sql); 
            ps.setString(index++, vo.getDiag_id());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                enfermedadesVO vo1;
                while(rs.next()){
                    vo1 = new enfermedadesVO();
                    vo1.setEnfer_id(rs.getString("enfer_id"));
                    vo1.setTip_id(rs.getString("tip_id"));
                    vo1.setEnfer_nombre(rs.getString("enfer_nombre"));
                    
                    
                    lista.add(vo1);
                }
            }
            rs.close();
            ps.close();
            conexion.getConexion().close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(lista+"---");
        return lista;
    }
}
