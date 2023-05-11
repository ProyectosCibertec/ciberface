package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.domain.dto.UserDTO;
import pe.edu.cibertec.domain.entity.User;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT password FROM User u WHERE u.userId = :userId")
    String getOldPassword(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.password = :newPassword WHERE u.userId = :userId")
    int updateOldPassword(@Param("userId") long userId, @Param("newPassword") String newPassword);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.userName = :userName, " +
            "u.firstName = :firstName, " +
            "u.lastName = :lastName, " +
            "u.email = :email, " +
            "u.biography = :biography, " +
            "u.photoUrl = :photoUrl " +
            "WHERE u.userId = :userId")
    Integer editUserInformation(
            @Param("userId") long userId,
            @Param("userName") String userName,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("biography") String biography,
            @Param("photoUrl") String photoUrl);

    @Query(value = "SELECT count(f) FROM Friendship f WHERE userId.userId = :userId")
    Integer getFriendsAmountByUser(@Param("userId") long userId);

    @Query(value = "SELECT f.friendId FROM Friendship f WHERE f.userId.userId = :userId")
    List<User> getFriendsByUser(@Param("userId") long userId);
}
