package pe.edu.cibertec.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long user_id;

    @Column(name = "first_name", length = 50)
    private String first_name;

    @Column(name = "last_name", length = 50)
    private String last_name;

    @Column(name = "user_name", length = 50)
    private String user_name;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "biography", length = 250)
    private String biography;

    @Column(name = "photo_url", length = 250)
    private String photo_url;

    @Column(name="create_date",  nullable = false)
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date create_date;

}
