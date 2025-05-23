/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Tema;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.TemaRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.TemaServicio;

/**
 *
 * @author Gabriela
 */
@Service
public class TemaServicioImpl implements TemaServicio {
    
    @Autowired
    private TemaRepositorio temaRepository;
    
    
    @Override
    public List<Tema> getAllTemas() throws Exception {
    try {
        List<Tema> temas = temaRepository.findAll();
        if (temas.isEmpty()) {
            throw new Exception("No se encontraron temas registrados");
        }
        return temas;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de temas : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Tema getTemaById(Integer id) throws Exception {
    try {
        return temaRepository.findById(id)
                .orElseThrow(() -> new Exception("Tema no encontrado con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar tema : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Tema createTema(Tema tema) throws Exception {
    try {
        if (temaRepository.findById(tema.getId_Tema()).isPresent()) {
            throw new Exception("El tema con ID " + tema.getId_Tema()+ " ya existe");
        }      
        return temaRepository.save(tema);
    } catch (Exception e) {
        throw new Exception("Error al crear tema : " + e.getMessage(), e);
    }
    }

    
    @Override
    public Tema updateTema(Integer id, Tema temaDetails) throws Exception {
    try {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new Exception("Tema no encontrado con ID: " + id));
        
            tema.setNombreTema(temaDetails.getNombreTema());
            tema.setDescripcionTema(temaDetails.getDescripcionTema());
            tema.setRecursos(temaDetails.getRecursos());
            tema.setNivelDificultadTema(temaDetails.getNivelDificultadTema());
            tema.setAsignatura(temaDetails.getAsignatura());
            
            return temaRepository.save(tema);
    } catch (Exception e) {
        throw new Exception("Error al actualizar tema : " + e.getMessage(), e);
    }
    }

    
    @Override
    public void deleteTema(Integer id) throws Exception {
    try {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new Exception("Tema no encontrado con ID: " + id));
        temaRepository.delete(tema);
        } catch (Exception e) {
        throw new Exception("Error al eliminar tema : " + e.getMessage(), e);
       }
    }
    
    
    @Override
    public Integer contarTemas() throws Exception {
    try {
        long total = temaRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los temas : " + e.getMessage(), e);
        }
    }

}
