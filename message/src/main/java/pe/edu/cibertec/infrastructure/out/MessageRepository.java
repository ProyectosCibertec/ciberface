package pe.edu.cibertec.infrastructure.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.domain.entity.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(value = "SELECT m FROM Message m WHERE m.chatId.chatId = :chatId")
    List<Message> findByChatId(@Param("chatId") Long chatId);
}
