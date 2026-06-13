package mvc.modelo;

public abstract class AATratamiento {
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
}
