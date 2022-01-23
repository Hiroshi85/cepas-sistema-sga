
package datos;

import db.Conexion;
import entidad.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author benja
 */
public class SecretariaDAO {
    
    private Connection cnn = null;
    private ResultSet rs = null;
    
    private static SecretariaDAO instancia;
    
    public static SecretariaDAO getInstancia(){
        if(instancia == null)
            instancia = new SecretariaDAO();
        return instancia;
    }
    
    public void insertar(String dni, String password, String nombre, String apellido_p, String apellido_m, String sexo, int edad, String telefono, String fecha_nacimiento, String oficio) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            
        try{
            ps = cnn.prepareCall("call insertar_Secretaria(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, dni);
            ps.setString(7, password);
            ps.setString(2, nombre);
            ps.setString(3, apellido_p);
            ps.setString(4, apellido_m);
            ps.setString(5, sexo);
            ps.setInt(6, edad);
            ps.setString(8, telefono);
            ps.setString(9, fecha_nacimiento);
            ps.setString(10, oficio);
            ps.executeUpdate();      
            
            // INSERT EN TABLA USUARIO 
            UsuarioDAO.getInstancia().insertar(dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fecha_nacimiento);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 404", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
    
    }
    
    public Secretaria buscarSecretaria(String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Secretaria secretaria = null;
        try{
            ps = cnn.prepareCall("call consultar_Secretaria(?)");
            ps.setString(1, dni);
            rs = ps.executeQuery();   
            if(rs.next()){
                String dni2 = rs.getString("dni");
                String password = rs.getString("p_word");
                String nombre = rs.getString("nombre");
                String apellido_p = rs.getString("ap_p");
                String apellido_m = rs.getString("ap_m");
                String sexo = rs.getString("sexo");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("f_nacimiento");
                String oficio = rs.getString("oficio");
                secretaria = new Secretaria(dni2, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento, oficio);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 505", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return secretaria;
    }
    
    
    public void actualizar(String dni, String nombre, String apellido_p, String apellido_m, String sexo, int edad, String telefono, String fecha_nacimiento, String oficio) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            
        try{
            ps = cnn.prepareCall("call actualizar_Secretaria(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido_p);
            ps.setString(4, apellido_m);
            ps.setString(5, sexo);
            ps.setInt(6, edad);
            ps.setString(7, telefono);
            ps.setString(8, fecha_nacimiento);
            ps.setString(9, oficio);
            ps.executeUpdate();      
            
            // UPDATE EN TABLA USUARIO TMBN
            UsuarioDAO.getInstancia().actualizar(dni, nombre, apellido_p, apellido_m, sexo, edad, telefono, fecha_nacimiento);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 606", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void actualizarPass(String dni, String passw) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            
        try{
            ps = cnn.prepareCall("call actualizar_passw_Secretaria(?,?)");
            ps.setString(1, passw);
            ps.setString(2, dni);
            
            UsuarioDAO.getInstancia().actualizarPass(dni, passw);
            ps.executeUpdate();      
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 606", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    
    public void eliminar(String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try{
            ps = cnn.prepareCall("call eliminar_Secretaria(?)");
            ps.setString(1, dni);
            ps.executeUpdate();
            
            // DELETE EN TABLA USUARIO TMBN
            UsuarioDAO.getInstancia().eliminar(dni);
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 707", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    
    public ArrayList <Secretaria> mostrarSecretarias() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Secretaria> lista = new ArrayList<>();
        try{
            ps = cnn.prepareCall("call mostrar_Secretarias()");
            rs = ps.executeQuery();   
            while(rs.next()){
                String dni = rs.getString("dni");
                String password = rs.getString("p_word");
                String nombre = rs.getString("nombre");
                String apellido_p = rs.getString("ap_p");
                String apellido_m = rs.getString("ap_m");
                String sexo = rs.getString("sexo");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("f_nacimiento");
                String oficio = rs.getString("oficio");
                Secretaria secretaria = new Secretaria(dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento, oficio);
                lista.add(secretaria);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 808", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return lista;
    }
    
    
    
    public ArrayList <Secretaria> buscarPorNombre(String nom) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Secretaria> lista = new ArrayList<>();
        try{
            ps = cnn.prepareStatement("SELECT * FROM Secretaria WHERE nombre LIKE ?");
            ps.setString(1, nom+"%");
            rs = ps.executeQuery();   
            while(rs.next()){
                String dni = rs.getString("dni");
                String password = rs.getString("p_word");
                String nombre = rs.getString("nombre");
                String apellido_p = rs.getString("ap_p");
                String apellido_m = rs.getString("ap_m");
                String sexo = rs.getString("sexo");
                int edad = rs.getInt("edad");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("f_nacimiento");
                String oficio = rs.getString("oficio");
                Secretaria secretaria = new Secretaria(dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento, oficio);
                lista.add(secretaria);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 909", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return lista;
    }
}
