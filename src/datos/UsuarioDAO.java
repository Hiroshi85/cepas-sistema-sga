
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
public class UsuarioDAO {
    
    private Connection cnn = null;
    private ResultSet rs = null;
    
    private static UsuarioDAO instancia;
    
    public static UsuarioDAO getInstancia(){
        if(instancia == null)
            instancia = new UsuarioDAO();
        return instancia;
    }
    
    public void insertar(String dni, String password, String nombre, String apellido_p, String apellido_m, String sexo, int edad, String telefono, String fecha_nacimiento) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            
        try{
            ps = cnn.prepareCall("call insertar_Usuario(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, dni);
            ps.setString(7, password);
            ps.setString(2, nombre);
            ps.setString(3, apellido_p);
            ps.setString(4, apellido_m);
            ps.setString(5, sexo);
            ps.setInt(6, edad);
            ps.setString(8, telefono);
            ps.setString(9, fecha_nacimiento);
            ps.executeUpdate();      
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 404", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Usuario buscarUsuario(String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Usuario usuario = null;
        try{
            ps = cnn.prepareCall("call consultar_Usuario(?)");
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
                usuario = new Usuario(dni2, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 505", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return usuario;
    }
    
    
    public void actualizar(String dni, String nombre, String apellido_p, String apellido_m, String sexo, int edad, String telefono, String fecha_nacimiento) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            
        try{
            ps = cnn.prepareCall("call actualizar_Usuario(?,?,?,?,?,?,?,?)");
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, apellido_p);
            ps.setString(4, apellido_m);
            ps.setString(5, sexo);
            ps.setInt(6, edad);
            ps.setString(7, telefono);
            ps.setString(8, fecha_nacimiento);
            ps.executeUpdate();      
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
            ps = cnn.prepareCall("call actualizar_passw_Usuario(?,?)");
            ps.setString(1, passw);
            ps.setString(2, dni);
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
            ps = cnn.prepareCall("call eliminar_Usuario(?)");
            ps.setString(1, dni);
            ps.executeUpdate();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 707", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    
    public ArrayList <Usuario> mostrarUsuarios() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Usuario> lista = new ArrayList<>();
        try{
            ps = cnn.prepareCall("call mostrar_Usuarios()");
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
                Usuario usuario = new Usuario(dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento);
                lista.add(usuario);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 808", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return lista;
    }
    
    
    
    public ArrayList <Usuario> buscarPorNombre(String nom) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Usuario> lista = new ArrayList<>();
        try{
            ps = cnn.prepareStatement("SELECT * FROM Usuario WHERE nombre LIKE ?");
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
                Usuario usuario = new Usuario(dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento);
                lista.add(usuario);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 909", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return lista;
    }
    
    
    public boolean validarUsuario(String dni, String password) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        boolean esValido = false;
        String passwordQuery;
        try{
            ps = cnn.prepareCall("call consultar_Usuario(?)");
            ps.setString(1, dni);
            rs = ps.executeQuery();   
            if(rs.next()){
                passwordQuery = rs.getString("p_word");
                if(password.equals(passwordQuery))
                {
                    esValido = true;
                }
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 1010", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return esValido;
    }
}
