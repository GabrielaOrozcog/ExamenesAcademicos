package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenPractico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenPracticoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class ExamenPracticoController {

    @Autowired
    private ExamenPracticoServicio examenPracticoServicio;

    public List<ExamenPractico> getAllExamenesPracticos() throws Exception {
        return examenPracticoServicio.getAllExamenesPracticos();
    }

    public ExamenPractico getExamenPracticoById(Integer id) throws Exception {
        return examenPracticoServicio.getExamenPracticoById(id);
    }

    public ExamenPractico createExamenPractico(ExamenPractico examenPractico) throws Exception {
        return examenPracticoServicio.createExamenPractico(examenPractico);
    }

    public ExamenPractico updateExamenPractico(Integer id, ExamenPractico examenPracticoDetails) throws Exception {
        return examenPracticoServicio.updateExamenPractico(id, examenPracticoDetails);
    }

    public void deleteExamenPractico(Integer id) throws Exception {
        examenPracticoServicio.deleteExamenPractico(id);
    }

    public Integer contarExamenesPracticos() throws Exception {
        return examenPracticoServicio.contarExamenesPracticos();
    }
}
