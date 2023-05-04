package pe.edu.cibertec.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
public class PostDTO {
    private long postId;
    private UserDTO userId;
    private String postContent;
    private Date creationDate;
}
