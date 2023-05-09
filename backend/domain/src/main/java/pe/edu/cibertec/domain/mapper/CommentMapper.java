package pe.edu.cibertec.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.cibertec.domain.dto.CommentDTO;
import pe.edu.cibertec.domain.entity.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO commentToCommentDTO(Comment comment);

    Comment commentDTOToComment(CommentDTO commentDTO);

    List<CommentDTO> listCommentToCommentDTO(List<Comment> comment);

    List<Comment> listCommentDTOToComment(List<CommentDTO> commentDTOList);
}
