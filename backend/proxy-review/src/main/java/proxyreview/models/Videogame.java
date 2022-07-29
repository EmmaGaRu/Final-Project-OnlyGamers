package proxyreview.models;
import proxyreview.enums.Genre;
import javax.persistence.*;
import java.util.List;

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

    //@OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private List<UserReview> userReview;

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
