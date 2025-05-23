/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Practica;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.PracticaRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.PracticaServicio;

/**
 *
 * @author Gabriela
 */

@Service
public class PracticaServicioImpl implements PracticaServicio {
    @Autowired
    private PracticaRepositorio practicaRepository;
    
    
    
    @Override
    public List<Practica> getAllPracticas() throws Exception {
    try {
        List<Practica> practicas = practicaRepository.findAll();
        if (practicas.isEmpty()) {
            throw new Exception("No se encontraron practicas registradas");
        }
        return practicas;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de practicas: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public Practica getPracticaById(Integer id) throws Exception {
    try {
        return practicaRepository.findById(id)
                .orElseThrow(() -> new Exception("Practica no encontrada con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar practica : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Practica createPractica(Practica practica) throws Exception {
    try {
        if (practicaRepository.findById(practica.getIdPractica()).isPresent()) {
            throw new Exception("La practica con ID " + practica.getIdPractica()+ " ya existe");
        }      
        return practicaRepository.save(practica);
    } catch (Exception e) {
        throw new Exception("Error al crear practica : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Practica updatePractica(Integer id, Practica practicaDetails) throws Exception {
    try {
        Practica practica = practicaRepository.findById(id)
                .orElseThrow(() -> new Exception("Practica no encontrada con ID: " + id));
        
            practica.setTitulo(practicaDetails.getTitulo());
            practica.setFechaCreacion(practicaDetails.getFechaCreacion());
            practica.setNivelDificultadPractica(practicaDetails.getNivelDificultadPractica());
        
        return practicaRepository.save(practica);
    } catch (Exception e) {
        throw new Exception("Error al actualizar practica : " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public void deletePractica(Integer id) throws Exception {
    try {
        Practica practica = practicaRepository.findById(id)
                .orElseThrow(() -> new Exception("Practica no encontrada con ID: " + id));
        practicaRepository.delete(practica);
    } catch (Exception e) {
        throw new Exception("Error al eliminar practica : " + e.getMessage(), e);
    }

    }
    
    
    @Override
    public Integer contarPracticas() throws Exception {
    try {
        long total = practicaRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar las practicas : " + e.getMessage(), e);
        }
    }
}
