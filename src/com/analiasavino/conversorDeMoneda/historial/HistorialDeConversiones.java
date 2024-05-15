package com.analiasavino.conversorDeMoneda.historial;

import com.analiasavino.conversorDeMoneda.modelos.Conversion;
import com.analiasavino.conversorDeMoneda.modelos.ExchangeRate;

import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversiones extends Conversion {

  public HistorialDeConversiones(String monedaDeOrigen, String monedaFinal, double indiceConversion, double montoAConvertir, double montoConvertido) {
    super(monedaDeOrigen, monedaFinal, indiceConversion, montoAConvertir, montoConvertido);
  }

  public HistorialDeConversiones(ExchangeRate exchangeRate, double montoAConvertir) {
    super(exchangeRate, montoAConvertir);
  }

  public HistorialDeConversiones(ExchangeRate exchangeRate) {
    super(exchangeRate);
  }

}
