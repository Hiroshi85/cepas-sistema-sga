/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import datos.ListaBimestre;
import java.util.ArrayList;

/**
 *
 * @author Piero
 */
public class Alumno extends Usuario {
    
    private String observacion;
    private Apoderado apoderado;
    private ListaBimestre lista;

    public Alumno() {
        lista = new ListaBimestre();
    }
    
    public Alumno(String dni, String password, String nombre, String apellido_p, String apellido_m, String sexo, int edad, String telefono, String fecha_nacimiento,
            String observacion,  Apoderado apoderado) 
    {
        super(dni, password, nombre, apellido_p, apellido_m, sexo, edad, telefono, fecha_nacimiento);
        this.observacion = observacion;
        this.apoderado = apoderado;
        lista=new ListaBimestre();
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Apoderado getApoderado() {
        return apoderado;
    }

    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    public ListaBimestre getLista() {
        return lista;
    }

    public void setLista(ListaBimestre lista) {
        this.lista = lista;
    }



}
