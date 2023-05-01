package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import pe.edu.cibertec.domain.Friendship;

/*import javax.transaction.Transactional;*/
import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository <Friendship, Long> {

    List<Friendship> findAllByUserId(Long user_id);

    List<Friendship> findAllByFriendId(Long friend_id);

    Optional<Friendship> findByUserIdAndFriendId(Long user_id, Long friend_id);

/*    @Modifying
    @Transactional
    @Query("DELETE FROM Friendship f WHERE f.userId = :userId AND f.friendId = :friendId")
    void deleteByUserIdAndFriendId(@Param("userId") Long userId, @Param("friendId") Long friendId);*/

}
