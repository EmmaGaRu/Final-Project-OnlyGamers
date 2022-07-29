package proxyreview.controller.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import proxyreview.controller.interfaces.ReviewController;
import proxyreview.models.UserReview;
import proxyreview.service.interfaces.ReviewService;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class ReviewControllerImpl implements ReviewController {
    @Autowired
    ReviewService reviewService;

    @GetMapping("/user/{id}")
    @ResponseStatus (HttpStatus.OK)
    public Optional<UserReview> findById(@PathVariable Long id) {
        return reviewService.findById(id);
    }

    @GetMapping("/findMeanUsersRate")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> findMeanRate() {
        return reviewService.findMeanRate();
    }

    @PostMapping("/review")
    @ResponseStatus(HttpStatus.CREATED)
    public UserReview postReview(@RequestBody UserReview userReview) {
        return reviewService.postReview(userReview);
    }
}
