package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    @NotNull
    private long userId;
    private String firstName;
    private String lastName;
    @NotEmpty
    private String userName;
    @NotEmpty
    private String email;
    private String password;
    private String biography;
    private String photoUrl;
}
