
package presentacion;

import datos.*;
import entidad.*;
import encriptacion.Encriptador;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public class DialogAlumno extends javax.swing.JDialog {

    ArrayList <Alumno> lista = null;
    Alumno alumnoConsulta = null;
    Encriptador ENC = Encriptador.getInstancia();
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Alumno a = null;
    Apoderado ap = null;
    
    public DialogAlumno() {
        super(FrmInicioSecretaria.getInstancia(),true);
        initComponents();
        mostrarTabla();
        SpinnerNumberModel nm = new SpinnerNumberModel();
        nm.setMaximum(25);
        nm.setMinimum(11);
        nm.setValue(13);
        SpinnerEdad.setModel(nm);
        txaObservacion.setLineWrap(true);
        btnReestablecer.setVisible(false);
    }

    public void habilitar(){
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnConsultar.setEnabled(false);
        btnReestablecer.setVisible(true);
    }
     
    public void desHabilitar(){
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnConsultar.setEnabled(true);
        btnReestablecer.setVisible(false);
    }     
    
    public void limpiarEntradas(){
        txtDni.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        comboSexo1.setSelectedIndex(0);
        txtApoderado.setText("");
        SpinnerEdad.setValue(18);
        dcFNAC.setCalendar(null);
        txtApoderado.setText("");
        txtDni.requestFocus();
        txaObservacion.setText("");
        ap = null;
        btnReestablecer.setVisible(false);
    }
    
    private void mostrarTabla(){
        try {
            lista = AlumnoDAO.getInstancia().mostrarAlumnos();
        } catch (SQLException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        AlumnoDAO.getInstancia().mostrar(lista, modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtDni = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBuscarPorIAp = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnReestablecer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        SpinnerEdad = new javax.swing.JSpinner();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaObservacion = new javax.swing.JTextArea();
        comboSexo1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        txtApoderado = new javax.swing.JTextField();
        btnBuscarApo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        dcFNAC = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:: SECRETARIA ::.");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jTable1.setModel(modelo);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 870, 540));

        jPanel5.setBackground(new java.awt.Color(26, 2, 58));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_log.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 840));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 54)); // NOI18N
        jLabel3.setText("ALUMNOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 290, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-alumno.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(231, 235, 244));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDni.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtDni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 180, 30));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel12.setText("DNI");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(25, 0, 58));
        jLabel9.setText("DATOS PERSONALES");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jPanel3.setBackground(new java.awt.Color(194, 36, 45));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-clean.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 160, 40));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Actualizar.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(null);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.setEnabled(false);
        btnActualizar.setMinimumSize(new java.awt.Dimension(200, 200));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 180, 60));

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Consulta.png"))); // NOI18N
        btnConsultar.setText("BUSCAR");
        btnConsultar.setBorder(null);
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnConsultar.setMinimumSize(new java.awt.Dimension(200, 200));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        jPanel3.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 180, 60));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.setEnabled(false);
        btnEliminar.setMinimumSize(new java.awt.Dimension(200, 200));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 180, 60));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save_37110.png"))); // NOI18N
        btnGuardar.setText("REGISTRAR");
        btnGuardar.setBorder(null);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.setMinimumSize(new java.awt.Dimension(200, 200));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 180, 60));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BASE DE DATOS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 40));

        txtBuscarPorIAp.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtBuscarPorIAp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtBuscarPorIAp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarPorIApActionPerformed(evt);
            }
        });
        txtBuscarPorIAp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPorIApKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarPorIApKeyTyped(evt);
            }
        });
        jPanel3.add(txtBuscarPorIAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 170, 30));

        jLabel21.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Buscar por apellido");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        btnReestablecer.setBackground(new java.awt.Color(255, 255, 255));
        btnReestablecer.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnReestablecer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-key.png"))); // NOI18N
        btnReestablecer.setText("Reestablecer contraseña");
        btnReestablecer.setBorder(null);
        btnReestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReestablecerActionPerformed(evt);
            }
        });
        jPanel3.add(btnReestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 300, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, -10, 910, 850));

        jPanel2.setBackground(new java.awt.Color(26, 2, 58));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 37, 229, 30));

        txtApellidoP.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtApellidoP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 230, 30));

        txtApellidoM.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtApellidoM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellidoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoMActionPerformed(evt);
            }
        });
        txtApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 213, 30));

        SpinnerEdad.setModel(new javax.swing.SpinnerNumberModel(35, 0, 100, 1));
        SpinnerEdad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(SpinnerEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 180, 30));

        txtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 264, 230, 30));

        txaObservacion.setColumns(20);
        txaObservacion.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txaObservacion.setRows(5);
        txaObservacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txaObservacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaObservacionKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txaObservacion);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 230, 160));

        comboSexo1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        comboSexo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        comboSexo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(comboSexo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 229, 40));

        jPanel4.setBackground(new java.awt.Color(194, 36, 45));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtApoderado.setEditable(false);
        txtApoderado.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtApoderado.setAutoscrolls(false);
        txtApoderado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApoderado.setEnabled(false);
        txtApoderado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApoderadoActionPerformed(evt);
            }
        });
        jPanel4.add(txtApoderado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 180, 30));

        btnBuscarApo.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarApo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        btnBuscarApo.setText("SELECCIONAR");
        btnBuscarApo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarApoActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscarApo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("DNI");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 220, 160));

        dcFNAC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(dcFNAC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 210, 30));

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("NOMBRES");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("APELLIDO MATERNO");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SEXO");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("EDAD");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("TELÉFONO");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("OBSERVACIÓN");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("APODERADO");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 560, 560));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 1520, 850));

        setSize(new java.awt.Dimension(1648, 863));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarEntradas();
        desHabilitar();
        txtDni.setEnabled(true);
        txtDni.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtApoderadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApoderadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApoderadoActionPerformed

    private void btnBuscarApoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarApoActionPerformed
        try{
            DialogConsultarApoderado f = new DialogConsultarApoderado();
            f.setVisible(true);
            ap=f.apoderadoSeleccionado;
            txtApoderado.setText(ap.getDni());
        }catch(NullPointerException e){
            System.out.println("Excepcion NullPointer en Apoderado");
        }
        
    }//GEN-LAST:event_btnBuscarApoActionPerformed

    private void txtApellidoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {   // TODO add your handling code here:
            String dni = txtDni.getText().trim();
            String apellidoP = txtApellidoP.getText().trim();
            String apellidoM = txtApellidoM.getText().trim();
            String nombre = txtNombre.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String password = dni;
            password = ENC.SHA256(password);
            String sexo = (String) comboSexo1.getSelectedItem();
            int edad = (int) SpinnerEdad.getValue();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaNac = formato.format(dcFNAC.getDate());
            String obs = txaObservacion.getText().trim();
            a = new Alumno(dni, password, nombre, apellidoP, apellidoM, sexo, edad, telefono, fechaNac, obs, ap);
        
            if(UsuarioDAO.getInstancia().buscarUsuario(a.getDni())==null && ApoderadoDAO.getInstancia().buscar(a.getDni())==null){
                AlumnoDAO.getInstancia().insertarAlumno(a);
                limpiarEntradas();
                mostrarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "DNI ya existente en el registro", "Advertencia", 2);
                txtDni.requestFocus();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        } catch(NullPointerException ex){
            System.out.println("No hay nada en apoderado");
            JOptionPane.showMessageDialog(this, "Datos inválidos en la entrada. Revisar ");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        String dni = (txtDni.getText().trim());
        if(txtDni.getText().equalsIgnoreCase(""))
             JOptionPane.showMessageDialog(null, "Ingresa el Dni");
        else
        {
            try{
                alumnoConsulta = AlumnoDAO.getInstancia().buscarAlumno(dni);
                if(alumnoConsulta!=null)
                {
                    txtDni.setEnabled(false);
                    txtNombre.setText(alumnoConsulta.getNombre());
                    txtTelefono.setText(alumnoConsulta.getTelefono());
                    txtApellidoP.setText(alumnoConsulta.getApellido_p());
                    txtApellidoM.setText(alumnoConsulta.getApellido_m());
                    
                    txtApoderado.setText(alumnoConsulta.getApoderado().getDni());
                    
                    comboSexo1.setSelectedItem(alumnoConsulta.getSexo());
                    txaObservacion.setText(alumnoConsulta.getObservacion());
                    SpinnerEdad.setValue(alumnoConsulta.getEdad());
                    java.util.Date fecha_nac = new SimpleDateFormat("yyyy-MM-dd").parse(alumnoConsulta.getFecha_nacimiento());
                    dcFNAC.setDate(fecha_nac);
                    ap = ApoderadoDAO.getInstancia().buscar(alumnoConsulta.getApoderado().getDni());
                            
                    habilitar();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Dni ingresado NO existe, ingrese otro", "NO EXISTE ALUMNO", 0);   
                }       
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 3030", 0);   
            } catch (ParseException ex) {
                Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        String dni = txtDni.getText();
        try{
            AlumnoDAO.getInstancia().eliminarAlumno(dni);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Acción restringida: No se puede eliminar al alumno debido a que se encuentra ya matriculado", "error 5050", 2);   
        }
        desHabilitar();
        limpiarEntradas();
        mostrarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        String dni = txtDni.getText().trim();
        String apellidoP = txtApellidoP.getText().trim();
        String apellidoM = txtApellidoM.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String password = "";
        String sexo = (String) comboSexo1.getSelectedItem();
        int edad = (int) SpinnerEdad.getValue();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNac = formato.format(dcFNAC.getDate());
        String obs = txaObservacion.getText().trim();
        a = new Alumno(dni, password, nombre, apellidoP, apellidoM, sexo, edad, telefono, fechaNac, obs, ap);
       
        try {
            AlumnoDAO.getInstancia().actualizarAlumno(dni,a);
        } catch (SQLException ex) {
            Logger.getLogger(DialogAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        desHabilitar();
        txtDni.setEnabled(true);
        limpiarEntradas();
        mostrarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
   // TODO add your handling code here:
        char c=evt.getKeyChar();
        String id = txtDni.getText();
        
        if(!Character.isDigit(c)){
             evt.consume();
         }
        if(id.length()==8)
            evt.consume();
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
         if (txtNombre.getText().length()==40){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        // TODO add your handling code here:
         if (txtApellidoP.getText().length()==30){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtApellidoPKeyTyped

    private void txtApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMKeyTyped
        // TODO add your handling code here:
        if (txtApellidoM.getText().length()==30){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtApellidoMKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        if (txtTelefono.getText().length()==12){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txaObservacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaObservacionKeyTyped
        // TODO add your handling code here:
        if (txaObservacion.getText().length()==100){
            evt.consume(); 
        }
    }//GEN-LAST:event_txaObservacionKeyTyped

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtBuscarPorIApActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarPorIApActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarPorIApActionPerformed

    private void txtBuscarPorIApKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorIApKeyReleased
        // TODO add your handling code here:
        try {
            if(txtBuscarPorIAp.getText().equals(""))
            AlumnoDAO.getInstancia().mostrar(AlumnoDAO.getInstancia().mostrarAlumnos(), modelo);
            else
            AlumnoDAO.getInstancia().mostrar(AlumnoDAO.getInstancia().mostrarAlumnosPorApellido(txtBuscarPorIAp.getText()), modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"",0);
        }
    }//GEN-LAST:event_txtBuscarPorIApKeyReleased

    private void txtBuscarPorIApKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPorIApKeyTyped
        if (txtBuscarPorIAp.getText().length()==30){
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarPorIApKeyTyped

    private void btnReestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReestablecerActionPerformed
        try{
            String dni = txtDni.getText().trim();
            String passw = dni;
            passw = ENC.SHA256(passw);
            AlumnoDAO.getInstancia().actualizarPass(dni, passw);
            JOptionPane.showMessageDialog(null, "Se ha restablecido la contraseña exitosamente.\nLa contraseña corresponde al número de DNI", "Éxito", 1);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 4040", 0);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
    }//GEN-LAST:event_btnReestablecerActionPerformed

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
//            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogAlumno dialog = new DialogAlumno();
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
    private javax.swing.JSpinner SpinnerEdad;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscarApo;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnReestablecer;
    private javax.swing.JComboBox<String> comboSexo1;
    private com.toedter.calendar.JDateChooser dcFNAC;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea txaObservacion;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtApoderado;
    private javax.swing.JTextField txtBuscarPorIAp;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
