import com.google.gson.Gson;

public class Conversion {
    //declaro atributos de la clase.
    private String monedaDeOrigen;
    private String monedaFinal;
    private double indiceConversion;
    private double montoAConvertir;
    private double montoConvertido;

    //creo un objeto a traves de un constructor.
    public Conversion(String monedaDeOrigen, String monedaFinal, double indiceConversion, double montoAConvertir){
        this.montoAConvertir = montoAConvertir;
        this.monedaFinal = monedaFinal;
        this.montoAConvertir = montoAConvertir;
        this.montoConvertido = getMontoConvertido();
    }

    public Conversion(ExchangeRate exchangeRate) {
        this.monedaDeOrigen = exchangeRate.base_code();
        this.monedaFinal = exchangeRate.target_code();
        this.montoConvertido = exchangeRate.conversion_result();
        this.indiceConversion = exchangeRate.conversion_rate();
    }

    public double getMontoAConvertir() {
       return montoAConvertir;
    }

    @Override
    public String toString() {
        return  " " + monedaDeOrigen +
                " equivale a: " + montoConvertido + " " +
                monedaFinal + "\n"
                ;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoAConvertir(double montoAConvertir) {
        this.montoAConvertir = montoAConvertir;
    }
}
//= ((monedaDeOrigen == "USD")? "dolares" : (monedaDeOrigen == "PYG")? "Guaranies" : (monedaDeOrigen == "ARS")?
//                "Pesos Argentinos" : (monedaDeOrigen == "UYU")?"Pesos Uruguayos":) +