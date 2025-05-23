/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;

/**
 *
 * @author Gabriela
 */

public interface AsignaturaServicio {
    
    List<Asignatura> getAllAsignaturas() throws Exception;
    
    Asignatura getAsignaturaById(Integer id) throws Exception;
    
    Asignatura createAsignatura(Asignatura asignatura) throws Exception;
    
    Asignatura updateAsignatura(Integer id, Asignatura asignaturaDetails) throws Exception;
    
<<<<<<< HEAD
    void deleteAsignatura(Integer id);
=======
    void deleteAsignatura(Integer id) throws Exception;
    
    Integer contarAsignaturas() throws Exception;
>>>>>>> Gabriela
}