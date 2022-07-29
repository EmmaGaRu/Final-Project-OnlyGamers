package proxyvideogames.model;

import proxyvideogames.enums.Genre;

import javax.persistence.*;

@Entity
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@NotNull
    private String name;
   //@NotNull
    private String image;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String review;
    private int rate;

    public Videogame() {
    }

    public Videogame(String name, String image, Genre genre, String review, int rate) {
        this.name = name;
        this.image = image;
        this.genre = genre;
        this.review = review;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRate() {
        return rate;
    }
}
