package mvc.modelo;
import java.util.ArrayList;

public class Paciente implements InterfaceAtendible {
    
    //Variables propias de la clase Paciente
    private String idP;
    private String nombre;
    private String historial;
    private String estado;
    private String tlf;
    private ArrayList<AATratamiento> listaTratamientos;
    private AMedico MedicoAsignado;   
    
    //C
    public Paciente(String idP, String nombre, String historial, String estado, String tlf, ArrayList<AATratamiento> listaTratamientos, AMedico MedicoAsignado) {
        this.idP = idP;
        this.nombre = nombre;
        this.historial = historial;
        this.estado = estado;
        this.tlf = tlf;
        this.listaTratamientos = listaTratamientos;
        this.MedicoAsignado = MedicoAsignado;
    }
    
    //Segundo Constructor quye no tiene el array de tratamiento y un estado neutral en estado, par la paret administrativa
    public Paciente(String idP, String nombre, String tlf, AMedico MedicoAsignado) {
        this.idP = idP;
        this.nombre = nombre;
        this.tlf = tlf;
        this.MedicoAsignado = MedicoAsignado;
        
        this.listaTratamientos = new ArrayList<>(); 
        this.estado = "Ingresado";
    }
    

    //G&S
    public void agregarTratamiento(AATratamiento tratamiento) {
    this.listaTratamientos.add(tratamiento);
}
    public String getIdP() {
        return idP;
    }
    public void setIdP(String idP) {
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
    public ArrayList<AATratamiento> getListaTratamientos() {
        return listaTratamientos;
    }
    public void setListaTratamientos(ArrayList<AATratamiento> listaTratamientos) {
        this.listaTratamientos = listaTratamientos;
    }
    public AMedico getMedicoAsignado() {
        return MedicoAsignado;
    }
     public void setMedicoAsignado(AMedico MedicoAsignado) {
        this.MedicoAsignado = MedicoAsignado;
     }
     
     
     
    public void asignarMedico(AMedico medico) {
     this.MedicoAsignado = medico;  
     }
     public void iniciarTratamiento(AATratamiento tratamiento) {
        listaTratamientos.add(tratamiento);
     }
     public void finalizarTratamiento(AATratamiento tratamiento) {
        listaTratamientos.remove(tratamiento);
     }
    
}
