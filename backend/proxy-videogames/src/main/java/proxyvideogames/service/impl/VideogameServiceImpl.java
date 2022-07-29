package proxyvideogames.service.impl;

import proxyvideogames.Repository.VideogameRepository;
import proxyvideogames.model.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import proxyvideogames.service.interfaces.VideogameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class VideogameServiceImpl implements VideogameService {
    @Autowired
    VideogameRepository videogameRepository;
    public Videogame postVideogame(Videogame videogame) {
    Optional<Videogame> games = videogameRepository.findByName(videogame.getName());
        if (games.isEmpty()) {
        Videogame createdGame = new Videogame(videogame.getName(), videogame.getImage(), videogame.getGenre(),
                videogame.getReview(), videogame.getRate() );
        videogameRepository.save(createdGame);
        return createdGame;
    }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The game " + videogame.getName() + " is already registered");
}
    @Override
    public List<Videogame> showAll() {
    List<Videogame> games = videogameRepository.findAll();
        if (games.isEmpty()) {
        return new ArrayList<>();
    }
        return videogameRepository.findAll();
}
    @Override
    public Videogame findGameByName(String name) {
        Optional<Videogame> game = videogameRepository.findByName(name);
        if (game.isPresent()) {
            return game.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Search not found");
    }

    @Override
    public void deleteGame(Long id) {
        Optional<Videogame> game = videogameRepository.findById(id);
        game.ifPresent(videogame -> videogameRepository.delete(videogame));
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Search not found");
    }
}
