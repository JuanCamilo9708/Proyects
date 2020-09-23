
package hospital.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import hospital.conexion.Conexion;
import hospital.interfaz.PatronInterface;
import hospital.vo.tipo_enfermedadVO;

public class Tipo_EnfermedadDAO implements PatronInterface{
    private Conexion conexion;

    public Tipo_EnfermedadDAO() {
        try {
            this.conexion = new Conexion();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList listar(Object obj){
        tipo_enfermedadVO vo = (tipo_enfermedadVO)obj;;
        ArrayList lista = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql;
        int index = 1;
        try{
            sql = "select * "
                    + "from tipo_enfermedad "
                   // + "where tipo_enfermedad.tip_id = ? "
                    + "order by tipo_enfermedad.tip_nombre ";
            ps = conexion.getConexion().prepareStatement(sql);
            //ps.setString(index++, vo.getTip_id());
            rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                lista = new ArrayList();
                while(rs.next()){
                    vo = new tipo_enfermedadVO();
                    vo.setTip_id(rs.getString("tip_id"));
                    vo.setTip_nombre(rs.getString("tip_nombre"));
                    
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
