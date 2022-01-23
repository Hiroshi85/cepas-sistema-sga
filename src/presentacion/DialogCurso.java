/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.*;
import datos.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Builder.*;
/**
 *
 * @author Piero
 */
public class DialogCurso extends javax.swing.JDialog {

    Docente d = null;
    Grado g = null;
    Curso c;
    ArrayList <Curso> l = null;
    String idbusc;
    DirectorBuilderCurso director;
    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    
    public void mostrar(){
        try {
            l = CursoDAO.getInstancia().mostrarCursos();
        } catch (SQLException ex) {
            Logger.getLogger(DialogCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        CursoDAO.getInstancia().mostrar(l, modelo);
    }
    
    public DialogCurso() {
        super(FrmInicioSecretaria.getInstancia(),true);
        initComponents();
        mostrar();
        setLocationRelativeTo(null);
        director = DirectorBuilderCurso.getInstancia();
    }
    
    
    public void limpiar(){
        txtDiasSemana.setText("");
        txtIdCurso.setText("");
        txtDocente.setText("");
        txtnHoras.setText("");
        cboTipoCurso.setSelectedIndex(0);
        txtGrado.setText("");
        txtIdGrado.setText("");
        txtSeccion.setText("");
        txtNombre.setText("");
        txtIdCurso.requestFocus();
    }
    
    public void habilitar(){
        btnConsultar.setEnabled(false);
        btnRegistrar.setEnabled(false);
        txtIdCurso.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    public void deshabilitar(){
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtIdCurso.setEnabled(true);
        btnRegistrar.setEnabled(true);
        btnConsultar.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jLabel9 = new javax.swing.JLabel();
        pnlBack = new javax.swing.JPanel();
        pnlSide = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        pnlRed = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cboMostrarPorGrado = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDiasSemana = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtDocente = new javax.swing.JTextField();
        btnBuscarDocente = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtSeccion = new javax.swing.JTextField();
        txtIdGrado = new javax.swing.JTextField();
        btnBuscarGrado = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtIdCurso = new javax.swing.JTextField();
        txtnHoras = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboTipoCurso = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jButton5.setText("jButton5");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(25, 0, 58));
        jLabel9.setText("Usuario");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBack.setBackground(new java.awt.Color(231, 235, 244));
        pnlBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSide.setBackground(new java.awt.Color(26, 2, 58));

        javax.swing.GroupLayout pnlSideLayout = new javax.swing.GroupLayout(pnlSide);
        pnlSide.setLayout(pnlSideLayout);
        pnlSideLayout.setHorizontalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlSideLayout.setVerticalGroup(
            pnlSideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        pnlBack.add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 770));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        jLabel1.setText("CURSOS");
        pnlBack.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 220, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon_Cursos.png"))); // NOI18N
        pnlBack.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 90, 90));

        jPanel6.setBackground(new java.awt.Color(196, 36, 45));
        pnlBack.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 130, -1));

        pnlRed.setBackground(new java.awt.Color(194, 36, 45));
        pnlRed.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save_37110.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(null);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setMinimumSize(new java.awt.Dimension(200, 200));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlRed.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 50));

        btnConsultar.setBackground(new java.awt.Color(255, 255, 255));
        btnConsultar.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        btnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Consulta.png"))); // NOI18N
        btnConsultar.setText("BUSCAR");
        btnConsultar.setBorder(null);
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.setMinimumSize(new java.awt.Dimension(200, 200));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnlRed.add(btnConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 180, 50));

        btnEliminar.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-Delete.png"))); // NOI18N
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
        pnlRed.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 50));

        btnActualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnActualizar.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
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
        pnlRed.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 180, 50));

        btnLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-clean.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.setBorder(null);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setMinimumSize(new java.awt.Dimension(200, 200));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        pnlRed.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 180, 50));

        jTable1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jTable1.setModel(modelo);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        pnlRed.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 980, 390));

        cboMostrarPorGrado.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        cboMostrarPorGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Seleccionar>", "1", "2", "3", "4", "5" }));
        cboMostrarPorGrado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboMostrarPorGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMostrarPorGradoActionPerformed(evt);
            }
        });
        pnlRed.add(cboMostrarPorGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 170, 40));

        jLabel21.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Mostrar por grado");
        pnlRed.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, -1, -1));

        pnlBack.add(pnlRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 1270, 500));

        txtNombre.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        pnlBack.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 200, -1));

        txtDiasSemana.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtDiasSemana.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDiasSemana.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDiasSemanaKeyTyped(evt);
            }
        });
        pnlBack.add(txtDiasSemana, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 70, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 0, 58));
        jLabel10.setText("GRADO Y SECCION");
        pnlBack.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(25, 0, 58));
        jLabel14.setText("Docente");
        pnlBack.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(26, 2, 58));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDocente.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtDocente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtDocente.setEnabled(false);
        txtDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(txtDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, -1));

        btnBuscarDocente.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-selecc.png"))); // NOI18N
        btnBuscarDocente.setText("SELECCIONAR");
        btnBuscarDocente.setBorder(null);
        btnBuscarDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDocenteActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscarDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 160, 40));

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DNI");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        pnlBack.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 220, 140));

        jPanel5.setBackground(new java.awt.Color(26, 2, 58));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSeccion.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtSeccion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSeccion.setEnabled(false);
        jPanel5.add(txtSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 95, -1));

        txtIdGrado.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtIdGrado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIdGrado.setEnabled(false);
        jPanel5.add(txtIdGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 136, -1));

        btnBuscarGrado.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscarGrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-selecc.png"))); // NOI18N
        btnBuscarGrado.setText("SELECCIONAR");
        btnBuscarGrado.setBorder(null);
        btnBuscarGrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarGradoActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscarGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 180, 40));

        jLabel12.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ID");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SECCIÓN");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        txtGrado.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtGrado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtGrado.setEnabled(false);
        jPanel5.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 136, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("GRADO");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        pnlBack.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, 300, 190));

        txtIdCurso.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtIdCurso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIdCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCursoActionPerformed(evt);
            }
        });
        txtIdCurso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdCursoKeyTyped(evt);
            }
        });
        pnlBack.add(txtIdCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 150, -1));

        txtnHoras.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        txtnHoras.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtnHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnHorasActionPerformed(evt);
            }
        });
        txtnHoras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnHorasKeyTyped(evt);
            }
        });
        pnlBack.add(txtnHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 70, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel11.setText("NOMBRE");
        pnlBack.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        cboTipoCurso.setBackground(new java.awt.Color(231, 235, 244));
        cboTipoCurso.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        cboTipoCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elemental", "Formativo", "Taller" }));
        cboTipoCurso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cboTipoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoCursoActionPerformed(evt);
            }
        });
        pnlBack.add(cboTipoCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 150, 40));

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel16.setText("TIPO");
        pnlBack.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, -1, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel17.setText("ID");
        pnlBack.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel18.setText("DÍAS A LA SEMANA");
        pnlBack.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        jLabel19.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel19.setText("NÚMERO DE HORAS");
        pnlBack.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        getContentPane().add(pnlBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1300, 770));

        setSize(new java.awt.Dimension(1312, 813));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String generarId(){
        ArrayList <Curso> lista = new ArrayList<>();
        try {
            lista = CursoDAO.getInstancia().mostrarCursos();
        } catch (SQLException ex) {
            System.out.println("Error SQL. Detalles: "+ex.getMessage());
        }
        int tamaño=lista.size();
        int aux;
        aux = tamaño;//Considerando que se le aumenta el elemento :v
        int orden=0;
        if(aux==0) orden=1;
        while (aux!=0){
            aux=aux/10;
            orden=orden+1;
        } //determino si es de 1,2,3 o 4 cifras
        String id="CUR";
        //CUR0000010
        for (int i = 0; i<10-3-orden;i++)//añade ceros hasta el tamaño menos el orden y los 3 caracteres de CUR
            id+="0";
        id+=String.valueOf(tamaño);
        return id;
    }
    
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        try {
            Curso x = null;
            String idCurso = generarId();
            String nombre = txtNombre.getText().trim();
            int nhoras = Integer.parseInt(txtnHoras.getText());
            int diasemana = Integer.parseInt(txtDiasSemana.getText());
            String tipo = cboTipoCurso.getSelectedItem().toString().trim();
            System.out.println(tipo);
            switch(tipo){
                case "Elemental":
                    BuilderCurso cursoElemental = new BuilderCursoElemental();
                    director.setBuilderCurso(cursoElemental);
                    director.construirCurso(idCurso, nombre, d, diasemana, nhoras, g);
                    x = director.getCurso();
                    System.out.println(x.getTipo());
                    break;
                    
                case "Formativo":
                    BuilderCurso cursoFormativo = new BuilderCursoFormativo();
                    director.setBuilderCurso(cursoFormativo);
                    director.construirCurso(idCurso, nombre, d, diasemana, nhoras, g);
                    x = director.getCurso();
                    break;
                    
                case "Taller":
                    BuilderCurso cursoTaller = new BuilderCursoTaller();
                    director.setBuilderCurso(cursoTaller);
                    director.construirCurso(idCurso, nombre, d, diasemana, nhoras, g);
                    x = director.getCurso();
                    break;
                default:
                    System.out.println("Esto no debe ocurrir");
            }
            CursoDAO.getInstancia().insertarCurso(x);
            JOptionPane.showMessageDialog(this,"Curso registrado correctamente.");
            mostrar();
            limpiar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void cboTipoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoCursoActionPerformed

    private void btnBuscarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDocenteActionPerformed
        DialogDocentes f = new DialogDocentes(); 
        f.setVisible(true); 
         
        try { 
            d = DocenteDAO.getInstancia().buscarDocente(f.docenteSelec.getDni().trim()); 
            txtDocente.setText(d.getDni());
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
        } catch(NullPointerException e){
            System.out.println("Excepcion en BuscarDocente");
        }
        
    }//GEN-LAST:event_btnBuscarDocenteActionPerformed

    private void txtDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocenteActionPerformed

    private void btnBuscarGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarGradoActionPerformed
        DialogGrado f = new DialogGrado(); 
        f.setVisible(true); 
        try{ 
            g=GradoDAO.getInstancia().buscarGrado(f.gradoSelec.getIdGrado().trim()); 
            txtGrado.setText(String.valueOf(g.getNumGrado())); 
            txtSeccion.setText(g.getSeccion());
            txtIdGrado.setText(g.getIdGrado());
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage()); 
        } catch(NullPointerException e){
            System.out.println("NullPointerExcepcion");
        }
        
    }//GEN-LAST:event_btnBuscarGradoActionPerformed

    private void txtnHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnHorasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnHorasActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
        deshabilitar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        idbusc = txtIdCurso.getText().trim();
        try {
            if (idbusc.equals("")) {
                JOptionPane.showMessageDialog(null, "Ingrese el código del curso");
            } else {
                c = CursoDAO.getInstancia().buscarCurso(idbusc);
                if (c != null) {
                    g = c.getGrado();
                    d = c.getDocente();
                    System.out.println(g.getIdGrado());
                    System.out.println("DOCENTE: "+d.getDni());
                    txtIdCurso.setText(c.getIdCurso());
                    txtNombre.setText(c.getNombre());
                    txtDiasSemana.setText(String.valueOf(c.getDiaSemana()));
                    txtnHoras.setText(String.valueOf(c.getnHoras()));
                    txtDocente.setText(c.getDocente().getDni());
                    cboTipoCurso.setSelectedItem(c.getTipo());
                    txtIdGrado.setText(g.getIdGrado());
                    txtGrado.setText(String.valueOf(c.getGrado().getNumGrado()));
                    txtSeccion.setText(c.getGrado().getSeccion());
                    
                    habilitar();
                } else {
                    JOptionPane.showMessageDialog(null, "Curso no encontrado");
                    limpiar();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(),"",0);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
                CursoDAO.getInstancia().eliminarCurso(idbusc);
                JOptionPane.showMessageDialog(this,"Curso eliminado correctamente.");
                limpiar();
                deshabilitar();
                mostrar();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Acción restringida: No se puede eliminar un curso en la cuál hay alumnos matriculado", "Advertencia", 0);
            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        try {
            String idCurso = txtIdCurso.getText().trim();
            
            String nombre = txtNombre.getText().trim();
            int nhoras = Integer.parseInt(txtnHoras.getText().trim());
            int diasemana = Integer.parseInt(txtDiasSemana.getText().trim());
            String tipo = cboTipoCurso.getSelectedItem().toString();
            Curso x = new Curso(idCurso, nombre, d, tipo, diasemana, nhoras, g);
            CursoDAO.getInstancia().actualizarCurso(x, idbusc);
            JOptionPane.showMessageDialog(this,"Curso actualizado correctamente.");
            limpiar();
            deshabilitar();
            mostrar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtIdCursoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCursoKeyTyped
        // TODO add your handling code here:
        if (txtIdCurso.getText().length()==10){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtIdCursoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        if (txtNombre.getText().length()==45){
            evt.consume(); 
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtIdCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCursoActionPerformed

    private void cboMostrarPorGradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMostrarPorGradoActionPerformed
        try {
            switch(cboMostrarPorGrado.getSelectedIndex()){
                case 0: CursoDAO.getInstancia().mostrar(CursoDAO.getInstancia().mostrarCursos(), modelo); break;
                case 1: CursoDAO.getInstancia().mostrar(CursoDAO.getInstancia().mostrarPorGradoNumero(1), modelo); break;
                case 2: CursoDAO.getInstancia().mostrar(CursoDAO.getInstancia().mostrarPorGradoNumero(2), modelo); break;
                case 3: CursoDAO.getInstancia().mostrar(CursoDAO.getInstancia().mostrarPorGradoNumero(3), modelo); break;
                case 4: CursoDAO.getInstancia().mostrar(CursoDAO.getInstancia().mostrarPorGradoNumero(4), modelo); break;
                case 5: CursoDAO.getInstancia().mostrar(CursoDAO.getInstancia().mostrarPorGradoNumero(5), modelo); break;
            }
         
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }//GEN-LAST:event_cboMostrarPorGradoActionPerformed

    private void txtnHorasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnHorasKeyTyped
        char c=evt.getKeyChar();
        int punto=txtnHoras.getText().indexOf(".")+1;
        if(punto==0){
            if(!Character.isDigit(c) && c!='.')
               evt.consume();
        }
        else{
              if(!Character.isDigit(c))
                 evt.consume();
            }
    }//GEN-LAST:event_txtnHorasKeyTyped

    private void txtDiasSemanaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiasSemanaKeyTyped
        char c=evt.getKeyChar();
        String id = txtDiasSemana.getText();
        
        if(!Character.isDigit(c)){
             evt.consume();
         }
        if(id.length()==1)
            evt.consume();
    }//GEN-LAST:event_txtDiasSemanaKeyTyped

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
//            java.util.logging.Logger.getLogger(DialogCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogCurso dialog = new DialogCurso();
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
    private javax.swing.JButton btnBuscarDocente;
    private javax.swing.JButton btnBuscarGrado;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboMostrarPorGrado;
    private javax.swing.JComboBox<String> cboTipoCurso;
    private javax.swing.JButton jButton5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlRed;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JTextField txtDiasSemana;
    private javax.swing.JTextField txtDocente;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtIdCurso;
    private javax.swing.JTextField txtIdGrado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSeccion;
    private javax.swing.JTextField txtnHoras;
    // End of variables declaration//GEN-END:variables
}
