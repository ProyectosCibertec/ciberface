package pe.edu.cibertec.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pe.edu.cibertec.domain.dto.PostDTO;
import pe.edu.cibertec.domain.entity.Post;

import java.util.List;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostDTO postToPostDTO(Post post);

    Post postDTOToPost(PostDTO postDTO);

    List<PostDTO> listPostToPostDTO(List<Post> post);

    List<Post> listPostDTOToPost(List<PostDTO> postDTOList);
}
