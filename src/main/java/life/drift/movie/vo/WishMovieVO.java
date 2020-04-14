package life.drift.movie.vo;

import lombok.Data;

@Data
public class WishMovieVO {
    private Long id;
    private Long userId;
    private Long movieId;
    private String movieName;
    private String movieAvatar;
    private String director;
    private String actor;
    private String country;
    private String score;
    private String category;
    private String showTime;
    private String addTime;
    private String updateTime;
    private Integer isWanted;
}
