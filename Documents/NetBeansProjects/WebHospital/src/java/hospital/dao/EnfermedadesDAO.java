package hospital.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hospital.conexion.Conexion;
import hospital.interfaz.PatronInterface;
import hospital.vo.enfermedadesVO;
import hospital.vo.tipo_enfermedadVO;

public class EnfermedadesDAO implements PatronInterface{
    Conexion conexion;

    public EnfermedadesDAO() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList listar(Object obj){
            enfermedadesVO vo = (enfermedadesVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            sql = "select * "
                    + "from enfermedades "
                    + "where tip_id = ? "
                    + "order by enfermedades.enfer_nombre ";
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, vo.getTip_id());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new enfermedadesVO();
                    vo.setEnfer_id(rs.getString("enfer_id"));
                    vo.setEnfer_nombre(rs.getString("enfer_nombre"));
                    vo.setTip_id(rs.getString("tip_id"));
                    lista.add(vo);
                }
            }
            rs.close();
            ps.close();
            conexion.getConexion().close();
        }catch(Exception ex){
            System.out.print(ex.getMessage());
        }
        return lista;
    }
    public ArrayList buscar(Object obj){
      enfermedadesVO vo = (enfermedadesVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            
          sql = "select * from enfermedades "
                  + "where tip_id = ?"; 
            
           
            ps = this.conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, String.valueOf(vo.getTip_id()));
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new enfermedadesVO();
                    vo.setTip_id(rs.getString("tip_id"));
                    vo.getTip().setTip_nombre(rs.getString("tip_nombre"));
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
    public String registrar(Object obj){
        return null;
    }
    public String editar(Object obj){
        return null;
    }
    public String borrar(Object obj){
        return null;
    }
    
}   