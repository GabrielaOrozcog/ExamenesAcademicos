/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Practica;
/**
 *
 * @author Gabriela
 */
public interface PracticaServicio {
    
    List<Practica> getAllPracticas() throws Exception;
    
    Practica getPracticaById(Integer id) throws Exception;
    
    Practica createPractica(Practica practica) throws Exception ;
    
    Practica updatePractica(Integer id, Practica practicaDetails) throws Exception ;
    
    void deletePractica(Integer id) throws Exception;
    
    Integer contarPracticas() throws Exception;
}
