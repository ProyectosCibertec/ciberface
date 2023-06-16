package pe.edu.cibertec.application.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.application.CommentService;
import pe.edu.cibertec.domain.dto.CommentDTO;
import pe.edu.cibertec.domain.entity.Comment;
import pe.edu.cibertec.domain.mapper.CommentMapper;
import pe.edu.cibertec.infrastructure.out.CommentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    private final CommentMapper commentMapper = CommentMapper.INSTANCE;

    @Override
    public CommentDTO find(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            return commentMapper.commentToCommentDTO(comment.get());
        }
        throw new RuntimeException();
    }

    @Override
    public List<CommentDTO> findAll() {
        return commentMapper.listCommentToCommentDTO(commentRepository.findAll());
    }

    @Override
    public CommentDTO save(CommentDTO commentDTO) {
        return commentMapper.commentToCommentDTO(commentRepository.save(commentMapper.commentDTOToComment(commentDTO)));
    }

    @Override
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDTO> findByPostId(long postId) {
        return commentMapper.listCommentToCommentDTO(commentRepository.findByPostId(postId));
    }
}
