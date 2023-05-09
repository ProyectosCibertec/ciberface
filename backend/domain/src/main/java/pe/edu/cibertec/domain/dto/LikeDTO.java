package pe.edu.cibertec.domain.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class LikeDTO {
    private long likeId;
    private int likeType;
    private PostDTO postId;
    private UserDTO userId;
}
