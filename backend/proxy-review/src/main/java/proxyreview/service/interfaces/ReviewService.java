package proxyreview.service.interfaces;

import org.springframework.data.jpa.repository.Query;
import proxyreview.models.UserReview;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public Optional<UserReview> findById(Long id);
    public List<Object[]> findMeanRate();

    UserReview postReview(UserReview userReview);
}
