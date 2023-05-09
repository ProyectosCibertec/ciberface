package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.LikeService;
import pe.edu.cibertec.domain.dto.LikeDTO;
import pe.edu.cibertec.domain.entity.Like;
import pe.edu.cibertec.domain.mapper.LikeMapper;
import pe.edu.cibertec.infrastructure.out.LikeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeRepository likeRepository;
    private LikeMapper likeMapper = LikeMapper.INSTANCE;

    @Override
    public LikeDTO find(Long likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        if (like.isPresent()) {
            return likeMapper.likeToLikeDTO(like.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<LikeDTO> findAll() {
        return likeMapper.listLikeToLikeDTO(likeRepository.findAll());
    }

    @Override
    public LikeDTO save(LikeDTO likeDTO) {
        return likeMapper.likeToLikeDTO(likeRepository.save(likeMapper.likeDTOToLike(likeDTO)));
    }

    @Override
    public void delete(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
