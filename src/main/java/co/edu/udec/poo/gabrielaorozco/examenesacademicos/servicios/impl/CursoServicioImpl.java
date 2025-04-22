/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.CursoCrud.CursoRepository;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;

/**
 *
 * @author Gabriela
 */
public class CursoServicioImpl implements CursoServicio {
    
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso getCursoById(Integer id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso updateCurso(Integer id, Curso cursoDetails) {
         return cursoRepository.findById(id).map(curso -> {
            curso.setNombreCurso(cursoDetails.getNombreCurso());
            return cursoRepository.save(curso);
        }).orElse(null);    
    }

    @Override
    public void deleteCurso(Integer id) {
        cursoRepository.deleteById(id);
    }
    
    
    
}
