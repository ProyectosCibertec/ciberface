package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.FriendshipService;
import pe.edu.cibertec.domain.dto.FriendshipDTO;
import pe.edu.cibertec.domain.entity.Friendship;
import pe.edu.cibertec.domain.mapper.FriendshipMapper;
import pe.edu.cibertec.infrastructure.out.FriendshipRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FriendshipServiceImpl implements FriendshipService {
    @Autowired
    private FriendshipRepository friendshipRepository;
    private FriendshipMapper friendshipMapper = FriendshipMapper.INSTANCE;

    @Override
    public FriendshipDTO find(Long friendshipId) {
        Optional<Friendship> friendship = friendshipRepository.findById(friendshipId);
        if (friendship.isPresent()) {
            return friendshipMapper.friendshipToFriendshipDTO(friendship.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<FriendshipDTO> findAll() {
        return friendshipMapper.listFriendshipToFriendshipDTO(friendshipRepository.findAll());
    }

    @Override
    public FriendshipDTO save(FriendshipDTO friendshipDTO) {
        return friendshipMapper.friendshipToFriendshipDTO(friendshipRepository.save(friendshipMapper.friendshipDTOToFriendship(friendshipDTO)));
    }

    @Override
    public void delete(Long friendshipId) {
        friendshipRepository.deleteById(friendshipId);
    }

    @Override
    public int getFriendsAmountByUser(long userId) {
        return friendshipRepository.countByUserId(userId);
    }
}
