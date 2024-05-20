public class ErroConversorAPI extends RuntimeException {
    private String message;

    public ErroConversorAPI(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}

