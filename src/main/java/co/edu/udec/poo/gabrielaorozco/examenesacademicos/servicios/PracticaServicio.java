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
    
    List<Practica> getAllPracticas();
    
    Practica getPracticaById(Integer id);
    
    Practica createPractica(Practica practica);
    
    Practica updatePractica(Integer id, Practica practicaDetails);
    
    void deletePractica(Integer id);
}
