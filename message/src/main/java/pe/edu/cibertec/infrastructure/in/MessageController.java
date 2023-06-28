package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.MessageService;
import pe.edu.cibertec.domain.dto.MessageDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MessageDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(messageService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> list() {
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/chat/{chatId}")
    public ResponseEntity<List<MessageDTO>> findMessageByChatId(@PathVariable Long chatId) {
        return new ResponseEntity<>(messageService.findMessageByChatId(chatId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageDTO> add(@Valid @RequestBody MessageDTO messageDTO) {
        return new ResponseEntity<>(messageService.save(messageDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MessageDTO> edit(@Valid @RequestBody MessageDTO messageDTO) {
        return new ResponseEntity<>(messageService.save(messageDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        messageService.delete(id);
    }

    @GetMapping(value = "/get-by-chat")
    public ResponseEntity<List<MessageDTO>> getByChatId(@RequestParam(name = "chatId") Long chatId) {
        return new ResponseEntity<>(messageService.getByChatId(chatId), HttpStatus.OK);
    }
}
