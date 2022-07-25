package uz.pdp.cinemaapplication.payload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.cinemaapplication.entity.Actor;
import uz.pdp.cinemaapplication.service.ActorService;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping()
    public ResponseEntity getAllActors() {
        List<Actor> allActors = actorService.getAllActors();
        return ResponseEntity.ok(allActors);
    }


    @GetMapping("/{id}")
    public ResponseEntity getActorById(@PathVariable Integer id) {
        Actor actor = actorService.getActorById(id);
        return ResponseEntity.ok(actor);
    }

    @PostMapping()
    public ResponseEntity saveActor(
            @RequestPart("file") MultipartFile file,
            @RequestPart("json") Actor actor) {
        boolean saveActor = actorService.saveActor(file, actor);
        return saveActor ?
                new ResponseEntity("Successfully saved!!!", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not save!!!", HttpStatus.CONFLICT);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteActor(@PathVariable Integer id){
        boolean deleteActor = actorService.deleteActor(id);
        return deleteActor?
                new ResponseEntity("Successfully deleted!!!", HttpStatus.CREATED)
                :
                new ResponseEntity("Could not delete!!!", HttpStatus.CONFLICT);
    }


    @PutMapping("/{id}")
    public ResponseEntity editActor(@PathVariable Integer id,
                                    @RequestPart("file") MultipartFile file,
                                    @RequestPart("json") Actor actor){
        return editActor(id, file, actor);
    }


}




