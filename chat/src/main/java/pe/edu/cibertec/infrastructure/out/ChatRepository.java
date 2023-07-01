package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.domain.entity.Chat;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
