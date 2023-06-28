package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
public class FriendshipDTO implements Serializable {
    @NotNull
    private long friendshipId;
    @NotNull
    private UserDTO userId;
    @NotNull
    private UserDTO friendId;
}
