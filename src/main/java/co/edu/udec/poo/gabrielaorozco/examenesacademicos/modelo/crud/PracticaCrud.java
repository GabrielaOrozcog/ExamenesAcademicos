package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Practica;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.PracticaServicio;

@RestController
@RequestMapping("/api/practicas")
public class PracticaCrud {

    @Autowired
    private PracticaServicio practicaServicio;

    @GetMapping
    public List<Practica> getAll() {
        return practicaServicio.getAllPracticas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practica> getById(@PathVariable Integer id) {
        Practica practica = practicaServicio.getPracticaById(id);
        if (practica != null) {
            return ResponseEntity.ok(practica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Practica create(@RequestBody Practica practica) {
        return practicaServicio.createPractica(practica);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Practica> update(@PathVariable Integer id, @RequestBody Practica practicaDetails) {
        Practica updatedPractica = practicaServicio.updatePractica(id, practicaDetails);
        if (updatedPractica != null) {
            return ResponseEntity.ok(updatedPractica);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        practicaServicio.deletePractica(id);
        return ResponseEntity.ok().build();
    }

    @Repository
    public static interface PracticaRepository extends JpaRepository<Practica, Integer> { }
}
