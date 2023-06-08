package pe.edu.cibertec.domain.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetPostsByContent implements Serializable {
    private String pattern;
}
