package proxyreview.models;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String comment;
    private int rate;
    private String gameName;

//    @ManyToOne
//    @JoinColumn(name = "name")
   // private Videogame videogame;

    public UserReview() {
    }

    public UserReview(String userName, String comment, int rate, String gameName) {
        this.userName = userName;
        this.comment = comment;
        this.rate = rate;
        this.gameName = gameName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public String toString() {
        return "UserReview{" +
                //"id=" + id +
                ", userName='" + userName + '\'' +
                ", comment='" + comment + '\'' +
                ", rate=" + rate +
                ", gameName='" + gameName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserReview that = (UserReview) o;
        return rate == that.rate && Objects.equals(id, that.id) && Objects.equals(userName, that.userName) && Objects.equals(comment, that.comment) && Objects.equals(gameName, that.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, comment, rate, gameName);
    }
}


