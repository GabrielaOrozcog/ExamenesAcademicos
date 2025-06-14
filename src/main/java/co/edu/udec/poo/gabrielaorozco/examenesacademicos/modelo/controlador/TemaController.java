package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Tema;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.TemaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */

@Component
public class TemaController {

    @Autowired
    private TemaServicio temaServicio;

    public List<Tema> getAllTemas() throws Exception {
        return temaServicio.getAllTemas();
    }

    public Tema getTemaById(Integer id) throws Exception {
        return temaServicio.getTemaById(id);
    }

    public Tema createTema(Tema tema) throws Exception {
        return temaServicio.createTema(tema);
    }

    public Tema updateTema(Integer id, Tema temaDetails) throws Exception {
        return temaServicio.updateTema(id, temaDetails);
    }

    public void deleteTema(Integer id) throws Exception {
        temaServicio.deleteTema(id);
    }

    public Integer contarTemas() throws Exception {
        return temaServicio.contarTemas();
    }
}
