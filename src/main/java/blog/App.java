package blog;

import blog.controller.PostController;
import blog.util.DatabaseInitializer;
import blog.util.PostRoutes;
import io.javalin.Javalin;

import java.io.IOException;

public class App {

    public static void main(String[] args) {
        DatabaseInitializer.initializeDatabase();

        var app = Javalin.create(config -> {
                config.bundledPlugins.enableDevLogging();
                })
                .start(7070);

        app.get(PostRoutes.postsPath(), PostController::showPosts);
        app.get(PostRoutes.postPath("{id}"), PostController::showPost);
        app.post(PostRoutes.postCreatePath(), PostController::createPost);
        app.put(PostRoutes.postUpdatePath(), PostController::updatePost);
        app.delete(PostRoutes.postDeletePath(), PostController::deletePost);
    }
}