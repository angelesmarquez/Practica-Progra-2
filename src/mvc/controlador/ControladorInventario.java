package mvc.controlador;

import javax.swing.table.DefaultTableModel;
import mvc.modelo.AAPersona;
import mvc.modelo.AATratamiento;
import mvc.modelo.GestorHospital;
import mvc.modelo.InterfaceAuditable;
import mvc.modelo.Paciente;
import mvc.vista.VistaInventario;

public class ControladorInventario {
    
    private VistaInventario vista;
    private GestorHospital gestor;

    public ControladorInventario(VistaInventario vista, GestorHospital gestor) {
        this.vista = vista;
        this.gestor = gestor;    
    }
    
    public void LlenarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) vista.getTablaT().getModel();
        modelo.setRowCount(0);
        
        java.util.ArrayList<Paciente> listaPacientes = new java.util.ArrayList<>(gestor.getvPacientes().values());
        for (int i = 0; i < listaPacientes.size(); i++) {
            Paciente paciente = listaPacientes.get(i);
            String nombrePac= paciente.getNombre();
            
            //Array para los tratamientos
            java.util.ArrayList<AATratamiento> listaTratamiento = paciente.getListaTratamientos();
            for (int j = 0; j < listaTratamiento.size(); j++) {
                AATratamiento tratamiento = listaTratamiento.get(j);
                InterfaceAuditable tratamientoAu = (InterfaceAuditable) tratamiento;
                Object[] datos = tratamientoAu.datosTratamiento(nombrePac);
                modelo.addRow(datos);
            }
        }
    }
}
