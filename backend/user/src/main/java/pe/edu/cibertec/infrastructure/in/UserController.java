package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.UserService;
import pe.edu.cibertec.domain.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(userService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> list() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> edit(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }
}
