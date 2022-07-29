package proxyvideogames.controller.impl;

import proxyvideogames.Repository.VideogameRepository;
import proxyvideogames.controller.interfaces.VideogameController;
import proxyvideogames.enums.Genre;
import proxyvideogames.model.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proxyvideogames.service.interfaces.VideogameService;

import java.util.Optional;

@RestController
@CrossOrigin("*")

public class VideogameControllerImpl implements VideogameController {
    @Autowired
    private VideogameService videogameService;

    @Autowired
    private VideogameRepository videogameRepository;

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Videogame postVideogame(@RequestBody Videogame videogame) {
        return videogameService.postVideogame(videogame);
    }

//    @GetMapping("/games")
//    @ResponseStatus(HttpStatus.OK)
//    public Object showAll(@RequestParam(required = false) Optional<String> genre, @RequestParam(required = false)
//    Optional<String> name) {
//        if (genre.isPresent()) {
//            return videogameRepository.findByGenre(Genre.valueOf(genre.get().toUpperCase()));
//        } else if (name.isPresent()) {
//            return videogameRepository.findByName(name.get());
//        }
//        return videogameService.showAll();
//
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
