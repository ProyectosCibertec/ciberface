package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO find(Long id);
    List<CommentDTO> findAll();
    CommentDTO save(CommentDTO commentDTO);
    void delete(Long commentId);
}
