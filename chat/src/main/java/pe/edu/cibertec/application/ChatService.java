package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.ChatDTO;

import java.util.List;

public interface ChatService {
    ChatDTO find(Long id);
    List<ChatDTO> findAll();
    ChatDTO save(ChatDTO chatDTO);
    void delete(Long chatId);
}
