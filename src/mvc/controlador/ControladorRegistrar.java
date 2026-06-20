package mvc.controlador;

import javax.swing.JOptionPane;
import mvc.modelo.AAPersona;
import mvc.modelo.AEnfermero;
import mvc.modelo.AMedico;
import mvc.modelo.Administrativo;
import mvc.modelo.GestorHospital;
import mvc.vista.AdminRegistrarPersonal;

public class ControladorRegistrar {
    private AdminRegistrarPersonal vista;
    private GestorHospital gestor;
    
    //C 
    public ControladorRegistrar(AdminRegistrarPersonal vista, GestorHospital gestor) {
        this.vista = vista;
        this.gestor = gestor;
    }
    
    public void RegitrarPersonal(){
        String area = vista.getCmbArea();
        
        if(area.isEmpty()){
            JOptionPane.showMessageDialog(vista,"Por favor, seleccione el área de trabajo","Error", JOptionPane.ERROR_MESSAGE);
           return;
        }
        
        //Objeto de clase padre que puede heredarar a cualquiera de las hijas
        AAPersona nuevoPersonal = null;
        try{
            
            //Validar entradas
            if(vista.getCajaNombre().isEmpty() || vista.getCajaID().isEmpty()||vista.getCajaTlf().isEmpty()||vista.getCajaUsuario().isEmpty()||vista.getCajaContraseña().isEmpty()||vista.getCmbArea().isEmpty()){
                JOptionPane.showMessageDialog(vista, "Error: Verifique que todos los campos esten llenos");
                return; 
            }
            if(gestor.getvPersonal().containsKey(vista.getCajaID())){
                JOptionPane.showMessageDialog(vista, "Error: Este número de ID ya está registrado en el sistema.");
                return;
            }
            
            String nombre = vista.getCajaNombre();
            String ID = vista.getCajaID();
            String tlf = vista.getCajaTlf();
            String usuario =vista.getCajaUsuario();
            String contrasena = vista.getCajaContraseña();
            
            switch (area){
                case "Médico":
                    String especialidad = vista.getCmbEspecialidad1();
                    String lic = vista.getCajaLic();
                    nuevoPersonal = new AMedico( especialidad,lic,ID,nombre,tlf,usuario,contrasena); 
                    System.out.println("Se guardo un Medico");
                    break;
                    
                case "Enfermero":
                    String areaAsig = vista.getCmbAreaEnf();
                    nuevoPersonal = new AEnfermero(areaAsig, ID, nombre, tlf, usuario, contrasena);
                    System.out.println("Se gyardo un enferemero");
                    break;
                    
                case "Administrativo":
                    String departamento=vista.getCmbDepartamento();
                    nuevoPersonal = new Administrativo(departamento, ID, nombre, tlf, usuario, contrasena);
                    System.out.println("Se guardo un administrativo");
                    break;
                    
            }//Fin del Switch
            
            if(nuevoPersonal != null){
                gestor.registrarPersonal(nuevoPersonal);
                gestor.GuardarDatos();
                
                //Preguntamos al usuario si desea registrar otro
               int respuesta = JOptionPane.showConfirmDialog(
               vista,
               "¡"+area+" registrado con éxito!\n¿Desea registrar otro personal?",
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
