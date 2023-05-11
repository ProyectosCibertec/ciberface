package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.FriendshipService;
import pe.edu.cibertec.domain.dto.FriendshipDTO;
import pe.edu.cibertec.domain.mapper.FriendshipMapper;
import pe.edu.cibertec.domain.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/friendship")
public class FriendshipController {
    @Autowired
    private FriendshipService friendshipService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FriendshipDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(friendshipService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<FriendshipDTO>> list() {
        return new ResponseEntity<>(friendshipService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<FriendshipDTO> add(@RequestBody FriendshipDTO friendshipDTO) {
        return new ResponseEntity<>(friendshipService.save(friendshipDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<FriendshipDTO> edit(@RequestBody FriendshipDTO friendshipDTO) {
        return new ResponseEntity<>(friendshipService.save(friendshipDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        friendshipService.delete(id);
    }

     @GetMapping("/{userId}/friends/amount")
    public ResponseEntity<Integer> countFriendsByUserId(@PathVariable long userId) {
        int amount = friendshipService.getFriendsAmountByUser(userId);
        return ResponseEntity.ok(amount);/**/
    }


    @RequestMapping(value = "/{id}/create-friendship/{friendId}", method = RequestMethod.POST)
    public void createFriendship(@PathVariable(value = "id") long userId, @PathVariable(value = "friendId") long friendId) {
        friendshipService.createFriendship(userId, friendId);
    }
}
