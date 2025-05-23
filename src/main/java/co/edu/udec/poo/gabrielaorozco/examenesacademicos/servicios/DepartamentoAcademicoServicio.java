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
    
    List<DepartamentoAcademico> getAllDepartamentosAcademicos() throws Exception;
    
    DepartamentoAcademico getDepartamentoAcademicoById(Integer id) throws Exception;
    
    DepartamentoAcademico createDepartamentoAcademico(DepartamentoAcademico departamentoAcademico) throws Exception;
    
    DepartamentoAcademico updateDepartamentoAcademico(Integer id, DepartamentoAcademico departamentoAcademicoDetails) throws Exception;
    
    void deleteDepartamentoAcademico(Integer id) throws Exception;
    
    Integer contarDepartamentosAcademicos() throws Exception;
}
