package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.ChatService;
import pe.edu.cibertec.domain.dto.ChatDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ChatDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(chatService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ChatDTO>> list() {
        return new ResponseEntity<>(chatService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChatDTO> add(@Valid @RequestBody ChatDTO chatDTO) {
        return new ResponseEntity<>(chatService.save(chatDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ChatDTO> edit(@Valid @RequestBody ChatDTO chatDTO) {
        return new ResponseEntity<>(chatService.save(chatDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        chatService.delete(id);
    }
}
