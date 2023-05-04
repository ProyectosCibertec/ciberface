package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.domain.entity.Friendship;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
}
