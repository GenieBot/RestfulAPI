package io.sponges.bot.restfulapi;

public class Main {

    private final Client client;
    private final Routes routes;

    public Main() {
        this.client = new Client();
        this.routes = new Routes(client);
    }

    public static void main(String[] args) {
        new Main();
    }

    public Client getClient() {
        return client;
    }
}
