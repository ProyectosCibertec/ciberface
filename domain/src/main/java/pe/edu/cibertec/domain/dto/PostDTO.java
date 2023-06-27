package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PostDTO implements Serializable {
    @NotNull
    private long postId;
    @NotNull
    private UserDTO userId;
    @NotEmpty
    private String postContent;
    private Date creationDate;
    private List<CommentDTO> comments;
    private int likes;
    private int dislikes;
}
