package blog.util;

public class PostRoutes {

    public static String postsPath() {
        return "/posts";
    }

    public static String postPath(String id) {
        return "/post/" + id;
    }

    public static String postCreatePath() {
        return "/post";
    }

    public static String postUpdatePath() {
        return "/post";
    }

    public static String postDeletePath() {
        return "/post";
    }
}
