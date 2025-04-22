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
    public List<ExamenPractico> getAllExamenesPracticos() {
        return examenPracticoRepository.findAll();
    }

    @Override
    public ExamenPractico getExamenPracticoById(Integer id) {
        return examenPracticoRepository.findById(id).orElse(null);
    }

    @Override
    public ExamenPractico createExamenPractico(ExamenPractico examenPractico) {
        return examenPracticoRepository.save(examenPractico);
    }

    @Override
    public ExamenPractico updateExamenPractico(Integer id, ExamenPractico examenDetails) {
        return examenPracticoRepository.findById(id).map(examen -> {
            examen.setDescripcionExamenPractico(examenDetails.getDescripcionExamenPractico());
            examen.setComponenteLaboratorio(examenDetails.getComponenteLaboratorio());
            examen.setComponenteEficiencia(examenDetails.getComponenteEficiencia());
            examen.setGrupal(examenDetails.isGrupal());
            examen.setFechaRealizacion(examenDetails.getFechaRealizacion());
            examen.setFechaCreacionExamen(examenDetails.getFechaCreacionExamen());
            examen.setTipoExamen(examenDetails.getTipoExamen());
            examen.setAsignatura(examenDetails.getAsignatura());
            examen.setAlumno(examenDetails.getAlumno());
            examen.setProfesor(examenDetails.getProfesor());
            return examenPracticoRepository.save(examen);
        }).orElse(null);
    }

    @Override
    public void deleteExamenPractico(Integer id) {
        examenPracticoRepository.deleteById(id);
    }
}
