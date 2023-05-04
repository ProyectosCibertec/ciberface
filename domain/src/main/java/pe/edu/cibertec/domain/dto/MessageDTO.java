package pe.edu.cibertec.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MessageDTO {
    private long messageId;
    private String messageContent;
    private UserDTO userId;
    private ChatDTO chatId;
    private Date creationDate;
}
