import com.google.gson.Gson;

public class Conversion {
    //declaro atributos de la clase.
    private String monedaDeOrigen;
    private String monedaFinal;
    private double indiceConversion;
    private double montoAConvertir;
    private double montoConvertido;

    //creo un objeto a traves de un constructor.
    public Conversion(String monedaDeOrigen, String monedaFinal, double indiceConversion, double montoAConvertir, double montoConvertido){
        this.monedaDeOrigen = monedaDeOrigen;
        this.monedaFinal = monedaFinal;
        this.montoAConvertir = montoAConvertir;
        this.indiceConversion = indiceConversion;
        this.montoConvertido = getMontoConvertido();
    }

    public Conversion(ExchangeRate exchangeRate) {
        this.monedaDeOrigen = exchangeRate.base_code();
        this.monedaFinal = exchangeRate.target_code();
        //this.montoConvertido = exchangeRate.conversion_result();
        this.indiceConversion = exchangeRate.conversion_rate();

    }

    public double getMontoAConvertir() {
       return montoAConvertir;
    }

    public double getIndiceConversion() {
        return indiceConversion;
    }

    @Override
    public String toString() {
        return  " " + monedaDeOrigen +
                " equivale a: " + montoConvertido + " " +
                monedaFinal + "\n"
                ;
    }

    public void setMontoAConvertir(double montoAConvertir) {
        this.montoAConvertir = montoAConvertir;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(double montoConvertido) {
        this.montoConvertido = montoConvertido;
    }


}