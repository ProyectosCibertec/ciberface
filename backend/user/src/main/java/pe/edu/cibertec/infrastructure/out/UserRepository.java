package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.cibertec.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT password FROM User u WHERE u.userId = :userId")
    String getOldPassword(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.password = :newPassword WHERE u.userId = :userId")
    int updateOldPassword(@Param("userId") long userId, @Param("newPassword") String newPassword);
}
