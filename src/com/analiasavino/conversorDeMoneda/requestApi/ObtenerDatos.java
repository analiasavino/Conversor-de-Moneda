package com.analiasavino.conversorDeMoneda.requestApi;

import com.analiasavino.conversorDeMoneda.modelos.ExchangeRate;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ObtenerDatos {
  //declaro el metodo obtenerDatos.

  public String obtenerDatos(String pedido) {
    //el cual se ocupa de hacer los pedidos a la appi
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(pedido))
          .build();
    HttpResponse<String> response = null;

    //manejo de excepciones.
    try {
      response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    // creo una variable en la cual se va a almacenar el cuerpo de lo enviado por la api
    String json = response.body();
    return json;
  }

}
