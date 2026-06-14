package mvc.modelo;

public class ATerapia extends AATratamiento {
    private int SesionesSemanales;
    private int CantidadSemanas;
    //AGREGUE ATRIBUTO CANTIDAD SEMANAS PARA PODER CALCULAR EL COSTO TOTAL QUE SE BASA EN EL NUMERO DE SESIONES 
    
    //CONSRUCTOR
    
    public ATerapia(int SesionesSemanales, int CantidadSemanas, int TDTratamiento, String nomTrat, float costoBase) {
        super(TDTratamiento, nomTrat, costoBase);
        this.SesionesSemanales = SesionesSemanales;
        this.CantidadSemanas = CantidadSemanas;
    }
    
    //GETTERS Y STERRES
    public int getSesionesSemanales() {
        return SesionesSemanales;
    }
    public void setSesionesSemanales(int SesionesSemanales) {
        this.SesionesSemanales = SesionesSemanales;
    }
    public int getCantidadSemanas() {
        return CantidadSemanas;
    }
    public void setCantidadSemanas(int CantidadSemanas) {
        this.CantidadSemanas = CantidadSemanas;
    }
    
    //METODOS ABSTRACTOS
    
    public float calcularcosto() {
        return costoBase * SesionesSemanales * CantidadSemanas;
    }
    
    public String obtenerDuracion() {
        return CantidadSemanas + " semanas de terapia";
    }
}