/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import entidad.Curso;
import entidad.Docente;
import entidad.Grado;


/**
 *
 * @author hiro
 */
public abstract class BuilderCurso {
    protected Curso curso;
    
    public Curso getCurso(){
        return curso;
    }
    
    public void crearNuevoCurso(){
        curso = new Curso();
    }
    
    public abstract void agregarIdCurso(String idCurso);
    public abstract void agregarNombre(String nombre);
    public abstract void agregarDocente(Docente docente);
    public abstract void agregarTipo();
    public abstract void agregarDiaSemana(int diaSemana);
    public abstract void agregarnHoras(int nHoras);
    public abstract void agregarGrado(Grado grado);
    
    
    
}
