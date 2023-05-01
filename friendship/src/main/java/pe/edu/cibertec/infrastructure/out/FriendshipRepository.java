package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.domain.Friendship;

public interface FriendshipRepository extends JpaRepository <Friendship, Long> {

}
