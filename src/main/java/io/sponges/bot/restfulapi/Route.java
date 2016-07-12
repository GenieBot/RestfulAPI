package io.sponges.bot.restfulapi;

import spark.Request;
import spark.Response;

import java.util.concurrent.TimeoutException;

public abstract class Route {

    private final String path;
    private final Method method;

    private Client client = null;

    public Route(String path, Method method) {
        this.path = path;
        this.method = method;
    }

    public Object internalExecute(Request request, Response response) {
        response.type("application/json;charset=utf-8");
        if (requiresAuth()) {
            if (!request.queryParams().contains("key")) {
                response.status(401);
                return "{\"error\":\"API key is required\"}";
            }
            String key = request.queryParams("key");
            // TODO validate api keys
            if (!key.equals("memes")) {
                response.status(401);
                return "{\"error\":\"Invalid API key\"}";
            }
        }
        return execute(request, response);
    }

    public abstract Object execute(Request request, Response response);

    public boolean requiresAuth() {
        return false;
    }

    public final String sendChannelMessage(Response response, String message) {
        try {
            return getClient().sendChannelMessage(message);
        } catch (TimeoutException e) {
            response.status(408);
            return "{\"error\":\"Request timed out\"}";
        }
    }

    public String getPath() {
        return path;
    }

    public Method getMethod() {
        return method;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public enum Method {
        GET, POST, PUT, PATCH, DELETE
    }
}
