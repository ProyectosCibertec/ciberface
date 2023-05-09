package pe.edu.cibertec.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.cibertec.domain.dto.LikeDTO;
import pe.edu.cibertec.domain.entity.Like;

import java.util.List;

@Mapper
public interface LikeMapper {
    LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    LikeDTO likeToLikeDTO(Like like);

    Like likeDTOToLike(LikeDTO likeDTO);

    List<LikeDTO> listLikeToLikeDTO(List<Like> like);

    List<Like> listLikeDTOToLike(List<LikeDTO> likeDTOList);
}
