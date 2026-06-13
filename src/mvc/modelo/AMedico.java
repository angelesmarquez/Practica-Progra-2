package mvc.modelo;

public class AMedico extends AAPersona {
    private String especialidad;
    private int licMedica;
    
    //Constructores 
    public AMedico(String especialidad, int licMedica, int ID, String nombre, int telf) {
        super(ID, nombre, telf);
        this.especialidad = especialidad;
        this.licMedica = licMedica;
    }
    
    //Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getLicMedica() {
        return licMedica;
    }

    public void setLicMedica(int licMedica) {
        this.licMedica = licMedica;
    }
    
    @Override 
    public String realizarAccion(){
        return "Diagnosticar paciente";
    }
    public String generarReporte(){
        return "Generar Reporte";
    }
}
