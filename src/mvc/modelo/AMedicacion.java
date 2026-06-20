package mvc.modelo;

public class AMedicacion extends AATratamiento {
    private float DosisDiaria;
    private int DiasTratamiento;
    
    //COMNSTRUCTOR
    public AMedicacion(float DosisDiaria, int DiasTratamiento, int TDTratamiento, String nomTrat, float costoBase) {
        super(TDTratamiento, nomTrat, costoBase);
        this.DosisDiaria = DosisDiaria;
        this.DiasTratamiento = DiasTratamiento;
    }
    
    //GETTERS Y SETTERS
    public float getDosisDiaria() {
        return DosisDiaria;
    }
    public void setDosisDiaria(float DosisDiaria) {
        this.DosisDiaria = DosisDiaria;
    }
    public int getDiasTratamiento() {
        return DiasTratamiento;
    }
    public void setDiasTratamiento(int DiasTratamiento) {
        this.DiasTratamiento = DiasTratamiento;
    }
    
    //METODOS 
    
    //se multiplica esas 3 cosas para el costo total ya que es por tiempo 
    public float calcularcosto() {
        return DosisDiaria * costoBase * DiasTratamiento;
    }
    public String obtenerDuracion() {
        return DiasTratamiento + " dias";
    }
}
