package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.PostService;
import pe.edu.cibertec.domain.dto.PostDTO;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(postService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> list() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDTO> add(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.save(postDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PostDTO> edit(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.save(postDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        postService.delete(id);
    }

    @GetMapping(value = "/get-by-content/{pattern}")
    public ResponseEntity<List<PostDTO>> getPostsByContent(@PathVariable("pattern") String pattern) {
        return new ResponseEntity<>(postService.getPostsByContent(pattern), HttpStatus.OK);
    }
}
