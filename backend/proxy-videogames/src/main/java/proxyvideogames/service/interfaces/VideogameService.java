package proxyvideogames.service.interfaces;

import proxyvideogames.model.Videogame;

import java.util.List;
public interface VideogameService {
    Videogame postVideogame(Videogame videogame);
    List<Videogame> showAll();
    Videogame findGameByName(String name);
    void deleteGame(Long id);
}
