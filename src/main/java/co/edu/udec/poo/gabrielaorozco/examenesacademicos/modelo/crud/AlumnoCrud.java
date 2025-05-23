/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

/**
 *
 * @author Gabriela
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoCrud {

    @Autowired
    private AlumnoServicio alumnoServicio;

    
    @GetMapping
    public ResponseEntity<?> getAllAlumnos() {
       try {
           List<Alumno> alumnos = alumnoServicio.getAllAlumnos();
           return ResponseEntity.ok(alumnos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los alumnos: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAlumnoById(@PathVariable Integer id) {
        try {
            Alumno alumno = alumnoServicio.getAlumnoById(id);
            return ResponseEntity.ok(alumno);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el alumno con ID: " + id + ". " + e.getMessage());
        }
    }

    
    @PostMapping
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno) {
        try {
            Alumno nuevoAlumno = alumnoServicio.createAlumno(alumno);
            return ResponseEntity.ok(nuevoAlumno);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear el alumno: " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable Integer id, @RequestBody Alumno alumnoDetails) {
        try {
            Alumno actualizado = alumnoServicio.updateAlumno(id, alumnoDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar el alumno: " + e.getMessage());
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable Integer id) {
        try {
            alumnoServicio.deleteAlumno(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar el alumno: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarAlumnos() {
    try {
        Integer total = alumnoServicio.contarAlumnos();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }

}

