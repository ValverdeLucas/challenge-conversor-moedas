package com.one.projetos.conversormoedas.modelos;

public class Moeda {
    private String time_last_update_utc;
    private double conversion_rate;
    private String base_code;
    private String target_code;

    public Moeda(DadosConversor dadosConversor) throws NullPointerException {
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
