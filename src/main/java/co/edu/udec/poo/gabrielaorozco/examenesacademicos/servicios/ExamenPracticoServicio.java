/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenPractico;

/**
 *
 * @author Gabriela
 */
        
public interface ExamenPracticoServicio {
    
    List<ExamenPractico> getAllExamenesPracticos() throws Exception;
    
    ExamenPractico getExamenPracticoById(Integer id) throws Exception;
    
    ExamenPractico createExamenPractico(ExamenPractico examenPractico) throws Exception;
    
    ExamenPractico updateExamenPractico(Integer id, ExamenPractico examenPracticoDetails) throws Exception;
    
    void deleteExamenPractico(Integer id) throws Exception;
    
    Integer contarExamenesPracticos() throws Exception;
}
