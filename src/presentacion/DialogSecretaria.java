
package presentacion;

import datos.ApoderadoDAO;
import datos.SecretariaDAO;
import datos.UsuarioDAO;
import entidad.Secretaria;
import encriptacion.Encriptador;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public class DialogSecretaria extends javax.swing.JDialog {

    ArrayList <Secretaria> lista = null;
    Secretaria secretariaConsulta = null;
    Secretaria secretariaSelect = null;
    Encriptador ENC = Encriptador.getInstancia();
    
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public DialogSecretaria() {
        super(FrmInicioSecretaria.getInstancia(),true);
        initComponents();
        setLocationRelativeTo(null);
        desHabilitar();
        mostrarTabla(modelo);
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
        comboSexo.setSelectedIndex(0);
        txtOficio.setText("");
        SpinnerEdad.setValue(35);
        jdcFechaNacimiento.setDate(null);
        txtDni.requestFocus();
    }
    
    private void mostrarTabla(DefaultTableModel modelo){
        try{
            lista = SecretariaDAO.getInstancia().mostrarSecretarias();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 1010", 0);   
        }
        Object datos[][]=new Object[lista.size()][8];
        String titulos[]={"Dni","Nombre","Apellidos","Sexo","Edad","Telefono","Fecha Nacimiento","Oficio"};
        for(int i=0;i<lista.size();i++)
        {
            Secretaria x=lista.get(i);
            datos[i][0]=x.getDni();
            datos[i][1]=x.getNombre();
            datos[i][2]=x.getApellido_p()+" "+x.getApellido_m();
            datos[i][3]=x.getSexo();
            datos[i][4]=x.getEdad();
            datos[i][5]=x.getTelefono();
            datos[i][6]=x.getFecha_nacimiento();
            datos[i][7]=x.getOficio();

        }
        modelo.setDataVector(datos, titulos);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBack = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        comboSexo = new javax.swing.JComboBox<>();
        SpinnerEdad = new javax.swing.JSpinner();
        txtTelefono = new javax.swing.JTextField();
        txtOficio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jdcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnRestaurar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnlSide = new javax.swing.JPanel();
        txtDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlRe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnReestablecer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".:: SECRETARIA ::.");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBack.setBackground(new java.awt.Color(231, 235, 244));
        pnlBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(26, 2, 58));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 229, 30));

        txtApellidoP.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtApellidoP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellidoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoPKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 204, -1));

        txtApellidoM.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtApellidoM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtApellidoM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoMKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 213, 30));

        comboSexo.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MASCULINO", "FEMENINO" }));
        comboSexo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(comboSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 204, 40));

        SpinnerEdad.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        SpinnerEdad.setModel(new javax.swing.SpinnerNumberModel(35, 0, 200, 1));
        SpinnerEdad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(SpinnerEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 83, 30));

        txtTelefono.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtTelefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 204, 30));

        txtOficio.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtOficio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(txtOficio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 260, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("APELLIDO MATERNO");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("NOMBRES");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("APELLIDO PATERNO");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("SEXO");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("EDAD");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("OFICIO");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("TELÉFONO");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        jPanel2.add(jdcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 170, 30));

        pnlBack.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 510, 390));

        btnRestaurar.setBackground(new java.awt.Color(153, 255, 204));
        btnRestaurar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnRestaurar.setText("Restaurar");
        btnRestaurar.setBorder(null);
        btnRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarActionPerformed(evt);
            }
        });
        pnlBack.add(btnRestaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 680, 99, 41));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 54)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(25, 0, 58));
        jLabel3.setText("SECRETARIA");
        pnlBack.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 70));

        jPanel6.setBackground(new java.awt.Color(196, 36, 45));
        pnlBack.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 190, -1));

        pnlSide.setBackground(new java.awt.Color(26, 2, 58));

        javax.swing.GroupLayout pnlSideLayout = new javax.swing.GroupLayout(pnlSide);
        pnlSide.setLayout(pnlSideLayout);
        pnlSideLayout.setHorizontalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        pnlSideLayout.setVerticalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        pnlBack.add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 750));

        txtDni.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtDni.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        pnlBack.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 170, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(25, 0, 58));
        jLabel4.setText("Información Personal");
        pnlBack.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel20.setText("DNI");
        pnlBack.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        pnlRe.setBackground(new java.awt.Color(194, 36, 45));
        pnlRe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jTable1.setModel(modelo);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        pnlRe.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 950, 580));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save_37110.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        pnlRe.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 170, 60));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlRe.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 160, 60));

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Consulta.png"))); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(null);
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnlRe.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 140, 60));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        pnlRe.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 170, 60));

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setFont(new java.awt.Font("Yu Gothic", 0, 13)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-selecc.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setBorder(null);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        pnlRe.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 160, 50));

        pnlBack.add(pnlRe, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, -10, 970, 780));

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
        pnlBack.add(btnReestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 240, 60));

        getContentPane().add(pnlBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReestablecerActionPerformed
       try{
            String dni = txtDni.getText().trim();
            String passw = dni;
            passw = ENC.SHA256(passw);
            SecretariaDAO.getInstancia().actualizarPass(dni, passw);
            JOptionPane.showMessageDialog(null, "Se ha restablecido la contraseña exitosamente.\nLa contraseña corresponde al número de DNI", "Éxito", 1);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 4040", 0);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("ERROR: "+ex.getMessage());
        }
        
        mostrarTabla(modelo);
    }//GEN-LAST:event_btnReestablecerActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
        int i = jTable1.getSelectedRow();
        if(i!=-1){
            secretariaSelect = new Secretaria();
            secretariaSelect.setDni(modelo.getValueAt(i,0).toString());
            this.dispose();
        }else JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla");

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        
        String dni = txtDni.getText().trim();
        String apellidoP = txtApellidoP.getText().trim();
        String apellidoM = txtApellidoM.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String sexo = (String) comboSexo.getSelectedItem();
        int edad = (int) SpinnerEdad.getValue();
        String oficio = txtOficio.getText().trim();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimiento = formato.format(jdcFechaNacimiento.getDate());
        
        try{
            SecretariaDAO.getInstancia().actualizar(dni,nombre,apellidoP,apellidoM,sexo,edad,telefono,fechaNacimiento, oficio);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 4040", 0);   
        }
        
        desHabilitar();
        txtDni.setEnabled(true);
        limpiarEntradas();
        mostrarTabla(modelo);
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        String dni = (txtDni.getText().trim());
        if(txtDni.getText().equalsIgnoreCase(""))
        JOptionPane.showMessageDialog(null, "POR FAVOR INGRESA Dni");
        else
        {
            try{
                secretariaConsulta = SecretariaDAO.getInstancia().buscarSecretaria(dni);
                if(secretariaConsulta!=null)
                {
                    txtDni.setEnabled(false);
                    txtNombre.setText(secretariaConsulta.getNombre());
                    txtTelefono.setText(secretariaConsulta.getTelefono());
                    txtApellidoP.setText(secretariaConsulta.getApellido_p());
                    txtApellidoM.setText(secretariaConsulta.getApellido_m());
                    //txtPassword.setText(secretariaConsulta.getPassword());
                    txtOficio.setText(secretariaConsulta.getOficio());
                    comboSexo.setSelectedItem(secretariaConsulta.getSexo());
                    SpinnerEdad.setValue(secretariaConsulta.getEdad());
                    java.util.Date fecha_nac = new SimpleDateFormat("yyyy-MM-dd").parse(secretariaConsulta.getFecha_nacimiento());
                    jdcFechaNacimiento.setDate(fecha_nac);
                    habilitar();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Dni ingresado NO existe, ingrese otro", "NO EXISTE SECRETARIA", 0);
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 3030", 0);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "ERROR: "+ex.getMessage(), "error ",0);
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String dni = txtDni.getText().trim();
        try{
            SecretariaDAO.getInstancia().eliminar(dni);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+ e.getMessage(), "error 5050", 0);
        }
        desHabilitar();
        limpiarEntradas();
        mostrarTabla(modelo);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try{
            String dni = txtDni.getText().trim();
            String apellidoP = txtApellidoP.getText().trim();
            String apellidoM = txtApellidoM.getText().trim();
            String nombre = txtNombre.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String password = dni;
            password = ENC.SHA256(password);
            String sexo = (String) comboSexo.getSelectedItem();
            int edad = (int) SpinnerEdad.getValue();
            String oficio = txtOficio.getText().trim();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaNacimiento = formato.format(jdcFechaNacimiento.getDate());

            if(UsuarioDAO.getInstancia().buscarUsuario(dni)==null && ApoderadoDAO.getInstancia().buscar(dni)==null){
                SecretariaDAO.getInstancia().insertar(dni,password,nombre,apellidoP,apellidoM,sexo,edad,telefono,fechaNacimiento, oficio);
                limpiarEntradas();
                mostrarTabla(modelo);
                JOptionPane.showMessageDialog(null, "Secretaria Registrada. \nContraseña asignada por defecto es el DNI", "Advertencia", 1);
            }else{
                JOptionPane.showMessageDialog(null, "DNI ya existente en el registro", "Advertencia", 2);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Datos inválidos en la entrada", "Advertencia", 0);
            System.out.println("ERROR: "+ e.getMessage());
        }catch(NoSuchAlgorithmException e){
            System.out.println("ERROR: "+e.getMessage());
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

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

    private void btnRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarActionPerformed
        limpiarEntradas();
        desHabilitar();
        txtDni.setEnabled(true);
        txtDni.requestFocus();
    }//GEN-LAST:event_btnRestaurarActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        String telefono = txtTelefono.getText();

        if(!Character.isDigit(c)){
            evt.consume();
        }
        if(telefono.length()==9)
        evt.consume();
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtApellidoMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoMKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        String ap_m = txtApellidoM.getText();
        if(!Character.isLetter(c) && !Character.isWhitespace(c)){
            evt.consume();
        }
        if(ap_m.length() == 30)
        evt.consume();
    }//GEN-LAST:event_txtApellidoMKeyTyped

    private void txtApellidoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoPKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        String ap_p = txtApellidoP.getText();
        if(!Character.isLetter(c) && !Character.isWhitespace(c)){
            evt.consume();
        }
        if(ap_p.length() == 30)
        evt.consume();
    }//GEN-LAST:event_txtApellidoPKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        String nombre = txtNombre.getText();
        if(!Character.isLetter(c) && !Character.isWhitespace(c)){
            evt.consume();
        }
        if(nombre.length() == 40)
        evt.consume();
    }//GEN-LAST:event_txtNombreKeyTyped

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
//            java.util.logging.Logger.getLogger(DialogSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogSecretaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogSecretaria dialog = new DialogSecretaria();
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
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnReestablecer;
    private javax.swing.JButton btnRestaurar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JDateChooser jdcFechaNacimiento;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlRe;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOficio;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
