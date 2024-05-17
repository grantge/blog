package blog.dto;

public class DeletePostDTO {

    private int id;

    public DeletePostDTO(int id) {
        this.id = id;
    }

    public DeletePostDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
