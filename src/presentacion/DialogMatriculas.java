/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.MatriculaDAO;
import entidad.Matricula;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Piero
 */
public class DialogMatriculas extends javax.swing.JDialog {

    MatriculaDAO MD = MatriculaDAO.getInstancia();
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    ArrayList <Matricula> l = null;
 
    public DialogMatriculas() {
        super(FrmInicioSecretaria.getInstancia(), true);
        initComponents();
        String titulos[]={"FECHA","ID MATRICULA","DNI ALUMNO","ID GRADO","DNI SECRETARIA"};
        modelo.setColumnIdentifiers(titulos);
        mostrar();
        setLocationRelativeTo(null);
    }
   
    public void mostrar(){
        try {
            l = MD.mostrarMatriculas();
        } catch (SQLException ex) {
            Logger.getLogger(DialogMatriculas.class.getName()).log(Level.SEVERE, null, ex);
        }
        MD.mostrar(l, modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        pnlBack = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlLine = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDniBusq = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jTable1.setModel(modelo);
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 1020, 540));

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-salir.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 720, 160, 50));

        pnlBack.setBackground(new java.awt.Color(231, 235, 244));
        pnlBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 2, 58));
        pnlBack.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 80, 830));

        pnlLine.setBackground(new java.awt.Color(196, 36, 45));
        pnlBack.add(pnlLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 320, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 54)); // NOI18N
        jLabel3.setText("MATRICULAS");
        pnlBack.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 350, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-matricula.png"))); // NOI18N
        pnlBack.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jLabel5.setText("Buscar por DNI ALUMNO:");
        pnlBack.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, 30));

        txtDniBusq.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        txtDniBusq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniBusqKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniBusqKeyTyped(evt);
            }
        });
        pnlBack.add(txtDniBusq, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 440, 30));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlBack.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 120, 110, 30));

        btnTodos.setBackground(new java.awt.Color(255, 255, 255));
        btnTodos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-todos.png"))); // NOI18N
        btnTodos.setText("TODOS");
        btnTodos.setBorder(null);
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        pnlBack.add(btnTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 120, 40));

        getContentPane().add(pnlBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        // TODO add your handling code here:
        mostrar();
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            // TODO add your handling code here:
            String dnibusq = txtDniBusq.getText();
            l = MD.mostrarMatriculasPorAlumno(dnibusq);
            MD.mostrar(l, modelo);
        } catch (SQLException ex) {
            Logger.getLogger(DialogListaAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDniBusqKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniBusqKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        String id = txtDniBusq.getText();
        
        if(!Character.isDigit(c)){
             evt.consume();
         }
        if(id.length()==8)
            evt.consume();
    }//GEN-LAST:event_txtDniBusqKeyTyped

    private void txtDniBusqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniBusqKeyReleased
        try {
            if(txtDniBusq.getText().equals(""))
                 MatriculaDAO.getInstancia().mostrar(MatriculaDAO.getInstancia().mostrarMatriculas(), modelo);  
            else
                MatriculaDAO.getInstancia().mostrar(MatriculaDAO.getInstancia().mostrarMatriculasPorAlumno(txtDniBusq.getText()),modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"",0);
        }
    }//GEN-LAST:event_txtDniBusqKeyReleased

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogMatriculas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogMatriculas dialog = new DialogMatriculas();
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTodos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlLine;
    private javax.swing.JTextField txtDniBusq;
    // End of variables declaration//GEN-END:variables
}