/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import db.Conexion;
import entidad.Docente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johann
 */
public class DocenteDAO {
    private Connection cnn = null;
    private ResultSet rs = null;
    private static DocenteDAO instancia;
    
    public static DocenteDAO getInstancia(){
        if(instancia==null)
            instancia = new DocenteDAO();
        return instancia;
    }
    
    public void insertar(Docente x) throws SQLException
    {   
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareCall("CALL registrarDocente (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,x.getDni());
            ps.setString(7, x.getPassword());
            ps.setString(2, x.getNombre());
            ps.setString(3, x.getApellido_p());
            ps.setString(4, x.getApellido_m());
            ps.setString(5, x.getSexo());
            ps.setInt(6, x.getEdad());
            ps.setString(8, x.getTelefono());
            ps.setString(9, x.getFecha_nacimiento());
            ps.setDouble(10, x.getSueldo());
            ps.executeQuery();
            UsuarioDAO.getInstancia().insertar(x.getDni(), x.getPassword(), x.getNombre(), x.getApellido_p(), x.getApellido_m(), x.getSexo(),x.getEdad(),x.getTelefono(), x.getFecha_nacimiento());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Docente buscarDocente (String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Docente x = null;
        try {
            ps = cnn.prepareCall("CALL buscarDocente (?)");
            ps.setString(1,dni);
            rs = ps.executeQuery();
            if(rs.next()){
               
                String nombre = rs.getString("nombre");
                String apellido_p = rs.getString("ap_p");
                String apellido_m = rs.getString("ap_m");
                String sexo = rs.getString("sexo");
                int edad = rs.getInt("edad");
                String password =  rs.getString("p_word");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("f_nacimiento");
                Double sueldo = rs.getDouble("sueldo");
                x = new Docente(sueldo, dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return x;
    }
    
    public void actualizar (Docente x) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareCall("CALL actualizarDocente (?,?,?,?,?,?,?,?,?)");
            ps.setString(1,x.getDni());
            ps.setString(2, x.getNombre());
            ps.setString(3, x.getApellido_p());
            ps.setString(4, x.getApellido_m());
            ps.setString(5, x.getSexo());
            ps.setInt(6, x.getEdad());
            ps.setString(7, x.getTelefono());
            ps.setString(8, x.getFecha_nacimiento());
            ps.setDouble(9, x.getSueldo());
            UsuarioDAO.getInstancia().actualizar(x.getDni(), x.getNombre(), x.getApellido_p(), x.getApellido_m(), x.getSexo(), x.getEdad(), x.getTelefono(), x.getFecha_nacimiento());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public void actualizarPass(String dni, String passw) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            
        try{
            ps = cnn.prepareCall("call actualizar_passw_Docente(?,?)");
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
    
    public boolean eliminar (String dni) throws SQLException{
        boolean eliminado=false;
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareCall("CALL eliminarDocente(?)");
            ps.setString(1, dni);
            ps.executeQuery();
            UsuarioDAO.getInstancia().eliminar(dni);
            eliminado = true;
        } catch (SQLException e) {
             System.out.println("Error: "+e.getMessage());
             throw new SQLException();
        }finally{
            cnn.close();
            ps.close();
        }
        return eliminado;
    }
    
    public ArrayList <Docente> mostrarDocentes() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Docente> lista = new ArrayList<Docente>();
        try {
            ps = cnn.prepareCall("CALL mostrarDocentes()");
            rs = ps.executeQuery();
            while(rs.next()){
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido_p = rs.getString("ap_p");
                String apellido_m = rs.getString("ap_m");
                String sexo = rs.getString("sexo");
                int edad = rs.getInt("edad");
                String password =  rs.getString("p_word");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("f_nacimiento");
                Double sueldo = rs.getDouble("sueldo");
                Docente x = new Docente(sueldo, dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento);
                lista.add(x);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public ArrayList <Docente> buscarPorID(String dnib) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Docente> lista = new ArrayList<Docente>();
        try {
            ps = cnn.prepareStatement("CALL buscarDocentePorDNI (?)");
            ps.setString(1,"%"+dnib+"%");
           
            rs = ps.executeQuery();
            while(rs.next()){
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido_p = rs.getString("ap_p");
                String apellido_m = rs.getString("ap_m");
                String sexo = rs.getString("sexo");
                int edad = rs.getInt("edad");
                String password =  rs.getString("p_word");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("f_nacimiento");
                Double sueldo = rs.getDouble("sueldo");
                Docente x = new Docente(sueldo, dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento);
                lista.add(x);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    public ArrayList <Docente> ordenar(String condicion) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Docente> lista = new ArrayList<Docente>();
        try {
           
            ps = cnn.prepareStatement("select * from docente order by "+condicion);
                    
            rs = ps.executeQuery();
            while(rs.next()){
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                String apellido_p = rs.getString("ap_p");
                String apellido_m = rs.getString("ap_m");
                String sexo = rs.getString("sexo");
                int edad = rs.getInt("edad");
                String password =  rs.getString("p_word");
                String telefono = rs.getString("telefono");
                String fechaNacimiento = rs.getString("f_nacimiento");
                Double sueldo = rs.getDouble("sueldo");
                Docente x = new Docente(sueldo, dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fechaNacimiento);
                lista.add(x);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public void mostrar (ArrayList<Docente> lista,DefaultTableModel modelo){
        
        Object datos[][] = new Object[lista.size()][8];
        String titulos[] = {"DNI","APELLIDO PATERNO","APELLIDO MATERNO","NOMBRES","SEXO","EDAD","FECHA DE NACIMIENTO","TELÉFONO"};
        for(int i=0;i<lista.size();i++){
            Docente x = lista.get(i);
            datos[i][0] = x.getDni();
            datos[i][1] = x.getApellido_p();
            datos[i][2] = x.getApellido_m();
            datos[i][3] = x.getNombre();
            datos[i][4] = x.getSexo();
            datos[i][5] = x.getEdad();
            datos[i][6] = x.getFecha_nacimiento();
            datos[i][7] = x.getTelefono();
        }
        modelo.setDataVector(datos, titulos);
    }
    
}
