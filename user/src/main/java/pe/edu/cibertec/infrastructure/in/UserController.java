package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.UserService;
import pe.edu.cibertec.domain.dto.ChangePasswordDTO;
import pe.edu.cibertec.domain.dto.EditUserInformationDTO;
import pe.edu.cibertec.domain.dto.GetBasicUserInformationDTO;
import pe.edu.cibertec.domain.dto.UserDTO;
import pe.edu.cibertec.domain.entity.User;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(userService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> list() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> add(@Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDTO> edit(@Valid @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }

    @PutMapping(value = "/{id}/change-password")
    public ResponseEntity<Integer> changePassword(@Valid @RequestBody ChangePasswordDTO changePasswordDTO, @PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.changePassword(userId, changePasswordDTO), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}/edit-user-information")
    public ResponseEntity<Integer> editUserInformation(@Valid @RequestBody EditUserInformationDTO editUserInformationDTO, @PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.editUserInformation(userId, editUserInformationDTO), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/get-basic-information")
    public ResponseEntity<GetBasicUserInformationDTO> getBasicUserInformation(@PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.getBasicUserInformation(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/get-friends")
    public ResponseEntity<List<UserDTO>> getFriendsByUser(@PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.getFriendsByUser(userId), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/get-no-friends")
    public ResponseEntity<List<UserDTO>> getNoFriendsByUser(@PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.getNoFriendsByUser(userId), HttpStatus.OK);
    }
}
