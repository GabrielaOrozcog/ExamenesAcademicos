/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenEscrito;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.ExamenEscritoCrud.ExamenEscritoRepository;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenEscritoServicio;

/**
 *
 * @author torrestr
 */
@Service
public class ExamenEscritoServicioImpl implements ExamenEscritoServicio {

    @Autowired
    private ExamenEscritoRepository examenEscritoRepository;
    
    @Override
    public List<ExamenEscrito> getAllExamenesEscritos() {
        return examenEscritoRepository.findAll();
    }

    @Override
    public ExamenEscrito getExamenEscritoById(Integer id) {
        return examenEscritoRepository.findById(id).orElse(null);
    }

    @Override
    public ExamenEscrito createExamenEscrito(ExamenEscrito examenEscrito) {
        return examenEscritoRepository.save(examenEscrito);
    }

    @Override
    public ExamenEscrito updateExamenEscrito(Integer id, ExamenEscrito examenDetails) {
        return examenEscritoRepository.findById(id).map(examen -> {
            examen.setNumeroPreguntas(examenDetails.getNumeroPreguntas());
            examen.setComponenteTeorico(examenDetails.getComponenteTeorico());
            examen.setComponenteRedaccion(examenDetails.getComponenteRedaccion());
            examen.setFechaRealizacion(examenDetails.getFechaRealizacion());
            examen.setFechaCreacionExamen(examenDetails.getFechaCreacionExamen());
            examen.setTipoExamen(examenDetails.getTipoExamen());
            examen.setAsignatura(examenDetails.getAsignatura());
            examen.setAlumno(examenDetails.getAlumno());
            examen.setProfesor(examenDetails.getProfesor());
            return examenEscritoRepository.save(examen);
        }).orElse(null);
    }

    @Override
    public void deleteExamenEscrito(Integer id) {
        examenEscritoRepository.deleteById(id);
    }
}