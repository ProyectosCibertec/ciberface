package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.FriendshipDTO;

import java.util.List;

public interface FriendshipService {
    FriendshipDTO find(Long id);
    List<FriendshipDTO> findAll();
    FriendshipDTO save(FriendshipDTO friendshipDTO);
    void delete(Long friendshipId);
    void createFriendship(long userId, long friendId);
}
