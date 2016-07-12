package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class ModulesRoute extends Route {

    public ModulesRoute() {
        super("/modules", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        return sendChannelMessage(response, "list_modules");
    }

    @Override
    public boolean requiresAuth() {
        return true;
    }
}
