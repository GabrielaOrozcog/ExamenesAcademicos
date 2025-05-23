/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.ProfesorRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;

/**
 *
 * @author Gabriela
 */

@Service
public class ProfesorServicioImpl implements ProfesorServicio {

    @Autowired
    private ProfesorRepositorio profesorRepository;
    
    
    @Override
    public List<Profesor> getAllProfesores() throws Exception {
    try {
        List<Profesor> profesores = profesorRepository.findAll();
        if (profesores.isEmpty()) {
            throw new Exception("No se encontraron profesores registrados");
        }
        return profesores;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de profesores : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Profesor getProfesorById(Integer id) throws Exception {
    try {
        return profesorRepository.findById(id)
                .orElseThrow(() -> new Exception("Profesor no encontrado con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar profesor : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Profesor createProfesor(Profesor profesor) throws Exception {
    try {
        if (profesorRepository.existsById(profesor.getId_Profesor())) {
            throw new Exception("Profesor con ID " + profesor.getId_Profesor()+ " ya existe");
        }
        return profesorRepository.save(profesor);
    } catch (Exception e) {
        throw new Exception("Error al crear profesor : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Profesor updateProfesor(Integer id, Profesor profesorDetails) throws Exception {
    try {
        Profesor profesor = profesorRepository.findById(id)
                              .orElseThrow(() -> new Exception("Profesor no encontrado"));
        
            profesor.setNombre_Profesor(profesorDetails.getNombre_Profesor());
            profesor.setEmail_Profesor(profesorDetails.getEmail_Profesor());
            profesor.setTelefono_Profesor(profesorDetails.getTelefono_Profesor());
            profesor.setCargo(profesorDetails.getCargo());
            profesor.setDepartamentoAcademico(profesorDetails.getDepartamentoAcademico());
            profesor.setFecha_InicioContrato(profesorDetails.getFecha_InicioContrato());
            profesor.setFecha_FinContrato(profesorDetails.getFecha_FinContrato());
            
            return profesorRepository.save(profesor);
        
    } catch (Exception e) {
        throw new Exception("Error actualizando profesor : " + e.getMessage(), e);
    }
    }

    
    @Override
    public void deleteProfesor(Integer id) throws Exception {
    try {
        profesorRepository.findById(id).orElseThrow(() -> 
            new Exception("Profesor con ID " + id + " no encontrado"));
        profesorRepository.deleteById(id);
    } catch (Exception e) {
        throw new Exception("Error eliminando profesor: " + e.getMessage());
    }
    }
    
    
    @Override
    public Integer contarProfesores() throws Exception {
    try {
        long total = profesorRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los profesores : " + e.getMessage(), e);
        }
    }

}
