package com.analiasavino.conversorDeMoneda.principal; //me indica en que paquete esta la clase Principal

//importo las clases que estoy utilizando que se encuentran en otros paquetes.
import com.analiasavino.conversorDeMoneda.historial.Historial;
import com.analiasavino.conversorDeMoneda.modelos.Conversion;
import com.analiasavino.conversorDeMoneda.modelos.ExchangeRate;
import com.analiasavino.conversorDeMoneda.calculos.Calculo;
import com.analiasavino.conversorDeMoneda.requestApi.ObtenerDatos;
import com.analiasavino.conversorDeMoneda.modelos.Menues;

import com.google.gson.Gson;

//importo las librerias java que necesito en funcion de lo que voy haciendo

import java.io.IOException;
import java.util.Scanner; //esta libreria me permite interactuar con el usuario

//*********************************************************************


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

      //Declaro parametros.
      Scanner scanner = new Scanner(System.in);

      //instancio los objetos que voy a utilizar:

      Menues menu1 = new Menues();
      
      Historial historial = new Historial();

      //Menu de bienvenida

        System.out.println("\n" +"***************************************");
        System.out.println("Bienvenido a nuestro conversor de monedas");
        System.out.println("***************************************" + '\n');
        String monedaDeOrigen = "";
        String monedaFinal = "";

        while (true) {
          System.out.println("Por favor elija la opcion deseada: ");
          System.out.println(menu1.getMenuHabituales());

          var opcion = scanner.nextInt();

          if (opcion == 9)
            break;

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
              case 7:
                System.out.println(menu1.getMenulibreEleccion());
                System.out.println("\n" + "Por favor ingrese tal y como figura en el listado la moneda desde la que desea convertir" +"\n");
                monedaDeOrigen = scanner.next();
                System.out.println("\n" + "Por favor ingrese tal y como figura en el listado la moneda a la que desea convertir" +"\n");
                monedaFinal = scanner.next();
                break;
              case 8:
                System.out.println("A continuacion encontrara el historial de conversiones realizadas:");
                System.out.println(historial);



            }

        //Solicitamos al usuario que ingrese el monto utilizado.

          System.out.println("\n"+ "Por favor elija el monto que desea convertir" +"\n");
          var montoAConvertir = scanner.nextDouble();

        // guardamos en la variable pedido el pedido.

          String pedido = "https://v6.exchangerate-api.com/v6/1967def449d10c81cd3d43a0/pair/" + monedaDeOrigen.toUpperCase()+ "/" +
                monedaFinal.toUpperCase()+ "/" + montoAConvertir;

        // Obtenemos lod datos desde la claes datos.

          var obtenerDatos = new ObtenerDatos();

        /* el Json obtenido lo guardamos en la variable json que es aquella que luego con la ayuda del metodo Gson haremos matchear con
          nuestra clase ExchangeRate. */

          var json = obtenerDatos.obtenerDatos(pedido);
          Gson gson = new Gson();
          ExchangeRate exchangeRate = gson.fromJson(json, ExchangeRate.class);


      //instancio el objeto conversion el cual recibe los atributos de la clase exchangeRate y el monto ingresado x el usuario
        Conversion conversion = new Conversion(exchangeRate, montoAConvertir);
          System.out.println(conversion);


      //luego debo ejecutar el metodo calcular() de mi clase calculo
        Calculo calculo = new Calculo();

      // ahora debo agregar al atributo montoConvertido lo retornado por el metodo calculo
         double montoConvertido = calculo.calcular(conversion);

         String respuestaAlCte = montoAConvertir + " " + monedaDeOrigen + " " + "equivalen a: " + montoConvertido + " " + monedaFinal;

         System.out.println("\n" +respuestaAlCte + "\n");
         System.out.println("*************************");





        }

    }


}