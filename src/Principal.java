import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        //Declaro parametros.
        Scanner scanner = new Scanner(System.in);
        String menu = """
                1 Dolar Americano   USD.
                2 Guarani Paraguayo PYG.
                3 Peso Argentino    ARS.
                4 Peso Uruguayo     UYU.
                5 Real Brasil       BRL.
                6 Sol Peruano       PEN.
                7 Yuan Chino        CNY. 
                9 Para salir.
                """;

        System.out.println("\n"+ "\n" +"***************************************");
        System.out.println("Bienvenido a nuestro conversor de monedas");
        System.out.println("***************************************" + '\n');
        String monedaDeOrigen = "";
        String monedaFinal = "";

        while (true) {
            System.out.println("Por favor elija en que moneda desde la que desea convertir.");
            System.out.println(menu);
            var opcion = scanner.nextInt();
            if (opcion == 9)
                break;

            switch (opcion) {
                case 1:
                    monedaDeOrigen = "USD";
                    break;
                case 2:
                    monedaDeOrigen = "PYG";
                    break;
                case 3:
                    monedaDeOrigen = "ARS";
                    break;
                case 4:
                    monedaDeOrigen = "UYU";
                    break;
                case 5:
                    monedaDeOrigen = "BRL";
                    break;
                case 7:
                    monedaDeOrigen = "PEN";
                    break;
                case 8:
                    monedaDeOrigen = "CNY";
                    break;
            }
            System.out.println("Por favor elija la moneda a la cual desea convertir.");
            var opcion2 = scanner.nextInt();

            switch (opcion2) {
                case 1:
                    monedaFinal = "USD";
                    break;
                case 2:
                    monedaFinal = "PYG";
                    break;
                case 3:
                    monedaFinal = "ARS";
                    break;
                case 4:
                    monedaFinal = "UYU";
                    break;
                case 5:
                    monedaFinal = "BRL";
                    break;
                case 7:
                    monedaFinal = "PEN";
                    break;
                case 8:
                    monedaFinal = "CNY";
                    break;
            }
            System.out.println("Por favor ingrese el monto que desea convertir.");
            var montoAConvertir = scanner.nextDouble();

            if (opcion == 9) {

            }

            String pedido = "https://v6.exchangerate-api.com/v6/1967def449d10c81cd3d43a0/pair/" + monedaDeOrigen
                    +"/"
                    +monedaFinal + "/" + montoAConvertir;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder() //lo que vamos a pedir
                    .uri(URI.create(pedido))
                    .build(); //este build se utiliza xq los objetos HttpRequest no se pueden instanciar.
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();
            ExchangeRate exchangeRate = gson.fromJson(json, ExchangeRate.class);
            Conversion conversion = new Conversion(exchangeRate);
            System.out.println("La suma de: " + montoAConvertir + conversion);




        }

    }
}