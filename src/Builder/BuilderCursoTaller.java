/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import entidad.Docente;
import entidad.Grado;

/**
 *
 * @author hiro
 */
public class BuilderCursoTaller extends BuilderCurso{
    
    private static BuilderCursoTaller instancia;
    
    public static BuilderCursoTaller getInstancia(){
        if(instancia ==null)
            instancia = new BuilderCursoTaller();
        return instancia;
    }
    
    @Override
    public void agregarIdCurso(String idCurso) {
        curso.setIdCurso(idCurso);
    }

    @Override
    public void agregarNombre(String nombre) {
        curso.setNombre(nombre);
    }

    @Override
    public void agregarDocente(Docente docente) {
        curso.setDocente(docente);
    }

    @Override
    public void agregarTipo() {
        curso.setTipo("Taller");
    }

    @Override
    public void agregarDiaSemana(int diaSemana) {
        curso.setDiaSemana(diaSemana);
    }

    @Override
    public void agregarnHoras(int nHoras) {
        curso.setnHoras(nHoras);
    }

    @Override
    public void agregarGrado(Grado grado) {
        curso.setGrado(grado);
    }
    
}
