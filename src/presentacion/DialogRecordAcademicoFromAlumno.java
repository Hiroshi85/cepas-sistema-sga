/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import datos.BimestreDAO;
import datos.CursoDAO;
import datos.ListaBimestre;
import datos.MatriculaDAO;
import entidad.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Piero
 */
public class DialogRecordAcademicoFromAlumno extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    Alumno a = null;
    Matricula m = null;
    ArrayList <Curso> listaCursos = new ArrayList<>();
    ArrayList <Curso> cursos = new ArrayList<>();
    ListaBimestre listaBimestre;
    Curso cursoSelec;
    
    public DialogRecordAcademicoFromAlumno() {
        super(FrmInicioSecretaria.getInstancia(),true);
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void iniciar()
    {
        try {
            m=MatriculaDAO.getInstancia().buscarMatriculaPorDniAlumno(a.getDni());
            MatriculaDAO.getInstancia().notaFinal(m, modelo);
            listaCursos = CursoDAO.getInstancia().mostrarPorGrado(m.getGrado().getIdGrado());
            mostrarDatos();
        } catch (SQLException ex) {
            Logger.getLogger(DialogRecordAcademicoFromAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setA(Alumno a) {
        this.a = a;
        iniciar();
    }

    public void mostrarDatos(){
        Alumno x = m.getAlumno();
        txtIdMatricula.setText(m.getId());
        txtDni.setText(x.getDni());
        txtNombre.setText(x.getNombre()+" "+x.getApellido_p()+" "+x.getApellido_m());
        txtNumGrado1.setText(String.valueOf(m.getGrado().getNumGrado()));
        txtSeccion1.setText(m.getGrado().getSeccion());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSide = new javax.swing.JPanel();
        btnImprimirMatricula = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtIdMatricula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtNumGrado1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtSeccion1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSalir4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnlSide1 = new javax.swing.JPanel();
        btnImprimirMatricula1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSide.setBackground(new java.awt.Color(230, 233, 242));
        pnlSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnImprimirMatricula.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimirMatricula.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnImprimirMatricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-reporte.png"))); // NOI18N
        btnImprimirMatricula.setText("REPORTE");
        btnImprimirMatricula.setBorder(null);
        btnImprimirMatricula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImprimirMatricula.setMinimumSize(new java.awt.Dimension(200, 200));
        btnImprimirMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirMatriculaActionPerformed(evt);
            }
        });
        pnlSide.add(btnImprimirMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 790, 180, 40));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        jLabel3.setText("RECORD ACADÉMICO 2022");
        pnlSide.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 620, 50));

        jLabel10.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 0, 58));
        pnlSide.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        jPanel7.setBackground(new java.awt.Color(24, 2, 56));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtIdMatricula.setEditable(false);
        txtIdMatricula.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtIdMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIdMatricula.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtIdMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdMatriculaActionPerformed(evt);
            }
        });
        txtIdMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdMatriculaKeyTyped(evt);
            }
        });
        jPanel7.add(txtIdMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 370, 40));

        txtNombre.setEditable(false);
        txtNombre.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 370, 40));

        txtDni.setEditable(false);
        txtDni.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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
        jPanel7.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 370, 40));

        jLabel24.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("NOMBRE DEL ALUMNO");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel25.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ID MATRICULA");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel27.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("DNI ALUMNO");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel32.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("GRADO");
        jPanel7.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 20));

        txtNumGrado1.setEditable(false);
        txtNumGrado1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtNumGrado1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumGrado1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNumGrado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumGrado1ActionPerformed(evt);
            }
        });
        jPanel7.add(txtNumGrado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 370, 40));

        jLabel33.setFont(new java.awt.Font("Yu Gothic Medium", 1, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("SECCIÓN:");
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        txtSeccion1.setEditable(false);
        txtSeccion1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        txtSeccion1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSeccion1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSeccion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeccion1ActionPerformed(evt);
            }
        });
        jPanel7.add(txtSeccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 370, 40));

        pnlSide.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 870, 280));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-matricula.png"))); // NOI18N
        pnlSide.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, -1, -1));

        btnSalir4.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir4.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnSalir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon-salir.png"))); // NOI18N
        btnSalir4.setText("SALIR");
        btnSalir4.setBorder(null);
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });
        pnlSide.add(btnSalir4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 790, 180, 40));
        pnlSide.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 210, -1, -1));

        jPanel2.setBackground(new java.awt.Color(194, 36, 45));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        jTable1.setModel(modelo
        );
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(22);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 960, 330));

        pnlSide.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 1000, 370));

        pnlSide1.setBackground(new java.awt.Color(26, 2, 58));
        pnlSide.add(pnlSide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 900));

        btnImprimirMatricula1.setBackground(new java.awt.Color(255, 255, 255));
        btnImprimirMatricula1.setFont(new java.awt.Font("Yu Gothic Medium", 0, 13)); // NOI18N
        btnImprimirMatricula1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grafico-de-barras.png"))); // NOI18N
        btnImprimirMatricula1.setText("GRÁFICOS");
        btnImprimirMatricula1.setBorder(null);
        btnImprimirMatricula1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImprimirMatricula1.setMinimumSize(new java.awt.Dimension(200, 200));
        btnImprimirMatricula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirMatricula1ActionPerformed(evt);
            }
        });
        pnlSide.add(btnImprimirMatricula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 790, 180, 40));

        getContentPane().add(pnlSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirMatriculaActionPerformed
        String destino="Notas_SGA"; // nombre por defecto
        JOptionPane.showMessageDialog(this, "Seleccione ubicación de archivo y el nombre respectivo","Guardar Archivo",1);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
            try {
                destino = fileChooser.getSelectedFile().getCanonicalPath();
                destino+=".pdf";
            } catch (IOException ex) {
                Logger.getLogger(DialogRegistroMatricula.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // CREACION DEL PDF
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(destino));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DialogRegistroMatricula.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(DialogRegistroMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.open();
        
        // FUENTES
        Font fontNegrita_1 = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
        Font fontNormal_1 = new Font(Font.FontFamily.HELVETICA, 20, Font.NORMAL);
        Font fontNegrita_2 = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
        Font fontNormal_2 = new Font(Font.FontFamily.HELVETICA, 16, Font.NORMAL);
        Font fontColumnas = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        
        // TEXTOS
        Paragraph para1 = new Paragraph("Institucion Educativa Privada", fontNegrita_1);
        para1.setAlignment(Element.ALIGN_CENTER);
        Paragraph para2 = new Paragraph("CEPAS", fontNegrita_1);
        para2.setAlignment(Element.ALIGN_CENTER);
        Paragraph para3 = new Paragraph("Boleta de Notas",fontNormal_1);
        para3.setAlignment(Element.ALIGN_CENTER);
        
        Image foto = null;
        try {
            foto = Image.getInstance(getClass().getResource("/img/icon_log.png"));
        } catch (Exception ex2) {
            Logger.getLogger(DialogRegistroMatricula.class.getName()).log(Level.SEVERE, null, ex2);
        }
	foto.setAlignment(Chunk.ALIGN_MIDDLE);
        
        
        Paragraph para5 = new Paragraph("Fecha: ",fontNegrita_2);
        para5.setFont(fontNormal_2);
        para5.add(m.getFecha());
        
        Paragraph para6 = new Paragraph("Alumno: ",fontNegrita_2);
        para6.setFont(fontNormal_2);
        para6.add(m.getAlumno().nombreCompleto());
        para6.setFont(fontNegrita_2);
        para6.add("    DNI: ");
        para6.setFont(fontNormal_2);
        para6.add(m.getAlumno().getDni());
        
        Paragraph para7 = new Paragraph("Grado: ",fontNegrita_2);
        para7.setFont(fontNormal_2);
        para7.add(String.valueOf(m.getGrado().getNumGrado()));
        para7.setFont(fontNegrita_2);
        para7.add("    Sección: ");
        para7.setFont(fontNormal_2);
        para7.add(m.getGrado().getSeccion());

        
        
        // TABLA CURSOS
       double pF=0.00d;
       
       Paragraph para8_2 = new Paragraph("Notas Bimestrales: ",fontNegrita_2);
       PdfPTable tabla = new PdfPTable(7);
        try {
            tabla.setWidths(new float[]{7f,29f,6f,6f,6f,6f,11f});
        } catch (DocumentException ex) {
            Logger.getLogger(DialogRecordAcademicoFromAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
       PdfPCell idCurso = new PdfPCell(new Paragraph("ID",fontColumnas)); 
       PdfPCell nombre = new PdfPCell(new Paragraph("Nombre",fontColumnas));
       PdfPCell n1 = new PdfPCell(new Paragraph("B1",fontColumnas));
       PdfPCell n2 = new PdfPCell(new Paragraph("B2",fontColumnas));
       PdfPCell n3 = new PdfPCell(new Paragraph("B3",fontColumnas));
       PdfPCell n4 = new PdfPCell(new Paragraph("B4",fontColumnas));
       PdfPCell pp = new PdfPCell(new Paragraph("Promedio",fontColumnas));
       idCurso.setMinimumHeight(18);
       idCurso.setHorizontalAlignment(Element.ALIGN_CENTER);
       nombre.setHorizontalAlignment(Element.ALIGN_CENTER);
       n1.setHorizontalAlignment(Element.ALIGN_CENTER);
       n2.setHorizontalAlignment(Element.ALIGN_CENTER);
       n3.setHorizontalAlignment(Element.ALIGN_CENTER);
       n4.setHorizontalAlignment(Element.ALIGN_CENTER);
       pp.setHorizontalAlignment(Element.ALIGN_CENTER);
       tabla.addCell(idCurso);
       tabla.addCell(nombre);
       tabla.addCell(n1);
       tabla.addCell(n2);
       tabla.addCell(n3);
       tabla.addCell(n4);
       tabla.addCell(pp);
       
        try {
            listaBimestre = BimestreDAO.getInstancia().buscar(a.getDni());
        } catch (SQLException ex) {
            Logger.getLogger(DialogRegistroMatricula.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        for (int i = 0; i < listaBimestre.getN(); i+=4)
       {
        double notaPP = (listaBimestre.getElemento(i).getPromedioBimestre()+
                listaBimestre.getElemento(i+1).getPromedioBimestre()+
                listaBimestre.getElemento(i+2).getPromedioBimestre()+
                listaBimestre.getElemento(i+3).getPromedioBimestre())/4;
        
	PdfPCell id = new PdfPCell(new Phrase(listaBimestre.getElemento(i).getCurso().getIdCurso()));
        id.setMinimumHeight(18);
        tabla.addCell(id);
        tabla.addCell(listaBimestre.getElemento(i).getCurso().getNombre());
        tabla.addCell(String.format("%.2f",listaBimestre.getElemento(i).getPromedioBimestre()));
        tabla.addCell(String.format("%.2f",listaBimestre.getElemento(i+1).getPromedioBimestre()));
        tabla.addCell(String.format("%.2f",listaBimestre.getElemento(i+2).getPromedioBimestre()));
        tabla.addCell(String.format("%.2f",listaBimestre.getElemento(i+3).getPromedioBimestre()));
        tabla.addCell(String.format("%.2f",notaPP));
        pF+=notaPP;
       }
        
        pF/=(listaBimestre.getN()/4);
        PdfPCell promF = new PdfPCell(new Paragraph("Promedio General",fontColumnas));
        promF.setColspan(6);
        promF.setHorizontalAlignment(Element.ALIGN_CENTER);
        promF.setMinimumHeight(18);
        tabla.addCell(promF);
        PdfPCell promF2 = new PdfPCell(new Paragraph(String.format("%.2f",pF),fontColumnas));
        tabla.addCell(promF2);
       
       //CONDICION ACADEMICA
       String condicionAcademica = pF >= 10.5 ? "APROBADO" : "REPROBADO";
       Paragraph para8 = new Paragraph(condicionAcademica,fontNegrita_2);
       para8.setAlignment(Element.ALIGN_BOTTOM);
       para8.setAlignment(Element.ALIGN_CENTER);
       Paragraph para9 = new Paragraph("____________________",fontNormal_2);
       para9.setAlignment(Element.ALIGN_BOTTOM);
       para9.setAlignment(Element.ALIGN_CENTER);
       Paragraph para10 = new Paragraph("Condición Académica",fontNormal_2);
       para10.setAlignment(Element.ALIGN_BOTTOM);
       para10.setAlignment(Element.ALIGN_CENTER);
       
       
       // Agregar todos los elementos previamente creados
        try {
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(foto);
            document.add(Chunk.NEWLINE);
            document.add(para5);
            document.add(para6);
            document.add(para7);
            document.add(para8_2);
            document.add(new Paragraph("\n\n"));
            document.add(tabla);
            for (int i = 0; i < 4; i++) {
                document.add(Chunk.NEWLINE);
            }
            document.add(para8);
            document.add(para9);
            document.add(para10);
        } catch (DocumentException ex3) {
            Logger.getLogger(DialogRegistroMatricula.class.getName()).log(Level.SEVERE, null, ex3);
        }
        
        // CERRAR DOCUMENTO y su edicion
        document.close();
        
        // ABRIR ARCHIVO
        File objetofile = new File (destino);
        try {
            Desktop.getDesktop().open(objetofile);
        } catch (IOException ex4) {
            Logger.getLogger(DialogRegistroMatricula.class.getName()).log(Level.SEVERE, null, ex4);
        }
    }//GEN-LAST:event_btnImprimirMatriculaActionPerformed

    private void txtIdMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdMatriculaActionPerformed

    private void txtIdMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdMatriculaKeyTyped
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txtIdMatriculaKeyTyped

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniKeyTyped

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSalir4ActionPerformed

    private void txtNumGrado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumGrado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumGrado1ActionPerformed

    private void txtSeccion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeccion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeccion1ActionPerformed

    private void btnImprimirMatricula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirMatricula1ActionPerformed
        try{
            int i = jTable1.getSelectedRow();
            if(i!=-1){
                cursoSelec = new Curso();
                cursoSelec = CursoDAO.getInstancia().buscarCurso(modelo.getValueAt(i,0).toString());
                DialogAlumnoGraficoNota dagn = new DialogAlumnoGraficoNota(this.cursoSelec, this.m);
                dagn.setVisible(true);
            }else 
                JOptionPane.showMessageDialog(null, "Seleccione un Curso de la tabla para graficar");
            
        }catch(SQLException e){
            System.out.println("Error no debe aparecer: "+e.getMessage());
        }
        
    }//GEN-LAST:event_btnImprimirMatricula1ActionPerformed

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
//            java.util.logging.Logger.getLogger(DialogRecordAcademicoFromAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DialogRecordAcademicoFromAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DialogRecordAcademicoFromAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DialogRecordAcademicoFromAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DialogRecordAcademicoFromAlumno dialog = new DialogRecordAcademicoFromAlumno();
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
    private javax.swing.JButton btnImprimirMatricula;
    private javax.swing.JButton btnImprimirMatricula1;
    private javax.swing.JButton btnSalir4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlSide;
    private javax.swing.JPanel pnlSide1;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIdMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumGrado1;
    private javax.swing.JTextField txtSeccion1;
    // End of variables declaration//GEN-END:variables
}
