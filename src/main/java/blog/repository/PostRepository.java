package blog.repository;

import blog.jdbc.JdbcConnection;
import blog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    Connection connection = new JdbcConnection().getConnection();

    // Получение всех постов
    public List<Post> getPosts() {
        String query = "SELECT * FROM posts";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Post> posts = new ArrayList<>();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getString("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setDate(resultSet.getTimestamp("date"));

                posts.add(post);
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Получение определенного поста по id
    public Post getPost(int id) {
        String query = "SELECT * FROM posts WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            String resultId = resultSet.getString("id");
            String resultTitle = resultSet.getString("title");
            String resultContent = resultSet.getString("content");
            Timestamp resultDate = resultSet.getTimestamp("date");

            return new Post(resultId, resultTitle, resultContent, resultDate);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Создание поста
    public void createPost() {
        String query = "SELECT * FROM posts";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Post> posts = new ArrayList<>();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getString("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setDate(resultSet.getTimestamp("date"));

                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Обновление поста
    public void updatePost() {
        String query = "SELECT * FROM posts";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Post> posts = new ArrayList<>();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getString("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setDate(resultSet.getTimestamp("date"));

                posts.add(post);
            }
//            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Удаление поста
    public List<Post> deletePosts() {
        String query = "SELECT * FROM posts";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Post> posts = new ArrayList<>();
            while (resultSet.next()) {
                Post post = new Post();
                post.setId(resultSet.getString("id"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setDate(resultSet.getTimestamp("date"));

                posts.add(post);
            }
            return posts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}