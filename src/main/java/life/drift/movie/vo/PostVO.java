package life.drift.movie.vo;

import lombok.Data;

@Data
public class PostVO {
    private Long id;
    private Long userId;
    private String postContent;
    private Long commentCount;
    private Long likeCount;
    private String createTime;
    private String updateTime;
    private Integer isSelected;
    private Long creator;

    private String userName;
    private String userAvatar;
}
