/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenEscrito;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.ExamenEscritoRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenEscritoServicio;

/**
 *
 * @author Gabriela
 */
@Service
public class ExamenEscritoServicioImpl implements ExamenEscritoServicio {

    @Autowired
    private ExamenEscritoRepositorio examenEscritoRepository;
    
    
    @Override
    public List<ExamenEscrito> getAllExamenesEscritos() throws Exception {
    try {
        List<ExamenEscrito> examenEscrito = examenEscritoRepository.findAll();
        if (examenEscrito.isEmpty()) {
            throw new Exception("No se encontraron examenes escritos registrados");
        }
        return examenEscrito;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de examenes escritos: " + e.getMessage(), e);
    }
    }
    
    @Override
    public ExamenEscrito getExamenEscritoById(Integer id) throws Exception {
    try {
        return examenEscritoRepository.findById(id)
                .orElseThrow(() -> new Exception("Examen Escrito no encontrado con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar examen escrito: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public ExamenEscrito createExamenEscrito(ExamenEscrito examenEscrito) throws Exception {
    try {
        if (examenEscritoRepository.existsById(examenEscrito.getIdExamen())) {
            throw new Exception("Examen escrito con ID " + examenEscrito.getIdExamen() + " ya existe");
        }
        return examenEscritoRepository.save(examenEscrito);
    } catch (Exception e) {
        throw new Exception("Error al crear examen escrito: " + e.getMessage(), e);
    }
    }
    

    @Override
    public ExamenEscrito updateExamenEscrito(Integer id, ExamenEscrito examenEscritoDetails) throws Exception {
    try {
        ExamenEscrito examenEscrito = examenEscritoRepository.findById(id)
                              .orElseThrow(() -> new Exception("Examen escrito no encontrado"));
        
            examenEscrito.setNumeroPreguntas(examenEscritoDetails.getNumeroPreguntas());
            examenEscrito.setComponenteTeorico(examenEscritoDetails.getComponenteTeorico());
            examenEscrito.setComponenteRedaccion(examenEscritoDetails.getComponenteRedaccion());
            examenEscrito.setFechaRealizacion(examenEscritoDetails.getFechaRealizacion());
            examenEscrito.setFechaCreacionExamen(examenEscritoDetails.getFechaCreacionExamen());
            examenEscrito.setTipoExamen(examenEscritoDetails.getTipoExamen());
            examenEscrito.setAsignatura(examenEscritoDetails.getAsignatura());
            examenEscrito.setAlumno(examenEscritoDetails.getAlumno());
            examenEscrito.setProfesor(examenEscritoDetails.getProfesor());
            return examenEscritoRepository.save(examenEscrito);
        
    } catch (Exception e) {
        throw new Exception("Error actualizando examen escrito: " + e.getMessage(), e);
    }
    }

    @Override
    public void deleteExamenEscrito(Integer id) throws Exception {
    try {
        examenEscritoRepository.findById(id).orElseThrow(() -> 
            new Exception("Examen escrito con ID " + id + " no encontrado"));
        examenEscritoRepository.deleteById(id);
    } catch (Exception e) {
        throw new Exception("Error eliminando examen escrito: " + e.getMessage());
    }
    }
    
    
    @Override
    public Integer contarExamenesEscritos() throws Exception {
    try {
        long total = examenEscritoRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los examenes escritos : " + e.getMessage(), e);
        }
    }
    
}