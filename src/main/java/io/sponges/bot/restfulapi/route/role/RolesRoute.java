package io.sponges.bot.restfulapi.route.role;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class RolesRoute extends Route {

    public RolesRoute() {
        super("/clients/:client/networks/:network/roles", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        String client = request.params(":client");
        String network = request.params(":network");
        return sendChannelMessage(response, "list_roles " + client + " " + network);
    }
}
