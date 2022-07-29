package edgeservice.controller.impl;
import edgeservice.controller.interfaces.ReviewController;
import edgeservice.model.UserReview;
import edgeservice.service.interfaces.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
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
