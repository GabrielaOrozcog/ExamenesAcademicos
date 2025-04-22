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
    
    List<ExamenEscrito> getAllExamenesEscritos();
    
    ExamenEscrito getExamenEscritoById(Integer id);
    
    ExamenEscrito createExamenEscrito(ExamenEscrito examenEscrito);
    
    ExamenEscrito updateExamenEscrito(Integer id, ExamenEscrito examenDetails);
    
    void deleteExamenEscrito(Integer id);
}
