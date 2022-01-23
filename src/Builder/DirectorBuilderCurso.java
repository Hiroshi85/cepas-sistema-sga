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
public class DirectorBuilderCurso {
    private static DirectorBuilderCurso instancia;
    public static DirectorBuilderCurso getInstancia(){
        if(instancia==null)
            instancia=new DirectorBuilderCurso();
        return instancia;
    }
    
    private BuilderCurso builderCurso;
    public void setBuilderCurso(BuilderCurso bc){
        builderCurso = bc;
    }
    
    public Curso getCurso(){
        return builderCurso.getCurso();
    }
    
    public void construirCurso(String idCurso, String nombre, Docente docente, int diaSemana, 
            int nHoras, Grado grado){
        builderCurso.crearNuevoCurso();
        builderCurso.agregarIdCurso(idCurso);
        builderCurso.agregarNombre(nombre);
        builderCurso.agregarDocente(docente);
        builderCurso.agregarTipo();
        builderCurso.agregarDiaSemana(diaSemana);
        builderCurso.agregarnHoras(nHoras);
        builderCurso.agregarGrado(grado);
    }
    
}
