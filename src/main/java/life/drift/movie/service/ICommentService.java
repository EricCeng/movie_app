package life.drift.movie.service;

import life.drift.movie.common.CommentTypeEnum;
import life.drift.movie.model.Comment;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.UserVO;

public interface ICommentService {
    ServerResponse insertComment(Comment comment, UserVO commentator);
    ServerResponse selectComment(Long id, CommentTypeEnum type);
}
