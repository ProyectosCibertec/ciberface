package pe.edu.cibertec.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "messages")
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="message_id")
    private long messageId;

    @Column(name = "message_content", length = 1000)
    private String messageContent;
    
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "chat_id")
    private int chatId;
    
    @Column(name="creation_date", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date creationDate;
}
