package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class GetBasicUserInformationDTO implements Serializable {
    @NotNull
    private long userId;
    private String firstName;
    private String lastName;
    @NotEmpty
    private String userName;
    private String email;
    private String biography;
    private String photoUrl;
    private int friendshipsAmount;
}
