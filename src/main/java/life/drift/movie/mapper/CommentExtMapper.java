package life.drift.movie.mapper;

import life.drift.movie.model.Comment;

public interface CommentExtMapper {

    //插入评论
    Integer insert(Comment record);

    //评论数
    int incCommentCount(Comment record);
}