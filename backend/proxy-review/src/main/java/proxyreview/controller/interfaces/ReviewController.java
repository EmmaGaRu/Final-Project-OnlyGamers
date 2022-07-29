package proxyreview.controller.interfaces;
import proxyreview.models.UserReview;

import java.util.List;
import java.util.Optional;

public interface ReviewController {
    public Optional<UserReview> findById(Long id);
    public List<Object[]> findMeanRate();

    UserReview postReview(UserReview userReview);
}
