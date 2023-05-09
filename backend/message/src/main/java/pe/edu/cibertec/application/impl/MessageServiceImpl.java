package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.MessageService;
import pe.edu.cibertec.domain.dto.MessageDTO;
import pe.edu.cibertec.domain.entity.Message;
import pe.edu.cibertec.domain.mapper.MessageMapper;
import pe.edu.cibertec.infrastructure.out.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    private MessageMapper messageMapper = MessageMapper.INSTANCE;

    @Override
    public MessageDTO find(Long messageId) {
        Optional<Message> message = messageRepository.findById(messageId);
        if (message.isPresent()) {
            return messageMapper.messageToMessageDTO(message.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<MessageDTO> findAll() {
        return messageMapper.listMessageToMessageDTO(messageRepository.findAll());
    }

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        return messageMapper.messageToMessageDTO(messageRepository.save(messageMapper.messageDTOToMessage(messageDTO)));
    }

    @Override
    public void delete(Long messageId) {
        messageRepository.deleteById(messageId);
    }
}
