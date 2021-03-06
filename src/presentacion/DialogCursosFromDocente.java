/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import datos.CursoDAO;
import javax.swing.table.DefaultTableModel;
import entidad.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Piero
 */
public class DialogCursosFromDocente extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Docente d = null;
    
    public DialogCursosFromDocente() {
        super(FrmInicioDocente.getInstancia(),true);
        initComponents();
        setLocationRelativeTo(null);
        
    }

    public void setD(Docente docente) {
        d=docente;
        mostrarDatos();
    }
    
    public void mostrarDatos(){
        txtDniDocente.setText(d.getDni());
        txtNombresDocente.setText(d.getNombre()+" "+d.getApellido_p()+" "+d.getApellido_m());
        txtTelefonoDocente.setText(d.getTelefono());
        txtSalarioDocente.setText(String.valueOf(d.getSueldo()));
        ArrayList<Curso> lcd = new ArrayList<>();
        try {
            lcd = CursoDAO.getInstancia().mostrarCursosPorDocente(d.getDni());
        } catch (SQLException ex) {
            Logger.getLogger(DialogCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object datos[][] = new Object[lcd.size()][7];
        String titulos[]={"ID CURSO","NOMBRE","TIPO","DIAS POR SEMANA","N° HORAS","GRADO","SECCIÓN"};
        for(int i=0;i<lcd.size();i++){
            Curso c = lcd.get(i);
            datos[i][0] = c.getIdCurso();
            datos[i][1] = c.getNombre();
            datos[i][2] = c.getTipo();
            datos[i][3] = c.getDiaSemana();
            datos[i][4] = c.getnHoras();
            datos[i][5] = c.getGrado().getNumGrado();
            datos[i][6] = c.getGrado().getSeccion();
            
        }
        modelo.setDataVector(datos, titulos);
        
        
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSide = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtDniDocente = new javax.swing.JTextField();
        txtSalarioDocente = new javax.swing.JTextField();
        txtNombresDocente = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtTelefonoDocente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSalir4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlSide1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSide.setBackground(new java.awt.Color(230, 233, 242));
        pnlSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        jLabel3.setText("CURSOS DEL DOCENTE");
        pnlSide.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 510, 50));

        jLabel10.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 0, 58));
        pnlSide.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jPanel7.setBackground(new java.awt.Color(24, 2, 56));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDniDocente.setEditable(false);
        txtDniDocente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtDniDocente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDniDocente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDniDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniDocenteActionPerformed(evt);
            }
        });
        txtDniDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniDocenteKeyTyped(evt);
            }
        });
        jPanel7.add(txtDniDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 370, 40));

        txtSalarioDocente.setEditable(false);
        txtSalarioDocente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtSalarioDocente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSalarioDocente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSalarioDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalarioDocenteActionPerformed(evt);
            }
        });
        txtSalarioDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalarioDocenteKeyTyped(evt);
            }
        });
        jPanel7.add(txtSalarioDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 370, 40));

        txtNombresDocente.setEditable(false);
        txtNombresDocente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtNombresDocente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombresDocente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombresDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresDocenteActionPerformed(evt);
            }
        });
        txtNombresDocente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresDocenteKeyTyped(evt);
            }
        });
        jPanel7.add(txtNombresDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 370, 40));

        jLabel24.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("SALARIO");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        jLabel25.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("DNI DOCENTE");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel27.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("NOMBRES");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel32.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("TELEFONO");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 20));

        txtTelefonoDocente.setEditable(false);
        txtTelefonoDocente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtTelefonoDocente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefonoDocente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefonoDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoDocenteActionPerformed(evt);
            }
        });
        jPanel7.add(txtTelefonoDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 370, 40));

        pnlSide.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 870, 200));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Cursos.png"))); // NOI18N
        pnlSide.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));

        btnSalir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-salir.png"))); // NOI18N
        btnSalir4.setText("SALIR");
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });
        pnlSide.add(btnSalir4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 740, 180, 40));
        pnlSide.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(194, 36, 45));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(modelo
        );
        jTable1.setEnabled(false);
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 970, 330));

        pnlSide.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 1020, 370));

        pnlSide1.setBackground(new java.awt.Color(26, 2, 58));
        pnlSide.add(pnlSide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 900));

        getContentPane().add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniDocenteActionPerformed

    private void txtDniDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniDocenteKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDniDocenteKeyTyped

    private void txtSalarioDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalarioDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioDocenteActionPerformed

    private void txtSalarioDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalarioDocenteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSalarioDocenteKeyTyped

    private void txtNombresDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresDocenteActionPerformed

    private void txtNombresDocenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresDocenteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresDocenteKeyTyped

    private void txtTelefonoDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoDocenteActionPerformed

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalir4ActionPerformed

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
//            java.util.logging.Logger.getLogger(DialogCursosFromDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogCursosFromDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogCursosFromDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogCursosFromDocente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogCursosFromDocente dialog = new DialogCursosFromDocente();
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
    private javax.swing.JButton btnSalir4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JPanel pnlSide1;
    private javax.swing.JTextField txtDniDocente;
    private javax.swing.JTextField txtNombresDocente;
    private javax.swing.JTextField txtSalarioDocente;
    private javax.swing.JTextField txtTelefonoDocente;
    // End of variables declaration//GEN-END:variables
}
