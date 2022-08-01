package proxyreview.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import proxyreview.models.UserReview;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<UserReview, Long> {
    //Optional<UserReview> findById(Long id);

    //Media de las valoraciones de los usuarios por juego
    @Query(value ="SELECT game_name, AVG(rate) FROM user_review GROUP BY game_name ORDER BY AVG(rate) DESC LIMIT 10",
            nativeQuery = true)
    public List<Object[]> findMeanRate();

    Optional<UserReview> findById(Long id);
}
