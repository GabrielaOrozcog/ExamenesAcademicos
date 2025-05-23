/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Examen;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.ExamenRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenServicio;

/**
 *
 * @author Gabriela
 */

@Service
public class ExamenServicioImpl implements ExamenServicio {
    
    @Autowired
    private ExamenRepositorio examenRepository;
    
    
    @Override
    public List<Examen> getAllExamenes() throws Exception {
    try {
        List<Examen> examen = examenRepository.findAll();
        if (examen.isEmpty()) {
            throw new Exception("No se encontraron examenes registrados");
        }
        return examen;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de examenes : " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public Examen getExamenById(Integer id) throws Exception {
    try {
        return examenRepository.findById(id)
                .orElseThrow(() -> new Exception("Examen no encontrado con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar examen : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Examen createExamen(Examen examen) throws Exception {
    try {
        if (examenRepository.existsById(examen.getIdExamen())) {
            throw new Exception("Examen con ID " + examen.getIdExamen() + " ya existe");
        }
        return examenRepository.save(examen);
    } catch (Exception e) {
        throw new Exception("Error al crear examen : " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public Examen updateExamen(Integer id, Examen examenDetails) throws Exception {
    try {
        Examen examen = examenRepository.findById(id)
                              .orElseThrow(() -> new Exception("Examen  no encontrado"));
        
            examen.setFechaRealizacion(examenDetails.getFechaRealizacion());
            examen.setFechaCreacionExamen(examenDetails.getFechaCreacionExamen());
            examen.setTipoExamen(examenDetails.getTipoExamen());
            examen.setAsignatura(examenDetails.getAsignatura());
            examen.setAlumno(examenDetails.getAlumno());
            examen.setProfesor(examenDetails.getProfesor());
            examen.setGrupo(examenDetails.getGrupo());
            return examenRepository.save(examen);
        
    } catch (Exception e) {
        throw new Exception("Error actualizando examen : " + e.getMessage(), e);
    }
    }


    @Override
    public void deleteExamen(Integer id) throws Exception {
    try {
        examenRepository.findById(id).orElseThrow(() -> 
            new Exception("Examen con ID " + id + " no encontrado"));
        examenRepository.deleteById(id);
    } catch (Exception e) {
        throw new Exception("Error eliminando examen : " + e.getMessage());
    }
    }

    
    @Override
    public Integer contarExamenes() throws Exception {
    try {
        long total = examenRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los examenes : " + e.getMessage(), e);
        }
    }
}
