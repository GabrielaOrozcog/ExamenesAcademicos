package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Examen;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class ExamenController {

    @Autowired
    private ExamenServicio examenServicio;

    public List<Examen> getAllExamenes() throws Exception {
        return examenServicio.getAllExamenes();
    }

    public Examen getExamenById(Integer id) throws Exception {
        return examenServicio.getExamenById(id);
    }

    public Examen createExamen(Examen examen) throws Exception {
        return examenServicio.createExamen(examen);
    }

    public Examen updateExamen(Integer id, Examen examenDetails) throws Exception {
        return examenServicio.updateExamen(id, examenDetails);
    }

    public void deleteExamen(Integer id) throws Exception {
        examenServicio.deleteExamen(id);
    }

    public Integer contarExamenes() throws Exception {
        return examenServicio.contarExamenes();
    }
}
