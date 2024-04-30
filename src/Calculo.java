public class Calculo {


    private double calculo(Conversion conversion){
        double montoConvertido;
        montoConvertido = conversion.getIndiceConversion() * conversion.getMontoAConvertir();
        return montoConvertido;
    }
}
