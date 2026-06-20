package mvc.modelo;
import java.io.Serializable;

public abstract class AATratamiento implements Serializable,InterfaceAuditable{
    //Variables
   protected int TDTratamiento;
   protected String nomTrat;
   protected float costoBase;
   
   //Getters y Setters 
    public int getTDTratamiento() {
        return TDTratamiento;
    }
    public void setTDTratamiento(int TDTratamiento) {
        this.TDTratamiento = TDTratamiento;
    }
    public String getNomTrat() {
        return nomTrat;
    }
    public void setNomTrat(String nomTrat) {
        this.nomTrat = nomTrat;
    }
    public float getCostoBase() {
        return costoBase;
    }
    public void setCostoBase(float costoBase) {
        this.costoBase = costoBase;
    }
    
    //Metodo consrructor
    public AATratamiento(int TDTratamiento, String nomTrat, float costoBase) {
        this.TDTratamiento = TDTratamiento;
        this.nomTrat = nomTrat;
        this.costoBase = costoBase;
    }
    
    //Metodos Abtractos 
    public abstract float calcularcosto();
    public abstract String obtenerDuracion();
    
    //Interface Auditable
    @Override
    public Object[] datosTabla(String cargo, String especialidad) {
        return null;
    }
    
    @Override
    public Object[] datosTratamiento (String nombrepaciente){
        return new Object[] {
            this.getNomTrat(),
            nombrepaciente,          
            this.calcularcosto(),
            this.obtenerDuracion()
        };
    }
    
    
}
