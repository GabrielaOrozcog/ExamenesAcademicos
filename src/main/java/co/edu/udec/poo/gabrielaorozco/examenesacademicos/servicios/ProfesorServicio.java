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
    
    List<Profesor> getAllProfesores();
    
    Profesor getProfesorById(Integer id);
    
    Profesor createProfesor(Profesor profesor);
    
    Profesor updateProfesor(Integer id, Profesor profesorDetails);
    
    void deleteProfesor(Integer id);
}
