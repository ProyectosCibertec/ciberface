package pe.edu.cibertec.domain.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PostDTO {
    private long postId;
    private UserDTO userId;
    private String postContent;
    private Date creationDate;
    private List<CommentDTO> comments;
    private int likes;
    private int dislikes;
}
