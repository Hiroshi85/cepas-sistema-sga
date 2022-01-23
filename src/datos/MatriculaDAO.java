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
public class MatriculaDAO{
    
    private Connection cnn = null;
    private ResultSet rs = null;
    private static MatriculaDAO instancia;
    
    public static MatriculaDAO getInstancia(){
        if(instancia==null)
            instancia = new MatriculaDAO();
        return instancia;
    }
    
    Matricula m = null;
    AlumnoDAO AD = new AlumnoDAO();
    GradoDAO GD = new GradoDAO();
    SecretariaDAO SD = new SecretariaDAO();
    
        public void insertarMatricula(Matricula m) throws SQLException{
            cnn = Conexion.getInstancia().miConexion();
            PreparedStatement ps = null;
            try{
                ps = cnn.prepareCall("call insertar_Matricula (?,?,?,?,?)");
                ps.setString(1,m.getId());
                ps.setString(2,m.getFecha());
                ps.setString(3,m.getAlumno().getDni());
                ps.setString(4,m.getGrado().getIdGrado());
                ps.setString(5,m.getSecretaria().getDni());
                ps.executeQuery();
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }finally{
                cnn.close();
                ps.close();
                
            }
        }
    
        
        public Matricula buscarMatricula(String matbus) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
            try{
                ps = cnn.prepareCall("call buscar_Matricula(?)");
                ps.setString(1,matbus);
                rs = ps.executeQuery();
                if(rs.next()){
                    String idmat = rs.getString("ID");
                    String fecha = rs.getString("FECHA");
                    String dnialum = rs.getString("ALUMNO_DNI");
                    String idgrad = rs.getString("GRADO_ID");
                    String dnisec = rs.getString("SECRETARIA_DNI");
                    Alumno a = AD.buscarAlumno(dnialum);
                    Grado g = GD.buscarGrado(idgrad);
                    Secretaria s = SD.buscarSecretaria(dnisec);
                    m = new Matricula(idmat, fecha, a, g, s);
                }else{
                    m = null;
                }
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
            }finally{
                rs.close();
                cnn.close();
                ps.close();
            }
            return m;
        }
        
        public void actualizarMatricula(Matricula m,String matbus) throws SQLException{
            cnn = Conexion.getInstancia().miConexion();
            PreparedStatement ps = null;

            try{
                ps = cnn.prepareCall("call actualizar_Matricula(?,?,?,?,?)"); 
                ps.setString(1,m.getFecha());
                ps.setString(2,m.getAlumno().getDni());
                ps.setString(3,m.getGrado().getIdGrado());
                ps.setString(4,m.getSecretaria().getDni());
                ps.setString(5,matbus);
                ps.executeUpdate();
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
            }finally{
                cnn.close();
                ps.close();
            }
        }
        
        public void eliminarMatricula(String matbus,String dni) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
            try{
                ps = cnn.prepareCall("call eliminar_Matricula(?)");
                ps.setString(1,matbus);
                ps.executeUpdate();
                ps = cnn.prepareCall("call ELIMINAR_BIMESTRE_MATRICULA(?)");
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
       
        
    public ArrayList <Matricula> mostrarMatriculas() throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Matricula> lista = new ArrayList<>();
        try {
            ps = cnn.prepareCall("call mostrar_Matriculas()");
            rs = ps.executeQuery();
            while(rs.next()){
                    String idmat = rs.getString("ID");
                    String fecha = rs.getString("FECHA");
                    String dnialum = rs.getString("ALUMNO_DNI");
                    String idgrad = rs.getString("GRADO_ID");
                    String dnisec = rs.getString("SECRETARIA_DNI");
                    Alumno a = AD.buscarAlumno(dnialum);
                    Grado g = GD.buscarGrado(idgrad);
                    Secretaria s = SD.buscarSecretaria(dnisec);
                    m = new Matricula(idmat, fecha, a, g, s);
                    lista.add(m);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public void mostrar (ArrayList<Matricula> lista,DefaultTableModel modelo){
        
        Object datos[][] = new Object[lista.size()][6];
        String titulos[]={"FECHA","ID MATRICULA","DNI ALUMNO", "NOMBRE ALUMNO", "ID GRADO","DNI SECRETARIA"};
        for(int i=0;i<lista.size();i++){
            m = lista.get(i);
            datos[i][0] = m.getFecha();
            datos[i][1] = m.getId();
            datos[i][2] = m.getAlumno().getDni();
            datos[i][3] = m.getAlumno().getNombre()+" "+m.getAlumno().getApellido_p();
            datos[i][4] = m.getGrado().getIdGrado();
            datos[i][5] = m.getSecretaria().getDni();
        }
        modelo.setDataVector(datos, titulos);
    }
    
    public ArrayList <Matricula> mostrarMatriculasPorAlumno(String dnibusq) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Matricula> lista = new ArrayList<>();
        try {
            ps = cnn.prepareCall("call mostrar_Matricula_por_Alumno(?)");
            ps.setString(1, dnibusq+'%');
            rs = ps.executeQuery();
            while(rs.next()){
                    String idmat = rs.getString("ID");
                    String fecha = rs.getString("FECHA");
                    String dnialum = rs.getString("ALUMNO_DNI");
                    String idgrad = rs.getString("GRADO_ID");
                    String dnisec = rs.getString("SECRETARIA_DNI");
                    Alumno a = AD.buscarAlumno(dnialum);
                    Grado g = GD.buscarGrado(idgrad);
                    Secretaria s = SD.buscarSecretaria(dnisec);
                    m = new Matricula(idmat, fecha, a, g, s);
                    lista.add(m);
            }
        } catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return lista;
    }
    
    public Matricula buscarMatriculaPorDniAlumno(String dnibus) throws SQLException{
        m=null;
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps=null;
            try{
                ps = cnn.prepareCall("call buscar_Matricula_DNIAlumno(?)");
                ps.setString(1,dnibus);
                rs = ps.executeQuery();
                if(rs.next()){
                    String idmat = rs.getString("ID");
                    String fecha = rs.getString("FECHA");
                    String dnialum = rs.getString("ALUMNO_DNI");
                    String idgrad = rs.getString("GRADO_ID");
                    String dnisec = rs.getString("SECRETARIA_DNI");
                    Alumno a = AD.buscarAlumno(dnialum);
                    Grado g = GD.buscarGrado(idgrad);
                    Secretaria s = SD.buscarSecretaria(dnisec);
                    m = new Matricula(idmat, fecha, a, g, s);
                }
            }catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"ERROR:"+ex.getMessage());
            }finally{
                rs.close();
                cnn.close();
                ps.close();
            }
            return m;
        }
    
    public ArrayList <Alumno> mostrarAlumnosMatriculadosCurso(String idGrado) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        ArrayList <Alumno> lista = new ArrayList<>();
        try {
            ps = cnn.prepareCall("call mostrarAlumnosDelCurso(?)");
            ps.setString(1,idGrado);
            rs = ps.executeQuery();
            while(rs.next()){
                    String idmat = rs.getString("ID");
                    String fecha = rs.getString("FECHA");
                    String dnialum = rs.getString("ALUMNO_DNI");
                    String idgrad = rs.getString("GRADO_ID");
                    String dnisec = rs.getString("SECRETARIA_DNI");
                    Alumno a = AD.buscarAlumno(dnialum);
                    Grado g = GD.buscarGrado(idgrad);
                    Secretaria s = SD.buscarSecretaria(dnisec);
                    m = new Matricula(idmat, fecha, a, g, s);
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
    
    public void notaFinal(Matricula M,DefaultTableModel modelo) throws SQLException{
        ArrayList<Double> notasFinales =  new ArrayList<>();
        Double acum = 0.0;
        
        ArrayList<Curso> lc = CursoDAO.getInstancia().mostrarPorGrado(M.getGrado().getIdGrado());
            for(int i=0; i<lc.size();i++){
                acum=0.0;
                for(int j=1;j<=4;j++){
                    Bimestre b = BimestreDAO.getInstancia().buscar(M.getAlumno().getDni(),lc.get(i).getIdCurso(), j);
                    double promaux = (b.getN1()+b.getN2()+b.getN3()+b.getN4()+b.getN5()+b.getN6()+b.getN7()+b.getN8())/8;
                    acum = acum + promaux;
                }
                Double PFC = acum/4;
                notasFinales.add(PFC);
        }
            
        Object datos[][] = new Object[lc.size()][5];
        String titulos[]={"ID CURSO","CURSO","DOCENTE","PROMEDIO FINAL","ESTADO"};
        for(int i=0;i<lc.size();i++){
            datos[i][0] = lc.get(i).getIdCurso();
            datos[i][1] = lc.get(i).getNombre();
            datos[i][2] = lc.get(i).getDocente().getApellido_p()+" "+lc.get(i).getDocente().getApellido_m()+", "+lc.get(i).getDocente().getNombre();
            datos[i][3] = notasFinales.get(i);
            datos[i][4] = estado(notasFinales.get(i));
        }
        modelo.setDataVector(datos, titulos);
            
    }
    
    public ArrayList<Double> promedioBimestreCurso(Matricula M, Curso curso) throws SQLException{
        Curso c = CursoDAO.getInstancia().buscarCurso(curso.getIdCurso());
        ArrayList<Double> promedioBimestral =  new ArrayList<>();
        for (int i = 1;i<=4;i++){
            Bimestre b = BimestreDAO.getInstancia().buscar(M.getAlumno().getDni(), c.getIdCurso(), i);
            double pB = (b.getN1()+b.getN2()+b.getN3()+b.getN4()+b.getN5()+b.getN6()+b.getN7()+b.getN8())/8;
            promedioBimestral.add(pB);
            System.out.println(i+": "+promedioBimestral.get(i-1));
        }
        return promedioBimestral;    
    }
    
    public String estado(double n){
        String msj = "";
        if(n<=11){
            msj = "Desaprobado";
        }else{
            msj = "Aprobado";
        }
        return msj;
    }
    
    public int numMatriculadosPorGrado(String idGrado) throws SQLException{
        cnn = Conexion.getInstancia().miConexion();
        PreparedStatement ps = null;
        int n=0;
        try {
            ps = cnn.prepareCall("call NumMatriculadosPorIDGrado(?)");
            ps.setString(1,idGrado);
            rs = ps.executeQuery();
            while(rs.next()){
                n = rs.getInt("count(*)");
            }
        }catch (SQLException e) {
         JOptionPane.showMessageDialog(null,"Error: "+e.getMessage() ,"",0);
        }finally{
            cnn.close();
            ps.close();
        }
        return n;
    }
}
