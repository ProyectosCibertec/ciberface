package pe.edu.cibertec.domain.dto;

import com.sun.istack.NotNull;
import lombok.Data;
import java.io.Serializable;

@Data
public class ChatDTO implements Serializable {
    @NotNull
    private long chatId;
    private int isBlocked;
}
