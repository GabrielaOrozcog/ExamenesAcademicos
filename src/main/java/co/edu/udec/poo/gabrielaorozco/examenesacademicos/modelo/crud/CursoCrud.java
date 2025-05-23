/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;

/**
 *
 * @author Gabriela
 */

@RestController
@RequestMapping("/api/cursos")
public class CursoCrud {

    @Autowired
    private CursoServicio cursoServicio;

    
    @GetMapping
    public ResponseEntity<?> getAllCursos() {
       try {
           List<Curso> cursos = cursoServicio.getAllCursos();
           return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los cursos: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getCursoById(@PathVariable Integer id) {
        try {
            Curso curso = cursoServicio.getCursoById(id);
            return ResponseEntity.ok(curso);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el curso con ID: " + id + ". " + e.getMessage());
        }
    }

    
    @PostMapping
    public ResponseEntity<?> createCurso(@RequestBody Curso curso) {
        try {
            Curso nuevoCurso = cursoServicio.createCurso(curso);
            return ResponseEntity.ok(nuevoCurso);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear el curso: " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCurso(@PathVariable Integer id, @RequestBody Curso cursoDetails) {
        try {
            Curso actualizado = cursoServicio.updateCurso(id, cursoDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar el curso: " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCurso(@PathVariable Integer id) {
        try {
            cursoServicio.deleteCurso(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar el curso: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarCursos() {
    try {
        Integer total = cursoServicio.contarCursos();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }
    
}
