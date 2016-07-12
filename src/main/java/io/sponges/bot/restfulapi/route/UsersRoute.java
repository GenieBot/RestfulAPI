package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class UsersRoute extends Route {

    public UsersRoute() {
        super("/clients/:client/networks/:network/users", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        String client = request.params("client");
        String network = request.params("network");
        return sendChannelMessage(response, "list_users " + client + " " + network);
    }

    @Override
    public boolean requiresAuth() {
        return true;
    }
}
