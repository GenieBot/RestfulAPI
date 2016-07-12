package io.sponges.bot.restfulapi.route.role;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class RoleRoute extends Route {

    public RoleRoute() {
        super("/clients/:client/networks/:network/roles/:role", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        String client = request.params(":client");
        String network = request.params(":network");
        String role = request.params(":role");
        return sendChannelMessage(response, "show_role " + client + " " + network + " " + role);
    }
}
