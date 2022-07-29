package edgeservice.service.impl;

import edgeservice.client.ProxyReviewClient;
import edgeservice.model.UserReview;
import edgeservice.service.interfaces.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);
    @Autowired
    private ProxyReviewClient proxyReviewClient;

    public Optional<UserReview> findById(Long id) {
            return proxyReviewClient.findById(id);
    }

    public List<Object[]> findMeanRate() {
        return proxyReviewClient.findMeanRate();
    }
    public UserReview postReview(UserReview userReview) {
        return proxyReviewClient.postReview(userReview);
    }
}
