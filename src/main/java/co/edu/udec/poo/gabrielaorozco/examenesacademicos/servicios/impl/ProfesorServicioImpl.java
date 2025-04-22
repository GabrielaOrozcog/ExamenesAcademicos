/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.ProfesorCrud.ProfesorRepository;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;

/**
 *
 * @author torrestr
 */
@Service
public class ProfesorServicioImpl implements ProfesorServicio {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public List<Profesor> getAllProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor getProfesorById(Integer id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public Profesor createProfesor(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor updateProfesor(Integer id, Profesor profesorDetails) {
        return profesorRepository.findById(id).map(profesor -> {
            profesor.setNombre_Profesor(profesorDetails.getNombre_Profesor());
            profesor.setEmail_Profesor(profesorDetails.getEmail_Profesor());
            profesor.setTelefono_Profesor(profesorDetails.getTelefono_Profesor());
            profesor.setCargo(profesorDetails.getCargo());
            profesor.setDepartamentoAcademico(profesorDetails.getDepartamentoAcademico());
            profesor.setFecha_InicioContrato(profesorDetails.getFecha_InicioContrato());
            profesor.setFecha_FinContrato(profesorDetails.getFecha_FinContrato());
            return profesorRepository.save(profesor);
        }).orElse(null);
    }

    @Override
    public void deleteProfesor(Integer id) {
        profesorRepository.deleteById(id);
    }
}
