
package presentacion;

import datos.ApoderadoDAO;
import entidad.Apoderado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public class DialogApoderado extends javax.swing.JDialog {

    Apoderado a = null;
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public DialogApoderado() {
        super(FrmInicioSecretaria.getInstancia(),true);
        initComponents();
        setLocationRelativeTo(null);
        desHabilitar();
        ApoderadoDAO.getInstancia().mostrar(modelo);
    }

    public void habilitar(){
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnConsultar.setEnabled(false);
        txtDni.setEditable(false);
    }
     
    public void desHabilitar(){
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnConsultar.setEnabled(true);
        txtDni.setEditable(true);
    }     
    
    public void limpiarEntradas(){
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtApellidoP.setText("");
        txtParentesco.setText("");
        txtPrefijoTelefono.setText("");
        a=null;
        txtDni.requestFocus();
    }
    
    private boolean validoDatos() throws SQLException{
        boolean b1,b2,b3;
        String dni = txtDni.getText().trim();
        String apellidoP = txtApellidoP.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String pTelefono=txtPrefijoTelefono.getText();
        String parentesco = txtParentesco.getText();
        b1=!dni.equals("") && !nombre.equals("") && !apellidoP.equals("") &&
                !telefono.equals("") && !parentesco.equals("");
        if (b1){
            if (nombre.length()>40){
                nombre = nombre.substring(0, 40);
                txtNombre.setText(nombre);
            }
            if(apellidoP.length()>30){
                apellidoP = apellidoP.substring(0, 30);
                txtApellidoP.setText(apellidoP);
            }
            if (parentesco.length()>30){
                parentesco = parentesco.substring(0,30);
                txtParentesco.setText(parentesco);
            }
            b2 = dni.length()==8 && telefono.length()==9 && pTelefono.length()==3;
            if (b2){
                b3 = ApoderadoDAO.getInstancia().buscar(dni)==null;
                return b3;
            }
            else 
                return false;
        }
        else
            return false;
    }
     
    private boolean validoDatosA() throws SQLException{
        boolean b1,b2;
        String dni = txtDni.getText();
        String apellidoP = txtApellidoP.getText();
        String nombre = txtNombre.getText();
        String pTelefono=txtPrefijoTelefono.getText();
        String telefono = txtTelefono.getText();
        String parentesco = txtParentesco.getText();
        b1=!dni.equals("") && !nombre.equals("") && !apellidoP.equals("") &&
                !telefono.equals("") && !parentesco.equals("") && !pTelefono.equals("");
        if (b1){
            if (nombre.length()>40){
                nombre = nombre.substring(0, 40);
                txtNombre.setText(nombre);
            }
            if(apellidoP.length()>30){
                apellidoP = apellidoP.substring(0, 30);
                txtApellidoP.setText(apellidoP);
            }
            if (parentesco.length()>30){
                parentesco = parentesco.substring(0,30);
                txtParentesco.setText(parentesco);
            }
            b2 = telefono.length()==9 && pTelefono.length()==3;
            return b2;
        }
        else
            return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBack = new javax.swing.JPanel();
        pnlSide = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtParentesco = new javax.swing.JTextField();
        txtPrefijoTelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        pnlRed = new javax.swing.JPanel();
        btnRestaurar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:: SECRETARIA ::.");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBack.setBackground(new java.awt.Color(231, 235, 244));
        pnlBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSide.setBackground(new java.awt.Color(26, 2, 58));

        javax.swing.GroupLayout pnlSideLayout = new javax.swing.GroupLayout(pnlSide);
        pnlSide.setLayout(pnlSideLayout);
        pnlSideLayout.setHorizontalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        pnlSideLayout.setVerticalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );

        pnlBack.add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 860));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 54)); // NOI18N
        jLabel3.setText("APODERADOS");
        pnlBack.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 390, 50));

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/padres.png"))); // NOI18N
        pnlBack.add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 0, 58));
        jLabel1.setText("Información Personal");
        pnlBack.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save_37110.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlBack.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 170, 129, 76));

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Consulta.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(null);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnlBack.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 125, 76));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlBack.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 260, 125, 75));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        pnlBack.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, 129, 76));

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jLabel2.setText("Base de Datos");
        pnlBack.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 410, 94, -1));

        jPanel2.setBackground(new java.awt.Color(26, 2, 58));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 220, 30));

        txtApellidoP.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtApellidoP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 240, 30));

        txtTelefono.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 120, 30));

        txtParentesco.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtParentesco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(txtParentesco, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 200, 30));

        txtPrefijoTelefono.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtPrefijoTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtPrefijoTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrefijoTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtPrefijoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 70, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PARENTESCO");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("DNI");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("NOMBRES");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("TELEFONO");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        txtDni.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtDni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 208, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("PREFIJO TELEFONICO");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        pnlBack.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 650, 230));

        pnlRed.setBackground(new java.awt.Color(194, 36, 45));
        pnlRed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRestaurar.setBackground(new java.awt.Color(153, 255, 204));
        btnRestaurar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-clean.png"))); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        pnlRed.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 150, 40));

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jTable1.setModel(modelo);
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        pnlRed.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 1110, 290));

        pnlBack.add(pnlRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 1170, 420));

        jPanel6.setBackground(new java.awt.Color(196, 36, 45));
        pnlBack.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 190, -1));

        getContentPane().add(pnlBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        limpiarEntradas();
        desHabilitar();
        txtDni.setEnabled(true);
        txtDni.requestFocus();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            if (validoDatos()){
                String dni = txtDni.getText().trim();
                String apellidoP = txtApellidoP.getText().trim();
                String nombre = txtNombre.getText().trim();
                String telefono = txtPrefijoTelefono.getText().trim()+txtTelefono.getText().trim();
                String parentesco = txtParentesco.getText().trim();
                Apoderado apoderado = new Apoderado(dni, nombre, apellidoP, telefono, parentesco);
                ApoderadoDAO.getInstancia().insertar(apoderado);
                ApoderadoDAO.getInstancia().mostrar(modelo);
                limpiarEntradas();
            }
            else{
                JOptionPane.showMessageDialog(this, "Datos inválidos.", "GUARDAR", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String dni=txtDni.getText().trim();
        if (!dni.equals("")){
            try {
                a = ApoderadoDAO.getInstancia().buscar(dni);
                if (a!=null){
                    String apellidoP = a.getAp_p();
                    String nombre = a.getNombre();
                    String telefono = a.getTelefono();
                    String parentesco = a.getParentesco();
                    txtApellidoP.setText(apellidoP);
                    txtDni.setText(dni);
                    txtNombre.setText(nombre);
                    txtParentesco.setText(parentesco);
                    txtPrefijoTelefono.setText(telefono.substring(0, 3));
                    txtTelefono.setText(telefono.substring(3, 12));
                    System.out.println(telefono.substring(3, 12));
                    
                    habilitar();
                }
                else{
                    JOptionPane.showMessageDialog(this, "El DNI no está registrado.", "CONSULTAR", JOptionPane.INFORMATION_MESSAGE);
                    limpiarEntradas();
                }
            } catch (SQLException ex) {
                System.out.println("ERROR: "+ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            if (validoDatosA()){
                String dni = txtDni.getText().trim();
                String apellidoP = txtApellidoP.getText().trim();
                String nombre = txtNombre.getText().trim();
                String telefono = txtPrefijoTelefono.getText().trim()+txtTelefono.getText().trim();
                String parentesco = txtParentesco.getText().trim();
                a = new Apoderado(dni, nombre, apellidoP, telefono, parentesco);
                ApoderadoDAO.getInstancia().actualizar(a);
                ApoderadoDAO.getInstancia().mostrar(modelo);
            }
            else{
                JOptionPane.showMessageDialog(this, "Datos inválidos.", "ACTUALIZAR APODERADO", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
        limpiarEntradas();
        desHabilitar();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            ApoderadoDAO.getInstancia().eliminarApoderado(a.getDni());
            ApoderadoDAO.getInstancia().mostrar(modelo);
            JOptionPane.showMessageDialog(this, "Datos eliminados con éxito.", "ELIMINAR APODERADO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }  
        desHabilitar();
        limpiarEntradas();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c=evt.getKeyChar();
        String id = txtDni.getText();
        
        if(!Character.isDigit(c)){
             evt.consume();
         }
        if(id.length()==8)
            evt.consume();
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c=evt.getKeyChar();
        String telefono = txtTelefono.getText();
        
        if(!Character.isDigit(c)){
             evt.consume();
         }
        if(telefono.length()==9)
            evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtPrefijoTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrefijoTelefonoKeyTyped
        if (txtPrefijoTelefono.getText().length()==3){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtPrefijoTelefonoKeyTyped

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(DialogApoderado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogApoderado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogApoderado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogApoderado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogApoderado dialog = new DialogApoderado();
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
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblImg;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlRed;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtParentesco;
    private javax.swing.JTextField txtPrefijoTelefono;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
