package pe.edu.cibertec.domain.dto;

import lombok.Data;

@Data
public class FriendshipDTO {
    private long friendshipId;
    private UserDTO userId;
    private UserDTO friendId;
    private ChatDTO chatId;
}
