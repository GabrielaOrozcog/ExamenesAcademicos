package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Tema;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.TemaServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(10)
public class TemaPrueba implements CommandLineRunner {

    @Autowired
    private TemaServicio temaServicio;

    @Autowired
    private AsignaturaServicio asignaturaServicio;

    @Autowired
    private CursoServicio cursoServicio;

    @Override
    public void run(String... args) throws Exception {
        try {
            Integer idAsignatura = 101;


            Asignatura asignaturaProgramacion = configurarAsignatura(idAsignatura, "CS");


            Tema tema = crearTema(
                    1, "Arreglos", "Tema para segundo semestre", "Libros", "Facil", asignaturaProgramacion
            );


            demostrarOperacionesCRUD(tema.getId_Tema());

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

    

    private Asignatura configurarAsignatura(Integer idAsignatura, String nombreAsignatura) throws Exception {
    try {
        return asignaturaServicio.getAsignaturaById(idAsignatura);
    } catch (Exception e) {
        Asignatura nuevoAsignatura = new Asignatura();
        nuevoAsignatura.setIdAsignatura(idAsignatura);
        nuevoAsignatura.setNombreAsignatura(nombreAsignatura);


        Curso curso = configurarCurso(100, "A4");
        nuevoAsignatura.setCurso(curso);

        return asignaturaServicio.createAsignatura(nuevoAsignatura);
    }
}


    private Tema crearTema(Integer idTema, String nombreTema, String descripcionTema, String recursos, String nivelDificultad, Asignatura asignatura) throws Exception {
        System.out.println("\n=== Creando nuevo tema ===");
        Tema tema = new Tema();
        tema.setId_Tema(idTema);
        tema.setNombreTema(nombreTema);
        tema.setDescripcionTema(descripcionTema);
        tema.setRecursos(recursos);
        tema.setNivelDificultadTema(nivelDificultad);
        tema.setAsignatura(asignatura);

        Tema creado = temaServicio.createTema(tema);
        System.out.printf(
                "Tema creado exitosamente:\nID: %d | Nombre: %s | Descripcion: %s | Recursos: %s | Nivel Dificultad: %s | Asignatura: %s\n",
                creado.getId_Tema(),
                creado.getNombreTema(),
                creado.getDescripcionTema(),
                creado.getRecursos(),
                creado.getNivelDificultadTema(),
                creado.getAsignatura() != null ? creado.getAsignatura().getNombreAsignatura() : "Sin asignatura"
        );
        return creado;
    }

    private void demostrarOperacionesCRUD(Integer idTema) throws Exception {
        System.out.println("\n=== Obteniendo tema por ID ===");
        Tema tema = temaServicio.getTemaById(idTema);
        System.out.println("Tema obtenido: " + tema.getNombreTema()
                + " - Asignatura: " + tema.getAsignatura().getNombreAsignatura());

        System.out.println("\n=== Actualizando tema ===");
        Tema actualizacion = new Tema();
        actualizacion.setNombreTema("El hombre como ser social");
        actualizacion.setDescripcionTema("Tema para tercer semestre");
        actualizacion.setRecursos("Videos");
        actualizacion.setNivelDificultadTema("Media");
        actualizacion.setAsignatura(tema.getAsignatura());

        Tema actualizado = temaServicio.updateTema(idTema, actualizacion);
        System.out.printf(
                "Tema actualizado exitosamente:\nID: %d | Nombre: %s | Descripcion: %s | Recursos: %s | Nivel Dificultad: %s | Asignatura: %s\n",
                actualizado.getId_Tema(),
                actualizado.getNombreTema(),
                actualizado.getDescripcionTema(),
                actualizado.getRecursos(),
                actualizado.getNivelDificultadTema(),
                actualizado.getAsignatura() != null ? actualizado.getAsignatura().getNombreAsignatura() : "Sin asignatura"
        );

        System.out.println("\n=== Listado completo de temas ===");
        temaServicio.getAllTemas().forEach(a
                -> System.out.println(String.format(
                        "ID: %d | Nombre: %s | Descripcion: %s | Recursos: %s | Nivel Dificultad: %s | Asignatura: %s",
                        a.getId_Tema(),
                        a.getNombreTema(),
                        a.getDescripcionTema(),
                        a.getRecursos(),
                        a.getNivelDificultadTema(),
                        a.getAsignatura() != null ? a.getAsignatura().getNombreAsignatura() : "Sin asignatura"
                )));

        System.out.println("\nTotal temas registrados: " + temaServicio.contarTemas());


        // System.out.println("\n=== Eliminando tema ===");
        // temaServicio.deleteTema(id_Tema);
        // System.out.println("Tema eliminado exitosamente");
    }
}
