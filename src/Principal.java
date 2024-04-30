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
        double montoConvertido = 0;

        while (true) {
            System.out.println("Por favor elija la opcion deseada: ");
            System.out.println(menu);
            var opcion = scanner.nextInt();
            if (opcion == 9)
                break;
            System.out.println("Por favor elija el monto que desea convertir");
            var montoAConvertir = scanner.nextDouble();

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
            System.out.println(montoAConvertir + " " + monedaDeOrigen + " " + "equivalen a: " + montoConvertido + " " + monedaFinal);

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
            System.out.println(pedido);


        }

    }
}