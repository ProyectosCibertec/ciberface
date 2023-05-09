package pe.edu.cibertec.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "likes")
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private long likeId;

    @Column(name = "like_type")
    private int likeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;
}
