package proxyvideogames.controller.interfaces;

import proxyvideogames.model.Videogame;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface VideogameController {
    Videogame postVideogame(Videogame videogame);
   // Object showAll(@RequestParam(required = false) Optional<String> type, @RequestParam(required = false)
   // Optional<String> name);
    Videogame findGameByName(String name);
    void deleteVideogame(@PathVariable(name = "id")Long id);
}
