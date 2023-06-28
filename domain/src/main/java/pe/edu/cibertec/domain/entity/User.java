package pe.edu.cibertec.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "biography", length = 250)
    private String biography;

    @Column(name = "photo_url", length = 250, columnDefinition = "varchar(250) default 'https://cdn-icons-png.flaticon.com/512/149/149071.png'")
    private String photoUrl;
}
