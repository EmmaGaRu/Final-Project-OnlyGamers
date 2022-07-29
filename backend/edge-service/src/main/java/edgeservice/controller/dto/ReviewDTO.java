package edgeservice.controller.dto;

import edgeservice.model.UserReview;
import edgeservice.model.Videogame;

public class ReviewDTO {
    private UserReview userReview;
    private Videogame videogame;

    public UserReview getUserReview() {
        return userReview;
    }

    public void setUserReview(UserReview userReview) {
        this.userReview = userReview;
    }

    public Videogame getVideogame() {
        return videogame;
    }

    public void setVideogame(Videogame videogame) {
        this.videogame = videogame;
    }
}
