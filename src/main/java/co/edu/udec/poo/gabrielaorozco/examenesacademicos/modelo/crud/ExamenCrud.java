/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Examen;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenServicio;

/**
 *
 * @author Gabriela
 */

@RestController
@RequestMapping("/api/examenes")
public class ExamenCrud {

    @Autowired
    private ExamenServicio examenServicio;

    @GetMapping
    public List<Examen> getAll() {
        return examenServicio.getAllExamenes();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Examen> getById(@PathVariable Integer id) {
        Examen examen = examenServicio.getExamenById(id);
        if (examen != null) {
            return ResponseEntity.ok(examen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Examen create(@RequestBody Examen examen) {
        return examenServicio.createExamen(examen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> update(@PathVariable Integer id, @RequestBody Examen examenDetails) {
        Examen updatedExamen = examenServicio.updateExamen(id, examenDetails);
        if (updatedExamen != null) {
            return ResponseEntity.ok(updatedExamen);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        examenServicio.deleteExamen(id);
        return ResponseEntity.ok().build();
    }
}
