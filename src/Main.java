import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static int validateOption(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("Por favor, insira um valor númerico válido:");
            input.next();
        }
        return input.nextInt();
    }

    public static void main(String[] args) throws MalformedURLException {
        Scanner input = new Scanner(System.in);
        RequestAPI request = new RequestAPI();
        Moeda moeda;

        String menu = """      
                ********************************** 
                Bem vindo(a) ao Conversor de Moedas em tempo real!
                
                Escolha a opção para conversão:
                                
                1- Dolar americano >>> Real brasileiro
                2- Real brasileiro >>> Dolar americano
                3- Dolar americano >>> Peso argentino
                4- Peso argentino >>> Dolar americano
                5- Dolar americano >>> Peso colombiano
                6- Peso colombiano >>> Dolar americano
                7- Seleção personalizada
                8- Sair      
                **********************************                                  
                """;

        var menuPrincipal = -1;
        while (menuPrincipal != 8) {

            System.out.println(menu);
            menuPrincipal = validateOption(input);

            switch (menuPrincipal) {
                case 1:
                    moeda = request.RequestApi("USD", "BRL");

                    break;
                case 2:
                    moeda = request.RequestApi("BRL", "USD");

                    break;
                case 3:
                    moeda = request.RequestApi("USD", "ARS");

                    break;
                case 4:
                    moeda = request.RequestApi("ARS", "USD");

                    break;
                case 5:
                    moeda = request.RequestApi("USD", "COP");

                    break;
                case 6:
                    moeda = request.RequestApi("COP", "USD");

                    break;
                case 7:
                    URL listaCambios = new URL("https://www.exchangerate-api.com/docs/supported-currencies");

                    System.out.println("Digite o código da moeda origem: ");
                    System.out.println("(A lista com todas as moedas aceitas você pode encontrar em " + listaCambios + ")");
                    var moeda1 = input.next().toUpperCase();

                    System.out.println("Digite a moeda para qual deseja fazer a conversão: ");
                    System.out.println("(A lista com todas as moedas aceitas você pode encontrar em " + listaCambios + ")");
                    var moeda2 = input.next().toUpperCase();

                    moeda = request.RequestApi(moeda1, moeda2);
                    System.out.println(moeda);
                    break;

                case 8:

                    break;
            }
        }
    }
}