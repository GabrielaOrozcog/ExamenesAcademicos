/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.AsignaturaRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriela
 */
@Service
public class AsignaturaServicioImpl implements AsignaturaServicio {
    
    @Autowired
    private AsignaturaRepositorio asignaturaRepository;
    
    
    @Override
    public List<Asignatura> getAllAsignaturas() throws Exception {
    try {
        List<Asignatura> asignaturas = asignaturaRepository.findAll();
        if (asignaturas.isEmpty()) {
            throw new Exception("No se encontraron asignaturas registradas");
        }
        return asignaturas;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de asignaturas: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public Asignatura getAsignaturaById(Integer id) throws Exception {
    try {
        return asignaturaRepository.findById(id)
                .orElseThrow(() -> new Exception("Asignatura no encontrada con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar asignatura: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public Asignatura createAsignatura(Asignatura asignatura) throws Exception {
    try {
        if (asignaturaRepository.findById(asignatura.getIdAsignatura()).isPresent()) {
            throw new Exception("La asignatura con ID " + asignatura.getIdAsignatura() + " ya existe");
        }      
        return asignaturaRepository.save(asignatura);
    } catch (Exception e) {
        throw new Exception("Error al crear asignatura: " + e.getMessage(), e);
    }
    }
    
    @Override
    public Asignatura updateAsignatura(Integer id, Asignatura asignaturaDetails) throws Exception {
    try {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new Exception("Asignatura no encontrada con ID: " + id));
        
        asignatura.setNombreAsignatura(asignaturaDetails.getNombreAsignatura());
        asignatura.setCreditos(asignaturaDetails.getCreditos());
        asignatura.setDescripcionAsignatura(asignaturaDetails.getDescripcionAsignatura());
        asignatura.setAnioAcademico(asignaturaDetails.getAnioAcademico());
        asignatura.setSemestre(asignaturaDetails.getSemestre());
        asignatura.setHorario(asignaturaDetails.getHorario());
        
        return asignaturaRepository.save(asignatura);
    } catch (Exception e) {
        throw new Exception("Error al actualizar asignatura: " + e.getMessage(), e);
    }
    }
    

    @Override
    public void deleteAsignatura(Integer id) throws Exception {
    try {
        Asignatura asignatura = asignaturaRepository.findById(id)
                .orElseThrow(() -> new Exception("Asignatura no encontrada con ID: " + id));
        asignaturaRepository.delete(asignatura);
        } catch (Exception e) {
        throw new Exception("Error al eliminar asignatura: " + e.getMessage(), e);
       }
    }
    
    
    @Override
    public Integer contarAsignaturas() throws Exception {
    try {
        long total = asignaturaRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar las asignaturas: " + e.getMessage(), e);
        }
    }   
}
