package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class LikeDTO implements Serializable {
    @NotNull
    private long likeId;
    private int likeType;
    @NotNull
    private PostDTO postId;
    @NotNull
    private UserDTO userId;
}
