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

    //C
    public ControladorPago(VistaPago vista, GestorHospital gestor, Paciente paciente) {
        this.vista = vista;
        this.gestor = gestor;
        this.paciente = paciente;
    }
    
    float pago = Float.parseFloat(vista.getCajaMonto());
    
    public void CalcularTasa(){
        float resultado =0.f;
        float tasaUSD= 612.43f;
        float Tasa_COP= 3500f;
        
    }
     
    public void RegistrarPago(){
        paciente.RegistrarAbono(pago);
        gestor.GuardarDatos();
        System.out.println("Se guardo abono en el rachivo");
        JOptionPane.showMessageDialog(vista, "Pago Resgitrado con Éxito");
        vista.dispose();
        
    }
}
