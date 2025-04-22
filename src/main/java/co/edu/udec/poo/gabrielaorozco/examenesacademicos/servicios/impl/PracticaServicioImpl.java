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
    public List<Practica> getAllPracticas() {
        return practicaRepository.findAll();
    }

    @Override
    public Practica getPracticaById(Integer id) {
        return practicaRepository.findById(id).orElse(null);
    }

    @Override
    public Practica createPractica(Practica practica) {
        return practicaRepository.save(practica);
    }

    @Override
    public Practica updatePractica(Integer id, Practica practicaDetails) {
        return practicaRepository.findById(id).map(practica -> {
            practica.setTitulo(practicaDetails.getTitulo());
            practica.setFechaCreacion(practicaDetails.getFechaCreacion());
            practica.setNivelDificultadPractica(practicaDetails.getNivelDificultadPractica());
            return practicaRepository.save(practica);
        }).orElse(null);
    }

    @Override
    public void deletePractica(Integer id) {
        practicaRepository.deleteById(id);
    }
}
