package logica;
import java.util.ArrayList;

public class Becas {
	private static final int MAX_ESTUDIANTES = 100;
    private ArrayList<Estudiantes> estudiantes;

    public Becas() {
        estudiantes = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiantes estudiante) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(estudiante);
        } else {
            System.out.println("No se puede agregar más estudiantes. Límite alcanzado.");
        }
    }
    
    public Estudiantes buscarPorCedula(String cedula) {
    	for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                return estudiante;
            }
    	}
    	return null;
    }

    public ArrayList<String> obtenerEstudiantesBecados() {
        ArrayList<String> estudiantesBecados = new ArrayList<>();

        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0) {
                estudiantesBecados.add(estudiante.getNombre());
            }
        }

        return estudiantesBecados;
    }

    public ArrayList<String> obtenerBecadosPorCarrera(String carrera) {
        ArrayList<String> becadosPorCarrera = new ArrayList<>();
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0 && estudiante.getCarrera().equals(carrera)) {
                becadosPorCarrera.add(estudiante.getNombre());
            }
        }
        return becadosPorCarrera;
    }

    public ArrayList<String> obtenerBecadosPorSexo(String sexo) {
        ArrayList<String> becadosPorSexo = new ArrayList<>();
        for (Estudiantes estudiante : estudiantes) {
            if (estudiante.getIndiceAcademico() >= 2.0 && estudiante.getSexo().equals(sexo)) {
                becadosPorSexo.add(estudiante.getNombre());
            }
        }
        return becadosPorSexo;
    }
    
}
