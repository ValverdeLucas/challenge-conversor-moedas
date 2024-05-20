public class Moeda {
    private String time_last_update_utc;
    private Object conversion_rates;

    public Moeda(DadosConversor dadosConversor) {
        this.time_last_update_utc = dadosConversor.time_last_update_utc();
        this.conversion_rates = dadosConversor.conversion_rates();
    }
}
