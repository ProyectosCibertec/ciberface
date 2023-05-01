package pe.edu.cibertec.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "friendship")
@Data
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="friendship_id")
    private long friendship_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id", nullable = false)
    private User friend_id;

    @Column(name="create_date",  nullable = false)
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date create_date;

}
