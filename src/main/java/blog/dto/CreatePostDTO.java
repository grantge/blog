package blog.dto;

public class CreatePostDTO {

    private String title;
    private String content;

    public CreatePostDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public CreatePostDTO() {
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
