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
public class Matricula {
    
    private String id;
    private String fecha;
    private Alumno alumno;
    private Grado grado;
    private Secretaria secretaria;

    public Matricula() {
    }

    public Matricula(String id, String fecha, Alumno alumno, Grado grado, Secretaria secretaria) {
        this.id = id;
        this.fecha = fecha;
        this.alumno = alumno;
        this.grado = grado;
        this.secretaria = secretaria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
    
    
}
