package io.sponges.bot.restfulapi;

import io.sponges.bot.client.Bot;
import io.sponges.bot.client.event.events.CommandResponseEvent;
import io.sponges.bot.client.event.events.StopEvent;
import spark.Spark;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public class Client {

    private final Bot bot;

    public Client() {
        this.bot = new Bot("restfulapi", "-", "localhost", 9574);
        this.bot.getEventBus().register(CommandResponseEvent.class, event -> {
            System.out.println("Response from query: " + event.getMessage());
        });
        this.bot.getEventBus().register(StopEvent.class, event -> {
            Spark.stop();
            this.bot.stop();
        });
        this.bot.start();
    }

    public Bot getBot() {
        return bot;
    }

    public String sendChannelMessage(String message) throws TimeoutException {
        AtomicReference<String> reply = new AtomicReference<>();
        bot.getClient().sendChannelMessage(bot, message, reply::set);
        long start = System.currentTimeMillis();
        while (reply.get() == null) {
            /*if (System.currentTimeMillis() - start > 4000) {
                throw new TimeoutException();
            }*/
        }
        return reply.get();
    }
}
