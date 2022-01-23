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
public class ApoderadoDAO {
    private Connection cnn = null;
    private ResultSet rs = null;
    
    private static ApoderadoDAO instancia;
    
    public static ApoderadoDAO getInstancia(){
        if(instancia==null)
            instancia = new ApoderadoDAO();
        return instancia;
    }
    
    public void insertar(Apoderado a) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;      
        try{
            ps = cnn.prepareCall("CALL INSERTAR_APODERADO (?,?,?,?,?)");
            ps.setString(1,a.getDni());
            ps.setString(2,a.getNombre());
            ps.setString(3,a.getAp_p());
            ps.setString(4,a.getTelefono());
            ps.setString(5,a.getParentesco());
            ps.executeUpdate();
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();               
        }
    }
        
    public Apoderado buscar(String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        Apoderado a = null;
        PreparedStatement ps=null;
        try{
            ps = cnn.prepareCall("CALL CONSULTAR_APODERADO(?)");
            ps.setString(1,dni);
            rs = ps.executeQuery();
            if(rs.next()){
                String nombre=rs.getString("NOMBRE");//40
                String ap_p=rs.getString("AP_P");//30
                String telefono=rs.getString("TELEFONO");//45
                String parentesco=rs.getString("PARENTESCO");//30
                a = new Apoderado(dni, nombre, ap_p, telefono, parentesco);
            }
        }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
        }finally{
            rs.close();
            cnn.close();
            ps.close();
        }
        return a;
    }
        
    public void actualizar(Apoderado a) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;      
        try{
            ps = cnn.prepareCall("CALL ACTUALIZAR_APODERADO (?,?,?,?,?)");
            ps.setString(1,a.getDni());
            ps.setString(2,a.getNombre());
            ps.setString(3,a.getAp_p());
            ps.setString(4,a.getTelefono());
            ps.setString(5,a.getParentesco());
            ps.executeUpdate();
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }finally{
            cnn.close();
            ps.close();               
        }
    }
        
    public void eliminarApoderado(String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            try{
                ps = cnn.prepareCall("CALL ELIMINAR_APODERADO (?)");
                ps.setString(1,dni);
                ps.executeUpdate();
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
            }finally{
                cnn.close();
                ps.close();
            }
    }
    
    private ArrayList<Apoderado> mostrarApoderados() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Apoderado> lista = new ArrayList<>();
        try {
            ps = cnn.prepareStatement("CALL MOSTRAR_APODERADO()");
            rs = ps.executeQuery();
            while (rs.next()){
                String dni=rs.getString("DNI");//8
                String nombre=rs.getString("NOMBRE");//40
                String ap_p=rs.getString("AP_P");//30
                String telefono=rs.getString("TELEFONO");//45
                String parentesco=rs.getString("PARENTESCO");//30
                Apoderado a = new Apoderado(dni, nombre, ap_p, telefono, parentesco);
                lista.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        } finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public void mostrar(DefaultTableModel modelo)
    {
        ArrayList<Apoderado> L = new ArrayList<>();
        try {
            L = mostrarApoderados();
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
        Object datos[][]=new Object[L.size()][5];
        String titulos[]={"DNI","NOMBRE","APELLIDO","TELÉFONO","PARENTESCO"}; 
        for(int i=0;i<L.size();i++){
            Apoderado x=L.get(i);
            datos[i][0]=x.getDni();
            datos[i][1]=x.getNombre();
            datos[i][2]=x.getAp_p();
            datos[i][3]=x.getTelefono();
            datos[i][4]=x.getParentesco();
        }
        modelo.setDataVector(datos, titulos);
    }   
}
