package mvc.modelo;


public class Administrativo extends AAPersona {
    
    private String departamento;
    
    //C
    public Administrativo(String departamento, String ID, String nombre, String telf, String usuario, String contraseña) {    
        super(ID, nombre, telf, usuario, contraseña);
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
