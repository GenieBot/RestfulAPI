package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class CommandsRoute extends Route {

    public CommandsRoute() {
        super("/commands", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        return sendChannelMessage(response, "list_commands");
    }

    @Override
    public boolean requiresAuth() {
        return true;
    }
}
