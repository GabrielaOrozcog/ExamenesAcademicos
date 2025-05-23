/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenEscrito;

/**
 *
 * @author Gabriela
 */

public interface ExamenEscritoServicio {
    
    List<ExamenEscrito> getAllExamenesEscritos() throws Exception;
    
    ExamenEscrito getExamenEscritoById(Integer id) throws Exception;
    
    ExamenEscrito createExamenEscrito(ExamenEscrito examenEscrito) throws Exception;
    
    ExamenEscrito updateExamenEscrito(Integer id, ExamenEscrito examenEscritoDetails) throws Exception;
    
    void deleteExamenEscrito(Integer id) throws Exception;
    
    Integer contarExamenesEscritos() throws Exception;
}
