import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestAPI extends NullPointerException {

    String urlConexao = "https://v6.exchangerate-api.com/v6/d99a180ca129d9012013b674/latest/BRL";

    public Moeda RequestApi() {

        Gson gson = new Gson();

        HttpClient client = HttpClient
                .newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlConexao))
                .build();

        try {
            HttpResponse<String> response;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 400) {
                throw new ErroConversorAPI("Erro ao fazer a requisitação");
            }

            DadosConversor dadosMoeda = gson.fromJson(response.body(), DadosConversor.class);
            Moeda moeda = new Moeda(dadosMoeda);

            return moeda;

        } catch (Exception e) {
            System.out.println("Opss, Houve um erro durante a consulta à API do ViaCEP.");
            e.printStackTrace();
        }
        return null;
    }
}