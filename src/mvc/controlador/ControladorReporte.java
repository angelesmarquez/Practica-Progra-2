package mvc.controlador;

import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mvc.modelo.AAPersona;
import mvc.modelo.AEnfermero;
import mvc.modelo.AMedico;
import mvc.modelo.Administrativo;
import mvc.modelo.GestorHospital;
import mvc.modelo.InterfaceAuditable;
import mvc.vista.VistaReporte;

public class ControladorReporte implements Serializable {
    
    private VistaReporte vista;
    private GestorHospital gestor;
    //c
    public ControladorReporte(VistaReporte vista, GestorHospital gestor) {
        this.vista = vista;
        this.gestor = gestor;
    }
    
    public void LlenarTabla(){
        DefaultTableModel modelo= (DefaultTableModel) vista.getTabla().getModel();
        modelo.setRowCount(0);
        
        java.util.ArrayList<AAPersona> listaMedicos = new java.util.ArrayList<>(gestor.getvPersonal().values());
        
        for (int i = 0; i < listaMedicos.size(); i++) {
            
            AAPersona persona = listaMedicos.get(i);
            String cargo="";
            String especialidad="";
            if(persona instanceof AMedico){
                cargo="Medico";
                especialidad= ((AMedico) persona).getEspecialidad();
            }else if(persona instanceof Administrativo){
                cargo="Administrativo"; 
                especialidad="--";
            }else if(persona instanceof AEnfermero){
                cargo="Enfermero";
                especialidad= ((AEnfermero) persona).getAreaAsignada();
            }
            InterfaceAuditable personaAuditable = (InterfaceAuditable) persona;
            Object[] datos = personaAuditable.datosTabla(cargo, especialidad);
            modelo.addRow(datos);
            
            
        }  
    }  
    
    public void EliminarPersonal(){
        String idEliminar = JOptionPane.showInputDialog(
        vista, "Ingrese el ID del personal que desea eliminar:","Eliminar Personal",JOptionPane.QUESTION_MESSAGE);
        
        if (gestor.getvPersonal().containsKey(idEliminar)) {
            AAPersona eliminado = gestor.getvPersonal().get(idEliminar);
            gestor.getvPersonal().remove(idEliminar);
            gestor.GuardarDatos();    
            JOptionPane.showMessageDialog(vista, "Se eliminó a: " + eliminado.getNombre(), "Éxito", JOptionPane.INFORMATION_MESSAGE);                    
            LlenarTabla();            
        } else {            
            JOptionPane.showMessageDialog(vista, "El ID ingresado no coincide con ningún personal registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
