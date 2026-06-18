package mvc.modelo;
import java.util.ArrayList;

public class Paciente {
    
    //Variables propias de la clase Paciente
    private int idP;
    private String nombre;
    private String historial;
    private String estado;
    private ArrayList<AATratamiento> listaTratamientos;
    private AMedico MedicoAsignado;   
    //faltaria el medico asignado, todavia no lo pongo esperando a empezar codificar, en caso de poner actualizar constructor,
    //gys

    public Paciente(int idP, String nombre, String historial, String estado, ArrayList<AATratamiento> listaTratamientos) {
        this.idP = idP;
        this.nombre = nombre;
        this.historial = historial;
        this.estado = estado;
        this.listaTratamientos = new ArrayList<>();
    }
    
    //G&S
    public int getIdP() {
        return idP;
    }
    public void setIdP(int idP) {
        this.idP = idP;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getHistorial() {
        return historial;
    }
    public void setHistorial(String historial) {
        this.historial = historial;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public AMedico getMedicoAsignado() {
    return MedicoAsignado;
    }
    public void setMedicoAsignado(AMedico MedicoAsignado) {
        this.MedicoAsignado = MedicoAsignado;
    }
    public ArrayList<AATratamiento> getListaTratamientos() {
        return listaTratamientos;
    }
    
    
    public void agregarTratamiento(AATratamiento tratamiento) {
    this.listaTratamientos.add(tratamiento);
}
}
