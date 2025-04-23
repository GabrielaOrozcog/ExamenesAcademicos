/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Tema;

/**
 *
 * @author Gabriela
 */

public interface TemaServicio {
    
    List<Tema> getAllTemas();
    
    Tema getTemaById(Integer id);
    
    Tema createTema(Tema tema);
    
    Tema updateTema(Integer id, Tema temaDetails);
    
    void deleteTema(Integer id);
}
