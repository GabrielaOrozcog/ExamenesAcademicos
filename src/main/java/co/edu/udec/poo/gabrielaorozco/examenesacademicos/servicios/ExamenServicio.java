/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Examen;

/**
 *
 * @author Gabriel
 */

public interface ExamenServicio {
    
    List<Examen> getAllExamenes();
    
    Examen getExamenById(Integer id);
    
    Examen createExamen(Examen examen);
    
    Examen updateExamen(Integer id, Examen examenDetails);
    
    void deleteExamen(Integer id);
}
