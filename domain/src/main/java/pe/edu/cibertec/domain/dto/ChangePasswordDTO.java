package pe.edu.cibertec.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class ChangePasswordDTO implements Serializable {
    @NotEmpty(message = "Old password should not be empty or null")
    private String oldPassword;
    @NotEmpty(message = "New password should not be empty or null")
    private String newPassword;
}
