/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.AlumnoCrud.AlumnoRepository;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;

/**
 *
 * @author Gabriela
 */
@Service
public class AlumnoServicioImpl implements AlumnoServicio {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public Alumno getAlumnoById(Integer id) {
        return alumnoRepository.findById(id).orElse(null);
    }

    @Override
    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno updateAlumno(Integer id, Alumno alumnoDetails) {
        return alumnoRepository.findById(id)
                .map(alumno -> {
                    alumno.setNombre_Alumno(alumnoDetails.getNombre_Alumno());
                    alumno.setGrupo(alumnoDetails.getGrupo());
                    alumno.setCurso(alumnoDetails.getCurso());
                    return alumnoRepository.save(alumno);
                })
                .orElse(null);
    }

    @Override
    public void deleteAlumno(Integer id) {
        alumnoRepository.deleteById(id);
    }
}
