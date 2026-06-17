package mvc.modelo;

public class AMedico extends AAPersona {
    private String especialidad;
    private String licMedica;
    
    //Constructores 
    public AMedico(String especialidad, String licMedica, String ID, String nombre, String telf, String usuario, String contraseña) {
        super(ID, nombre, telf, usuario, contraseña);
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

    public String getLicMedica() {
        return licMedica;
    }

    public void setLicMedica(String licMedica) {
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
