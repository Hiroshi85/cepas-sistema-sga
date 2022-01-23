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
 * @author despa
 */
public class BimestreDAO {
    private Connection cnn = null;
    private ResultSet rs = null;
    
    private static BimestreDAO instancia;
    
    public static BimestreDAO getInstancia(){
        if(instancia==null)
            instancia = new BimestreDAO();
        return instancia;
    }
    
    public void crearBimestre(Alumno a, String idCurso, int numero) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;      
        try{
            ps = cnn.prepareCall("CALL CREAR_BIMESTRE (?,?,?)");
            ps.setString(1,a.getDni());
            ps.setString(2,idCurso);
            ps.setInt(3,numero);
            ps.executeUpdate();
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();               
        }
    }
    
    public void insertar(Bimestre b, Alumno a) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;      
        try{
            ps = cnn.prepareCall("CALL INSERTAR_BIMESTRE (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,a.getDni());
            ps.setString(2,b.getCurso().getIdCurso());
            ps.setInt(3,b.getNumero());
            ps.setDouble(4,b.getN1());
            ps.setDouble(5,b.getN2());
            ps.setDouble(6,b.getN3());
            ps.setDouble(7,b.getN4());
            ps.setDouble(8,b.getN5());
            ps.setDouble(9,b.getN6());
            ps.setDouble(10,b.getN7());
            ps.setDouble(11,b.getN8());
            ps.setString(12, b.getAsistencia_binaria());
            ps.executeUpdate();
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();               
        }
    }
// un bimestre en específico
    public Bimestre buscar(String dni,String id,int numero) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        Bimestre e = null;
        PreparedStatement ps=null;
        Curso curso = null;
        try{
            ps = cnn.prepareCall("CALL CONSULTAR_BIMESTRE(?,?,?)");
            ps.setString(1, dni);
            ps.setString(2,id);
            ps.setInt(3,numero);
            rs = ps.executeQuery();
            if(rs.next()){
                curso = CursoDAO.getInstancia().buscarCurso(id);
                double n1=rs.getDouble("N1");
                double n2=rs.getDouble("N2");
                double n3=rs.getDouble("N3");
                double n4=rs.getDouble("N4");
                double n5=rs.getDouble("N5");
                double n6=rs.getDouble("N6");
                double n7=rs.getDouble("N7");
                double n8=rs.getDouble("N8");
                String asistencia_binaria=rs.getString("ASISTENCIA_BINARIA");
                e = new Bimestre(curso, numero, n1, n2, n3, n4, n5, n6, n7, n8, asistencia_binaria);
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
        }finally{
            rs.close();
            cnn.close();
            ps.close();
        }
        return e;
    }
    public ListaBimestre buscar(String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ListaBimestre lista = new ListaBimestre();
        try {
            ps = cnn.prepareStatement("CALL MOSTRAR_BIMESTRE_ALUMNO(?)");
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while (rs.next()){
                String idCurso = rs.getString("CURSO_ID");
                int numero = rs.getInt("NUMERO");
                double n1=rs.getDouble("N1");
                double n2=rs.getDouble("N2");
                double n3=rs.getDouble("N3");
                double n4=rs.getDouble("N4");
                double n5=rs.getDouble("N5");
                double n6=rs.getDouble("N6");
                double n7=rs.getDouble("N7");
                double n8=rs.getDouble("N8");
                String asistencia_binaria=rs.getString("ASISTENCIA_BINARIA");
                Curso curso = CursoDAO.getInstancia().buscarCurso(idCurso);
                Bimestre e = new Bimestre(curso, numero, n1, n2, n3, n4, n5, n6, n7, n8, asistencia_binaria);
                lista.agregar(e);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        } finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
           
    public void actualizar(Bimestre b, Alumno a) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;      
        try{
            ps = cnn.prepareCall("CALL ACTUALIZAR_BIMESTRE (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,a.getDni());
            ps.setString(2,b.getCurso().getIdCurso());
            ps.setInt(3,b.getNumero());
            ps.setDouble(4,b.getN1());
            ps.setDouble(5,b.getN2());
            ps.setDouble(6,b.getN3());
            ps.setDouble(7,b.getN4());
            ps.setDouble(8,b.getN5());
            ps.setDouble(9,b.getN6());
            ps.setDouble(10,b.getN7());
            ps.setDouble(11,b.getN8());
            ps.setString(12, b.getAsistencia_binaria());
            ps.executeUpdate();
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();               
        }
    }
    
    public void eliminar(String dni,String id,int numero)throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            try{
                ps = cnn.prepareCall("CALL ELIMINAR_BIMESTRE (?,?,?)");
                ps.setString(1, dni);
                ps.setString(2,id);
                ps.setInt(3,numero);
                ps.executeUpdate();
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
            }finally{
                cnn.close();
                ps.close();
            }
    }
    public ListaBimestre mostrarBimestres() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ListaBimestre lista = new ListaBimestre();
        try {
            ps = cnn.prepareStatement("CALL MOSTRAR_BIMESTRE()");
            rs = ps.executeQuery();
            while (rs.next()){
//              curso = Curso_DAO.getInstancia().buscar(id);
                Curso curso = new Curso();
//              alumno = Alumno_DAO.getInstancia().buscar(dni);
                Alumno alumno = new Alumno();
                int numero = rs.getInt("NUMERO");
                double n1=rs.getDouble("N1");
                double n2=rs.getDouble("N2");
                double n3=rs.getDouble("N3");
                double n4=rs.getDouble("N4");
                double n5=rs.getDouble("N5");
                double n6=rs.getDouble("N6");
                double n7=rs.getDouble("N7");
                double n8=rs.getDouble("N8");
                String asistencia_binaria=rs.getString("ASISTENCIA_BINARIA");
                Bimestre e = new Bimestre(curso, numero, n1, n2, n3, n4, n5, n6, n7, n8, asistencia_binaria);
                lista.agregar(e);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        } finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public ListaBimestre mostrarBimestre_DialogRegistro(String idCurso, int numero) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ListaBimestre lista = new ListaBimestre();
        try {
            ps = cnn.prepareCall("CALL buscarRegistrosPorCursoYNumero(?,?)");
            ps.setString(1, idCurso);
            ps.setInt(2, numero);
            rs = ps.executeQuery();
            while (rs.next()){
                // String ALUMNO_DNI = rs.getString("ALUMNO_DNI");
                String CURSO_ID = rs.getString("CURSO_ID");
                Curso curso = CursoDAO.getInstancia().buscarCurso(CURSO_ID);
                // Alumno alumno = AlumnoDAO.getInstancia().buscarAlumno(ALUMNO_DNI);
                double n1=rs.getDouble("N1");
                double n2=rs.getDouble("N2");
                double n3=rs.getDouble("N3");
                double n4=rs.getDouble("N4");
                double n5=rs.getDouble("N5");
                double n6=rs.getDouble("N6");
                double n7=rs.getDouble("N7");
                double n8=rs.getDouble("N8");
                String asistencia_binaria=rs.getString("ASISTENCIA_BINARIA");
                Bimestre e = new Bimestre(curso, numero, n1, n2, n3, n4, n5, n6, n7, n8, asistencia_binaria);
                lista.agregar(e);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        } finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public ArrayList <Alumno> alumnosBimestre_DialogRegistro(String idCurso, int numero) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Alumno> lista = new ArrayList<>();
        
        try {
            ps = cnn.prepareCall("CALL buscarRegistrosPorCursoYNumero(?,?)");
            ps.setString(1, idCurso);
            ps.setInt(2, numero);
            rs = ps.executeQuery();
            while (rs.next()){
                String ALUMNO_DNI = rs.getString("ALUMNO_DNI");
                Alumno alumno = AlumnoDAO.getInstancia().buscarAlumno(ALUMNO_DNI);
                lista.add(alumno);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        } finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    // No se para q son los metodos mostrar
    public void mostrar(DefaultTableModel modelo)
    {
        ListaBimestre L = new ListaBimestre();
        try {
            L = mostrarBimestres();
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
        Object datos[][]=new Object[L.getN()][11];
        String titulos[]={"ID Curso","N Bimestre","N1","N2","N3","N4","N5",
            "N6","N7","N8","Asistencia Binaria"};
        for(int i=0;i<L.getN();i++){
            Bimestre x=L.getElemento(i);
            datos[i][0]=x.getCurso().getIdCurso();
            datos[i][1]=x.getNumero();
            datos[i][2]=x.getN1();
            datos[i][3]=x.getN2();
            datos[i][4]=x.getN3();
            datos[i][5]=x.getN4();
            datos[i][6]=x.getN5();
            datos[i][7]=x.getN6();
            datos[i][8]=x.getN7();
            datos[i][9]=x.getN8();
            datos[i][10]=x.getAsistencia_binaria();
            
        }
        modelo.setDataVector(datos, titulos);
    }   
    
    public void mostrar(DefaultTableModel modelo, Alumno a)
    {
        ListaBimestre L = new ListaBimestre();
        try {
            L = buscar(a.getDni());
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
        Object datos[][]=new Object[L.getN()][11];
        String titulos[]={"ID Curso","N Bimestre","N1","N2","N3","N4","N5",
            "N6","N7","N8","Asistencia Binaria"};
        for(int i=0;i<L.getN();i++){
            Bimestre x=L.getElemento(i);
            datos[i][0]=x.getCurso().getIdCurso();
            datos[i][1]=x.getNumero();
            datos[i][2]=x.getN1();
            datos[i][3]=x.getN2();
            datos[i][4]=x.getN3();
            datos[i][5]=x.getN4();
            datos[i][6]=x.getN5();
            datos[i][7]=x.getN6();
            datos[i][8]=x.getN7();
            datos[i][9]=x.getN8();
            datos[i][10]=x.getAsistencia_binaria();
            
        }
        modelo.setDataVector(datos, titulos);
    }   
    
    // Recomiendo eliminar en los DAO
   
    
}
