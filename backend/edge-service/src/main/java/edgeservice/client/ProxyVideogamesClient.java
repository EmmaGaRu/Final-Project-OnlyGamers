package edgeservice.client;

import edgeservice.model.Videogame;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("proxy-videogames")
public interface ProxyVideogamesClient {
    @PostMapping("/games")
    public Videogame postVideogame(@RequestBody Videogame videogame);

//    @GetMapping("/games")
//    public Object showAll(@RequestParam(required = false) Optional<String> genre, @RequestParam(required = false));

    @GetMapping("/games/{name}")
    public Videogame findGameByName(@PathVariable(name = "name") String name);

    @DeleteMapping("/games/{id}")
    public void deleteVideogame(@PathVariable(name = "id") Long id);
}