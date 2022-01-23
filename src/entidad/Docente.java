/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.Objects;

/**
 *
 * @author FAMILY
 */
public class Docente extends Usuario{
    
    private double sueldo;

    public Docente() {
        
    }
        
    public Docente(double sueldo, String dni, String password, String nombre, String apellido_p, String apellido_m, String sexo, int edad, String telefono, String fecha_nacimiento) {
        super(dni,password,nombre,apellido_p,apellido_m,sexo,edad,telefono,fecha_nacimiento);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

  
    
    
    
}
