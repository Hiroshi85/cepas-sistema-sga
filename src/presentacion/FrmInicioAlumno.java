/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import entidad.*;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hiro
 */
public class FrmInicioAlumno extends javax.swing.JFrame {
    int xCursor, yCursor;
    Alumno alumnolog = null;
    /**
     * Creates new form FrmInicioSecretaria
     */
    private static FrmInicioAlumno instancia;
    public static FrmInicioAlumno getInstancia(){
        if(instancia==null)
            instancia=new FrmInicioAlumno();
        return instancia;
    }
    public FrmInicioAlumno() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon iconoFrm = new ImageIcon(getClass().getResource("/img/logoPrincipal.png"));
        this.setIconImage(iconoFrm.getImage()); 
    }
    public void setAlumnoLog(Alumno a){
        alumnolog = a;
        lblNombreAlumno.setText(alumnolog.apellidosYNombres());
    }
//    public void setScaledPhoto(JLabel lbl, String route){
//        ImageIcon img = new ImageIcon(route);
//        Icon icono = new ImageIcon(img.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), 1));
//        lbl.setIcon(icono);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBack = new javax.swing.JPanel();
        pnlUpper = new javax.swing.JPanel();
        pnlMin = new javax.swing.JPanel();
        lblMin = new javax.swing.JLabel();
        pnlExit = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        lblNombreAlumno = new javax.swing.JLabel();
        pnlSide = new javax.swing.JPanel();
        pnlPerfil = new javax.swing.JPanel();
        lblSecretaria = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlLinea = new javax.swing.JPanel();
        pnlRecord = new javax.swing.JPanel();
        lblGrado = new javax.swing.JLabel();
        pnlMatriculas = new javax.swing.JPanel();
        lblCurso = new javax.swing.JLabel();
        pnlNotas = new javax.swing.JPanel();
        lblDocente = new javax.swing.JLabel();
        pnlCerrarSesion = new javax.swing.JPanel();
        lblAlumno = new javax.swing.JLabel();
        lblEstIni = new javax.swing.JLabel();
        lblLogoMenu = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlBack.setBackground(new java.awt.Color(26, 2, 58));
        pnlBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlUpper.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlUpperMouseDragged(evt);
            }
        });
        pnlUpper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlUpperMousePressed(evt);
            }
        });
        pnlUpper.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMin.setBackground(new java.awt.Color(255, 255, 255));
        pnlMin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMin.setFont(new java.awt.Font("Yu Gothic", 0, 16)); // NOI18N
        lblMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMin.setText("_");
        lblMin.setToolTipText("");
        lblMin.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMinMouseExited(evt);
            }
        });
        pnlMin.add(lblMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        pnlUpper.add(pnlMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(885, 0, 70, 30));

        pnlExit.setBackground(new java.awt.Color(255, 255, 255));
        pnlExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblExit.setBackground(new java.awt.Color(255, 255, 255));
        lblExit.setFont(new java.awt.Font("Yu Gothic", 0, 16)); // NOI18N
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setText("X");
        lblExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExitMouseExited(evt);
            }
        });
        pnlExit.add(lblExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        pnlUpper.add(pnlExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 70, 40));

        lblNombreAlumno.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 13)); // NOI18N
        lblNombreAlumno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombreAlumno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlUpper.add(lblNombreAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 510, 30));

        pnlBack.add(pnlUpper, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 30));

        pnlSide.setBackground(new java.awt.Color(255, 255, 255));
        pnlSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlPerfil.setBackground(new java.awt.Color(26, 2, 58));
        pnlPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPerfilMouseExited(evt);
            }
        });

        lblSecretaria.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblSecretaria.setForeground(new java.awt.Color(255, 255, 255));
        lblSecretaria.setText("Perfil de Estudiante");
        lblSecretaria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSecretaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlPerfilLayout = new javax.swing.GroupLayout(pnlPerfil);
        pnlPerfil.setLayout(pnlPerfilLayout);
        pnlPerfilLayout.setHorizontalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPerfilLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblSecretaria)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pnlPerfilLayout.setVerticalGroup(
            pnlPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSecretaria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        pnlSide.add(pnlPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 260, 35));

        lblTitulo.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(26, 2, 58));
        lblTitulo.setText("Menú de control");
        pnlSide.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 190, 40));

        pnlLinea.setBackground(new java.awt.Color(194, 36, 45));

        javax.swing.GroupLayout pnlLineaLayout = new javax.swing.GroupLayout(pnlLinea);
        pnlLinea.setLayout(pnlLineaLayout);
        pnlLineaLayout.setHorizontalGroup(
            pnlLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        pnlLineaLayout.setVerticalGroup(
            pnlLineaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        pnlSide.add(pnlLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 80, 5));

        pnlRecord.setBackground(new java.awt.Color(26, 2, 58));
        pnlRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlRecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlRecordMouseExited(evt);
            }
        });

        lblGrado.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblGrado.setForeground(new java.awt.Color(255, 255, 255));
        lblGrado.setText("Récord Académico");
        lblGrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblGrado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlRecordLayout = new javax.swing.GroupLayout(pnlRecord);
        pnlRecord.setLayout(pnlRecordLayout);
        pnlRecordLayout.setHorizontalGroup(
            pnlRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRecordLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(lblGrado)
                .addGap(56, 56, 56))
        );
        pnlRecordLayout.setVerticalGroup(
            pnlRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGrado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        pnlSide.add(pnlRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 260, 35));

        pnlMatriculas.setBackground(new java.awt.Color(26, 2, 58));
        pnlMatriculas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlMatriculas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMatriculasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlMatriculasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlMatriculasMouseExited(evt);
            }
        });

        lblCurso.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(255, 255, 255));
        lblCurso.setText("Matrícula");
        lblCurso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCurso.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlMatriculasLayout = new javax.swing.GroupLayout(pnlMatriculas);
        pnlMatriculas.setLayout(pnlMatriculasLayout);
        pnlMatriculasLayout.setHorizontalGroup(
            pnlMatriculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMatriculasLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lblCurso)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        pnlMatriculasLayout.setVerticalGroup(
            pnlMatriculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCurso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        pnlSide.add(pnlMatriculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 260, 35));

        pnlNotas.setBackground(new java.awt.Color(26, 2, 58));
        pnlNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlNotasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlNotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlNotasMouseExited(evt);
            }
        });

        lblDocente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblDocente.setForeground(new java.awt.Color(255, 255, 255));
        lblDocente.setText("Notas");
        lblDocente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDocente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlNotasLayout = new javax.swing.GroupLayout(pnlNotas);
        pnlNotas.setLayout(pnlNotasLayout);
        pnlNotasLayout.setHorizontalGroup(
            pnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNotasLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(lblDocente)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        pnlNotasLayout.setVerticalGroup(
            pnlNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblDocente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        pnlSide.add(pnlNotas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 260, 35));

        pnlCerrarSesion.setBackground(new java.awt.Color(26, 2, 58));
        pnlCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCerrarSesionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCerrarSesionMouseExited(evt);
            }
        });

        lblAlumno.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 16)); // NOI18N
        lblAlumno.setForeground(new java.awt.Color(255, 255, 255));
        lblAlumno.setText("Cerrar Sesión");
        lblAlumno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAlumno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout pnlCerrarSesionLayout = new javax.swing.GroupLayout(pnlCerrarSesion);
        pnlCerrarSesion.setLayout(pnlCerrarSesionLayout);
        pnlCerrarSesionLayout.setHorizontalGroup(
            pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCerrarSesionLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(lblAlumno)
                .addGap(80, 80, 80))
        );
        pnlCerrarSesionLayout.setVerticalGroup(
            pnlCerrarSesionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAlumno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        pnlSide.add(pnlCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 260, 35));

        lblEstIni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estIni.png"))); // NOI18N
        pnlSide.add(lblEstIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        pnlBack.add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 660));

        lblLogoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoPrincipal.png"))); // NOI18N
        lblLogoMenu.setText("jLabel1");
        pnlBack.add(lblLogoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, 140, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CepasSinFondo.png"))); // NOI18N
        lblLogo.setText("jLabel1");
        pnlBack.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 230, 210));

        getContentPane().add(pnlBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1040, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPerfilMouseClicked
        DialogAlumnoPerfil ap = new DialogAlumnoPerfil();
        ap.setAlumno(alumnolog);
        ap.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pnlPerfilMouseClicked

    private void pnlPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPerfilMouseEntered
        pnlPerfil.setBackground(new Color(168, 181, 240));
        lblSecretaria.setForeground(new Color(26, 2, 58));
    }//GEN-LAST:event_pnlPerfilMouseEntered

    private void pnlPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPerfilMouseExited
        pnlPerfil.setBackground(new Color(26, 2, 58));
        lblSecretaria.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnlPerfilMouseExited

    private void pnlRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRecordMouseClicked
        DialogRecordAcademicoFromAlumno dra = new DialogRecordAcademicoFromAlumno();
        dra.setA(alumnolog);
        dra.setVisible(true);
    }//GEN-LAST:event_pnlRecordMouseClicked

    private void pnlRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRecordMouseEntered
        pnlRecord.setBackground(new Color(168, 181, 240));
        lblGrado.setForeground(new Color(26, 2, 58));
    }//GEN-LAST:event_pnlRecordMouseEntered

    private void pnlRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRecordMouseExited
        pnlRecord.setBackground(new Color(26, 2, 58));
        lblGrado.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnlRecordMouseExited

    private void pnlUpperMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUpperMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xCursor, y - yCursor);
    }//GEN-LAST:event_pnlUpperMouseDragged

    private void pnlUpperMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUpperMousePressed
        xCursor = evt.getX();
        yCursor = evt.getY();
    }//GEN-LAST:event_pnlUpperMousePressed

    private void lblExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblExitMouseClicked

    private void lblExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseEntered
        pnlExit.setBackground(Color.RED);
        lblExit.setForeground(Color.WHITE);
    }//GEN-LAST:event_lblExitMouseEntered

    private void lblExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitMouseExited
        pnlExit.setBackground(Color.WHITE);
        lblExit.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblExitMouseExited

    private void lblMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_lblMinMouseClicked

    private void lblMinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinMouseEntered
        pnlMin.setBackground(new Color(240,240,240));
        lblMin.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblMinMouseEntered

    private void lblMinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinMouseExited
        pnlMin.setBackground(Color.WHITE);
        lblMin.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblMinMouseExited

    private void pnlMatriculasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMatriculasMouseClicked
        DialogMatriculaFromAlumno dc = new DialogMatriculaFromAlumno();
        dc.setA(alumnolog);
        dc.setVisible(true);
    }//GEN-LAST:event_pnlMatriculasMouseClicked

    private void pnlMatriculasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMatriculasMouseEntered
        pnlMatriculas.setBackground(new Color(168, 181, 240));
        lblCurso.setForeground(new Color(26, 2, 58));
    }//GEN-LAST:event_pnlMatriculasMouseEntered

    private void pnlMatriculasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMatriculasMouseExited
        pnlMatriculas.setBackground(new Color(26, 2, 58));
        lblCurso.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnlMatriculasMouseExited

    private void pnlNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNotasMouseClicked
        DialogAlumnoNotas an = new DialogAlumnoNotas();
        an.setAlumno(alumnolog);
        an.setVisible(true);
    }//GEN-LAST:event_pnlNotasMouseClicked

    private void pnlNotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNotasMouseEntered
        pnlNotas.setBackground(new Color(168, 181, 240));
        lblDocente.setForeground(new Color(26, 2, 58));
    }//GEN-LAST:event_pnlNotasMouseEntered

    private void pnlNotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlNotasMouseExited
        pnlNotas.setBackground(new Color(26, 2, 58));
        lblDocente.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnlNotasMouseExited

    private void pnlCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarSesionMouseClicked
        alumnolog = null;
        this.dispose();
        FrmLogin l = new FrmLogin();
        l.setUsuario(null);
        l.setVisible(true);
        
   
    }//GEN-LAST:event_pnlCerrarSesionMouseClicked

    private void pnlCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarSesionMouseEntered
        pnlCerrarSesion.setBackground(new Color(168, 181, 240));
        lblAlumno.setForeground(new Color(26, 2, 58));
    }//GEN-LAST:event_pnlCerrarSesionMouseEntered

    private void pnlCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarSesionMouseExited
        pnlCerrarSesion.setBackground(new Color(26, 2, 58));
        lblAlumno.setForeground(Color.WHITE);
    }//GEN-LAST:event_pnlCerrarSesionMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmInicioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmInicioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmInicioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmInicioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmInicioAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAlumno;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblDocente;
    private javax.swing.JLabel lblEstIni;
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblGrado;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogoMenu;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblNombreAlumno;
    private javax.swing.JLabel lblSecretaria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBack;
    private javax.swing.JPanel pnlCerrarSesion;
    private javax.swing.JPanel pnlExit;
    private javax.swing.JPanel pnlLinea;
    private javax.swing.JPanel pnlMatriculas;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JPanel pnlNotas;
    private javax.swing.JPanel pnlPerfil;
    private javax.swing.JPanel pnlRecord;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JPanel pnlUpper;
    // End of variables declaration//GEN-END:variables
}
