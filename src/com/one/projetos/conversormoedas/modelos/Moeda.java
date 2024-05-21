package com.one.projetos.conversormoedas.modelos;

public class Moeda {
    private final String time_last_update_utc;
    private final double conversion_rate;
    private final String base_code;
    private final String target_code;

    public Moeda(DadosConversor dadosConversor) {
        this.time_last_update_utc = dadosConversor.time_last_update_utc().substring(0, 25);
        this.conversion_rate = dadosConversor.conversion_rate();
        this.base_code = dadosConversor.base_code();
        this.target_code = dadosConversor.target_code();
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    @Override
    public String toString() {
        return "Taxa de conversão de " + base_code + " para " + target_code + ": " + conversion_rate + " | " +
                "Última atualização da taxa de conversão: " + time_last_update_utc;
    }
}
