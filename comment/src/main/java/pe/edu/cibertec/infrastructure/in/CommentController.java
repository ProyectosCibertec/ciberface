package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.CommentService;
import pe.edu.cibertec.domain.dto.CommentDTO;
import pe.edu.cibertec.domain.dto.PostDTO;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(commentService.find(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CommentDTO>> list() {
        List<CommentDTO> dtos = commentService.findAll();
        Collections.reverse(dtos);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> add(@Valid @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.save(commentDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CommentDTO> edit(@Valid @RequestBody CommentDTO commentDTO) {
        return new ResponseEntity<>(commentService.save(commentDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        commentService.delete(id);
    }

    @GetMapping(value = "/list-by-post")
    public ResponseEntity<List<CommentDTO>> listByPost(@RequestParam("postId") long postId) {
        return new ResponseEntity<>(commentService.findByPostId(postId), HttpStatus.OK);
    }
}
