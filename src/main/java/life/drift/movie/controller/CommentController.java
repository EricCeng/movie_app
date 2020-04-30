package life.drift.movie.controller;

import life.drift.movie.common.CommentTypeEnum;
import life.drift.movie.common.Const;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.model.Comment;
import life.drift.movie.model.CommentCreate;
import life.drift.movie.model.User;
import life.drift.movie.service.ICommentService;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class CommentController {
    @Autowired
    private ICommentService commentService;

    //写评论
    @RequestMapping(value = "/comment/insert")
    public ServerResponse insertComment(CommentCreate commentCreate,
                                       HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);

        if (StringUtils.isBlank(commentCreate.getContent())) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.CONTENT_IS_EMPTY.getCode(), ResponseErrorCode.CONTENT_IS_EMPTY.getMsg());
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreate.getParentId());
        comment.setContent(commentCreate.getContent());
        comment.setType(commentCreate.getType());
        comment.setCommentator(userInfo.getId());
        comment.setLikeCount(0L);
        comment.setCommentCount(0L);

        ServerResponse serverResponse = commentService.insertComment(comment, userInfo);
        return serverResponse;
    }

    //查看 动态 二级评论
    @RequestMapping(value = "/comment/postComment/{id}")
    public ServerResponse selectPostSecComment(@PathVariable("id") Long id){
        ServerResponse serverResponse = commentService.selectComment(id, CommentTypeEnum.POST_COMMENT);
        return serverResponse;
    }

    //查看 电影 二级评论
    @RequestMapping(value = "/comment/reviewComment/{id}")
    public ServerResponse selectReviewSecComment(@PathVariable("id") Long id){
        ServerResponse serverResponse = commentService.selectComment(id, CommentTypeEnum.REVIEW_COMMENT);
        return serverResponse;
    }
}
