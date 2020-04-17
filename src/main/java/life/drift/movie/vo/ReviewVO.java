package life.drift.movie.vo;

import lombok.Data;

@Data
public class ReviewVO {
    private Long id;
    private Long userId;
    private Long movieId;
    private Integer isSelected;
    private String reviewContent;
    private String createTime;
    private String updateTime;
    private Long commentCount;
    private Long likeCount;
    private Double reviewScore;

    private String userName;
    private String userAvatar;

    private String movieName;
    private String movieAvatar;
    private String director;
    private String actor;
    private String country;
    private Double score;
    private String category;
    private String showTime;
}
