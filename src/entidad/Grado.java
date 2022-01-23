/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author Johann
 */
public class Grado {
    private String idGrado;
    private int numGrado;
    private int vacantes;
    private String seccion;

    public Grado(String idGrado) {
        this.idGrado = idGrado;
    }

    public Grado() {
    }
    
    
    public Grado(String idGrado, int numGrado, int vacantes, String seccion) {
        this.idGrado = idGrado;
        this.numGrado = numGrado;
        this.vacantes = vacantes;
        this.seccion = seccion;
    }

    public String getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(String idGrado) {
        this.idGrado = idGrado;
    }

    public int getNumGrado() {
        return numGrado;
    }

    public void setNumGrado(int numGrado) {
        this.numGrado = numGrado;
    }

    public int getVacantes() {
        return vacantes;
    }

    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    
}
