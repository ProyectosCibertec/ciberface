package pe.edu.cibertec.application.impl;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.FriendshipService;
import pe.edu.cibertec.domain.dto.FriendshipDTO;
import pe.edu.cibertec.domain.entity.Chat;
import pe.edu.cibertec.domain.entity.Friendship;
import pe.edu.cibertec.domain.mapper.ChatMapper;
import pe.edu.cibertec.domain.mapper.FriendshipMapper;
import pe.edu.cibertec.infrastructure.out.ChatRepository;
import pe.edu.cibertec.infrastructure.out.FriendshipRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FriendshipServiceImpl implements FriendshipService {
    private final FriendshipRepository friendshipRepository;
    private final ChatRepository chatRepository;
    private final FriendshipMapper friendshipMapper = FriendshipMapper.INSTANCE;
    private final ChatMapper chatMapper = ChatMapper.INSTANCE;

    public FriendshipServiceImpl(FriendshipRepository friendshipRepository, ChatRepository chatRepository) {
        this.friendshipRepository = friendshipRepository;
        this.chatRepository = chatRepository;
    }

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

    @Transactional
    @Override
    public Integer save(FriendshipDTO friendshipDTO) {
        Chat chat = chatRepository.save(chatMapper.chatDTOToChat(friendshipDTO.getChatId()));
        friendshipRepository.createFriendship(friendshipDTO.getUserId().getUserId(), friendshipDTO.getFriendId().getUserId(), chat.getChatId());
        friendshipRepository.createFriendship(friendshipDTO.getFriendId().getUserId(), friendshipDTO.getUserId().getUserId(), chat.getChatId());
        return 1;
    }

    @Override
    public void delete(Long friendshipId) {
        friendshipRepository.deleteById(friendshipId);
    }

    @Override
    public int getFriendsAmountByUser(Long userId) {
        return friendshipRepository.countByUserId(userId);
    }

    @Override
    public FriendshipDTO getByFriendAndUserIds(Long userId, Long friendId) {
        return friendshipMapper.friendshipToFriendshipDTO(friendshipRepository.getByFriendAndUserIds(userId, friendId));
    }
}
