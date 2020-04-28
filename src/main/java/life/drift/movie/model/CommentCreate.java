package life.drift.movie.model;

import lombok.Data;

@Data
public class CommentCreate {
    private Long parentId;
    private String content;
    private Integer type;
}
