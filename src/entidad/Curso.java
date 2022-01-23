/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;



/**
 *
 * @author Piero
 */
public class Curso {
 
    private String idCurso;
    private String nombre;
    private Docente docente;
    private String tipo;
    private int diaSemana;
    private int nHoras;
    private Grado grado;

    public Curso() {
    }
    
    
    public Curso(String idCurso, String nombre, Docente docente, String tipo, int diaSemana, int nHoras, Grado grado) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.docente = docente;
        this.tipo = tipo;
        this.diaSemana = diaSemana;
        this.nHoras = nHoras;
        this.grado = grado;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getnHoras() {
        return nHoras;
    }

    public void setnHoras(int nHoras) {
        this.nHoras = nHoras;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    

    
}
