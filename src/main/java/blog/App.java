package blog;

import io.javalin.Javalin;
public class App {

    public static void main(String[] args) {
        var app = Javalin.create(config -> {
                config.bundledPlugins.enableDevLogging();
                })
                .start(7070);

        app.get("/hello", ctx -> ctx.result("Hello"));
        app.get("/bye", ctx -> ctx.result("Bye"));
    }
}