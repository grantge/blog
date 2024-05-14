package blog.model;

import java.sql.Timestamp;
import java.util.Date;

public class Post {

    // Приватные свойства сущности
    private String id;
    private String title;
    private String content;
    private Timestamp date;

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    // Конструктор класса


    public Post() {

    }

    public Post(String id, String title, String content, Timestamp date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
