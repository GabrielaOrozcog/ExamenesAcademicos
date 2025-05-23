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
    
    public List<Examen> getAllExamenes() throws Exception;
    
    Examen getExamenById(Integer id) throws Exception;
    
    Examen createExamen(Examen examen) throws Exception;
    
    Examen updateExamen(Integer id, Examen examenDetails) throws Exception;
    
    void deleteExamen(Integer id) throws Exception;
    
    Integer contarExamenes() throws Exception;
}
