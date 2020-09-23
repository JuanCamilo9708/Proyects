package hospital.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import hospital.conexion.Conexion;
import hospital.interfaz.PatronInterface;
import hospital.vo.MedicoVO;

public class MedicoDAO implements PatronInterface{
    Conexion conexion;

    public MedicoDAO() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public ArrayList listar(Object obj){
            MedicoVO vo = (MedicoVO) obj;
            String sql;
            PreparedStatement ps;
            ResultSet rs;
            int index = 1;
            ArrayList lista = null;        
        try{
            sql = "select * "
                    + "from medico "
                    + "where medico.med_id=? "
                    + "order by medico.med_nombre ";
            ps = conexion.getConexion().prepareStatement(sql);
            ps.setString(index++, vo.getMed_id());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new MedicoVO();
                    vo.setMed_id(rs.getString("med_id"));
                    vo.setMed_nombre(rs.getString("med_nombre"));
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