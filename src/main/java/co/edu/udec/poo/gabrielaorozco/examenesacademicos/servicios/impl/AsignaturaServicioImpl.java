/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.AsignaturaRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriela
 */
@Service
public class AsignaturaServicioImpl implements AsignaturaServicio {
    
    @Autowired
    private AsignaturaRepositorio asignaturaRepository;
    
    @Override
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura getAsignaturaById(Integer id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    @Override
    public Asignatura createAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura updateAsignatura(Integer id, Asignatura asignaturaDetails) {
        return asignaturaRepository.findById(id).map(asignatura -> {
            asignatura.setNombreAsignatura(asignaturaDetails.getNombreAsignatura());
            asignatura.setCreditos(asignaturaDetails.getCreditos());
            asignatura.setDescripcionAsignatura(asignaturaDetails.getDescripcionAsignatura());
            asignatura.setAnioAcademico(asignaturaDetails.getAnioAcademico());
            asignatura.setSemestre(asignaturaDetails.getSemestre());
            asignatura.setHorario(asignaturaDetails.getHorario());
            return asignaturaRepository.save(asignatura);
        }).orElse(null);
    }

    @Override
    public void deleteAsignatura(Integer id) {
        asignaturaRepository.deleteById(id);
    }
}
