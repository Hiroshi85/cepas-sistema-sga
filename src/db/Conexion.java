
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author benja
 */
public class Conexion {
    
    private static Conexion instancia;
    
    public static Conexion getInstancia(){
        if(instancia == null)
            instancia = new Conexion();
        return instancia;
    }
    
    private Conexion(){
    }
    
    public Connection miConexion(){
        
        Connection cn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error no se puede cargar el driver: "+e.getMessage(), "ERROR CONNECTION",0);
        }
        
        try{
            String url = "jdbc:mysql://localhost:3306/BDPROYECTO?useSSL=false";
            String user = "root";
            String password = "root";
            cn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error no se puede establecer la conexion: "+e.getMessage(), "ERROR CONNECTION",0);
        }
        
        return cn;
    }
    
}
