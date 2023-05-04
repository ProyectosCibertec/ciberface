package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    MessageDTO find(Long id);
    List<MessageDTO> findAll();
    MessageDTO save(MessageDTO messageDTO);
    void delete(Long messageId);
}
