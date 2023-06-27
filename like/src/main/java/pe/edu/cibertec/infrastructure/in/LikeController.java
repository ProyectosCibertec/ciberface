package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.LikeService;
import pe.edu.cibertec.domain.dto.LikeDTO;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<LikeDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(likeService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LikeDTO>> list() {
        return new ResponseEntity<>(likeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LikeDTO> add(@Valid @RequestBody LikeDTO likeDTO) {
        return new ResponseEntity<>(likeService.save(likeDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<LikeDTO> edit(@Valid @RequestBody LikeDTO likeDTO) {
        return new ResponseEntity<>(likeService.save(likeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        likeService.delete(id);
    }
}
