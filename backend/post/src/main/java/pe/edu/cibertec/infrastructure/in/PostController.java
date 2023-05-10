package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.PostService;
import pe.edu.cibertec.domain.dto.PostDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PostDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(postService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> list() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<PostDTO> add(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.save(postDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<PostDTO> edit(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.save(postDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        postService.delete(id);
    }
}
