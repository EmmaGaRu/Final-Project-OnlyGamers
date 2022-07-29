package edgeservice.service.impl;

import edgeservice.client.ProxyReviewClient;
import edgeservice.client.ProxyVideogamesClient;
import edgeservice.model.Videogame;
import edgeservice.service.interfaces.VideogameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
//import proxyvideogames.Repository.VideogameRepository;
//import proxyvideogames.model.Videogame;
//import proxyvideogames.service.interfaces.VideogameService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideogameServiceImpl implements VideogameService {
    private final Logger logger = LoggerFactory.getLogger(VideogameServiceImpl.class);
    @Autowired
    private ProxyVideogamesClient proxyVideogamesClient;

    public Videogame postVideogame(Videogame videogame) {
        return proxyVideogamesClient.postVideogame(videogame);
    }

//    public List<Videogame> showAll() {
//        return proxyVideogamesClient.showAll();
//}

    public Videogame findGameByName(String name) {
            return proxyVideogamesClient.findGameByName(name);
    }

    public void deleteGame(Long id){}
}
