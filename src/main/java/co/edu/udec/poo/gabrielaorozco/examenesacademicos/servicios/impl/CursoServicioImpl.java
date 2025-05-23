/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio.CursoRepositorio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriela
 */
@Service
public class CursoServicioImpl implements CursoServicio {
    
    @Autowired
    private CursoRepositorio cursoRepository;

    @Override
    public List<Curso> getAllCursos() throws Exception {
    try {
        List<Curso> cursos = cursoRepository.findAll();
        if (cursos.isEmpty()) {
            throw new Exception("No se encontraron cursos registrados");
        }
        return cursos;
    } catch (Exception e) {
        throw new Exception("Error al obtener la lista de cursos: " + e.getMessage(), e);
    }
    }

    @Override
    public Curso getCursoById(Integer id) throws Exception {
    try {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new Exception("Curso no encontrado con ID: " + id));
    } catch (Exception e) {
        throw new Exception("Error al buscar curso: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public Curso createCurso(Curso curso) throws Exception {
    try {
        if (cursoRepository.findById(curso.getIdCurso()).isPresent()) {
            throw new Exception("El curso con ID " + curso.getIdCurso() + " ya existe");
        }
        
        return cursoRepository.save(curso);
    } catch (Exception e) {
        throw new Exception("Error al crear curso: " + e.getMessage(), e);
    }
    }
    
    
    @Override
    public Curso updateCurso(Integer id, Curso cursoDetails) throws Exception {
    try {
        Curso curso = cursoRepository.findById(id)
                              .orElseThrow(() -> new Exception("Curso no encontrado"));
        
        curso.setNombreCurso(cursoDetails.getNombreCurso());
        return cursoRepository.save(curso);
        
    } catch (Exception e) {
        throw new Exception("Error actualizando curso: " + e.getMessage(), e);
    }
    }
    
    
    
    @Override
    public void deleteCurso(Integer id) throws Exception {
    try {
        cursoRepository.findById(id).orElseThrow(() -> 
            new Exception("Curso con ID " + id + " no encontrado"));
        cursoRepository.deleteById(id);
    } catch (Exception e) {
        throw new Exception("Error eliminando curso: " + e.getMessage());
    }
    }
    
    
    @Override
    public Integer contarCursos() throws Exception {
    try {
        long total = cursoRepository.count();
        return Math.toIntExact(total); 
        } catch (Exception e) {
        throw new Exception("Error al contar los cursos : " + e.getMessage(), e);
        }
    }  
    
}
