package com.analiasavino.conversorDeMoneda.modelos;

public class Conversion {
    //declaro atributos de la clase.
    private String monedaDeOrigen;
    private String monedaFinal;
    private double indiceConversion;
    private double montoAConvertir;
    private  double resultadoConversion;
    private double montoConvertido;
    private String fecha;


    //creo un objeto a traves de un constructor.
    public Conversion(String monedaDeOrigen, String monedaFinal, double indiceConversion, double montoAConvertir, double montoConvertido, String fecha){
        this.monedaDeOrigen = monedaDeOrigen;
        this.monedaFinal = monedaFinal;
        this.montoAConvertir = montoAConvertir;
        this.indiceConversion = indiceConversion;
        this.resultadoConversion = montoConvertido;
        this.fecha = fecha;
    }

    public Conversion(ExchangeRate exchangeRate, double montoAConvertir) {

        this.monedaDeOrigen = exchangeRate.base_code();
        this.monedaFinal = exchangeRate.target_code();
        this.indiceConversion = exchangeRate.conversion_rate();
        this.montoAConvertir = montoAConvertir;
        this.resultadoConversion = exchangeRate.conversion_result();
        this.fecha = exchangeRate.time_last_update_utc();
    }

    public Conversion(ExchangeRate exchangeRate) {
    }
    //metodos get and setter

    public String getMonedaDeOrigen() {return monedaDeOrigen;}

    public String getMonedaFinal() {return monedaFinal;}

    public double getMontoAConvertir() {
       return montoAConvertir;
    }

    public double getIndiceConversion() {
        return indiceConversion;
    }

    public void setMontoConvertido(double montoConvertido) {
        this.montoConvertido = montoConvertido;
    }

    public void setMontoAConvertir(double montoAConvertir) {
        this.montoAConvertir = montoAConvertir;
    }

    public double getMontoConvertido() {
        return montoConvertido;
    }

    public String getFecha() { return fecha; }

    @Override
    public String toString() {
        return  " " + monedaDeOrigen +
                " equivale a: " + montoConvertido + " " +
                monedaFinal + "\n"
                ;
    }





}