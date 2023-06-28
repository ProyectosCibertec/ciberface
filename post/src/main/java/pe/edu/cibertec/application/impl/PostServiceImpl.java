package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.PostService;
import pe.edu.cibertec.domain.dto.GetPostsByContent;
import pe.edu.cibertec.domain.dto.PostDTO;
import pe.edu.cibertec.domain.entity.Comment;
import pe.edu.cibertec.domain.entity.Post;
import pe.edu.cibertec.domain.mapper.CommentMapper;
import pe.edu.cibertec.domain.mapper.PostMapper;
import pe.edu.cibertec.infrastructure.out.CommentRepository;
import pe.edu.cibertec.infrastructure.out.LikeRepository;
import pe.edu.cibertec.infrastructure.out.PostRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;
    private final PostMapper postMapper = PostMapper.INSTANCE;
    private final CommentMapper commentMapper = CommentMapper.INSTANCE;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository, LikeRepository likeRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.likeRepository = likeRepository;
    }

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
        List<PostDTO> postDTOS = postMapper.listPostToPostDTO(postRepository.findAll());
        postDTOS.forEach(postDTO -> {
            List<Comment> comments = commentRepository.findByPostId(postDTO.getPostId());
            Collections.reverse(comments);
            postDTO.setComments(commentMapper.listCommentToCommentDTO(comments));
            postDTO.setLikes(likeRepository.countLikesByPostId(postDTO.getPostId()));
            postDTO.setDislikes(likeRepository.countDislikesByPostId(postDTO.getPostId()));
        });
        Collections.reverse(postDTOS);
        return postDTOS;
    }

    @Override
    public PostDTO save(PostDTO postDTO) {
        return postMapper.postToPostDTO(postRepository.save(postMapper.postDTOToPost(postDTO)));
    }

    @Override
    public void delete(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostDTO> getPostsByContent(String pattern) {
        return postMapper.listPostToPostDTO(postRepository.getPostsByContent(pattern));
    }
}
