/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;
import db.Conexion;
import entidad.Grado;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Johann
 */
public class GradoDAO {
    private Connection cnn = null;
    private ResultSet rs = null;
    private static GradoDAO instancia;
    
    public static GradoDAO getInstancia(){
        if(instancia==null)
            instancia = new GradoDAO();
        return instancia;
    }
    
    public void insertar(Grado x) throws SQLException
    {   
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareCall("CALL registrarGrado (?,?,?,?)");
            ps.setString(1,x.getIdGrado());
            ps.setInt(2, x.getNumGrado());
            ps.setInt(3, x.getVacantes());
            ps.setString(4, x.getSeccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public Grado buscarGrado (String idgrado) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        Grado x = null;
        try {
            ps = cnn.prepareCall("Call buscarGrado (?)");
            ps.setString(1,idgrado);
            rs = ps.executeQuery();
            if(rs.next()){
                int numgrado = rs.getInt("numGrado");
                int vacantes = rs.getInt("vacantes");
                String seccion = rs.getString("seccion");
                x = new Grado(idgrado,numgrado,vacantes,seccion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return x;
    }
    
    public void actualizar (String idbuscado,Grado x) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareCall("CALL actualizarGrado (?,?,?,?,?)");
            ps.setString(5, idbuscado);
            ps.setString(1,x.getIdGrado());
            ps.setInt(2, x.getNumGrado());
            ps.setInt(3, x.getVacantes());
            ps.setString(4, String.valueOf(x.getSeccion()));
            ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
    }
    
    public boolean eliminar (String idgrado) throws SQLException{
        boolean eliminado=false;
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        try {
            ps = cnn.prepareStatement("CALL eliminarGrado (?)");
            ps.setString(1, idgrado);
            ps.executeQuery();
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
    
    public ArrayList <Grado> mostrarGrados() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Grado> lista = new ArrayList<Grado>();
        try {
            ps = cnn.prepareStatement("CALL mostrarGrados()");
            rs = ps.executeQuery();
            while(rs.next()){
                String idgrado = rs.getString("id");
                int numgrado = rs.getInt("numGrado");
                int vacantes = rs.getInt("vacantes");
                String seccion = rs.getString("seccion");
                Grado x = new Grado(idgrado, numgrado, vacantes, seccion);
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
    
    public ArrayList <Grado> ordenar (String condicion) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Grado> lista = new ArrayList<Grado>();
        try {
            ps = cnn.prepareStatement("select * from grado order by "+condicion);
            
            rs = ps.executeQuery();
            while(rs.next()){
                String idgrado = rs.getString("id");
                int numgrado = rs.getInt("numGrado");
                int vacantes = rs.getInt("vacantes");
                String seccion = rs.getString("seccion");
                Grado x = new Grado(idgrado, numgrado, vacantes, seccion);
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
    
    public ArrayList <Grado> buscarPorID(String id) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Grado> lista = new ArrayList<Grado>();
        try {
            ps = cnn.prepareStatement("CALL buscarGradoPorID(?)");
            ps.setString(1,"%"+id+"%");
           
            rs = ps.executeQuery();
            while(rs.next()){
                String idgrado = rs.getString("id");
                int numgrado = rs.getInt("numGrado");
                int vacantes = rs.getInt("vacantes");
                String seccion = rs.getString("seccion");
                Grado x = new Grado(idgrado, numgrado, vacantes, seccion);
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
    public void mostrar (ArrayList<Grado> lista,DefaultTableModel modelo){
        
        Object datos[][] = new Object[lista.size()][4];
        String titulos[] = {"ID","GRADO","SECCIÓN","VACANTES"};
        for(int i=0;i<lista.size();i++){
            Grado x = lista.get(i);
            datos[i][0] = x.getIdGrado();
            datos[i][1] = x.getNumGrado();
            datos[i][2] = x.getSeccion();
            datos[i][3] = x.getVacantes();
        }
        modelo.setDataVector(datos, titulos);
    }
}
