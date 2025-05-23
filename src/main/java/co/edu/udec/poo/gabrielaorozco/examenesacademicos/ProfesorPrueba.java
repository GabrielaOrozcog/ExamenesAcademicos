package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.DepartamentoAcademicoServicio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(5)
public class ProfesorPrueba implements CommandLineRunner {

    @Autowired
    private ProfesorServicio profesorServicio;

    @Autowired
    private DepartamentoAcademicoServicio departamentoAcademicoServicio;

    @Override
    public void run(String... args) throws Exception {
        try {
            DepartamentoAcademico departamento = crearDepartamentoAcademico(2, "Departamento de Matematicas");

            Profesor profesor = crearProfesor(1, "Maria Lopez", "maria@gmail.com", departamento);

            demostrarOperacionesCRUD(profesor.getId_Profesor());

        } catch (Exception e) {
            System.err.println("Error en pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private DepartamentoAcademico crearDepartamentoAcademico(Integer id, String nombre) throws Exception {
        DepartamentoAcademico departamento = new DepartamentoAcademico();
        departamento.setIdDepartamentoAcademico(id);
        departamento.setNombre(nombre);
        return departamentoAcademicoServicio.createDepartamentoAcademico(departamento);
    }

    private Profesor crearProfesor(Integer id_Profesor, String nombre_Profesor, String email_Profesor, DepartamentoAcademico departamentoAcademico) throws Exception {
        System.out.println("\n=== Creando nuevo profesor ===");
        Profesor profesor = new Profesor();
        profesor.setId_Profesor(id_Profesor);
        profesor.setNombre_Profesor(nombre_Profesor);
        profesor.setEmail_Profesor(email_Profesor);
        profesor.setDepartamentoAcademico(departamentoAcademico);

        Profesor creado = profesorServicio.createProfesor(profesor);
        System.out.println("Profesor creado exitosamente: ID: " + creado.getId_Profesor() + " | Nombre: " + creado.getNombre_Profesor() + " | Email: " + creado.getEmail_Profesor() + " | Departamento: " + creado.getDepartamentoAcademico().getNombre());
        return creado;
    }

    private void demostrarOperacionesCRUD(Integer id_Profesor) throws Exception {
        System.out.println("\n=== Obteniendo profesor por ID ===");
        Profesor profesor = profesorServicio.getProfesorById(id_Profesor);
        System.out.println("Profesor obtenido: " + profesor.getNombre_Profesor());

        System.out.println("\n=== Actualizando Profesor ===");

        Profesor profesorExistente = profesorServicio.getProfesorById(id_Profesor);

        profesorExistente.setNombre_Profesor("Felicia");
        profesorExistente.setEmail_Profesor("felicia@gmail.com");



        Profesor actualizado = profesorServicio.updateProfesor(id_Profesor, profesorExistente);

        System.out.println("Profesor actualizado: " + actualizado.getNombre_Profesor() + " | Email: " + actualizado.getEmail_Profesor());

        System.out.println("\n=== Listado completo de profesores ===");
        profesorServicio.getAllProfesores().forEach(a
                -> System.out.println(String.format(
                        "ID: %d | Nombre: %s | Email: %s",
                        a.getId_Profesor(),
                        a.getNombre_Profesor(),
                        a.getEmail_Profesor()
                ))
        );

        System.out.println("\nTotal profesores registrados: " + profesorServicio.contarProfesores());
    }

    // System.out.println("\n=== Eliminando profesor ===");
    // profesorServicio.deleteProfesor(id_Profesor);
    // System.out.println("Profesor eliminado exitosamente");
}

