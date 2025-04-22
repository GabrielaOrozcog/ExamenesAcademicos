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
    
    List<Alumno> getAllAlumnos();
    
    Alumno getAlumnoById(Integer id);
    
    Alumno createAlumno(Alumno alumno);
    
    Alumno updateAlumno(Integer id, Alumno alumno);
    
    void deleteAlumno(Integer id);
}
