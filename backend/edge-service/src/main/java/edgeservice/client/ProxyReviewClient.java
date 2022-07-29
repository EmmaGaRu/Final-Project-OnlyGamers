package edgeservice.client;

import edgeservice.model.UserReview;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@FeignClient("proxy-review")
public interface ProxyReviewClient {
    @GetMapping("/user/{id}")
    public Optional<UserReview> findById(@PathVariable Long id);

    @GetMapping("/findMeanUsersRate")
    public List<Object[]> findMeanRate();

    @PostMapping("/review")
    public UserReview postReview(@RequestBody UserReview userReview);
}
