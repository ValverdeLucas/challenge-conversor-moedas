package com.one.projetos.conversormoedas.metodos;

import com.google.gson.Gson;
import com.one.projetos.conversormoedas.modelos.Moeda;
import com.one.projetos.conversormoedas.modelos.DadosConversor;
import com.one.projetos.exception.ErroConversorAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class RequestAPI {

    public Moeda RequestApi(String moeda1, String moeda2) {

        String urlConexao = "https://v6.exchangerate-api.com/v6/d99a180ca129d9012013b674/pair/" + moeda1 + "/" + moeda2;

        Gson gson = new Gson();


        try {
            HttpClient client = HttpClient
                    .newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlConexao))
                    .build();
            HttpResponse<String> response;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 400) {
                throw new ErroConversorAPI("Erro ao fazer a requisitação");
            }

            DadosConversor dadosMoeda = gson.fromJson(response.body(), DadosConversor.class);

            return new Moeda(dadosMoeda);

        } catch (Exception e) {
            throw new ErroConversorAPI("Opss, Houve um erro durante a consulta à ExchangeRate-API. Tente novamente!");
        }
    }
}