package blog.repository;

import blog.dto.CreatePostDTO;
import blog.dto.DeletePostDTO;
import blog.dto.UpdatePostDTO;
import blog.jdbc.JdbcConnection;
import blog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    Connection connection = new JdbcConnection().getConnection();

    // Получение всех постов
    public List<Post> getPosts() {
        String query = "select * from posts";

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
        String query = "select * from posts where id = ?";

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
    public Post createPost(CreatePostDTO createPost) {
        String query = "insert into posts (title, content, date) values ( ?, ?, NOW()) returning * ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, createPost.getTitle());
            preparedStatement.setString(2, createPost.getContent());
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return new Post(
                    resultSet.getString("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getTimestamp("date")
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Обновление поста
    public Post updatePost(UpdatePostDTO updatePost) {
        String query = "update posts set title = ?, content = ?, date = NOW() where id = ? returning * ";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, updatePost.getTitle());
            preparedStatement.setString(2, updatePost.getContent());
            preparedStatement.setInt(3, updatePost.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return new Post(
                    resultSet.getString("id"),
                    resultSet.getString("title"),
                    resultSet.getString("content"),
                    resultSet.getTimestamp("date")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Удаление поста
    public void deletePosts(DeletePostDTO deletePost) {
        String query = "delete from posts where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, deletePost.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}