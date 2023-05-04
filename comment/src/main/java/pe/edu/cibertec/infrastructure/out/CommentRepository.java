package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.domain.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
