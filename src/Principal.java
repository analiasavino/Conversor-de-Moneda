import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("***************************************");
        System.out.println("Bienvenido a nuestro conversor de monedas");
        System.out.println("***************************************");

        System.out.println("""
                Elija la conversion que desea realizar:
                1- Pesos Argentinos a Dolares.
                2- Dolares a Pesos Argentinos.
                3- Reales a Dolares.
                4- Dolares a Reales.
                5- Pesos Uruguayos a Dolares
                6- Dolares a Pesos Uruguayos.
                7- Salir.
                """);

        Scanner opcion = new Scanner(System.in);
        var monedaElegida = opcion.nextLine();

        String pedido = "https://v6.exchangerate-api.com/v6/1967def449d10c81cd3d43a0/latest/"+ monedaElegida;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request  = HttpRequest.newBuilder()
                .uri(URI.create(pedido))
                .build();
        HttpResponse<String>response =client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }

}