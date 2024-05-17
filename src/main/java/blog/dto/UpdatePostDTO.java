package blog.dto;

public class UpdatePostDTO {

    private int id;
    private String title;
    private String content;

    public UpdatePostDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public UpdatePostDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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


}
