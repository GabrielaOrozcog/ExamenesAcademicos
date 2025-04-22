/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;

/**
 *
 * @author torrestr
 */
@RestController
@RequestMapping("/api/profesores")
public class ProfesorCrud {

    @Autowired
    private ProfesorServicio profesorServicio;
    
    @GetMapping
    public List<Profesor> getAll() {
        return profesorServicio.getAllProfesores();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> getById(@PathVariable Integer id) {
        Profesor profesor = profesorServicio.getProfesorById(id);
        if (profesor != null) {
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping
    public Profesor create(@RequestBody Profesor profesor) {
        return profesorServicio.createProfesor(profesor);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> update(@PathVariable Integer id, @RequestBody Profesor profesorDetails) {
        Profesor updatedProfesor = profesorServicio.updateProfesor(id, profesorDetails);
        if (updatedProfesor != null) {
            return ResponseEntity.ok(updatedProfesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        profesorServicio.deleteProfesor(id);
        return ResponseEntity.ok().build();
    }
    
    @Repository
    public static interface ProfesorRepository extends JpaRepository<Profesor, Integer> { }
}
