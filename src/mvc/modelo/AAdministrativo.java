package mvc.modelo;
public class AAdministrativo extends AAPersona {
    
    private String departamento;
    
    //C
    public AAdministrativo(String departamento, int ID, String nombre, int telf) {
        super(ID, nombre, telf);
        this.departamento = departamento;
    }
    //G&S
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    @Override 
    public String realizarAccion (){
        return "gestionar facturación";
    }
    public String generarReporte (){
        return "generar reporte";
    }
}
