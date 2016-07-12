package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class TestRoute extends Route {

    public TestRoute() {
        super("/test", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        return sendChannelMessage(response, "test");
    }
}
