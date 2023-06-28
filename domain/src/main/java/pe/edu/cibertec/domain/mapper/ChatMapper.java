package pe.edu.cibertec.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.cibertec.domain.dto.ChatDTO;
import pe.edu.cibertec.domain.entity.Chat;

import java.util.List;

@Mapper
public interface ChatMapper {
    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    ChatDTO chatToChatDTO(Chat chat);

    Chat chatDTOToChat(ChatDTO chatDTO);

    List<ChatDTO> listChatToChatDTO(List<Chat> chat);

    List<Chat> listChatDTOToChat(List<ChatDTO> chatDTOList);
}
