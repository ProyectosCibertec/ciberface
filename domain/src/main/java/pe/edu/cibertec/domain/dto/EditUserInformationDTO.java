package pe.edu.cibertec.domain.dto;

import lombok.Data;

@Data
public class EditUserInformationDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String biography;
    private String photoUrl;
}
