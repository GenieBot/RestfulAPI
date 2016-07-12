package io.sponges.bot.restfulapi.route.module;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class NetworkModulesRoute extends Route {

    public NetworkModulesRoute() {
        super("/clients/:client/networks/:network/modules", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        String client = request.params(":client");
        String network = request.params(":network");
        return sendChannelMessage(response, "network_modules " + client + " " + network);
    }
}
