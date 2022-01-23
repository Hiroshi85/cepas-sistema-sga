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
public class CursoDAO{
    private Connection cnn = null;
    private ResultSet rs = null;
    private static CursoDAO instancia;
    
    public static CursoDAO getInstancia(){
        if(instancia==null)
            instancia = new CursoDAO();
        return instancia;
    }
    
    Curso c = null;
    DocenteDAO DD = new DocenteDAO();
    GradoDAO GD = new GradoDAO();
    
        public void insertarCurso(Curso c) throws SQLException{
            cnn = Conexion.getInstancia().miConexion();
            PreparedStatement ps = null;
            
            try{
                ps = cnn.prepareCall("call insertar_Curso(?,?,?,?,?,?,?)");
                ps.setString(1,c.getIdCurso());
                ps.setString(2,c.getNombre());
                ps.setString(3,c.getTipo());
                ps.setInt(4,c.getDiaSemana());
                ps.setInt(5,c.getnHoras());
                ps.setString(6,c.getGrado().getIdGrado());
                ps.setString(7,c.getDocente().getDni());
                ps.executeUpdate();
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }finally{
                cnn.close();
                ps.close();
                
            }
        }
    
        
        public Curso buscarCurso(String idbusq) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
            try{
                ps = cnn.prepareCall("call buscar_Curso(?)");
                ps.setString(1,idbusq);
                rs = ps.executeQuery();
                if(rs.next()){
                    String idcurso = rs.getString("ID");
                    String nombre = rs.getString("NOMBRE");
                    String tipo = rs.getString("TIPO");
                    int diasem = rs.getInt("DIASEMANA");
                    int nhoras = rs.getInt("NHORAS");
                    String idgrado = rs.getString("GRADO_ID");
                    String iddoc = rs.getString("DOCENTE_DNI");
                    Docente d = DD.buscarDocente(iddoc);
                    Grado g = GD.buscarGrado(idgrado);
                    c = new Curso(idcurso, nombre, d , tipo, diasem, nhoras, g);
                }else{
                    c = null;
                }
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
            }finally{
                rs.close();
                cnn.close();
                ps.close();
            }
            return c;
        }
        
        public void actualizarCurso(Curso c,String idbusq) throws SQLException{
            cnn = Conexion.getInstancia().miConexion();
            PreparedStatement ps = null;

            try{
                ps = cnn.prepareCall("call actualizar_Curso(?,?,?,?,?,?,?)"); 
                ps.setString(1,c.getNombre());
                ps.setString(2,c.getTipo());
                ps.setInt(3,c.getDiaSemana());
                ps.setInt(4,c.getnHoras());
                ps.setString(5,c.getGrado().getIdGrado());
                ps.setString(6,c.getDocente().getDni());
                ps.setString(7,idbusq);
                ps.executeUpdate();
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
            }finally{
                cnn.close();
                ps.close();
            }
        }
        
        public void eliminarCurso(String idbusq) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            try{
                ps = cnn.prepareCall("call eliminar_Curso(?)");
                ps.setString(1,idbusq);
                ps.executeUpdate();
            }catch(SQLException ex)
            {
                System.out.println("ERROR:"+ex.getMessage());
                throw new SQLException();
            }finally{
                cnn.close();
                ps.close();
            }
        }
       
        
    public ArrayList <Curso> mostrarCursos() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Curso> lista = new ArrayList<Curso>();
        try {
            ps = cnn.prepareCall("call mostrar_Cursos()");
            rs = ps.executeQuery();
            while(rs.next()){
                    String idcurso = rs.getString("ID");
                    String nombre = rs.getString("NOMBRE");
                    String tipo = rs.getString("TIPO");
                    int diasem = rs.getInt("DIASEMANA");
                    int nhoras = rs.getInt("NHORAS");
                    String idgrado = rs.getString("GRADO_ID");
                    String iddoc = rs.getString("DOCENTE_DNI");
                    Docente d = DD.buscarDocente(iddoc);
                    Grado g = GD.buscarGrado(idgrado);
                    c = new Curso(idcurso, nombre, d , tipo, diasem, nhoras, g);
                    lista.add(c);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    
    public ArrayList <Curso> mostrarCursosPorDocente(String dniDocente) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Curso> lista = new ArrayList<Curso>();
        try {
            ps = cnn.prepareCall("call mostrarCursosPorDocente(?)");
            ps.setString(1, dniDocente);
            rs = ps.executeQuery();
            while(rs.next()){
                    String idcurso = rs.getString("ID");
                    String nombre = rs.getString("NOMBRE");
                    String tipo = rs.getString("TIPO");
                    int diasem = rs.getInt("DIASEMANA");
                    int nhoras = rs.getInt("NHORAS");
                    String idgrado = rs.getString("GRADO_ID");
                    String iddoc = rs.getString("DOCENTE_DNI");
                    Docente d = DD.buscarDocente(iddoc);
                    Grado g = GD.buscarGrado(idgrado);
                    c = new Curso(idcurso, nombre, d , tipo, diasem, nhoras, g);
                    lista.add(c);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"0000",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public ArrayList <Curso> mostrarPorGrado(String idg) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Curso> lista = new ArrayList<>();
        try{
            ps = cnn.prepareCall("call buscar_Curso_por_Id_Grado(?)");
            ps.setString(1, idg);
            rs = ps.executeQuery();     
            while(rs.next()){
                    String idcurso = rs.getString("ID");
                    String nombre = rs.getString("NOMBRE");
                    String tipo = rs.getString("TIPO");
                    int diasem = rs.getInt("DIASEMANA");
                    int nhoras = rs.getInt("NHORAS");
                    String idgrado = rs.getString("GRADO_ID");
                    String iddoc = rs.getString("DOCENTE_DNI");
                    Docente d = DD.buscarDocente(iddoc);
                    Grado g = GD.buscarGrado(idgrado);
                    c = new Curso(idcurso, nombre, d , tipo, diasem, nhoras, g);
                    lista.add(c);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 909", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return lista;
    }
    
    public ArrayList <Curso> mostrarPorGradoNumero(int ng) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Curso> lista = new ArrayList<>();
        try{
            ps = cnn.prepareCall("call buscar_Curso_por_Num_Grado(?)");
            ps.setInt(1, ng);
            rs = ps.executeQuery();     
            while(rs.next()){
                    String idcurso = rs.getString("ID");
                    String nombre = rs.getString("NOMBRE");
                    String tipo = rs.getString("TIPO");
                    int diasem = rs.getInt("DIASEMANA");
                    int nhoras = rs.getInt("NHORAS");
                    String idgrado = rs.getString("GRADO_ID");
                    String iddoc = rs.getString("DOCENTE_DNI");
                    Docente d = DD.buscarDocente(iddoc);
                    Grado g = GD.buscarGrado(idgrado);
                    c = new Curso(idcurso, nombre, d , tipo, diasem, nhoras, g);
                    lista.add(c);
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: "+ ex.getMessage(), "error 909", 0);         
        }finally{
            cnn.close();
            ps.close();
        }
        
        return lista;
    }
    
    // metodo no necesario opinion: Benja
    
      public void mostrar (ArrayList<Curso> lista,DefaultTableModel modelo){
        
        Object datos[][] = new Object[lista.size()][8];
        String titulos[]={"ID CURSO","NOMBRE","TIPO","DIAS POR SEMANA","N HORAS","GRADO","SECCIÓN","DOCENTE"};
        for(int i=0;i<lista.size();i++){
            c = lista.get(i);
            datos[i][0] = c.getIdCurso();
            datos[i][1] = c.getNombre();
            datos[i][2] = c.getTipo();
            datos[i][3] = c.getDiaSemana();
            datos[i][4] = c.getnHoras();
            datos[i][5] = c.getGrado().getNumGrado();
            datos[i][6] = c.getGrado().getSeccion();
            datos[i][7] = c.getDocente().getApellido_p()+" "+c.getDocente().getApellido_m()+" "+c.getDocente().getNombre();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    
}
