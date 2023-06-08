package pe.edu.cibertec.application;

import pe.edu.cibertec.domain.dto.LikeDTO;

import java.util.List;

public interface LikeService {
    LikeDTO find(Long id);
    List<LikeDTO> findAll();
    LikeDTO save(LikeDTO likeDTO);
    void delete(Long likeId);
}
