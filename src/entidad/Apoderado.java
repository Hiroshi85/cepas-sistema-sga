/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author despa
 */
public class Apoderado {
    private String dni;//8
    private String nombre;//40
    private String ap_p;//30
    private String telefono;//45
    private String parentesco;//30
    public Apoderado(){
    }

    public Apoderado(String dni, String nombre, String ap_p, String telefono, String parentesco) {
        this.dni = dni;
        this.nombre = nombre;
        this.ap_p = ap_p;
        this.telefono = telefono;
        this.parentesco = parentesco;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_p() {
        return ap_p;
    }

    public void setAp_p(String ap_p) {
        this.ap_p = ap_p;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
