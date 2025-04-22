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
    public List<Examen> getAllExamenes() {
        return examenRepository.findAll();
    }

    @Override
    public Examen getExamenById(Integer id) {
        return examenRepository.findById(id).orElse(null);
    }

    @Override
    public Examen createExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen updateExamen(Integer id, Examen examenDetails) {
        return examenRepository.findById(id).map(examen -> {
            examen.setFechaRealizacion(examenDetails.getFechaRealizacion());
            examen.setFechaCreacionExamen(examenDetails.getFechaCreacionExamen());
            examen.setTipoExamen(examenDetails.getTipoExamen());
            examen.setAsignatura(examenDetails.getAsignatura());
            examen.setAlumno(examenDetails.getAlumno());
            examen.setProfesor(examenDetails.getProfesor());
            return examenRepository.save(examen);
        }).orElse(null);
    }

    @Override
    public void deleteExamen(Integer id) {
        examenRepository.deleteById(id);
    }
}
