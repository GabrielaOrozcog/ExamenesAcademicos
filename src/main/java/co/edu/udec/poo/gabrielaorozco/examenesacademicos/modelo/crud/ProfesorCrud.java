/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;

/**
 *
 * @author Gabriela
 */
@RestController
@RequestMapping("/api/profesores")
public class ProfesorCrud {

    @Autowired
    private ProfesorServicio profesorServicio;
    
    
    @GetMapping
    public ResponseEntity<?> getAllProfesores() {
       try {
           List<Profesor> profesores = profesorServicio.getAllProfesores();
           return ResponseEntity.ok(profesores);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los profesores : " + e.getMessage());
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getProfesorById(@PathVariable Integer id) {
        try {
            Profesor profesor = profesorServicio.getProfesorById(id);
            return ResponseEntity.ok(profesor);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el profesor con ID: " + id + ". " + e.getMessage());
        }
    }
    
    
    @PostMapping
    public ResponseEntity<?> createProfesor(@RequestBody Profesor profesor) {
        try {
            Profesor nuevoProfesor = profesorServicio.createProfesor(profesor);
            return ResponseEntity.ok(nuevoProfesor);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear el profesor : " + e.getMessage());
        }
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfesor(@PathVariable Integer id, @RequestBody Profesor profesorDetails) {
        try {
            Profesor actualizado = profesorServicio.updateProfesor(id, profesorDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar el profesor : " + e.getMessage());
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesor(@PathVariable Integer id) {
        try {
            profesorServicio.deleteProfesor(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar el profesor : " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarProfesores() {
    try {
        Integer total = profesorServicio.contarProfesores();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }
    
}
