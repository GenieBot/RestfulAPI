package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class StatisticsRoute extends Route {

    public StatisticsRoute() {
        super("/statistics", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        return sendChannelMessage(response, "statistics");
    }
}
