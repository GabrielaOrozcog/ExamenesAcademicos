/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
/**
 *
 * @author Gabriela
 */
@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaCrud {

    @Autowired
    private AsignaturaServicio asignaturaServicio;
    
    
    @GetMapping
    public ResponseEntity<?> getAllAsignaturas() {
       try {
           List<Asignatura> asignaturas = asignaturaServicio.getAllAsignaturas();
           return ResponseEntity.ok(asignaturas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener las asignaturas: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAsignaturaById(@PathVariable Integer id) {
        try {
            Asignatura asignatura = asignaturaServicio.getAsignaturaById(id);
            return ResponseEntity.ok(asignatura);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró la asignatura con ID: " + id + ". " + e.getMessage());
        }
    }

    
    @PostMapping
    public ResponseEntity<?> createAsignatura(@RequestBody Asignatura asignatura) {
        try {
            Asignatura nuevaAsignatura = asignaturaServicio.createAsignatura(asignatura);
            return ResponseEntity.ok(nuevaAsignatura);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear la asignatura: " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAsignatura(@PathVariable Integer id, @RequestBody Asignatura asignaturaDetails) {
        try {
            Asignatura actualizada = asignaturaServicio.updateAsignatura(id, asignaturaDetails);
            return ResponseEntity.ok(actualizada);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar la asignatura: " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAsignatura(@PathVariable Integer id) {
        try {
            asignaturaServicio.deleteAsignatura(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar la asignatura: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarAsignaturas() {
    try {
        Integer total = asignaturaServicio.contarAsignaturas();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }

}
