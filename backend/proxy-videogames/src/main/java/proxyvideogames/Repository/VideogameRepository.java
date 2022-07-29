package proxyvideogames.Repository;

import proxyvideogames.enums.Genre;
import proxyvideogames.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface VideogameRepository extends JpaRepository<Videogame, Long> {
   Optional<Videogame> findByName(String name);
    List<Videogame> findByGenre(Genre genre);
}
