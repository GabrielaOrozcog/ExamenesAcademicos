/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios;

import java.util.List;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;

/**
 *
 * @author Gabriela
 */

public interface DepartamentoAcademicoServicio {
    
    List<DepartamentoAcademico> getAllDepartamentoAcademicos();
    
    DepartamentoAcademico getDepartamentoAcademicoById(Integer id);
    
    DepartamentoAcademico createDepartamentoAcademico(DepartamentoAcademico departamentoAcademico);
    
    DepartamentoAcademico updateDepartamentoAcademico(Integer id, DepartamentoAcademico departamentoAcademico);
    
    void deleteDepartamentoAcademico(Integer id);
}
