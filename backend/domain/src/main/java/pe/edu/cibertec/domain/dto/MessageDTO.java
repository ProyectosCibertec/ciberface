package pe.edu.cibertec.domain.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class MessageDTO implements Serializable {
    private long messageId;
    private String messageContent;
    private UserDTO userId;
    private ChatDTO chatId;
    private Date creationDate;
}
