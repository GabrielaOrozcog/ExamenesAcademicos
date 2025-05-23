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
    
    List<Tema> getAllTemas() throws Exception;
    
    Tema getTemaById(Integer id) throws Exception;
    
    Tema createTema(Tema tema) throws Exception;
    
    Tema updateTema(Integer id, Tema temaDetails) throws Exception;
    
    void deleteTema(Integer id) throws Exception;
    
    Integer contarTemas() throws Exception;
}
