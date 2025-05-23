/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;

/**
 *
 * @author Gabriela
 */
public interface AlumnoServicio {
    
    List<Alumno> getAllAlumnos() throws Exception;
    
    Alumno getAlumnoById(Integer id) throws Exception;
    
    Alumno createAlumno(Alumno alumno) throws Exception;
    
    Alumno updateAlumno(Integer id, Alumno alumnoDetails) throws Exception;
    
    void deleteAlumno(Integer id) throws Exception;
    
    Integer contarAlumnos() throws Exception;
}
