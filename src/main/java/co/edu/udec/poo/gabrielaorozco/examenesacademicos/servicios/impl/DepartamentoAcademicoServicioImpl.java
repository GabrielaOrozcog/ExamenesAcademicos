/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.DepartamentoAcademicoCrud.DepartamentoAcademicoRepository;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.DepartamentoAcademicoServicio;

/**
 *
 * @author Gabriela
 */

public class DepartamentoAcademicoServicioImpl implements DepartamentoAcademicoServicio {
    
    @Autowired
    private DepartamentoAcademicoRepository departamentoAcademicoRepository;

    @Override
    public List<DepartamentoAcademico> getAllDepartamentoAcademicos() {
        return departamentoAcademicoRepository.findAll();
    }

    @Override
    public DepartamentoAcademico getDepartamentoAcademicoById(Integer id) {
        return departamentoAcademicoRepository.findById(id).orElse(null);
    }

    @Override
    public DepartamentoAcademico createDepartamentoAcademico(DepartamentoAcademico departamentoAcademico) {
        return departamentoAcademicoRepository.save(departamentoAcademico);
    }

    @Override
    public DepartamentoAcademico updateDepartamentoAcademico(Integer id, DepartamentoAcademico departamentoAcademicoDetails) {
        return departamentoAcademicoRepository.findById(id).map(departamentoAcademico -> {
            departamentoAcademico.setNombre(departamentoAcademicoDetails.getNombre());
            return departamentoAcademicoRepository.save(departamentoAcademico);
        }).orElse(null);  
    }

    @Override
    public void deleteDepartamentoAcademico(Integer id) {
        departamentoAcademicoRepository.deleteById(id);
    }
    
}
