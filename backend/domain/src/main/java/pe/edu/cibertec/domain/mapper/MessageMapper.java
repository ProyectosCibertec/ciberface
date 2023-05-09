package pe.edu.cibertec.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.cibertec.domain.dto.ChatDTO;
import pe.edu.cibertec.domain.dto.MessageDTO;
import pe.edu.cibertec.domain.entity.Chat;
import pe.edu.cibertec.domain.entity.Message;

import java.util.List;

@Mapper
public interface MessageMapper {
    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDTO messageToMessageDTO(Message message);

    Message messageDTOToMessage(MessageDTO messageDTO);

    List<MessageDTO> listMessageToMessageDTO(List<Message> message);

    List<Message> listMessageDTOToMessage(List<MessageDTO> messageDTOList);
}
