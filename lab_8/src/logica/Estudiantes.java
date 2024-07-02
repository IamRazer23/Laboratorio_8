package logica;



public class Estudiantes {
	private String nombre;
    private String cedula;
    private String carrera;
    private double indiceAcademico;
    private String sexo;

    public Estudiantes(String nombre, String cedula, String carrera, double indiceAcademico, String sexo) {
        if (indiceAcademico < 0.0 || indiceAcademico > 3.0) {
            throw new IllegalArgumentException("El índice académico debe estar entre 0.0 y 3.0");
        }
        
        this.nombre = nombre;
        this.cedula = cedula;
        this.carrera = carrera;
        this.indiceAcademico = indiceAcademico;
        this.sexo = sexo;
    }

    public double getIndiceAcademico() {
        return indiceAcademico;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getCedula() {
        return cedula;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getSexo() {
        return sexo;
    }
}