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
@Order(9)
public class ExamenPracticoPrueba implements CommandLineRunner {

    @Autowired
    private ExamenPracticoServicio examenPracticoServicio;

    @Autowired
    private AlumnoServicio alumnoServicio;

    @Autowired
    private AsignaturaServicio asignaturaServicio;

    @Autowired
    private ProfesorServicio profesorServicio;

    @Autowired
    private PracticaServicio practicaServicio;

    @Override
    public void run(String... args) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaRealizacion = sdf.parse("2025/06/23");
            Date fechaCreacion = sdf.parse("2025/06/22");

            ExamenPractico examenPractico = crearExamenPractico(
                    105, "Grupo A2", fechaRealizacion, fechaCreacion, "practico",
                    1, 1, 1,
                    4.2, 3.8, 1);

            demostrarOperacionesCRUD(examenPractico.getIdExamen());

        } catch (Exception e) {
            System.err.println("Error en pruebas : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private ExamenPractico crearExamenPractico(
            Integer idExamen, String grupo, Date fechaRealizacion, Date fechaCreacion,
            String tipoExamen, Integer idAlumno, Integer idAsignatura, Integer idProfesor,
            double componenteLaboratorio, double componenteEficiencia, Integer idPractica
    ) throws Exception {

        System.out.println("\n=== Creando nuevo examen practico ===");

        Alumno alumno = alumnoServicio.getAlumnoById(idAlumno);
        Asignatura asignatura = asignaturaServicio.getAsignaturaById(idAsignatura);
        Profesor profesor = profesorServicio.getProfesorById(idProfesor);
        Practica practica = practicaServicio.getPracticaById(idPractica);
        if (practica == null) {
            throw new Exception("No se encontró la práctica con ID: " + idPractica);
        }

        ExamenPractico examen = new ExamenPractico();
        examen.setIdExamen(idExamen);
        examen.setGrupo(grupo);
        examen.setFechaRealizacion(fechaRealizacion);
        examen.setFechaCreacionExamen(fechaCreacion);
        examen.setTipoExamen(tipoExamen);
        examen.setAlumno(alumno);
        examen.setAsignatura(asignatura);
        examen.setProfesor(profesor);
        examen.setComponenteLaboratorio(componenteLaboratorio);
        examen.setComponenteEficiencia(componenteEficiencia);
        examen.setPractica(practica);

        ExamenPractico creado = examenPracticoServicio.createExamenPractico(examen);
        System.out.println(String.format(
                "ID: %d | Laboratorio: %.2f | Eficiencia: %.2f | Nota Final: %.2f | Alumno: %s | Asignatura: %s | Profesor: %s",
                creado.getIdExamen(),
                creado.getComponenteLaboratorio(),
                creado.getComponenteEficiencia(),
                creado.calcularNotaFinal(),
                creado.getAlumno().getNombre_Alumno(),
                creado.getAsignatura().getNombreAsignatura(),
                creado.getProfesor().getNombre_Profesor()
        ));
        return creado;
    }

    private void demostrarOperacionesCRUD(Integer idExamen) throws Exception {
        System.out.println("\n=== Obteniendo examen practico por ID ===");
        ExamenPractico examen = examenPracticoServicio.getExamenPracticoById(idExamen);
        System.out.println("Examen practico obtenido: ID = " + examen.getIdExamen());

        System.out.println("\n=== Actualizando examen practico ===");
        examen.setComponenteLaboratorio(4.8);
        examen.setComponenteEficiencia(4.2);

        ExamenPractico actualizado = examenPracticoServicio.updateExamenPractico(idExamen, examen);
        System.out.println("Examen escrito practico con nueva nota final: " + actualizado.calcularNotaFinal());

        System.out.println("\n=== Listando todos los examenes practico ===");
        examenPracticoServicio.getAllExamenesPracticos().forEach(a -> {
            System.out.println(String.format(
                    "ID: %d  | Laboratorio: %.2f | Eficiencia: %.2f | Nota Final: %.2f | Alumno: %s | Asignatura: %s | Profesor: %s",
                    a.getIdExamen(),
                    a.getComponenteLaboratorio(),
                    a.getComponenteEficiencia(),
                    a.calcularNotaFinal(),
                    a.getAlumno().getNombre_Alumno(),
                    a.getAsignatura().getNombreAsignatura(),
                    a.getProfesor().getNombre_Profesor()
            ));
        });

        System.out.println("\nTotal examenes practicos : " + examenPracticoServicio.contarExamenesPracticos());

        //examenPracticoServicio.deleteExamenPractico(idExamen);
        //System.out.println("Examen practico eliminado exitosamente.");
    }
}
