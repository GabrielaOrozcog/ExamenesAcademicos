/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;

/**
 *
 * @author Gabriela
 */

public interface ProfesorServicio {
    
    List<Profesor> getAllProfesores() throws Exception;
    
    Profesor getProfesorById(Integer id) throws Exception;
    
    Profesor createProfesor(Profesor profesor) throws Exception;
    
    Profesor updateProfesor(Integer id, Profesor profesorDetails) throws Exception;
    
    void deleteProfesor(Integer id) throws Exception;
    
    Integer contarProfesores() throws Exception;
}
