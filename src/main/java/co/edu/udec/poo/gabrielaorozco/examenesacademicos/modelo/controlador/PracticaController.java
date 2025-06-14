package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Practica;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.PracticaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class PracticaController {

    @Autowired
    private PracticaServicio practicaServicio;

    public List<Practica> getAllPracticas() throws Exception {
        return practicaServicio.getAllPracticas();
    }

    public Practica getPracticaById(Integer id) throws Exception {
        return practicaServicio.getPracticaById(id);
    }

    public Practica createPractica(Practica practica) throws Exception {
        return practicaServicio.createPractica(practica);
    }

    public Practica updatePractica(Integer id, Practica practicaDetails) throws Exception {
        return practicaServicio.updatePractica(id, practicaDetails);
    }

    public void deletePractica(Integer id) throws Exception {
        practicaServicio.deletePractica(id);
    }

    public Integer contarPracticas() throws Exception {
        return practicaServicio.contarPracticas();
    }
}
