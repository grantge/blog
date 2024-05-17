package blog.controller;

import blog.dto.CreatePostDTO;
import blog.dto.DeletePostDTO;
import blog.dto.UpdatePostDTO;
import blog.model.Post;
import blog.repository.PostRepository;
import com.google.gson.Gson;
import io.javalin.http.Context;

import java.util.HashMap;
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
        String resp = gson.toJson(post);

        ctx.status(200);
        ctx.json(resp);
    }

    // Контроллер создания поста
    public static void createPost(Context ctx) {
        String reqBody = ctx.body();
        Gson gson = new Gson();
        CreatePostDTO createPost = gson.fromJson(reqBody, CreatePostDTO.class);

        Post post = postQuery.createPost(createPost);
        String resp = gson.toJson(post);

        ctx.status(200);
        ctx.json(resp);
    }

    // Контроллер обновления поста
    public static void updatePost(Context ctx) {
        String reqId = ctx.queryParam("id");
        if (reqId == null) {
            return;
        }

        String reqBody = ctx.body();
        Gson gson = new Gson();
        UpdatePostDTO updatePost = gson.fromJson(reqBody, UpdatePostDTO.class);
        updatePost.setId(Integer.parseInt(reqId));

        Post post = postQuery.updatePost(updatePost);
        String resp = gson.toJson(post);

        ctx.status(200);
        ctx.json(resp);

    }

    // Контроллер удаления поста
    public static void deletePost(Context ctx) {
        String reqId = ctx.queryParam("id");
        if (reqId == null) {
            return;
        }
        DeletePostDTO deletePost = new DeletePostDTO();
        deletePost.setId(Integer.parseInt(reqId));

        postQuery.deletePosts(deletePost);
        String resp = "Post with id " + reqId + " was successfully deleted!";

        ctx.status(200);
        ctx.json(resp);

    }
}