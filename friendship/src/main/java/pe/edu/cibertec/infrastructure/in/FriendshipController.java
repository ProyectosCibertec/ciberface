package pe.edu.cibertec.infrastructure.in;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.FriendshipService;
import pe.edu.cibertec.domain.dto.FriendshipDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/friendship")
public class FriendshipController {
    private final FriendshipService friendshipService;

    public FriendshipController(FriendshipService friendshipService){
        this.friendshipService = friendshipService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FriendshipDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(friendshipService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FriendshipDTO>> list() {
        return new ResponseEntity<>(friendshipService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> add(@Valid @RequestBody FriendshipDTO friendshipDTO) {
        return new ResponseEntity<>(friendshipService.save(friendshipDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Integer> edit(@Valid @RequestBody FriendshipDTO friendshipDTO) {
        return new ResponseEntity<>(friendshipService.save(friendshipDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        friendshipService.delete(id);
    }

    @GetMapping(value = "/{userId}/friends/amount")
    public ResponseEntity<Integer> countFriendsByUserId(@PathVariable long userId) {
        int amount = friendshipService.getFriendsAmountByUser(userId);
        return ResponseEntity.ok(amount);
    }

    @GetMapping(value = "/get-by-user-friend-id")
    public ResponseEntity<FriendshipDTO> getByFriendAndUserIds(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "friendId") Long friendId
    ) {
        FriendshipDTO friendshipDTO = friendshipService.getByFriendAndUserIds(userId, friendId);
        return ResponseEntity.ok(friendshipDTO);
    }
}
