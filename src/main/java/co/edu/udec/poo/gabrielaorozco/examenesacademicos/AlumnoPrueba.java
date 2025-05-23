package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(2)
public class AlumnoPrueba implements CommandLineRunner {

    @Autowired
    private AlumnoServicio alumnoServicio;
    
    @Autowired 
    private CursoServicio cursoServicio;

    @Override
    public void run(String... args) throws Exception {
        try {

            Curso cursoProgramacion = configurarCurso(101, "A4");
            

            Alumno alumno = crearAlumno(1, "Juan Perez", "Grupo A", cursoProgramacion);
            

            demostrarOperacionesCRUD(alumno.getIdAlumno());
            
        } catch (Exception e) {
            System.err.println("Error en pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private Curso configurarCurso(Integer idCurso, String nombreCurso) throws Exception {
        try {
            return cursoServicio.getCursoById(idCurso);
        } catch (Exception e) {

            Curso nuevoCurso = new Curso();
            nuevoCurso.setIdCurso(idCurso);
            nuevoCurso.setNombreCurso(nombreCurso);
            return cursoServicio.createCurso(nuevoCurso);
        }
    }
    
    private Alumno crearAlumno(Integer id, String nombre, String grupo, Curso curso) throws Exception {
        System.out.println("\n=== Creando nuevo alumno ===");
        Alumno alumno = new Alumno();
        alumno.setIdAlumno(id);
        alumno.setNombre_Alumno(nombre);
        alumno.setGrupo(grupo);
        alumno.setCurso(curso);
        
        Alumno creado = alumnoServicio.createAlumno(alumno);
        System.out.printf(
        "Alumno creado exitosamente:\nID: %d | Nombre: %s | Grupo: %s | Curso: %s\n",
        creado.getIdAlumno(),
        creado.getNombre_Alumno(),
        creado.getGrupo(),
        creado.getCurso() != null ? creado.getCurso().getNombreCurso() : "Sin curso"
    );
        return creado;
    }
    
    private void demostrarOperacionesCRUD(Integer idAlumno) throws Exception {
        System.out.println("\n=== Obteniendo alumno por ID ===");
        Alumno alumno = alumnoServicio.getAlumnoById(idAlumno);
        System.out.println("Alumno obtenido: " + alumno.getNombre_Alumno() + 
                         " - Curso: " + alumno.getCurso().getNombreCurso());
        

        System.out.println("\n=== Actualizando alumno ===");
        Alumno actualizacion = new Alumno();
        actualizacion.setNombre_Alumno("Carlos Gomez");
        actualizacion.setGrupo("Grupo B");
        actualizacion.setCurso(alumno.getCurso());
        
        Alumno actualizado = alumnoServicio.updateAlumno(idAlumno, actualizacion);
        System.out.printf(
        "Alumno creado exitosamente:\nID: %d | Nombre: %s | Grupo: %s | Curso: %s\n",
        actualizado.getIdAlumno(),
        actualizado.getNombre_Alumno(),
        actualizado.getGrupo(),
        actualizado.getCurso() != null ? actualizado.getCurso().getNombreCurso() : "Sin curso"
    );
        

        System.out.println("\n=== Listado completo de alumnos ===");
        alumnoServicio.getAllAlumnos().forEach(a -> 
            System.out.println(String.format(
                "ID: %d | Nombre: %-15s | Grupo: %-8s | Curso: %s",
                a.getIdAlumno(),
                a.getNombre_Alumno(),
                a.getGrupo(),
                a.getCurso().getNombreCurso()
            )));
        

        System.out.println("\nTotal alumnos registrados: " + alumnoServicio.contarAlumnos());
        
        //Eliminación 
        // System.out.println("\n=== Eliminando alumno ===");
        // alumnoServicio.deleteAlumno(idAlumno);
        // System.out.println("Alumno eliminado exitosamente");
        
    }
}