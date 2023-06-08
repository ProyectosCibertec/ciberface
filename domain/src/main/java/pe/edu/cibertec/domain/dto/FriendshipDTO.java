package pe.edu.cibertec.domain.dto;

import lombok.Data;

import javax.persistence.*;

@Data
public class FriendshipDTO {
    private long friendshipId;
    private UserDTO userId;
    private UserDTO friendId;
}
