package mvc.controlador;

import mvc.vista.VentanaClinica;
import mvc.modelo.GestorHospital;

public class ControladorClinico {
    
    private VentanaClinica vista;
    private GestorHospital gestor;
    private String idMedico;
    
    public ControladorClinico(VentanaClinica vista, GestorHospital gestor, String idMedico) {
        this.vista = vista;
        this.gestor = gestor;
        this.idMedico = idMedico;
    }
    
    public void abrirPacientes() {
       
    }
    
    public void abrirTratamiento() {
        
    }
    
    public void abrirFactura() {
        
    }
}