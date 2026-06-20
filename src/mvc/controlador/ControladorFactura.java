package mvc.controlador;

import javax.swing.JOptionPane;
import mvc.modelo.AAPersona;
import mvc.modelo.AATratamiento;
import mvc.modelo.ACirugia;
import mvc.modelo.AMedicacion;
import mvc.modelo.ATerapia;
import mvc.modelo.GestorHospital;
import mvc.modelo.Paciente;
import mvc.vista.GenerarFactura;

public class ControladorFactura {
    GenerarFactura vista;
    GestorHospital gestor;
    Paciente pacienteEncontrado;

    public ControladorFactura(GenerarFactura vista, GestorHospital gestor) {
        this.vista = vista;
        this.gestor = gestor;
    }
    
    //G
    public Paciente getPacienteEncontrado(){
        return pacienteEncontrado;    
    }

    public void mostratDatos() {
        int i;
        String idPaciente= vista.getCajaID();
        boolean encontrado = false;
        
        //Array para recorrer los pacientes
        java.util.ArrayList<Paciente> listaPacientes= new java.util.ArrayList<>(gestor.getvPacientes().values());
        
        for (i=0; i<listaPacientes.size(); i++) {
            
            Paciente paciente = listaPacientes.get(i);
          
            if(paciente.getIdP().equalsIgnoreCase(idPaciente)){
                
                //Guardamos el apciente en el que esta para despues poderselo pasar al Controlador de Pago
                this.pacienteEncontrado= paciente;
                //Nombre
                String nombre = paciente.getNombre();
                vista.setCajaNombre(nombre);  
                encontrado=true;
                
                //Lista Tratamientos
                String texto = "=====  Lista de Tratmientos  =====\n\n";
                //Array para recorrer la listade tratamientos de ese paciente
                java.util.ArrayList<AATratamiento> listaTratamientos = paciente.getListaTratamientos();
                
                float CostoTotal=0;
                //Ciclo para recorrer los tratmiento
                for (int j=0;j<listaTratamientos.size();j++){
                    
                    AATratamiento tratencontrado = listaTratamientos.get(j);
                    String textoDuracion= "";
                    
                    //Condicionales para la factura para dias de terapia, medicacion o cirugía
                    if (tratencontrado instanceof ATerapia){
                        String duracion= tratencontrado.obtenerDuracion();
                        int TotalSesiones=0;
                        try{
                            String[] partes= duracion.split(" ");
                            int semanas = Integer.parseInt(partes[0]);
                            
                            //Casteo para que reconozca el metodo que esta en Terapia
                            ATerapia terapia= (ATerapia) tratencontrado; 
                            int sesionesSemanales = terapia.getSesionesSemanales();
                            TotalSesiones= semanas*sesionesSemanales;
                            
                        }catch (Exception e){
                            TotalSesiones=0;
                        }
                        textoDuracion=" || Cantidad de Sesiones: "+TotalSesiones;
                        CostoTotal+=  TotalSesiones*tratencontrado.getCostoBase();
                        
                    }else if (tratencontrado instanceof AMedicacion){
                        textoDuracion=" || Duración: "+tratencontrado.obtenerDuracion();
                        AMedicacion medicacion = (AMedicacion) tratencontrado;
                        CostoTotal+= medicacion.calcularcosto();
               
                    }else if(tratencontrado instanceof ACirugia){
                        textoDuracion= " || No aplica Sesiones/Duración";
                        ACirugia cirugia = (ACirugia) tratencontrado;
                        CostoTotal+= cirugia.calcularcosto();
                    }
                    texto= texto + "-> " + tratencontrado.getNomTrat()+ textoDuracion+"\n";
                    
                    if(listaTratamientos.size()==0){
                        texto= "El Paciente no tiene tratamientos Asignados";
                    }
                    
                    vista.setTxtTratamiento(texto);  
                    
                }//Fin del Del For Trtameiento
                vista.setTxtCostoTotal(String.valueOf(CostoTotal+" Bs."));
                vista.setTxtTotalPago(String.valueOf(paciente.getAbono()));
                break;
               
            } 
        }
        if(encontrado==false){
                JOptionPane.showMessageDialog(vista, "No se Encontro el Paciente en el Sistema", "Paciente no Encontrado", JOptionPane.ERROR_MESSAGE);
            } 
    }
}

