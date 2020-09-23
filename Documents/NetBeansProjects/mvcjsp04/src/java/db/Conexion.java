package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Se encarga de generar la conexion con la base de datos Postgres
 */
public class Conexion {
    private String host;
    private String port;
    private String user;
    private String password;
    private String db;
    private String puente;
    private String driver;
    private Connection conexion;

    public Conexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
     this.host="localhost";
     this.port="5432";
     this.user="postgres";
     this.password="camilo";
     this.db="efi";
     this.puente="postgresql";
     this.driver="org.postgresql.Driver";
     this.setConexion();
}
    private void setConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
         Class.forName(driver).newInstance();
         this.conexion=DriverManager.getConnection("jdbc:"+this.puente+"://"+this.host+":"+this.port+"/"+this.db, this.user, this.password);
         
    }
    public Connection getConexion(){
        return this.conexion;
    }
    
    public ResultSet consultarSql(String strSql) {
        try {
            ResultSet rsrta;
            rsrta= conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(strSql);
            return rsrta;
        } catch (SQLException ex) {
            return null;
        }
    }
    public int ejecutarSql(String strSql) throws SQLException{
        
        return conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate(strSql);
        
    } 
    public void cerrar() throws SQLException{
        this.conexion.close();
    }
}
