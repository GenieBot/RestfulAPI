package io.sponges.bot.restfulapi;

import io.sponges.bot.restfulapi.route.*;
import io.sponges.bot.restfulapi.route.module.ModifyModuleRoute;
import io.sponges.bot.restfulapi.route.module.NetworkModulesRoute;
import io.sponges.bot.restfulapi.route.role.RoleRoute;
import io.sponges.bot.restfulapi.route.role.RolesRoute;
import spark.Spark;

public class Routes {

    private final Client client;

    public Routes(Client client) {
        this.client = client;
        Spark.port(4568);
        register(
                new TestRoute(),
                new IndexRoute(),
                new StatisticsRoute(),
                new ClientsRoute(),
                new NetworksRoute(),
                new ModulesRoute(),
                new CommandsRoute(),
                new RolesRoute(),
                new RoleRoute(),
                new UsersRoute(),
                new NetworkModulesRoute(),
                new ModifyModuleRoute()
        );
        Spark.get("/api", (request, response) -> {
            response.redirect("/api/");
            return "Redirecting...";
        });
    }
    private void register(Route... routes) {
        for (Route route : routes) {
            register(route);
        }
    }

    private void register(Route route) {
        route.setClient(client);
        String path = "/api" + route.getPath();
        Route.Method method = route.getMethod();
        switch (method) {
            case GET:
                Spark.get(path, route::internalExecute);
                break;
            case POST:
                Spark.post(path, route::internalExecute);
                break;
            case PUT:
                Spark.put(path, route::internalExecute);
                break;
            case PATCH:
                Spark.patch(path, route::internalExecute);
                break;
            case DELETE:
                Spark.delete(path, route::internalExecute);
                break;
        }
    }

}