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

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenEscrito;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenEscritoServicio;

/**
 *
 * @author Gabriela
 */
@RestController
@RequestMapping("/api/examenes-escritos")
public class ExamenEscritoCrud {

    @Autowired
    private ExamenEscritoServicio examenEscritoServicio;

    @GetMapping
    public List<ExamenEscrito> getAll() {
        return examenEscritoServicio.getAllExamenesEscritos();
                
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamenEscrito> getById(@PathVariable Integer id) {
        ExamenEscrito examenEscrito = examenEscritoServicio.getExamenEscritoById(id);
        if (examenEscrito != null) {
            return ResponseEntity.ok(examenEscrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ExamenEscrito create(@RequestBody ExamenEscrito examenEscrito) {
        return examenEscritoServicio.createExamenEscrito(examenEscrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExamenEscrito> update(@PathVariable Integer id, @RequestBody ExamenEscrito examenEscritoDetails) {
        ExamenEscrito updatedExamenEscrito = examenEscritoServicio.updateExamenEscrito(id, examenEscritoDetails);
        if (updatedExamenEscrito != null) {
            return ResponseEntity.ok(updatedExamenEscrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        examenEscritoServicio.deleteExamenEscrito(id);
        return ResponseEntity.ok().build();
    }

    @Repository
    public static interface ExamenEscritoRepository extends JpaRepository<ExamenEscrito, Integer> { }
}
