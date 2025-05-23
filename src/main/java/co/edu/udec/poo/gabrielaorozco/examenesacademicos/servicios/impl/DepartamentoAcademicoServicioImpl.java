/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.DepartamentoAcademicoRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.DepartamentoAcademicoServicio;

/**
 *
 * @author Gabriela
 */

@Service
public class DepartamentoAcademicoServicioImpl implements DepartamentoAcademicoServicio {
    
    @Autowired
    private DepartamentoAcademicoRepositorio departamentoAcademicoRepository;

   
    @Override
    public List<DepartamentoAcademico> getAllDepartamentosAcademicos() throws Exception {
    try {
        List<DepartamentoAcademico> departamentoAcademico = departamentoAcademicoRepository.findAll();
        if (departamentoAcademico.isEmpty()) {
            throw new Exception("No se encontraron departamentos academicos registrados");
        }
        return departamentoAcademico;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de departamentos academicos: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public DepartamentoAcademico getDepartamentoAcademicoById(Integer id) throws Exception {
    try {
        return departamentoAcademicoRepository.findById(id)
                .orElseThrow(() -> new Exception("Departamento academico no encontrado con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar departamento academico: " + e.getMessage(), e);
    }
    }
    
    @Override
    public DepartamentoAcademico createDepartamentoAcademico(DepartamentoAcademico departamentoAcademico) throws Exception {
    try {
        if (departamentoAcademicoRepository.existsById(departamentoAcademico.getIdDepartamentoAcademico())) {
            throw new Exception("El departamento academico con ID " + departamentoAcademico.getIdDepartamentoAcademico() + " ya existe");
        }
        return departamentoAcademicoRepository.save(departamentoAcademico);
    } catch (Exception e) {
        throw new Exception("Error al crear departamento academico: " + e.getMessage(), e);
    }
    }

    
    @Override
    public DepartamentoAcademico updateDepartamentoAcademico(Integer id, DepartamentoAcademico departamentoAcademicoDetails) throws Exception {
    try {
        DepartamentoAcademico departamentoAcademico = departamentoAcademicoRepository.findById(id)
                              .orElseThrow(() -> new Exception("Departamento academico no encontrado"));
        
        departamentoAcademico.setNombre(departamentoAcademicoDetails.getNombre());
        return departamentoAcademicoRepository.save(departamentoAcademico);
        
    } catch (Exception e) {
        throw new Exception("Error actualizando departamento academico: " + e.getMessage(), e);
    }
    }
    
    @Override
    public void deleteDepartamentoAcademico(Integer id) throws Exception {
    try {
        departamentoAcademicoRepository.findById(id).orElseThrow(() -> 
            new Exception("El departamento academico con ID " + id + " no encontrado"));
        departamentoAcademicoRepository.deleteById(id);
    } catch (Exception e) {
        throw new Exception("Error eliminando departamento academico: " + e.getMessage());
    }
    }
    
    
    @Override
    public Integer contarDepartamentosAcademicos() throws Exception {
    try {
        long total = departamentoAcademicoRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los departamentos : " + e.getMessage(), e);
        }
    }
  
}
