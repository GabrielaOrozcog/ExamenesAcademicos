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
    public List<Curso> getAll() {
        return cursoServicio.getAllCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable Integer id) {
        Curso curso = cursoServicio.getCursoById(id);
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return cursoServicio.createCurso(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso cursoDetails) {
        Curso updatedCurso = cursoServicio.updateCurso(id, cursoDetails);
        if (updatedCurso != null) {
            return ResponseEntity.ok(updatedCurso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        cursoServicio.deleteCurso(id);
        return ResponseEntity.ok().build();
    }
}
