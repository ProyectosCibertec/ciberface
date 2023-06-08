package pe.edu.cibertec.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentDTO {
    private long commentId;
    private String commentContent;
    private PostDTO postId;
    private UserDTO userId;
    private Date creationDate;
}
