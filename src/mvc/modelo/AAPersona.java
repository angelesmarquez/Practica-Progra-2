package mvc.modelo;

public abstract class  AAPersona {
    //Dclaracion de Variables
    protected String ID;
    protected String nombre;
    protected String telf;
    protected String usuario;
    protected String contraseña;
    
    //Getter y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelf() {
        return telf;
    }
    public void setTelf(String telf) {
        this.telf = telf;
    }
    
    //Método Constructor
    public AAPersona(String ID, String nombre, String telf, String usuario, String contraseña) {
        this.ID = ID;
        this.nombre = nombre;
        this.telf = telf;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    //Metodos Abtractos
    public abstract String realizarAccion();
    public abstract String generarReporte();

}
