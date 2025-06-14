package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class AlumnoController {

    @Autowired
    private AlumnoServicio alumnoServicio;

    public List<Alumno> getAllAlumnos() throws Exception {
        return alumnoServicio.getAllAlumnos();
    }

    public Alumno getAlumnoById(Integer id) throws Exception {
        return alumnoServicio.getAlumnoById(id);
    }

    public Alumno createAlumno(Alumno alumno) throws Exception {
        return alumnoServicio.createAlumno(alumno);
    }

    public Alumno UpdateAlumno(Integer id, Alumno alumnoDetails) throws Exception {
        return alumnoServicio.updateAlumno(id, alumnoDetails);
    }

    public void DeleteAlumno(Integer id) throws Exception {
        alumnoServicio.deleteAlumno(id);
    }

    public Integer contarAlumnos() throws Exception {
        return alumnoServicio.contarAlumnos();
    }
}
