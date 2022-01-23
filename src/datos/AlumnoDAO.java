/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import db.Conexion;
import entidad.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Piero
 */
public class AlumnoDAO {
    
    private Connection cnn = null;
    private ResultSet rs = null;
    
    private static AlumnoDAO instancia;
    
    public static AlumnoDAO getInstancia(){
        if(instancia==null)
            instancia = new AlumnoDAO();
        return instancia;
    }
    
     ApoderadoDAO APD = new ApoderadoDAO();
     GradoDAO GD = new GradoDAO();
     UsuarioDAO UD = new UsuarioDAO();
     Alumno a = null;
    
    public void insertarAlumno(Alumno a) throws SQLException
    {   
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareCall("call registrar_Alumno (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,a.getDni());
            ps.setString(2,a.getNombre());
            ps.setString(3,a.getApellido_p());
            ps.setString(4,a.getApellido_m());
            ps.setString(5,a.getSexo());
            ps.setInt(6, a.getEdad());
            ps.setString(7,a.getPassword());
            ps.setString(8, a.getTelefono());
            ps.setString(9, a.getFecha_nacimiento());
            ps.setString(10, a.getObservacion());
            ps.setString(11, a.getApoderado().getDni());
            ps.executeQuery();  
            UD.insertar(a.getDni(), a.getPassword(), a.getNombre(), a.getApellido_p(), a.getApellido_m(), a.getSexo(), a.getEdad(), a.getTelefono(), a.getFecha_nacimiento());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Alumno buscarAlumno (String idabusq) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Alumno alum=null;
        try {
            ps = cnn.prepareCall("call buscar_Alumno(?)");
            ps.setString(1,idabusq);
            rs = ps.executeQuery();
            if(rs.next()){
                String dni = rs.getString("DNI");
                String name = rs.getString("NOMBRE");
                String apellidop = rs.getString("AP_P");
                String apellidom = rs.getString("AP_M");
                String sexo = rs.getString("SEXO");
                int edad = rs.getInt("EDAD");
                String pass = rs.getString("P_WORD");
                String telef = rs.getString("TELEFONO");
                String fecha = rs.getString("F_NACIMIENTO");
                String obs = rs.getString("OBSERVACION");
                String dnia = rs.getString("APODERADO_DNI");
                Apoderado ap = APD.buscar(dnia);
                alum = new Alumno(dni, pass, name, apellidop, apellidom, sexo, edad, telef, fecha, obs, ap);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return alum;
    }
    
    public void actualizarAlumno(String dnibusq, Alumno a) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareCall("call actualizar_Alumno (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,a.getNombre());
            ps.setString(2,a.getApellido_p());
            ps.setString(3,a.getApellido_m());
            ps.setString(4,a.getSexo());
            ps.setInt(5, a.getEdad());
            ps.setString(6, a.getTelefono());
            ps.setString(7, a.getFecha_nacimiento());
            ps.setString(8, a.getObservacion());
            
            String dnia = a.getApoderado().getDni();
            
            ps.setString(9, dnia);
            ps.setString(10, dnibusq);
            UD.actualizar(a.getDni(), a.getNombre(), a.getApellido_p(), a.getApellido_m(), a.getSexo(), a.getEdad(), a.getTelefono(), a.getFecha_nacimiento());
            
            ps.executeQuery();
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
            ps = cnn.prepareCall("call actualizar_passw_Alumno(?,?)");
            ps.setString(1, passw);
            ps.setString(2, dni);
            
            UD.actualizarPass(dni, passw);
            ps.executeUpdate();      
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 606", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    
    public boolean eliminarAlumno(String dnibusq) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        boolean eliminado=false;
        try {
            ps = cnn.prepareCall("call eliminar_Alumno(?)");
            ps.setString(1, dnibusq);
            ps.executeQuery();
            UD.eliminar(dnibusq);
            eliminado=true;
        } catch (SQLException e) {
             System.out.println("Error: "+e.getMessage());
             throw new SQLException();
        }finally{
            cnn.close();
            ps.close();
        }
        return eliminado;
    }
    
    public ArrayList <Alumno> mostrarAlumnos() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Alumno> lista = new ArrayList<>();
        try {
            ps = cnn.prepareCall("call mostrar_Alumnos()");
            rs = ps.executeQuery();
            while(rs.next()){
                String dni = rs.getString("DNI");
                String name = rs.getString("NOMBRE");
                String apellidop = rs.getString("AP_P");
                String apellidom = rs.getString("AP_M");
                String sexo = rs.getString("SEXO");
                int edad = rs.getInt("EDAD");
                String pass = rs.getString("P_WORD");
                String telef = rs.getString("TELEFONO");
                String fecha = rs.getString("F_NACIMIENTO");
                String obs = rs.getString("OBSERVACION");
                String dnia = rs.getString("APODERADO_DNI");
                Apoderado ap = APD.buscar(dnia);
                a = new Alumno(dni, pass, name, apellidop, apellidom, sexo, edad, telef, fecha, obs, ap);
                lista.add(a);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public ArrayList<Alumno> listarAlumnosDocente(String idgrado) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Alumno> lista = new ArrayList<>();
        try {
            ps = cnn.prepareCall("call mostrarListasDocente(?)");
            ps.setString(1,idgrado);
            rs = ps.executeQuery();
            while(rs.next()){
                String dni = rs.getString("DNI");
                String name = rs.getString("NOMBRE");
                String apellidop = rs.getString("AP_P");
                String apellidom = rs.getString("AP_M");
                String pass="";
                String sexo=rs.getString("SEXO");
                int edad=0;
                String fecha="";
                String telef="";
                String obs="";
                Apoderado ap = null;
                a = new Alumno(dni, pass, name, apellidop, apellidom, sexo, edad, telef, fecha, obs, ap);
                lista.add(a);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public void mostrarListasDocente(String idgrado,DefaultTableModel modelo) throws SQLException{
        ArrayList<Alumno>lista =listarAlumnosDocente(idgrado);
        Object datos[][] = new Object[lista.size()][4];
        String titulos[] = {"ID MATRICULA","DNI ALUMNO","SEXO","NOMBRE"};
        for(int i=0;i<lista.size();i++){
            Alumno x = lista.get(i);
            Matricula m = MatriculaDAO.getInstancia().buscarMatriculaPorDniAlumno(x.getDni());  
            datos[i][0] = m.getId();
            datos[i][1] = x.getDni();
            datos[i][2] = x.getSexo();
            datos[i][3] = x.getApellido_p()+" "+x.getApellido_m()+", "+x.getNombre();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    
    public void mostrar(ArrayList<Alumno>lista, DefaultTableModel modelo){
        
        Object datos[][] = new Object[lista.size()][8];
        String titulos[] = {"DNI ALUMNO","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","SEXO","EDAD","TELEFONO","APODERADO"};
        for(int i=0;i<lista.size();i++){
            Alumno x = lista.get(i);   
            datos[i][0] = x.getDni();
            datos[i][1] = x.getNombre();
            datos[i][2] = x.getApellido_p();
            datos[i][3] = x.getApellido_m();
            datos[i][4] = x.getSexo();
            datos[i][5] = x.getEdad();
            datos[i][6] = x.getTelefono();
            datos[i][7] = x.getApoderado().getDni();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    
    public ArrayList <Alumno> mostrarAlumnosPorDni(String dnibusq) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Alumno> lista = new ArrayList<>();
        try {
            ps = cnn.prepareCall("call buscarAlumnoPorDNI(?)");
            ps.setString(1, dnibusq+'%');
            rs = ps.executeQuery();
            while(rs.next()){
                String dni = rs.getString("DNI");
                String name = rs.getString("NOMBRE");
                String apellidop = rs.getString("AP_P");
                String apellidom = rs.getString("AP_M");
                String sexo = rs.getString("SEXO");
                int edad = rs.getInt("EDAD");
                String pass = rs.getString("P_WORD");
                String telef = rs.getString("TELEFONO");
                String fecha = rs.getString("F_NACIMIENTO");
                String obs = rs.getString("OBSERVACION");
                String dnia = rs.getString("APODERADO_DNI");
                Apoderado ap = APD.buscar(dnia);
                a = new Alumno(dni, pass, name, apellidop, apellidom, sexo, edad, telef, fecha, obs, ap);
                lista.add(a);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public ArrayList <Alumno> mostrarAlumnosPorApellido(String apel) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Alumno> lista = new ArrayList<>();
        try {
            ps = cnn.prepareCall("call buscarAlumnoPorApellido(?)");
            ps.setString(1, apel+'%');
            rs = ps.executeQuery();
            while(rs.next()){
                String dni = rs.getString("DNI");
                String name = rs.getString("NOMBRE");
                String apellidop = rs.getString("AP_P");
                String apellidom = rs.getString("AP_M");
                String sexo = rs.getString("SEXO");
                int edad = rs.getInt("EDAD");
                String pass = rs.getString("P_WORD");
                String telef = rs.getString("TELEFONO");
                String fecha = rs.getString("F_NACIMIENTO");
                String obs = rs.getString("OBSERVACION");
                String dnia = rs.getString("APODERADO_DNI");
                Apoderado ap = APD.buscar(dnia);
                a = new Alumno(dni, pass, name, apellidop, apellidom, sexo, edad, telef, fecha, obs, ap);
                lista.add(a);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
}
