package pe.edu.cibertec.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.cibertec.domain.dto.FriendshipDTO;
import pe.edu.cibertec.domain.entity.Friendship;

import java.util.List;

@Mapper
public interface FriendshipMapper {
    FriendshipMapper INSTANCE = Mappers.getMapper(FriendshipMapper.class);

    FriendshipDTO friendshipToFriendshipDTO(Friendship friendship);

    Friendship friendshipDTOToFriendship(FriendshipDTO friendshipDTO);

    List<FriendshipDTO> listFriendshipToFriendshipDTO(List<Friendship> friendship);

    List<Friendship> listFriendshipDTOToFriendship(List<FriendshipDTO> friendshipDTOList);
}
