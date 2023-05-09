package pe.edu.cibertec.domain.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class ChatDTO implements Serializable {
    private long chatId;
    private FriendshipDTO friendshipId;
}
