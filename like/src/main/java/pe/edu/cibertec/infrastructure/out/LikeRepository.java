package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.domain.entity.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query(value = "SELECT COUNT(l) FROM Like l WHERE l.postId.postId = :postId AND l.likeType = 1")
    Integer countLikesByPostId(@Param("postId") Long postId);

    @Query(value = "SELECT COUNT(l) FROM Like l WHERE l.postId.postId = :postId AND l.likeType = 0")
    Integer countDislikesByPostId(@Param("postId") Long postId);
}
