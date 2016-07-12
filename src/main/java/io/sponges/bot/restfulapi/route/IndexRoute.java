package io.sponges.bot.restfulapi.route;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class IndexRoute extends Route {

    public IndexRoute() {
        super("/", Method.GET);
    }

    @Override
    public Object execute(Request request, Response response) {
        return "{\"response\":\"Nothing to see here!\"}";
    }
}
