

package presentacion;

import datos.*;
import entidad.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roggee
 */
public class DialogRegistro extends javax.swing.JDialog {
    
    ListaBimestre listaBimestre = null;
    ArrayList <Alumno> listaAlumnos = null;
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Docente docente = null;
    ArrayList <Curso> cursos = null;
    
    public DialogRegistro(Docente docente) {
        super(FrmInicioDocente.getInstancia(),true);
        initComponents();
        this.docente = docente;
        try{
            cursos = CursoDAO.getInstancia().mostrarCursosPorDocente(docente.getDni());
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 1010", 0);   
        }
        llenarComboCursos();
        llenarComboBimestre();
        setLocationRelativeTo(null);
        mostrarTabla(modelo);
        
    }

    
    private void llenarComboCursos(){
        for (int i = 0; i < cursos.size(); i++) {
            cboCurso.addItem(cursos.get(i).getNombre());
        }
    }
    
    private void llenarComboBimestre(){
        cboBimestre.addItem("I");
        cboBimestre.addItem("II");
        cboBimestre.addItem("III");
        cboBimestre.addItem("IV");
    }
    
    
    public void mostrarTabla(DefaultTableModel modelo){
//        int indexCurso = cboCurso.getSelectedIndex();
//        String idCurso = cursos.get(indexCurso).getIdCurso();
//        int numero = cboBimestre.getSelectedIndex()+1;
        try{
            int indexCurso = cboCurso.getSelectedIndex();
            String idCurso = cursos.get(indexCurso).getIdCurso();
            int numero = cboBimestre.getSelectedIndex()+1;
            listaBimestre = BimestreDAO.getInstancia().mostrarBimestre_DialogRegistro(idCurso,numero);
            listaAlumnos = BimestreDAO.getInstancia().alumnosBimestre_DialogRegistro(idCurso,numero);
            Object datos[][]=new Object[listaBimestre.getN()][6];
            String titulos[]={"DNI","Nombres","Apellidos","Promedio Ponderado","Asistencia"};
            for(int i=0;i<listaBimestre.getN();i++)
            {
                Bimestre x=listaBimestre.getElemento(i);
                Alumno a = listaAlumnos.get(i);
                String asistenciaIngreso = x.getAsistencia_binaria().equalsIgnoreCase("00000000") ? "NO INGRESADA":"INGRESADA";
                datos[i][0]= a.getDni();
                datos[i][1]= a.getNombre();
                datos[i][2]= a.apellidoCompleto();
                datos[i][3]= x.getPromedio();
                datos[i][4]= asistenciaIngreso;

            }
            modelo.setDataVector(datos, titulos);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 1010", 0);   
        }catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(this, "No hay cursos registrados como docente.\nComunicarse con Secretaría para la asignación de materias");
            btnSeleccionar.setEnabled(false);
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSeleccionar = new javax.swing.JButton();
        cboCurso = new javax.swing.JComboBox<>();
        cboBimestre = new javax.swing.JComboBox<>();
        pnlSide = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        pnlBack = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Bimestre");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Consulta.png"))); // NOI18N
        btnSeleccionar.setText("Registrar Notas / Asistencia");
        btnSeleccionar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSeleccionar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 230, 80));

        cboCurso.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        cboCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCursoActionPerformed(evt);
            }
        });
        getContentPane().add(cboCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 231, 46));

        cboBimestre.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        cboBimestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBimestreActionPerformed(evt);
            }
        });
        getContentPane().add(cboBimestre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 80, 46));

        pnlSide.setBackground(new java.awt.Color(26, 2, 58));

        javax.swing.GroupLayout pnlSideLayout = new javax.swing.GroupLayout(pnlSide);
        pnlSide.setLayout(pnlSideLayout);
        pnlSideLayout.setHorizontalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        pnlSideLayout.setVerticalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        getContentPane().add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 770));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 54)); // NOI18N
        jLabel4.setText("REGISTRO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 290, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono_calificaciones.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 70, 70));

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(25, 0, 58));
        jLabel15.setText("ALUMNO (S) MATRICULADOS");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(25, 0, 58));
        jLabel16.setText("BIMESTRE");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(25, 0, 58));
        jLabel17.setText("CURSO");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        jPanel1.setBackground(new java.awt.Color(194, 36, 45));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        Tabla.setModel(modelo);
        Tabla.setGridColor(new java.awt.Color(255, 255, 255));
        Tabla.setRowHeight(22);
        jScrollPane1.setViewportView(Tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1100, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 1140, 430));

        pnlBack.setBackground(new java.awt.Color(231, 235, 244));
        pnlBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(pnlBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int i = Tabla.getSelectedRow();
        
        int indexCurso = cboCurso.getSelectedIndex();
        String idCurso = cursos.get(indexCurso).getIdCurso();
        int numero = cboBimestre.getSelectedIndex()+1;
        Alumno alumnoSelec = null;
        
        if(i!=-1) {
            String DNI_ALUMNO = (String) (modelo.getValueAt(i, 0));
            try{
                alumnoSelec = AlumnoDAO.getInstancia().buscarAlumno(DNI_ALUMNO);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 1111", 0);
            }
            DialogDocenteBimestre fDB = new DialogDocenteBimestre(alumnoSelec, idCurso, numero, docente);
            fDB.setVisible(true);
            mostrarTabla(modelo);
        } else
            JOptionPane.showMessageDialog(null, "Debes Seleccionar un Alumno");
}//GEN-LAST:event_btnSeleccionarActionPerformed

    private void cboCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCursoActionPerformed
        mostrarTabla(modelo);
    }//GEN-LAST:event_cboCursoActionPerformed

    private void cboBimestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBimestreActionPerformed
        mostrarTabla(modelo);
    }//GEN-LAST:event_cboBimestreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cboBimestre;
    private javax.swing.JComboBox<String> cboCurso;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlSide;
    // End of variables declaration//GEN-END:variables



}
