package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO find(Long id);
    List<PostDTO> findAll();
    PostDTO save(PostDTO postDTO);
    void delete(Long postId);
}
