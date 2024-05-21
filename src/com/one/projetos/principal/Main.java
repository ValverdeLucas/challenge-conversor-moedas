package com.one.projetos.principal;

import com.one.projetos.conversormoedas.metodos.Conversor;
import com.one.projetos.conversormoedas.modelos.Moeda;

import java.net.MalformedURLException;

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

    public static double validateAmount(Scanner input) {
        while (!input.hasNextDouble()) {
            System.out.println("Por favor, insira um valor válido para a operação!");
            input.next();
        }
        return input.nextDouble();
    }

    public static void main(String[] args) throws MalformedURLException, NullPointerException {
        Scanner input = new Scanner(System.in);
        Conversor conversor = new Conversor();
        double valorConverter;

        String menu = """      
                ************************************************** 
                Bem vindo(a) ao Conversor de Moedas em tempo real!
                                
                Escolha a opção para conversão:
                                
                1- Dolar Americano (USD) >>> Real Brasileiro (BRL)
                2- Real Brasileiro (BRL) >>> Dolar Americano (USD)
                3- Dolar Americano (USD) >>> Peso Argentino (ARS)
                4- Peso Argentino (ARS) >>> Dolar Americano (USD)
                5- Dolar Americano (USD) >>> Peso Colombiano (COP)
                6- Peso Colombiano (COP) >>> Dolar Americano (USD)
                7- Seleção personalizada
                8- Sair      
                *************************************************                             
                """;

        var menuPrincipal = -1;
        while (menuPrincipal != 8) {

            System.out.println(menu);
            menuPrincipal = validateOption(input);
            Moeda moeda;

            switch (menuPrincipal) {
                case 1:
                    moeda = conversor.dadosMoeda("USD", "BRL");
                    System.out.println("Digite a quantia a ser convertida:");
                    valorConverter = validateAmount(input);
                    System.out.println("O valor de " + valorConverter + "(" + moeda.getBase_code() + ") corresponde a quantia de " + conversor.converterValores(valorConverter, "USD", "BRL") + "(" + moeda.getTarget_code() + ")");
                    System.out.println("Cotação atualizada em: " + moeda.getTime_last_update_utc());
                    break;

                case 2:
                    moeda = conversor.dadosMoeda("BRL", "USD");
                    System.out.println("Digite a quantia a ser convertida:");
                    valorConverter = validateAmount(input);
                    System.out.println("O valor de " + valorConverter + "(" + moeda.getBase_code() + ") corresponde a quantia de " + conversor.converterValores(valorConverter, "BRL", "USD") + "(" + moeda.getTarget_code() + ")");
                    System.out.println("Cotação atualizada em: " + moeda.getTime_last_update_utc());

                    break;

                case 3:
                    moeda = conversor.dadosMoeda("USD", "ARS");
                    System.out.println("Digite a quantia a ser convertida:");
                    valorConverter = validateAmount(input);
                    System.out.println("O valor de " + valorConverter + "(" + moeda.getBase_code() + ") corresponde a quantia de " + conversor.converterValores(valorConverter, "USD", "ARS") + "(" + moeda.getTarget_code() + ")");
                    System.out.println("Cotação atualizada em: " + moeda.getTime_last_update_utc());

                    break;

                case 4:
                    moeda = conversor.dadosMoeda("ARS", "USD");
                    System.out.println("Digite a quantia a ser convertida:");
                    valorConverter = validateAmount(input);
                    System.out.println("O valor de " + valorConverter + "(" + moeda.getBase_code() + ") corresponde a quantia de " + conversor.converterValores(valorConverter, "ARS", "USD") + "(" + moeda.getTarget_code() + ")");
                    System.out.println("Cotação atualizada em: " + moeda.getTime_last_update_utc());

                    break;

                case 5:
                    moeda = conversor.dadosMoeda("USD", "COP");
                    System.out.println("Digite a quantia a ser convertida:");
                    valorConverter = validateAmount(input);
                    System.out.println("O valor de " + valorConverter + "(" + moeda.getBase_code() + ") corresponde a quantia de " + conversor.converterValores(valorConverter, "USD", "COP") + "(" + moeda.getTarget_code() + ")");
                    System.out.println("Cotação atualizada em: " + moeda.getTime_last_update_utc());

                    break;

                case 6:
                    moeda = conversor.dadosMoeda("COP", "USD");
                    System.out.println("Digite a quantia a ser convertida:");
                    valorConverter = validateAmount(input);
                    System.out.println("O valor de " + valorConverter + "(" + moeda.getBase_code() + ") corresponde a quantia de " + conversor.converterValores(valorConverter, "COP", "USD") + "(" + moeda.getTarget_code() + ")");
                    System.out.println("Cotação atualizada em: " + moeda.getTime_last_update_utc());

                    break;

                case 7:
                    URL listaCambios = new URL("https://www.exchangerate-api.com/docs/supported-currencies");
                    System.out.println("Digite o código da moeda origem: ");
                    System.out.println("(A lista com todas as moedas aceitas você pode encontrar em " + listaCambios + ")");
                    var moeda1 = input.next().toUpperCase();

                    System.out.println("Digite o código da moeda para qual deseja fazer a conversão: ");
                    System.out.println("(A lista com todas as moedas aceitas você pode encontrar em " + listaCambios + ")");
                    var moeda2 = input.next().toUpperCase();

                    System.out.println("Digite a quantia a ser convertida:");
                    moeda = conversor.dadosMoeda(moeda1, moeda2);
                    valorConverter = validateAmount(input);
                    System.out.println("O valor de " + valorConverter + "(" + moeda.getBase_code() + ") corresponde a quantia de " + conversor.converterValores(valorConverter, moeda1, moeda2) + "(" + moeda.getTarget_code() + ")");
                    System.out.println("Cotação atualizada em: " + moeda.getTime_last_update_utc());

                    break;

                case 8:
                    System.out.println("""
                             ********** Obrigado por utilizar os nossos serviços **********
                                    *************** Sessão encerrada ***************
                            """);
                    break;
            }
        }
    }
}