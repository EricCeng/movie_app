package life.drift.movie.mapper;

import life.drift.movie.model.Comment;

import java.util.List;

public interface CommentExtMapper {

    //插入评论
    Integer insert(Comment record);

    //评论数
    int incCommentCount(Comment record);

    //查看评论
//    List<Comment> selectComment(Comment record);
}