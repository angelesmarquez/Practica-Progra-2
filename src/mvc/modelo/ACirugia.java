package mvc.modelo;
public class ACirugia extends AATratamiento {
    private String TipoCirugia;
    private float CostoComplejidad;
    
    //CONSTRUCTOR 
    
    public ACirugia(String TipoCirugia, float CostoComplejidad, int TDTratamiento, String nomTrat, float costoBase) {
        super(TDTratamiento, nomTrat, costoBase);
        this.TipoCirugia = TipoCirugia;
        this.CostoComplejidad = CostoComplejidad;
    }
    
    //GETTERS Y SETTERS
    
    public String getTipoCirugia() {
        return TipoCirugia;
    }
    public void setTipoCirugia(String TipoCirugia) {
        this.TipoCirugia = TipoCirugia;
    }
    public float getCostoComplejidad() {
        return CostoComplejidad;
    }
    public void setCostoComplejidad(float CostoComplejidad) {
        this.CostoComplejidad = CostoComplejidad;
    }
    
    //METODS
    
    public float calcularcosto() {
        return costoBase + CostoComplejidad;
    }
    public String obtenerDuracion() {
        return " ";
    }
}