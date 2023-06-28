package pe.edu.cibertec.domain.dto;

import java.io.Serializable;

public class TokenDTO implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final long userId;

    public TokenDTO(String jwttoken, long userId) {
        this.jwttoken = jwttoken;
        this.userId = userId;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public long getUserId() {
        return userId;
    }
}