package mvc.controlador;

import javax.swing.JOptionPane;
import mvc.modelo.AAPersona;
import mvc.modelo.AMedico;
import mvc.modelo.GestorHospital;
import mvc.modelo.Paciente;
import mvc.vista.AdminRegistrarPaciente;

public class ControladorRegistrarPaciente {
    
    private AdminRegistrarPaciente vista;
    private GestorHospital gestor;
    
    //C
    public ControladorRegistrarPaciente(AdminRegistrarPaciente vista, GestorHospital gestor) {
        this.vista = vista;
        this.gestor = gestor;
    }
    
    
    public void RegistrarPaciente(){
    
    try{
        //Validar Entradas
        if(vista.getCajaNombre().isEmpty() || vista.getCajaID().isEmpty()||vista.getCajaTlf().isEmpty()||vista.getCmbASolicitada().isEmpty()||vista.getCmbMedicoAsig().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Error: Verifique que todos los campos esten llenos");
                return; 
            }
        if(gestor.getvPacientes().containsKey(vista.getCajaID())){
           JOptionPane.showMessageDialog(vista, "Error: Este número de ID ya está registrado en el sistema.");
           return;
        }
            
        String nombre = vista.getCajaNombre();
        String ID = vista.getCajaID();
        String tlf = vista.getCajaTlf();
        String nombreMed = vista.getCmbMedicoAsig();
        
        java.util.ArrayList<AAPersona> listaMedicos = new java.util.ArrayList<>(gestor.getvPersonal().values());
        AMedico medicoObjeto = null;
        for (int i = 0; i < listaMedicos.size(); i++) {
            AAPersona encontrado = listaMedicos.get(i);
            
            if (encontrado instanceof AMedico) {
                AMedico medico = (AMedico) encontrado;
                if (medico.getNombre().equalsIgnoreCase(nombreMed)) {
                    medicoObjeto = medico; 
                    break;
                }
            }
        }
       
        Paciente nuevoPaciente = null;
        nuevoPaciente = new Paciente(ID, nombre, tlf, medicoObjeto);
        
        if(nuevoPaciente != null){
                gestor.registrarPaciente(nuevoPaciente);
                
                //Preguntamos al usuario si desea registrar otro
               int respuesta = JOptionPane.showConfirmDialog(
               vista,
               "¡"+nombre+" registrado con éxito!\n¿Desea registrar otro paciente?",
               "Confirmar Registro",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
              
               if (respuesta == JOptionPane.YES_OPTION){
                   vista.limpiarCampos();
               }else{
                   //Ocultamos la vista
                   vista.setVisible(false);                  
                   //Liberamos los reursos por completo, es decir, la memoria 
                   vista.dispose();                  
                   System.out.println("Formulario de Registro Cerrado. Retornando al Menú Principal");
                   return;
               }             
            }
        
    }catch (Exception e){
            JOptionPane.showMessageDialog(vista, "Ocurrió un error inesperado: " + e.getMessage());
        }
    
    
}
     
    public void AreaMedico(){
        int i;
        String seleccion = vista.getCmbASolicitada();
        vista.cmbMedico().removeAllItems();
       
        //Array del tamaño del maps para el ciclo for
        java.util.ArrayList<AAPersona> listaMedicos= new java.util.ArrayList<>(gestor.getvPersonal().values());
        
        for(i=0;i<listaMedicos.size();i++){
            
            AAPersona encontrado = listaMedicos.get(i);
            
            if(encontrado instanceof AMedico){
                AMedico medico = (AMedico) encontrado;
                if(medico.getEspecialidad().equalsIgnoreCase(seleccion)){
                    vista.cmbMedico().addItem(medico.getNombre());
                }
            }
        }
        if(vista.cmbMedico().getItemCount() == 0){
            vista.cmbMedico().addItem("No hay médicos disponibles");
        }
    }
}
