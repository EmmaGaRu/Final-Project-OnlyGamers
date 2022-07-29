package edgeservice.controller.impl;

import edgeservice.controller.interfaces.VideogameController;
import edgeservice.model.Videogame;
import edgeservice.service.interfaces.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")

public class VideogameControllerImpl implements VideogameController {
    @Autowired
    private VideogameService videogameService;

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Videogame postVideogame(@RequestBody Videogame videogame) {
        return videogameService.postVideogame(videogame);
    }

//    @GetMapping("/games")
//    @ResponseStatus(HttpStatus.OK)
//    public Object showAll(@RequestParam(required = false) Optional<String> genre, @RequestParam(required = false)
//    Optional<String> name) {
//        return videogameService.showAll();
//}
    @GetMapping("/games/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Videogame findGameByName(@PathVariable String name) {
        return videogameService.findGameByName(name);
    }

    @DeleteMapping("/games/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVideogame(@PathVariable(name = "id") Long id) {
        videogameService.deleteGame(id);
    }

}
