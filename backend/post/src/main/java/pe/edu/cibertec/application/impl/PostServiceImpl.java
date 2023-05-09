package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.PostService;
import pe.edu.cibertec.domain.dto.PostDTO;
import pe.edu.cibertec.domain.entity.Post;
import pe.edu.cibertec.domain.mapper.PostMapper;
import pe.edu.cibertec.infrastructure.out.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    private PostMapper postMapper = PostMapper.INSTANCE;

    @Override
    public PostDTO find(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            return postMapper.postToPostDTO(post.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<PostDTO> findAll() {
        return postMapper.listPostToPostDTO(postRepository.findAll());
    }

    @Override
    public PostDTO save(PostDTO postDTO) {
        return postMapper.postToPostDTO(postRepository.save(postMapper.postDTOToPost(postDTO)));
    }

    @Override
    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }
}
