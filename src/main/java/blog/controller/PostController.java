package blog.controller;

import blog.model.Post;
import blog.repository.PostRepository;
import com.google.gson.Gson;
import io.javalin.http.Context;

import java.nio.channels.Pipe;
import java.util.List;

public class PostController {

    static PostRepository postQuery = new PostRepository();
    static Gson gson = new Gson();

    // Контроллер отображения всех постов
    public static void showPosts(Context ctx) {
        List<Post> posts = postQuery.getPosts();
        String resp = gson.toJson(posts);

        ctx.status(200);
        ctx.json(resp);
    }

    // Контроллер отображения одного поста
    public static void showPost(Context ctx) {
        String reqId = ctx.pathParam("id");
        Post post = postQuery.getPost(Integer.parseInt(reqId));
        System.out.println(reqId);
        String resp = gson.toJson(post);

        ctx.status(200);
        ctx.json(resp);
    }

    // Контроллер создания поста
    public static void createPost(Context ctx) {

    }

    // Контроллер обновления поста
    public static void updatePost(Context ctx) {

    }

    // Контроллер удаления поста
    public static void deletePost(Context ctx) {

    }
}