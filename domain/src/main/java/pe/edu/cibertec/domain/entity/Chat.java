package pe.edu.cibertec.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private long chatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friendship_id", nullable = false)
    private Friendship friendshipId;
}
