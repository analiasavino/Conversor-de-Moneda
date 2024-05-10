package com.analiasavino.conversorDeMoneda.principal; //me indica en que paquete esta la clase Principal

//importo las clases que estoy utilizando que se encuentran en otros paquetes.
import com.analiasavino.conversorDeMoneda.modelos.Conversion;
import com.analiasavino.conversorDeMoneda.modelos.ExchangeRate;
import com.analiasavino.conversorDeMoneda.calculos.Calculo;
import com.analiasavino.conversorDeMoneda.modelos.MenuLibreEleccionDeMonedas;
import com.analiasavino.conversorDeMoneda.requestApi.ObtenerDatos;
import com.google.gson.Gson;

//importo las librerias java que necesito en funcion de lo que voy haciendo

import java.io.IOException;
import java.util.Scanner; //esta libreria me permite interactuar con el usuario


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Declaro parametros.
        Scanner scanner = new Scanner(System.in);
        String menu = """
                1 Dolar Americano   USD ==> Peso Argentino  ARS
                2 Peso Argentino    ARS ==> Dolar Americano USD
                3 Dolar Americano   USD ==> Real Brasileno  BRL
                4 Real Brasileno    BRL ==> Dolar Americano USD
                5 Dolar Americano   USD ==> Peso Colombinao COP
                6 Peso Colombiano   COP ==> Dolar Americano USD
                7 Otras conversiones. 
                9 Para salir.
                """;

        System.out.println("\n"+ "\n" +"***************************************");
        System.out.println("Bienvenido a nuestro conversor de monedas");
        System.out.println("***************************************" + '\n');
        String monedaDeOrigen = "";
        String monedaFinal = "";

        while (true) {
          System.out.println("Por favor elija la opcion deseada: ");
          System.out.println(menu);

          var opcion = scanner.nextInt();

          if (opcion == 9)
            break;
          if (opcion != 7)
            switch (opcion) {
              case 1:
                monedaDeOrigen = "USD";
                monedaFinal = "ARS";
                break;
              case 2:
                monedaDeOrigen = "ARS";
                monedaFinal = "USD";
                break;
              case 3:
                monedaDeOrigen = "USD";
                monedaFinal = "BRL";
                break;
              case 4:
                monedaDeOrigen = "BRL";
                monedaFinal = "USD";
                break;
              case 5:
                monedaDeOrigen = "USD";
                monedaFinal = "COP";
                break;
              case 6:
                monedaDeOrigen = "COP";
                monedaFinal = "USD";
                break;
            }

          MenuLibreEleccionDeMonedas menuLibreEleccion = null;

          if (opcion == 7) {
            menuLibreEleccion = new MenuLibreEleccionDeMonedas();
            String pedido = menuLibreEleccion.OtrasConversiones();
            break;
          }

          System.out.println("Por favor elija el monto que desea convertir");
          var montoAConvertir = scanner.nextDouble();

          String pedido = "https://v6.exchangerate-api.com/v6/1967def449d10c81cd3d43a0/pair/" + monedaDeOrigen + "/" +
                monedaFinal + "/" + montoAConvertir;

          var obtenerDatos = new ObtenerDatos();
          var json = obtenerDatos.obtenerDatos(pedido);

//          HttpClient client = HttpClient.newHttpClient();
//          HttpRequest request = HttpRequest.newBuilder() //lo que vamos a pedir
//                .uri(URI.create(pedido))
//                .build(); //este build se utiliza xq los objetos HttpRequest no se pueden instanciar.
//          HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());
//
//          String json = response.body();

          Gson gson = new Gson();

          ExchangeRate exchangeRate = gson.fromJson(json, ExchangeRate.class);

          //instancio el objeto conversion el cual recibe los atributos de la clase exchangeRate y el monto ingresado x el usuario
          Conversion conversion = new Conversion(exchangeRate, montoAConvertir);

          //luego debo ejecutar el metodo calcular() de mi clase calculo
          Calculo calculo = new Calculo();

          // ahora debo agregar al atributo montoConvertido lo retornado por el metodo calculo
          double montoConvertido = calculo.calcular(conversion);


          System.out.println(montoAConvertir + " " + monedaDeOrigen + " " + "equivalen a: " + montoConvertido + " " + monedaFinal);


        }

    }
}