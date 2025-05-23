package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.*;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(7)
public class ExamenEscritoPrueba implements CommandLineRunner {

    @Autowired
    private ExamenEscritoServicio examenEscritoServicio;

    @Autowired
    private AlumnoServicio alumnoServicio;

    @Autowired
    private AsignaturaServicio asignaturaServicio;

    @Autowired
    private ProfesorServicio profesorServicio;

    @Override
    public void run(String... args) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaRealizacion = sdf.parse("2025/05/23");
            Date fechaCreacion = sdf.parse("2025/05/22");

            ExamenEscrito examenEscrito = crearExamenEscrito(
                    100, "Grupo A1", fechaRealizacion, fechaCreacion, "escrito",
                    1, 1, 1,
                    10, 4.5, 3.7);

            demostrarOperacionesCRUD(examenEscrito.getIdExamen());

        } catch (Exception e) {
            System.err.println("Error en pruebas : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private ExamenEscrito crearExamenEscrito(
            Integer idExamen, String grupo, Date fechaRealizacion, Date fechaCreacion,
            String tipoExamen, Integer idAlumno, Integer idAsignatura, Integer idProfesor,
            int numeroPreguntas, double componenteTeorico, double componenteRedaccion
    ) throws Exception {

        System.out.println("\n=== Creando nuevo examen escrito ===");

        Alumno alumno = alumnoServicio.getAlumnoById(idAlumno);
        Asignatura asignatura = asignaturaServicio.getAsignaturaById(idAsignatura);
        Profesor profesor = profesorServicio.getProfesorById(idProfesor);

        ExamenEscrito examen = new ExamenEscrito();
        examen.setIdExamen(idExamen);
        examen.setGrupo(grupo);
        examen.setFechaRealizacion(fechaRealizacion);
        examen.setFechaCreacionExamen(fechaCreacion);
        examen.setTipoExamen(tipoExamen);
        examen.setAlumno(alumno);
        examen.setAsignatura(asignatura);
        examen.setProfesor(profesor);
        examen.setNumeroPreguntas(numeroPreguntas);
        examen.setComponenteTeorico(componenteTeorico);
        examen.setComponenteRedaccion(componenteRedaccion);

        ExamenEscrito creado = examenEscritoServicio.createExamenEscrito(examen);
        System.out.println(String.format(
                "ID: %d | Preguntas: %d | Teorico: %.2f | Redaccion: %.2f | Nota Final: %.2f | Alumno: %s | Asignatura: %s | Profesor: %s",
                creado.getIdExamen(),
                creado.getNumeroPreguntas(),
                creado.getComponenteTeorico(),
                creado.getComponenteRedaccion(),
                creado.calcularNotaFinal(),
                creado.getAlumno().getNombre_Alumno(),
                creado.getAsignatura().getNombreAsignatura(),
                creado.getProfesor().getNombre_Profesor()
        ));
        return creado;
    }

    private void demostrarOperacionesCRUD(Integer idExamen) throws Exception {
        System.out.println("\n=== Obteniendo examen escrito por ID ===");
        ExamenEscrito examen = examenEscritoServicio.getExamenEscritoById(idExamen);
        System.out.println("Examen escrito obtenido: ID = " + examen.getIdExamen());

        System.out.println("\n=== Actualizando Examen escrito ===");
        examen.setNumeroPreguntas(15);
        examen.setComponenteTeorico(4.8);
        examen.setComponenteRedaccion(4.2);

        ExamenEscrito actualizado = examenEscritoServicio.updateExamenEscrito(idExamen, examen);
        System.out.println("Examen escrito actualizado con nueva nota final: " + actualizado.calcularNotaFinal());

        System.out.println("\n=== Listando todos los examenes escritos ===");
        examenEscritoServicio.getAllExamenesEscritos().forEach(a -> {
            System.out.println(String.format(
                    "ID: %d | Preguntas: %d | Teorico: %.2f | Redaccion: %.2f | Nota Final: %.2f | Alumno: %s | Asignatura: %s | Profesor: %s",
                    a.getIdExamen(),
                    a.getNumeroPreguntas(),
                    a.getComponenteTeorico(),
                    a.getComponenteRedaccion(),
                    a.calcularNotaFinal(),
                    a.getAlumno().getNombre_Alumno(),
                    a.getAsignatura().getNombreAsignatura(),
                    a.getProfesor().getNombre_Profesor()
            ));
        });

        System.out.println("\nTotal examenes escritos: " + examenEscritoServicio.contarExamenesEscritos());

        // 
        // examenEscritoServicio.deleteExamenEscrito(idExamen);
        // System.out.println("Examen escrito eliminado exitosamente.");
    }
}
