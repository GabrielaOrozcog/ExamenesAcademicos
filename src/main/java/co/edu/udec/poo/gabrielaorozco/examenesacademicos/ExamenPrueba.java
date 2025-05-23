package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Examen;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(6)
public class ExamenPrueba implements CommandLineRunner {

    @Autowired
    private ExamenServicio examenServicio;

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
            Date fechaRealizacion = sdf.parse("2025/05/22");
            Date fechaCreacionExamen = sdf.parse("2025/05/22");

            Examen examen = crearExamen(1, "2A diurno", fechaRealizacion, fechaCreacionExamen, "escrito", 1, 1, 1);

            demostrarOperacionesCRUD(examen.getIdExamen());

        } catch (Exception e) {
            System.err.println("Error en pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Examen crearExamen(
            Integer idExamen,
            String grupo,
            Date fechaRealizacion,
            Date fechaCreacionExamen,
            String tipoExamen,
            Integer idAlumno,
            Integer idAsignatura,
            Integer idProfesor) throws Exception {

        System.out.println("\n=== Creando nuevo examen ===");

        Alumno alumno = alumnoServicio.getAlumnoById(idAlumno);
        if (alumno == null) {
            throw new Exception("No se encontro el alumno con ID: " + idAlumno);
        }

        Asignatura asignatura = asignaturaServicio.getAsignaturaById(idAsignatura);
        if (asignatura == null) {
            throw new Exception("No se encontro la asignatura con ID: " + idAsignatura);
        }
        
       
        Profesor profesor = profesorServicio.getProfesorById(idProfesor);
        if (profesor == null) {
            throw new Exception("No se encontro el profesor con ID: " + idProfesor);
        }

        Examen examen = new Examen();
        examen.setIdExamen(idExamen);
        examen.setGrupo(grupo);
        examen.setFechaRealizacion(fechaRealizacion);
        examen.setFechaCreacionExamen(fechaCreacionExamen);
        examen.setTipoExamen(tipoExamen);
        examen.setAlumno(alumno);
        examen.setAsignatura(asignatura);
        examen.setProfesor(profesor); 

        Examen creado = examenServicio.createExamen(examen);
        System.out.printf(
                "Examen creado exitosamente:\nID: %d | Grupo: %s | Fecha Realizacion: %s | Fecha Creacion: %s | Tipo: %s | Alumno: %s | Asignatura: %s | Profesor: %s\n",
                creado.getIdExamen(),
                creado.getGrupo(),
                creado.getFechaRealizacion(),
                creado.getFechaCreacionExamen(),
                creado.getTipoExamen(),
                creado.getAlumno().getNombre_Alumno(),
                creado.getAsignatura().getNombreAsignatura(),
                creado.getProfesor().getNombre_Profesor() 
        );
        return creado;
    }

    private void demostrarOperacionesCRUD(Integer idExamen) throws Exception {
        System.out.println("\n=== Obteniendo examen por ID ===");
        Examen examen = examenServicio.getExamenById(idExamen);
        System.out.println("Examen obtenido: " + examen.getIdExamen());

        System.out.println("\n=== Actualizando Examen ===");
        Examen actualizacion = new Examen();
        actualizacion.setIdExamen(idExamen); 
        actualizacion.setGrupo("A4");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date fechaCreacionExamen = sdf.parse("2025/05/25");
        Date fechaRealizacion = sdf.parse("2025/06/10");

        actualizacion.setFechaCreacionExamen(fechaCreacionExamen);
        actualizacion.setFechaRealizacion(fechaRealizacion);

        Alumno alumno = alumnoServicio.getAlumnoById(1);
        actualizacion.setAlumno(alumno);

        Asignatura asignatura = asignaturaServicio.getAsignaturaById(1);
        actualizacion.setAsignatura(asignatura);
        
        Profesor profesor = profesorServicio.getProfesorById(1);
        actualizacion.setProfesor(profesor);

        actualizacion.setTipoExamen("practico");

        Examen actualizado = examenServicio.updateExamen(idExamen, actualizacion);
        System.out.println("Examen actualizado: " + actualizado.getIdExamen());

        System.out.println("\n=== Listado completo de examenes ===");
        examenServicio.getAllExamenes().forEach(a -> System.out.println(String.format(
                "ID: %d | Grupo: %s | Fecha Realizacion: %s | Fecha Creacion: %s | Tipo: %s | Alumno: %s | Asignatura: %s | Profesor: %s",
                a.getIdExamen(),
                a.getGrupo(),
                a.getFechaRealizacion(),
                a.getFechaCreacionExamen(),
                a.getTipoExamen(),
                a.getAlumno().getNombre_Alumno(),
                a.getAsignatura().getNombreAsignatura(),
                a.getProfesor().getNombre_Profesor()
        )));

        System.out.println("\nTotal examenes registrados: " + examenServicio.contarExamenes());

        // === Eliminación (comentada por seguridad) ===
        // System.out.println("\n=== Eliminando examen ===");
        // examenServicio.deleteExamen(idExamen);
        // System.out.println("Examen eliminado exitosamente");
    }
}