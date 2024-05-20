public class Main {
    public static void main(String[] args) {
        RequestAPI request = new RequestAPI();
        Moeda moeda = request.RequestApi();

        System.out.println(moeda);

    }
}