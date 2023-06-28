package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.domain.entity.Friendship;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO friendships(user_id_1, user_id_2) VALUES (:userId, :friendId)",
            nativeQuery = true)
    void createFriendship(@Param("userId") long userId, @Param("friendId") long friendId);
    @Query("SELECT COUNT(friendship) FROM Friendship friendship WHERE friendship.userId.userId = :userId")
    int countByUserId(@Param("userId") long userId);/**/
}
