/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;

/**
 *
 * @author Gabriela
 */

public interface CursoServicio {
    
    List<Curso> getAllCursos() throws Exception;
    
    Curso getCursoById(Integer id) throws Exception;
    
    Curso createCurso(Curso curso) throws Exception;
    
    Curso updateCurso(Integer id, Curso cursoDetails) throws Exception;
    
    void deleteCurso(Integer id) throws Exception;
    
    Integer contarCursos() throws Exception;
}
