package com.analiasavino.conversorDeMoneda.calculos;

import com.analiasavino.conversorDeMoneda.modelos.Conversion;
import com.analiasavino.conversorDeMoneda.modelos.MenuLibreEleccionDeMonedas;

public class Calculo {

    public double calcular(Conversion conversion){
        double montoConvertido = conversion.getIndiceConversion() * conversion.getMontoAConvertir();
        return montoConvertido;

    }

}
