package pe.edu.cibertec.infrastructure.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.application.LikeService;
import pe.edu.cibertec.domain.dto.LikeDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<LikeDTO> get(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(likeService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<LikeDTO>> list() {
        return new ResponseEntity<>(likeService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<LikeDTO> add(@RequestBody LikeDTO likeDTO) {
        return new ResponseEntity<>(likeService.save(likeDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<LikeDTO> edit(@RequestBody LikeDTO likeDTO) {
        return new ResponseEntity<>(likeService.save(likeDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "id") long id) {
        likeService.delete(id);
    }
}
