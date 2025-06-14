package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.DepartamentoAcademicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 * @author Gabriela
 */
@Component
public class DepartamentoAcademicoController {

    @Autowired
    private DepartamentoAcademicoServicio departamentoAcademicoServicio;

    public List<DepartamentoAcademico> getAllDepartamentosAcademicos() throws Exception {
        return departamentoAcademicoServicio.getAllDepartamentosAcademicos();
    }

    public DepartamentoAcademico getDepartamentoAcademicoById(Integer id) throws Exception {
        return departamentoAcademicoServicio.getDepartamentoAcademicoById(id);
    }

    public DepartamentoAcademico createDepartamentoAcademico(DepartamentoAcademico departamentoAcademico) throws Exception {
        return departamentoAcademicoServicio.createDepartamentoAcademico(departamentoAcademico);
    }

    public DepartamentoAcademico updateDepartamentoAcademico(Integer id, DepartamentoAcademico departamentoAcademicoDetails) throws Exception {
        return departamentoAcademicoServicio.updateDepartamentoAcademico(id, departamentoAcademicoDetails);
    }

    public void deleteDepartamentoAcademico(Integer id) throws Exception {
        departamentoAcademicoServicio.deleteDepartamentoAcademico(id);
    }

    public Integer contarDepartamentoAcademicos() throws Exception {
        return departamentoAcademicoServicio.contarDepartamentosAcademicos();
    }
}
