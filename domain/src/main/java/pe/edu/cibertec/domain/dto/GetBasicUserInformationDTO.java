package pe.edu.cibertec.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetBasicUserInformationDTO implements Serializable {
    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String biography;
    private String photoUrl;
    private int friendshipsAmount;
}
