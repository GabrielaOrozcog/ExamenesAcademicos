package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Practica;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.PracticaServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Order(8)
public class PracticaPrueba implements CommandLineRunner {

    @Autowired
    private PracticaServicio practicaServicio;

    @Autowired
    private ProfesorServicio profesorServicio;

    @Override
    public void run(String... args) throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaCreacion = sdf.parse("2025/05/26");

            Practica practica = crearPractica(1, "Practica 2", "Intermedio", fechaCreacion, Arrays.asList(1));

            demostrarOperacionesCRUD(practica.getIdPractica());

        } catch (Exception e) {
            System.err.println("Error en pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Practica crearPractica(int id, String titulo, String dificultad, Date fechaCreacion, List<Integer> idProfesores) throws Exception {

        List<Profesor> profesores = obtenerProfesoresPorIds(idProfesores);
        if (profesores.isEmpty()) {
            throw new Exception("No se encontraron profesores validos.");
        }

        System.out.println("\n=== Creando nueva practica ===");

        Practica practica = new Practica();
        practica.setIdPractica(id);
        practica.setTitulo(titulo);
        practica.setNivelDificultadPractica(dificultad);
        practica.setFechaCreacion(fechaCreacion);
        practica.setProfesores(profesores);

        Practica creada = practicaServicio.createPractica(practica);
        System.out.printf(
                "Practica creada exitosamente:\nID: %d | Titulo: %s | Nivel dificultad: %s | Fecha Creacion: %s\n",
                creada.getIdPractica(),
                creada.getTitulo(),
                creada.getNivelDificultadPractica(),
                creada.getFechaCreacion()
        );
        return creada;
    }

    private void demostrarOperacionesCRUD(Integer idPractica) throws Exception {
        System.out.println("\n=== Obteniendo practica por ID ===");
        Practica practica = practicaServicio.getPracticaById(idPractica);
        System.out.println("Practica obtenida: " + practica.getTitulo());

        System.out.println("\n=== Actualizando practica ===");
        Practica actualizacion = new Practica();
        actualizacion.setIdPractica(idPractica);
        actualizacion.setTitulo("Practica actualizada");
        actualizacion.setNivelDificultadPractica("Avanzado");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        actualizacion.setFechaCreacion(sdf.parse("2025/06/01"));

        List<Profesor> profesoresActualizados = obtenerProfesoresPorIds(Arrays.asList(1));
        actualizacion.setProfesores(profesoresActualizados);

        Practica actualizada = practicaServicio.updatePractica(idPractica, actualizacion);
        
        System.out.println("Practica actualizada: " + actualizada.getTitulo());

        System.out.println("\n=== Listado completo de practicas ===");
        practicaServicio.getAllPracticas().forEach(p -> {
            String nombresProfesores = p.getProfesores().stream()
                    .map(Profesor::getNombre_Profesor)
                    .reduce((a, b) -> a + ", " + b)
                    .orElse("Ninguno");
            System.out.printf(
                    "ID: %d | Titulo: %s | Nivel Dificultad: %s | Fecha Creacion: %s | Profesores: %s\n",
                    p.getIdPractica(),
                    p.getTitulo(),
                    p.getNivelDificultadPractica(),
                    p.getFechaCreacion(),
                    nombresProfesores
            );
        });

        System.out.println("\nTotal practicas registradas: " + practicaServicio.contarPracticas());

       
        // System.out.println("\n=== Eliminando practica ===");
        // practicaServicio.deletePractica(idPractica);
        // System.out.println("Practica eliminada exitosamente");
    }

    private List<Profesor> obtenerProfesoresPorIds(List<Integer> ids) {
    return ids.stream()
            .map(id -> {
                try {
                    return profesorServicio.getProfesorById(id);
                } catch (Exception e) {
                    // Puedes imprimir o registrar el error si es necesario
                    System.err.println("Error obteniendo profesor con ID: " + id);
                    return null;
                }
            })
            .filter(p -> p != null)
            .collect(Collectors.toList());
}

}
