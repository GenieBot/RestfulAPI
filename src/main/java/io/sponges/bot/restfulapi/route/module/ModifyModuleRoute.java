package io.sponges.bot.restfulapi.route.module;

import io.sponges.bot.restfulapi.Route;
import spark.Request;
import spark.Response;

public class ModifyModuleRoute extends Route {

    public ModifyModuleRoute() {
        super("/clients/:client/networks/:network/modules/:module", Method.POST);
    }

    @Override
    public Object execute(Request request, Response response) {
        String client = request.params(":client");
        String network = request.params(":network");
        String module = request.params(":module");
        String body = request.body();
        return sendChannelMessage(response, "modify_module " + client + " " + network + " " + module + " " + body);
    }
}
