package pe.edu.cibertec.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class CommentDTO implements Serializable {
    @NotNull
    private long commentId;
    @NotEmpty(message = "Comment content should not be empty or null")
    private String commentContent;
    @NotNull
    private PostDTO postId;
    @NotNull
    private UserDTO userId;
    private Date creationDate;
}
