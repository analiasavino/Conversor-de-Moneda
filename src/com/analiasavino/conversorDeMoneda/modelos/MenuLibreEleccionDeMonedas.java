package com.analiasavino.conversorDeMoneda.modelos;
import com.analiasavino.conversorDeMoneda.modelos.Conversion;
import com.analiasavino.conversorDeMoneda.modelos.ExchangeRate;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class MenuLibreEleccionDeMonedas extends Conversion {

        String menulibreEleccion = """
                Trabajamos con 161 monedas comúnmente circulantes, las cuales se enumeran a continuación. 
                Estas cubren el 99% de todos los estados y territorios reconocidos por la ONU.
                            
                  Código 
                de Moneda | Nombre de la Moneda                  | País
                --------- | ------------------------------------ | -----------------------
                AED       | Dirham de los Emiratos Árabes Unidos | Emiratos Árabes Unidos
                AFN       | Afghani Afgano                       | Afganistán
                ALL       | Lek Albanés                          | Albania
                AMD       | Dram Armenio | Armenia
                ANG       | Florín de las Antillas Neerlandesas | Antillas Neerlandesas
                AOA       | Kwanza Angoleño | Angola
                ARS | Peso Argentino | Argentina
                AUD | Dólar Australiano | Australia
                AWG | Florín Arubeño | Aruba
                AZN | Manat Azerbaiyano | Azerbaiyán
                BAM | Marco de Bosnia y Herzegovina | Bosnia y Herzegovina
                BBD | Dólar de Barbados | Barbados
                BDT | Taka Bangladesí | Bangladesh
                BGN | Lev Búlgaro | Bulgaria
                BHD | Dinar Bahreiní | Baréin
                BIF | Franco Burundés | Burundi
                BMD | Dólar Bermudeño | Bermudas
                BND | Dólar de Brunéi | Brunéi
                BOB | Boliviano Boliviano | Bolivia
                BRL | Real Brasileño | Brasil
                BSD | Dólar Bahameño | Bahamas
                BTN | Ngultrum Butanés | Bután
                BWP | Pula Botsuano | Botsuana
                BYN | Rublo Bielorruso | Bielorrusia
                BZD | Dólar Beliceño | Belice
                CAD | Dólar Canadiense | Canadá
                CDF | Franco Congoleño | República Democrática del Congo
                CHF | Franco Suizo | Suiza
                CLP | Peso Chileno | Chile
                CNY | Renminbi Chino | China
                COP | Peso Colombiano | Colombia
                CRC | Colón Costarricense | Costa Rica
                CUP | Peso Cubano | Cuba
                CVE | Escudo Caboverdiano | Cabo Verde
                CZK | Corona Checa | República Checa
                DJF | Franco Yibutiano | Yibuti
                DKK | Corona Danesa | Dinamarca
                DOP | Peso Dominicano | República Dominicana
                DZD | Dinar Argelino | Argelia
                EGP | Libra Egipcia | Egipto
                ERN | Nakfa Eritreo | Eritrea
                ETB | Birr Etíope | Etiopía
                EUR | Euro | Unión Europea
                FJD | Dólar Fiyiano | Fiyi
                FKP | Libra de las Islas Malvinas | Islas Malvinas
                FOK | Króna Feroesa | Islas Feroe
                GBP | Libra Esterlina | Reino Unido
                GEL | Lari Georgiano | Georgia
                GGP | Libra de Guernsey | Guernsey
                GHS | Cedi Ganés | Ghana
                GIP | Libra de Gibraltar | Gibraltar
                GMD | Dalasi Gambiano | Gambia
                GNF | Franco Guineano | Guinea
                GTQ | Quetzal Guatemalteco | Guatemala
                GYD | Dólar Guyanés | Guyana
                HKD | Dólar de Hong Kong | Hong Kong
                HNL | Lempira Hondureño | Honduras
                HRK | Kuna Croata | Croacia
                HTG | Gourde Haitiano | Haití
                HUF | Forinto Húngaro | Hungría
                IDR | Rupia Indonesia | Indonesia
                ILS | Nuevo Shekel Israelí | Israel
                IMP | Libra de la Isla de Man | Isla de Man
                INR | Rupia India | India
                IQD | Dinar Iraquí | Irak
                IRR | Rial Iraní | Irán
                ISK | Króna Islandesa | Islandia
                JEP | Libra de Jersey | Jersey
                JMD | Dólar Jamaicano | Jamaica
                JOD | Dinar Jordano | Jordania
                JPY | Yen Japonés | Japón
                KES | Chelín Keniano | Kenia
                KGS | Som Kirguís | Kirguistán
                KHR | Riel Camboyano | Camboya
                KID | Dólar Kiribatiano | Kiribati
                KMF | Franco Comorense | Comoras
                KRW | Won Surcoreano | Corea del Sur
                KWD | Dinar Kuwaití | Kuwait
                KYD | Dólar de las Islas Caimán | Islas Caimán
                KZT | Tenge Kazajo | Kazajistán
                LAK | Kip Laosiano | Laos
                LBP | Libra Libanesa | Líbano
                LKR | Rupia de Sri Lanka | Sri Lanka
                LRD | Dólar Liberiano | Liberia
                LSL | Loti Lesotense | Lesoto
                LYD | Dinar Libio | Libia
                MAD | Dirham Marroquí | Marruecos
                MDL | Leu Moldavo | Moldavia
                MGA | Ariary Malgache | Madagascar
                MKD | Denar Macedonio | Macedonia del Norte
                MMK | Kyat Birmano | Myanmar
                MNT | Tugrik Mongol | Mongolia
                MOP | Pataca de Macao | Macao
                MRU | Ouguiya Mauritano | Mauritania
                MUR | Rupia Mauriciana | Mauricio
                MVR | Rufiyaa de Maldivas | Maldivas
                MWK | Kwacha Malauí | Malaui
                MXN | Peso Mexicano | México
                MYR | Ringgit Malayo | Malasia
                MZN | Metical Mozambiqueño | Mozambique
                NAD | Dólar de Namibia | Namibia
                NGN | Naira Nigeriano | Nigeria
                NIO | Córdoba Nicaragüense | Nicaragua
                NOK | Corona Noruega | Noruega
                NPR | Rupia Nepalí | Nepal
                NZD | Dólar Neozelandés | Nueva Zelanda
                OMR | Rial Omaní | Omán
                PAB | Balboa Panameño | Panamá
                PEN | Sol Peruano | Perú
                PGK | Kina de Papúa Nueva Guinea | Papúa Nueva Guinea
                PHP | Peso Filipino | Filipinas
                PKR | Rupia Pakistaní | Pakistán
                PLN | Złoty Polaco | Polonia
                PYG | Guaraní Paraguayo | Paraguay
                QAR | Riyal Catarí | Catar
                RON | Leu Rumano | Rumanía
                RSD | Dinar Serbio | Serbia
                RUB | Rublo Ruso |""";

        Scanner scanner = new Scanner(System.in);
        double resuladoConversion = 0;
        String respuesta ="";

        public MenuLibreEleccionDeMonedas(String monedaDeOrigen, String monedaFinal, double indiceConversion, double montoAConvertir, double montoConvertido) {
                super(monedaDeOrigen, monedaFinal, indiceConversion, montoAConvertir, montoConvertido);
        }

        public MenuLibreEleccionDeMonedas(ExchangeRate exchangeRate, double montoAConvertir) {
                super(exchangeRate, montoAConvertir);
        }

        public MenuLibreEleccionDeMonedas(ExchangeRate exchangeRate) {
                super(exchangeRate);
        }

        public String OtrasConversiones(){
                var monedaDeOrigen = "";
                var montoAConvertir = 0.00;
                var monedaFinal = "";
                String pedido;

                //while (true){
                        System.out.println(menulibreEleccion);
                        System.out.println("Por favor ingrese tal y como figura en el listado, (con letras mayusculas" +
                                "y entre comillas, la moneda desde la que desea convertir");
                        monedaDeOrigen = scanner.next();

                        System.out.println("Por favor ingrese tal y como figura en el listado, (letras em mayusculas" +
                                "y entre comillas, la moneda a la que desea convertir su dinero");
                        monedaFinal = scanner.next();

                        System.out.println("Por favor ingrese el monto que desea convertir: ");
                        montoAConvertir = scanner.nextDouble();

//                        System.out.println("Usted quiere convertir: " + montoAConvertir + monedaDeOrigen + " a: " + monedaFinal +
//                                " si es correcto ingrese 8 si es incorrecto ingrese 0: ");
//                        var opcion = scanner.nextInt();

//                        if (opcion == 8) {
//
//                        } else {
//                                respuesta = "Por favor ingrese los datos correctamente.";
//                                break;
//                        }
                //}

                return pedido = "https://v6.exchangerate-api.com/v6/1967def449d10c81cd3d43a0/pair/" + monedaDeOrigen + "/" +
                      monedaFinal + "/" + montoAConvertir;
        }

}