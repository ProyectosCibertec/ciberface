package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.domain.entity.Comment;
import pe.edu.cibertec.domain.entity.User;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT c FROM Comment c WHERE c.postId.postId = :postId")
    List<Comment> findByPostId(@Param("postId") long postId);
}
