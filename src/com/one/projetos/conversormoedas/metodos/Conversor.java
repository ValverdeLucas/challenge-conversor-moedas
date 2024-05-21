package com.one.projetos.conversormoedas.metodos;

import com.one.projetos.conversormoedas.modelos.Moeda;
import com.one.projetos.exception.ErroConversorAPI;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Conversor {

    RequestAPI request = new RequestAPI();
    private final List<Moeda> historicoBusca = new ArrayList<>();


    public List<Moeda> getHistoricoBusca() {
        return historicoBusca;
    }

    public double converterValores(double valorConverter, String moeda1, String moeda2) {
        try {
            Moeda moeda = request.RequestApi(moeda1, moeda2);
            if (moeda == null) {
                throw new IllegalArgumentException("As moedas inseridas não são válidas!");
            }
            moeda.setValorOrigem(valorConverter);
            moeda.setValorConvertido(valorConverter * moeda.getConversion_rate());
            inserirNoHistorico(moeda);
            return valorConverter * moeda.getConversion_rate();
        } catch (ErroConversorAPI e) {
            throw new ErroConversorAPI("Opss, Houve um erro durante a consulta à ExchangeRate-API. Tente novamente!");
        }
    }

    public Moeda dadosMoeda(String moeda1, String moeda2) {
        try {
            return request.RequestApi(moeda1, moeda2);

        } catch (ErroConversorAPI e) {
            throw new ErroConversorAPI("Uma ou mais moedas inseridas são inválidas! (" + moeda1 + " | " + moeda2 + ")\nCorrija e tente novamente!");
        }
    }

    public void inserirNoHistorico(Moeda moeda) {
        ZonedDateTime relogio = ZonedDateTime.now(ZoneId.systemDefault());
        String relogioFormatado = relogio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss (z)"));
        moeda.setRegistoLog(relogioFormatado);
        this.historicoBusca.add(moeda);
    }
}
