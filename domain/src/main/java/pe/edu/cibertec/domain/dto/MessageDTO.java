package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Data
public class MessageDTO implements Serializable {
    @NotNull
    private long messageId;
    @NotEmpty
    private String messageContent;
    @NotNull
    private UserDTO userId;
    @NotNull
    private ChatDTO chatId;
    private Date creationDate;
}
