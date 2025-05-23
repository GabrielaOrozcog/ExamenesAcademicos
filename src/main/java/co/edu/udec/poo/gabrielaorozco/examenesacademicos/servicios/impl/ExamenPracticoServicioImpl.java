/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenPractico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.ExamenPracticoRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenPracticoServicio;

/**
 *
 * @author Gabriela
 */

@Service
public class ExamenPracticoServicioImpl implements ExamenPracticoServicio{
    @Autowired
    private ExamenPracticoRepositorio examenPracticoRepository;
   
    
    @Override
    public List<ExamenPractico> getAllExamenesPracticos() throws Exception {
    try {
        List<ExamenPractico> examenPractico = examenPracticoRepository.findAll();
        if (examenPractico.isEmpty()) {
            throw new Exception("No se encontraron examenes practicos registrados");
        }
        return examenPractico;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de examenes practicos: " + e.getMessage(), e);
    }
    }

    
    @Override
    public ExamenPractico getExamenPracticoById(Integer id) throws Exception {
    try {
        return examenPracticoRepository.findById(id)
                .orElseThrow(() -> new Exception("Examen practico no encontrado con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar examen practico: " + e.getMessage(), e);
    }
    }
    

    @Override
    public ExamenPractico createExamenPractico(ExamenPractico examenPractico) throws Exception {
    try {
        if (examenPracticoRepository.existsById(examenPractico.getIdExamen())) {
            throw new Exception("Examen practico con ID " + examenPractico.getIdExamen() + " ya existe");
        }
        return examenPracticoRepository.save(examenPractico);
    } catch (Exception e) {
        throw new Exception("Error al crear examen practico: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public ExamenPractico updateExamenPractico(Integer id, ExamenPractico examenPracticoDetails) throws Exception {
    try {
        ExamenPractico examenPractico = examenPracticoRepository.findById(id)
                              .orElseThrow(() -> new Exception("Examen practico no encontrado"));
        
            examenPractico.setDescripcionExamenPractico(examenPracticoDetails.getDescripcionExamenPractico());
            examenPractico.setComponenteEficiencia(examenPracticoDetails.getComponenteEficiencia());
            examenPractico.setComponenteLaboratorio(examenPracticoDetails.getComponenteLaboratorio());
            examenPractico.setGrupal(examenPracticoDetails.isGrupal());
            examenPractico.setFechaRealizacion(examenPracticoDetails.getFechaRealizacion());
            examenPractico.setFechaCreacionExamen(examenPracticoDetails.getFechaCreacionExamen());
            examenPractico.setTipoExamen(examenPracticoDetails.getTipoExamen());
            examenPractico.setAsignatura(examenPracticoDetails.getAsignatura());
            examenPractico.setAlumno(examenPracticoDetails.getAlumno());
            examenPractico.setProfesor(examenPracticoDetails.getProfesor());
            return examenPracticoRepository.save(examenPractico);
        
    } catch (Exception e) {
        throw new Exception("Error actualizando examen practico: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public void deleteExamenPractico(Integer id) throws Exception {
    try {
        examenPracticoRepository.findById(id).orElseThrow(() -> 
            new Exception("Examen practico con ID " + id + " no encontrado"));
        examenPracticoRepository.deleteById(id);
    } catch (Exception e) {
        throw new Exception("Error eliminando examen practico: " + e.getMessage());
    }
    }
    
    
    @Override
    public Integer contarExamenesPracticos() throws Exception {
    try {
        long total = examenPracticoRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los examenes practicos : " + e.getMessage(), e);
        }
    }
}
