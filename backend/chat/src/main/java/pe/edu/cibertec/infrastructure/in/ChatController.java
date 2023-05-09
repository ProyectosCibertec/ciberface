package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.ChatService;
import pe.edu.cibertec.domain.dto.ChatDTO;
import java.util.List;

@RestController
@RequestMapping(value = "/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ChatDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(chatService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ChatDTO>> list() {
        return new ResponseEntity<>(chatService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ChatDTO> add(@RequestBody ChatDTO chatDTO) {
        return new ResponseEntity<>(chatService.save(chatDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<ChatDTO> edit(@RequestBody ChatDTO chatDTO) {
        return new ResponseEntity<>(chatService.save(chatDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        chatService.delete(id);
    }
}
