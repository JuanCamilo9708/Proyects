package hospital.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hospital.conexion.Conexion;
import hospital.interfaz.PatronInterface;
import hospital.vo.PacienteVO;

public class PacienteDAO implements PatronInterface{
    Conexion conexion;

    public PacienteDAO() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList listar(Object obj){
            PacienteVO vo = (PacienteVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            sql = "select * "
                    + "from paciente ";
            ps = conexion.getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new PacienteVO();
                    vo.setPac_id(rs.getString("pac_id"));
                    vo.setPac_nombre(rs.getString("pac_nombre"));
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