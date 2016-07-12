package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class NetworksRoute extends Route {

    public NetworksRoute() {
        super("/clients/:client/networks", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        String appender = request.params(":client");
        if (request.queryParams().size() > 1) {
            String user = request.params("user");
            appender += " " + user;
        }
        return sendChannelMessage(response, "list_networks " + appender);
    }

    @Override
    public boolean requiresAuth() {
        return true;
    }
}
