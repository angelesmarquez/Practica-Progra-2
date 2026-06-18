package mvc.controlador;

import javax.swing.JOptionPane;
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
        String medicoAsig = vista.getCmbMedicoAsig();
       
        Paciente nuevoPaciente = null;
        nuevoPaciente = new Paciente(ID, nombre, tlf, medicoAsig);
        
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
}
