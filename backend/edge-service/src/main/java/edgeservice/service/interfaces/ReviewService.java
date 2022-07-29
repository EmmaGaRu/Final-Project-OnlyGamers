package edgeservice.service.interfaces;

import edgeservice.model.UserReview;
import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public Optional<UserReview> findById(Long id);
    public List<Object[]> findMeanRate();
    public UserReview postReview(UserReview userReview);
}
