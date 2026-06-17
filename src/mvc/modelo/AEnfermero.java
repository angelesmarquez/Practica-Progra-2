package mvc.modelo;

public class AEnfermero extends AAPersona{
    
    private String areaAsignada;
    
    //Constructore
    public AEnfermero(String areaAsignada, String ID, String nombre, String telf, String usuario, String contraseña) {
        super(ID, nombre, telf, usuario, contraseña);
        this.areaAsignada = areaAsignada;
    }
   

    //G&S
    public String getAreaAsignada() {
        return areaAsignada;
    }
    public void setAreaAsignada(String areaAsignada) {
        this.areaAsignada = areaAsignada;
    }
    
    @Override
    public String realizarAccion(){
        return "Administrar Medicación";
    }
    public String generarReporte(){
        return "Generar Reporte";
    }
}
