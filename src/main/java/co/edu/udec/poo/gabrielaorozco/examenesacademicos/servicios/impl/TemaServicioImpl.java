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
    public List<Tema> getAllTemas() {
        return temaRepository.findAll();
    }

    @Override
    public Tema getTemaById(Integer id) {
        return temaRepository.findById(id).orElse(null);
    }

    @Override
    public Tema createTema(Tema profesor) {
        return temaRepository.save(profesor);
    }

    @Override
    public Tema updateTema(Integer id, Tema temaDetails) {
        return temaRepository.findById(id).map(tema -> {
            tema.setNombreTema(temaDetails.getNombreTema());
            tema.setDescripcionTema(temaDetails.getDescripcionTema());
            tema.setRecursos(temaDetails.getRecursos());
            tema.setNivelDificultadTema(temaDetails.getNivelDificultadTema());
            tema.setAsignatura(temaDetails.getAsignatura());
            return temaRepository.save(tema);
        }).orElse(null);
    }

    @Override
    public void deleteTema(Integer id) {
        temaRepository.deleteById(id);
    }
}
