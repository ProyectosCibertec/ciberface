package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.MessageService;
import pe.edu.cibertec.domain.dto.MessageDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MessageDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(messageService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<MessageDTO>> list() {
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/chat/{chatId}", method = RequestMethod.GET)
    public ResponseEntity<List<MessageDTO>> findMessageByChatId(@PathVariable Long chatId) {
        return new ResponseEntity<>(messageService.findMessageByChatId(chatId), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<MessageDTO> add(@RequestBody MessageDTO messageDTO) {
        return new ResponseEntity<>(messageService.save(messageDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<MessageDTO> edit(@RequestBody MessageDTO messageDTO) {
        return new ResponseEntity<>(messageService.save(messageDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        messageService.delete(id);
    }

    @RequestMapping(value = "/get-by-chat", method = RequestMethod.GET)
    public ResponseEntity<List<MessageDTO>> getByChatId(@RequestParam(name = "chatId") Long chatId) {
        return new ResponseEntity<>(messageService.getByChatId(chatId), HttpStatus.OK);
    }
}
