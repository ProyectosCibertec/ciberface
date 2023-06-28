package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
public class PostDTO implements Serializable {
    @NotNull
    private long postId;
    @NotNull
    private UserDTO userId;
    @NotEmpty
    private String postContent;
    private Date creationDate;
}
