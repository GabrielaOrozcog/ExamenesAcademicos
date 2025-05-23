
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.AlumnoRepositorio;

/**
 *
 * @author Gabriela
 */
@Service
public class AlumnoServicioImpl implements AlumnoServicio {

    @Autowired
    private AlumnoRepositorio alumnoRepository;

    @Override
    public List<Alumno> getAllAlumnos() throws Exception {
    try {
        List<Alumno> alumnos = alumnoRepository.findAll();
        if (alumnos.isEmpty()) {
            throw new Exception("No se encontraron alumnos registrados");
        }
        return alumnos;
        } catch (Exception e) {
        throw new Exception("Error al obtener la lista de alumnos: " + e.getMessage(), e);
        }
    }
    
    @Override
    public Alumno getAlumnoById(Integer id) throws Exception {
    try {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new Exception("Alumno no encontrado con ID: " + id));
        } catch (Exception e) {
        throw new Exception("Error al buscar alumno: " + e.getMessage(), e);
        }
    }

    
    @Override
    public Alumno createAlumno(Alumno alumno) throws Exception {
    try {
        if (alumnoRepository.existsById(alumno.getIdAlumno())) {
            throw new Exception("Alumno con ID " + alumno.getIdAlumno() + " ya existe");
        }
        return alumnoRepository.save(alumno);
        } catch (Exception e) {
        throw new Exception("Error al crear alumno: " + e.getMessage(), e);
        }
    }
    

    @Override
    public Alumno updateAlumno(Integer id, Alumno alumnoDetails) throws Exception {
    try {
        Alumno alumno = alumnoRepository.findById(id)
                              .orElseThrow(() -> new Exception("Alumno no encontrado"));
        
        alumno.setNombre_Alumno(alumnoDetails.getNombre_Alumno());
        alumno.setGrupo(alumnoDetails.getGrupo());
        alumno.setCurso(alumnoDetails.getCurso());
        
        return alumnoRepository.save(alumno);
        
        } catch (Exception e) {
        throw new Exception("Error actualizando alumno: " + e.getMessage(), e);
        }
    }
    

    @Override
    public void deleteAlumno(Integer id) throws Exception {
    try {
        alumnoRepository.findById(id).orElseThrow(() -> 
            new Exception("Alumno con ID " + id + " no encontrado"));
        alumnoRepository.deleteById(id);
        } catch (Exception e) {
        throw new Exception("Error eliminando alumno: " + e.getMessage());
        }
    }
    
    
    @Override
    public Integer contarAlumnos() throws Exception {
    try {
        long total = alumnoRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los alumnos: " + e.getMessage(), e);
        }
    }    
}
