package edgeservice.controller.interfaces;

import edgeservice.model.UserReview;
import java.util.List;
import java.util.Optional;

public interface ReviewController {
    public Optional<UserReview> findById(Long id);
    public List<Object[]> findMeanRate();
}
