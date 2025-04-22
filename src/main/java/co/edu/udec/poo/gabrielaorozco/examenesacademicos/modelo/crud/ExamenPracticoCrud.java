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

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenPractico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenPracticoServicio;
/**
 *
 * @author Gabriela
 */
@RestController
@RequestMapping("/api/examenes-practicos")
public class ExamenPracticoCrud {

    @Autowired
    private ExamenPracticoServicio examenPracticoServicio;

    @GetMapping
    public List<ExamenPractico> getAll() {
        return examenPracticoServicio.getAllExamenesPracticos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenPractico> getById(@PathVariable Integer id) {
        ExamenPractico examenPractico = examenPracticoServicio.getExamenPracticoById(id);
        if (examenPractico != null) {
            return ResponseEntity.ok(examenPractico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ExamenPractico create(@RequestBody ExamenPractico examenPractico) {
        return examenPracticoServicio.createExamenPractico(examenPractico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenPractico> update(@PathVariable Integer id, @RequestBody ExamenPractico examenPracticoDetails) {
        ExamenPractico updatedExamenPractico = examenPracticoServicio.updateExamenPractico(id, examenPracticoDetails);
        if (updatedExamenPractico != null) {
            return ResponseEntity.ok(updatedExamenPractico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        examenPracticoServicio.deleteExamenPractico(id);
        return ResponseEntity.ok().build();
    }

    @Repository
    public static interface ExamenPracticoRepository extends JpaRepository<ExamenPractico, Integer> { }
}
