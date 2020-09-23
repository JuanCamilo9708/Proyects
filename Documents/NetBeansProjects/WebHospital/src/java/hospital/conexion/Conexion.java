
package hospital.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion;
    public Conexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        Class.forName("org.postgresql.Driver").newInstance();
        this.conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hospital", "postgres", "nedfortspead");        
        System.out.println("hola");    
    }

    public Connection getConexion() {
        return this.conexion;
    }
    
}
