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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        userService.delete(id);
    }

    @RequestMapping(value = "/{id}/change-password", method = RequestMethod.PUT)
    public ResponseEntity<Integer> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, @PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.changePassword(userId, changePasswordDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/edit-user-information", method = RequestMethod.PUT)
    public ResponseEntity<Integer> editUserInformation(@RequestBody EditUserInformationDTO editUserInformationDTO, @PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.editUserInformation(userId, editUserInformationDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/get-basic-information", method = RequestMethod.GET)
    public ResponseEntity<GetBasicUserInformationDTO> getBasicUserInformation(@PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.getBasicUserInformation(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/get-friends", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getFriendsByUser(@PathVariable(value = "id") long userId) {
        return new ResponseEntity<>(userService.getFriendsByUser(userId), HttpStatus.OK);
    }
}
