package mvc.controlador;

import mvc.vista.VentanaListaPacientesEnfermero;
import mvc.vista.VentanaDetallesDosis;
import mvc.modelo.GestorHospital;
import mvc.vista.VentanaEnfermero;
import java.io.Serializable;

public class ControladorEnfermero implements Serializable {
    
    private VentanaEnfermero vista;
    private GestorHospital gestor;
    private String idEnfermero;

    public ControladorEnfermero(VentanaEnfermero vista, GestorHospital gestor, String idEnfermero) {
        this.vista = vista;
        this.gestor = gestor;
        this.idEnfermero = idEnfermero;
    }

    public void abrirPacientes() {
        VentanaListaPacientesEnfermero ventana = new VentanaListaPacientesEnfermero(null, true);
        cargarPacientes(ventana);
        ventana.getBotonVerDosis().addActionListener(e -> abrirDosis(ventana));
        ventana.setVisible(true);
    }

    public void abrirDosis(VentanaListaPacientesEnfermero ventana) {
        int fila = ventana.getTablaPacientes().getSelectedRow();
        if (fila == -1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Seleccione un paciente primero.");
            return;
        }
        String idPaciente = ventana.getModeloTabla().getValueAt(fila, 0).toString();
        mvc.modelo.Paciente paciente = gestor.getvPacientes().get(idPaciente);
        
        if (paciente != null) {
        VentanaDetallesDosis detalles = new VentanaDetallesDosis(null, true, paciente, gestor);
        detalles.setVisible(true);
        cargarPacientes(ventana);

        }
    }

    private void cargarPacientes(VentanaListaPacientesEnfermero ventana) {
        java.util.Map<String, mvc.modelo.Paciente> pacientes = gestor.getvPacientes();
        javax.swing.table.DefaultTableModel modelo = ventana.getModeloTabla();
        
        modelo.setRowCount(0);
        
        for (mvc.modelo.Paciente p : pacientes.values()) {
            String medico = p.getMedicoAsignado() != null ? p.getMedicoAsignado().getNombre() : "Sin médico";
            Object[] fila = {p.getIdP(), p.getNombre(), medico};
            modelo.addRow(fila);
        }
    }
}