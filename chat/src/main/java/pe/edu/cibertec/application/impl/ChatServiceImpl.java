package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.ChatService;
import pe.edu.cibertec.domain.dto.ChatDTO;
import pe.edu.cibertec.domain.entity.Chat;
import pe.edu.cibertec.domain.mapper.ChatMapper;
import pe.edu.cibertec.infrastructure.out.ChatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;
    private final ChatMapper chatMapper = ChatMapper.INSTANCE;

    @Override
    public ChatDTO find(Long chatId) {
        Optional<Chat> chat = chatRepository.findById(chatId);
        if (chat.isPresent()) {
            return chatMapper.chatToChatDTO(chat.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<ChatDTO> findAll() {
        return chatMapper.listChatToChatDTO(chatRepository.findAll());
    }

    @Override
    public ChatDTO save(ChatDTO chatDTO) {
        return chatMapper.chatToChatDTO(chatRepository.save(chatMapper.chatDTOToChat(chatDTO)));
    }

    @Override
    public void delete(Long chatId) {
        chatRepository.deleteById(chatId);
    }
}
