package mvc.controlador;

import mvc.vista.VentanaClinica;
import mvc.vista.VentanaListaPacients;
import mvc.vista.VentanaTratamiento;
import mvc.modelo.GestorHospital;
import mvc.modelo.AATratamiento;
import mvc.modelo.ACirugia;
import mvc.modelo.ATerapia;
import mvc.modelo.AMedicacion;
import mvc.modelo.Paciente;

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
        VentanaListaPacients ventana = new VentanaListaPacients((java.awt.Dialog) vista.getOwner(), true);
        cargarPacientes(ventana);
        ventana.getBotonAlta().addActionListener(e -> darDeAlta(ventana));
        ventana.setVisible(true);
    }
    
    public void abrirTratamiento() {
    VentanaTratamiento ventana = new VentanaTratamiento((java.awt.Dialog) vista.getOwner(), true);
    cargarComboPacientes(ventana);
    ventana.getBotonAsignar().addActionListener(e -> asignarTratamientoNuevo(ventana));
    ventana.setVisible(true);
}

    private void asignarTratamientoNuevo(VentanaTratamiento ventana) {
        String itemPaciente = (String) ventana.getComboPacientes().getSelectedItem();
        String tipo = (String) ventana.getComboTipo().getSelectedItem();
        String campo1 = ventana.getCampoDinamico1().getText().trim();
        String campo2 = ventana.getCampoDinamico2().getText().trim();
        String costoBaseStr = ventana.getCampoCostoBase().getText().trim();

        // VALIDAR CAMPOS VACIOS 
        if (itemPaciente == null || campo1.isEmpty() || campo2.isEmpty() || costoBaseStr.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(ventana, "Por favor llena todos los campos.");
            return;
        }

        try {
            String idPaciente = itemPaciente.split(" - ")[0];
            float costoBase = Float.parseFloat(costoBaseStr);
            int idNuevo = gestor.getvTratamiento().size() + 1;
            AATratamiento tratamiento = null;

            switch (tipo) {
                case "Cirugía":
                if (campo1.matches(".*\\d.*")) {
                    javax.swing.JOptionPane.showMessageDialog(ventana, "El tipo de cirugía no puede contener números.");
                    return;
                }
                float costoComplejidad = Float.parseFloat(campo2);
                tratamiento = new ACirugia(campo1, costoComplejidad, idNuevo, "Cirugía", costoBase);
                break;
                case "Terapia":
                    int sesiones = Integer.parseInt(campo1);
                    int semanas = Integer.parseInt(campo2);
                    tratamiento = new ATerapia(sesiones, semanas, idNuevo, "Terapia", costoBase);
                    break;
                case "Medicación":
                    float dosis = Float.parseFloat(campo1);
                    int dias = Integer.parseInt(campo2);
                    tratamiento = new AMedicacion(dosis, dias, idNuevo, "Medicación", costoBase);
                    break;
            }

            gestor.getvTratamiento().put(idNuevo, tratamiento);
            gestor.asignarTratamiento(idPaciente, idNuevo);
            gestor.GuardarDatos();
            
            javax.swing.JOptionPane.showMessageDialog(ventana, "Tratamiento asignado correctamente.");
            ventana.dispose();

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(ventana, "Los campos numéricos deben ser números válidos.");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(ventana, ex.getMessage());
        }
      
    }
    
    private void cargarPacientes(VentanaListaPacients ventana) {
     javax.swing.table.DefaultTableModel modelo = ventana.getModeloTabla();
     modelo.setRowCount(0);
      for (Paciente p : gestor.obtenerPacientesPorMedico(idMedico)) {
         String tratamiento = p.getListaTratamientos().isEmpty() ? "Terminado" : "En curso";
          modelo.addRow(new Object[]{p.getIdP(), p.getNombre(), p.getEstado(), tratamiento});
        }
    }
    
    private void cargarComboPacientes(VentanaTratamiento ventana) {
        ventana.getComboPacientes().removeAllItems();
        for (Paciente p : gestor.obtenerPacientesPorMedico(idMedico)) {
            ventana.getComboPacientes().addItem(p.getIdP() + " - " + p.getNombre());
        }
    }
    
    private void darDeAlta(VentanaListaPacients ventana) {
     int fila = ventana.getTablaPacientes().getSelectedRow();
     if (fila == -1) {
         javax.swing.JOptionPane.showMessageDialog(ventana, "Seleccione un paciente primero.");
         return;
        }
     String idPaciente = ventana.getModeloTabla().getValueAt(fila, 0).toString();
     String tratamiento = ventana.getModeloTabla().getValueAt(fila, 3).toString();
    
     if (tratamiento.equals("En curso")) {
         javax.swing.JOptionPane.showMessageDialog(ventana, "El paciente aún tiene tratamientos en curso.");
         return;
       }
    
     int confirmacion = javax.swing.JOptionPane.showConfirmDialog(ventana, 
     "¿Dar de alta al paciente?", "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
    
     if (confirmacion == javax.swing.JOptionPane.YES_OPTION) {
        gestor.getvPacientes().remove(idPaciente);
        gestor.GuardarDatos();
        cargarPacientes(ventana);
        javax.swing.JOptionPane.showMessageDialog(ventana, "Paciente dado de alta exitosamente.");
    }
   }
 }