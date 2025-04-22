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
    
    List<ExamenPractico> getAllExamenesPracticos();
    
    ExamenPractico getExamenPracticoById(Integer id);
    
    ExamenPractico createExamenPractico(ExamenPractico examenPractico);
    
    ExamenPractico updateExamenPractico(Integer id, ExamenPractico examenDetails);
    
    void deleteExamenPractico(Integer id);
}
