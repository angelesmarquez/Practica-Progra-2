package mvc.modelo;

public abstract class  Persona {
    //Dclaracion de Variables
    protected int ID;
    protected String nombre;
    protected int telf;
    
    //Getter y Setters
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getTelf() {
        return telf;
    }
    public void setTelf(int telf) {
        this.telf = telf;
    }
    
    //Método Constructor
    public Persona(int ID, String nombre, int telf) {
        this.ID = ID;
        this.nombre = nombre;
        this.telf = telf;
    }
    
    //Metodos Abtractos
    public abstract String realizarAccion();
    public abstract String generarReporte();
}
