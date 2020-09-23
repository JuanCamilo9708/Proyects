package hospital.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hospital.conexion.Conexion;
import hospital.interfaz.PatronInterface;
import hospital.vo.MedxEspVO;

public class MedxEspDAO implements PatronInterface{
    Conexion conexion;

    public MedxEspDAO() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList listar(Object obj){
            MedxEspVO vo = (MedxEspVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            sql = "select * "
                    + "from medxesp, especialidad, medico "
                    + "where medxesp.esp_id = especialidad.esp_id "
                    + "and medxesp.med_id = medico.med_id and especialidad.esp_id=? ";
                    
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, vo.getEsp_id());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new MedxEspVO();
                    vo.getEsp().setEsp_id(rs.getString("esp_id"));
                    vo.getMed().setMed_id(rs.getString("med_id"));
                    vo.getMed().setMed_nombre(rs.getString("med_nombre"));
                    vo.getMed().setMed_apellido(rs.getString("med_apellido"));
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
    public String registrar(Object obj){
        return null;
    }
    public String editar(Object obj){
        return null;
    }
    public String borrar(Object obj){
        return null;
    }
    public ArrayList buscar(Object obj){
        return null;
    }
}   