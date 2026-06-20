package mvc.controlador;

import java.io.Serializable;
import javax.swing.JOptionPane;
import mvc.modelo.GestorHospital;
import mvc.modelo.Paciente;
import mvc.vista.VistaPago;

public class ControladorPago implements Serializable {
    
    private VistaPago vista;
    private GestorHospital gestor;
    private Paciente paciente;
    private float tasaUSD=615.50f;
    private float tasaCOP=3500f;
    
    //C
    public ControladorPago(VistaPago vista, GestorHospital gestor, Paciente paciente) {
        this.vista = vista;
        this.gestor = gestor;
        this.paciente = paciente;
    }

    public void setVista(VistaPago vista) {
        this.vista = vista;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public float getTasaUSD() {
        return tasaUSD;
    }
    public float getTasaCOP() {
        return tasaCOP;
    }
    
    public void actualizarTasas(float nuevoUSD, float nuevoCOP){
        this.tasaUSD = nuevoUSD;
        this.tasaCOP= nuevoCOP;
        System.out.println("Tasas actualizadas");
        JOptionPane.showMessageDialog(vista, "Se Guardaron los Cambios con Éxito");          
    }
    public void CalcularTasa(){
        try{
            float pago = Float.parseFloat(vista.getCajaMonto());
            float resultado =0.f;
            String moneda = vista.getCmbMoneda();
            String simbolo="";
            if(moneda.equals("Bs.")){
                resultado= pago;
                simbolo= "Bs.";
            }else if(moneda.equals("USD")){
                resultado= pago/tasaUSD;
                simbolo="USD";
            }else if(moneda.equals("COP")){
                resultado=(pago/tasaUSD)*tasaCOP;
                simbolo="COP";
            }
            vista.setCajaTotal(String.format("%.2f "+simbolo,resultado));
            
        }catch(NumberFormatException e ){
            vista.setCajaTotal("Monto Inválido");
        }
        
    }
    public boolean validarMonto(float total,float abonado){
        float pago= Float.parseFloat(vista.getCajaMonto());
        boolean validacion= false;
        if((pago+abonado)>total){
            float restante= total-abonado;
            JOptionPane.showMessageDialog(vista, "El Monto a cncelar supera el Monto Total a Pagr. Restante a pagar : "+restante, "Monto Excedente", JOptionPane.ERROR_MESSAGE);
            validacion = true;
        }
        return validacion;
    }
     
    public void RegistrarPago(){
        String pagoTexto = vista.getCajaMonto();
         if(pagoTexto.isEmpty()){
            JOptionPane.showMessageDialog(vista, "Ingrese un Monto Antes de Registrar Pago", "Monto Vacío", JOptionPane.ERROR_MESSAGE);
            return;
         }  
         try{
             float pago = Float.parseFloat(vista.getCajaMonto());
            paciente.RegistrarAbono(pago);
            gestor.GuardarDatos();
            System.out.println("Se guardo abono en el rachivo");
            JOptionPane.showMessageDialog(vista, "Pago Resgitrado con Éxito");
            vista.dispose();
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(vista, "Ingrese un Monto Válido", "Error de Formato", JOptionPane.ERROR_MESSAGE);
         }
        
        
    }
}
