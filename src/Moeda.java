public class Moeda {
    private String time_last_update_utc;
    private Object conversion_rates;

    public Moeda(DadosConversor dadosConversor) {
        this.time_last_update_utc = dadosConversor.time_last_update_utc();
        this.conversion_rates = dadosConversor.conversion_rates();
    }

    @Override
    public String toString() {
        return "Última atualização: " + time_last_update_utc + " | " +
                "Taxa de conversão: " + conversion_rates;
    }
}
