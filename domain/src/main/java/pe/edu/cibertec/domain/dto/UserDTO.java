package pe.edu.cibertec.domain.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String biography;
    private String photoUrl;
}
