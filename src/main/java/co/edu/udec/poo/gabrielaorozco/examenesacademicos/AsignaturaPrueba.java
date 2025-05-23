package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(3)
public class AsignaturaPrueba implements CommandLineRunner {

    @Autowired
    private AsignaturaServicio asignaturaServicio;
    
    @Autowired 
    private CursoServicio cursoServicio;
    
    

    @Override
    public void run(String... args) throws Exception {
        try {
            

            Curso curso = configurarCurso(101, "Base");
            
            Asignatura asignatura = crearAsignatura(1, "POO", 3, "Programacion orientada a objetos", 2025, 6, curso);
            
            demostrarOperacionesCRUD(asignatura.getIdAsignatura());
            
        } catch (Exception e) {
            System.err.println("Error en pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private Curso configurarCurso(Integer idCurso, String nombreCurso) throws Exception {
        try {
            return cursoServicio.getCursoById(idCurso);
        } catch (Exception e) {
            System.out.println("Curso no encontrado, creando nuevo curso...");
            Curso nuevoCurso = new Curso();
            nuevoCurso.setIdCurso(idCurso);
            nuevoCurso.setNombreCurso(nombreCurso);
            return cursoServicio.createCurso(nuevoCurso);
        }
    }
    
    
    private Asignatura crearAsignatura(Integer idAsignatura, String nombreAsignatura, Integer creditos, String descripcionAsignatura,Integer anioAcademico, Integer semestre, Curso curso ) throws Exception {
        System.out.println("\n=== Creando nueva asignatura ===");
        Asignatura asignatura = new Asignatura();
        asignatura.setIdAsignatura(idAsignatura);
        asignatura.setNombreAsignatura(nombreAsignatura);
        asignatura.setCreditos(creditos);
        asignatura.setDescripcionAsignatura(descripcionAsignatura);
        asignatura.setAnioAcademico(anioAcademico);
        asignatura.setSemestre(semestre);
        asignatura.setCurso(curso);

        
        Asignatura creada = asignaturaServicio.createAsignatura(asignatura);
        System.out.printf(
        "Asignatura creada exitosamente:\nID: %d | Nombre: %s | Creditos: %d | Descripcion: %s| Anio: %d | Semestre: %d\n",
        creada.getIdAsignatura(),
        creada.getNombreAsignatura(),
        creada.getCreditos(),
        creada.getDescripcionAsignatura(),
        creada.getAnioAcademico(),
        creada.getSemestre(),
        creada.getCurso().getNombreCurso()
        );
        return creada;
    }
    
    private void demostrarOperacionesCRUD(Integer idAsignatura) throws Exception {
        System.out.println("\n=== Obteniendo asignatura por ID ===");
        Asignatura asignatura = asignaturaServicio.getAsignaturaById(idAsignatura);
        System.out.println("Asignatura obtenida: " + asignatura.getNombreAsignatura()) ;
                         
        
        
        
        System.out.println("\n=== Actualizando asignatura ===");
        Asignatura actualizacion = new Asignatura();
        actualizacion.setNombreAsignatura("CS");
        actualizacion.setCreditos(2);
        actualizacion.setDescripcionAsignatura("Ciencias Sociales");
        actualizacion.setAnioAcademico(2026);
        actualizacion.setSemestre(6);
        actualizacion.setCurso(asignatura.getCurso());
        
        
        Asignatura actualizada = asignaturaServicio.updateAsignatura(idAsignatura, actualizacion);
        System.out.printf(
        "Asignatura actualizada:\nID: %d | Nombre: %s | Creditos: %d | Descripcion: %s | Anio: %d | Semestre: %d | Curso: %s\n",
        actualizada.getIdAsignatura(),
        actualizada.getNombreAsignatura(),
        actualizada.getCreditos(),
        actualizada.getDescripcionAsignatura(),
        actualizada.getAnioAcademico(),
        actualizada.getSemestre(),
        actualizada.getCurso().getNombreCurso()
        );
        

        System.out.println("\n=== Listado completo de asignaturas ===");
        asignaturaServicio.getAllAsignaturas().forEach(a ->
            System.out.printf("ID: %d | Nombre: %s | Curso: %s\n",
                a.getIdAsignatura(),
                a.getNombreAsignatura(),
                a.getCurso() != null ? a.getCurso().getNombreCurso() : "Sin curso")
        );
        
  
        System.out.println("\nTotal asignaturas registradas: " + asignaturaServicio.contarAsignaturas());
        
        
        /*System.out.println("\n=== Eliminando asignatura ===");
        asignaturaServicio.deleteAsignatura(idAsignatura);
        System.out.println("Asignatura eliminada exitosamente");*/
        
    }
}
