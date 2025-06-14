package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenEscrito;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenEscritoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class ExamenEscritoController {

    @Autowired
    private ExamenEscritoServicio examenEscritoServicio;

    public List<ExamenEscrito> getAllExamenesEscritos() throws Exception {
        return examenEscritoServicio.getAllExamenesEscritos();
    }

    public ExamenEscrito getExamenEscritoById(Integer id) throws Exception {
        return examenEscritoServicio.getExamenEscritoById(id);
    }

    public ExamenEscrito createExamenEscrito(ExamenEscrito examenEscrito) throws Exception {
        return examenEscritoServicio.createExamenEscrito(examenEscrito);
    }

    public ExamenEscrito updateExamenEscrito(Integer id, ExamenEscrito examenEscritoDetails) throws Exception {
        return examenEscritoServicio.updateExamenEscrito(id, examenEscritoDetails);
    }

    public void deleteExamenEscrito(Integer id) throws Exception {
        examenEscritoServicio.deleteExamenEscrito(id);
    }

    public Integer contarExamenesEscritos() throws Exception {
        return examenEscritoServicio.contarExamenesEscritos();
    }
}
