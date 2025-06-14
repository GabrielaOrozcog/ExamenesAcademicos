package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class AsignaturaController {

    @Autowired
    private AsignaturaServicio asignaturaServicio;

    public List<Asignatura> getAllAsignaturas() throws Exception {
        return asignaturaServicio.getAllAsignaturas();
    }

    public Asignatura getAsignaturaById(Integer id) throws Exception {
        return asignaturaServicio.getAsignaturaById(id);
    }

    public Asignatura createAsignatura(Asignatura asignatura) throws Exception {
        return asignaturaServicio.createAsignatura(asignatura);
    }

    public Asignatura updateAsignatura(Integer id, Asignatura asignaturaDetails) throws Exception {
        return asignaturaServicio.updateAsignatura(id, asignaturaDetails);
    }

    public void DeleteAsignatura(Integer id) throws Exception {
        asignaturaServicio.deleteAsignatura(id);
    }

    public Integer contarAsignaturas() throws Exception {
        return asignaturaServicio.contarAsignaturas();
    }
}
