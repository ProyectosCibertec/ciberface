package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.domain.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
