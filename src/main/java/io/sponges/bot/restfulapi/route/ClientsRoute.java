package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class ClientsRoute extends Route {

    public ClientsRoute() {
        super("/clients", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        return sendChannelMessage(response, "list_clients");
    }

    @Override
    public boolean requiresAuth() {
        return true;
    }
}
