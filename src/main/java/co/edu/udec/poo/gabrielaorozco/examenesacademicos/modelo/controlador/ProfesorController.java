package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class ProfesorController {

    @Autowired
    private ProfesorServicio profesorServicio;

    public List<Profesor> getAllProfesores() throws Exception {
        return profesorServicio.getAllProfesores();
    }

    public Profesor getProfesorById(Integer id) throws Exception {
        return profesorServicio.getProfesorById(id);
    }

    public Profesor createProfesor(Profesor profesor) throws Exception {
        return profesorServicio.createProfesor(profesor);
    }

    public Profesor updateProfesor(Integer id, Profesor profesorDetails) throws Exception {
        return profesorServicio.updateProfesor(id, profesorDetails);
    }

    public void deleteProfesor(Integer id) throws Exception {
        profesorServicio.deleteProfesor(id);
    }

    public Integer contarProfesores() throws Exception {
        return profesorServicio.contarProfesores();
    }
}
