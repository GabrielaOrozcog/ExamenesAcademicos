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
    
    List<Asignatura> getAllAsignaturas();
    
    Asignatura getAsignaturaById(Integer id);
    
    Asignatura createAsignatura(Asignatura asignatura);
    
    Asignatura updateAsignatura(Integer id, Asignatura asignaturaDetails);
    
    void deleteAsignatura(Integer id);
}
