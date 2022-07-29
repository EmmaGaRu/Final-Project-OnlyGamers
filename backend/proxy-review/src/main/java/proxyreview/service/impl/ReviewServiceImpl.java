package proxyreview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import proxyreview.models.UserReview;
import proxyreview.repository.ReviewRepository;
import proxyreview.service.interfaces.ReviewService;

import java.util.List;
import java.util.Optional;
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public Optional<UserReview> findById(Long id) {
        Optional<UserReview> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            return Optional.of(review.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Search not found");
    }

    @Override
    public List<Object[]> findMeanRate() {
        return reviewRepository.findMeanRate();
    }

    @Override
    public UserReview postReview(UserReview userReview) {
        Optional<UserReview> review = reviewRepository.findById(userReview.getId());
        if (review.isEmpty()) {
            UserReview createdReview = new UserReview(userReview.getUserName(), userReview.getComment(),
                    userReview.getRate(), userReview.getGameName());
            reviewRepository.save(createdReview);
            return createdReview;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The review already existed");
    }
}

