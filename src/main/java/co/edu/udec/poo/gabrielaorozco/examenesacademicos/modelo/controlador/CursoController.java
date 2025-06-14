package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class CursoController {

    @Autowired
    private CursoServicio cursoServicio;

    public List<Curso> getAllCursos() throws Exception {
        return cursoServicio.getAllCursos();
    }

    public Curso getCursoById(Integer id) throws Exception {
        return cursoServicio.getCursoById(id);
    }

    public Curso createCurso(Curso curso) throws Exception {
        return cursoServicio.createCurso(curso);
    }

    public Curso updateCurso(Integer id, Curso cursoDetails) throws Exception {
        return cursoServicio.updateCurso(id, cursoDetails);
    }

    public void deleteCurso(Integer id) throws Exception {
        cursoServicio.deleteCurso(id);
    }

    public Integer contarCursos() throws Exception {
        return cursoServicio.contarCursos();
    }
}
