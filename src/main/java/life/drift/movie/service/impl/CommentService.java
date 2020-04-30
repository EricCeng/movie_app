package life.drift.movie.service.impl;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import life.drift.movie.common.CommentTypeEnum;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.*;
import life.drift.movie.model.*;
import life.drift.movie.service.ICommentService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.CommentVO;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostExtMapper postExtMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private ReviewExtMapper reviewExtMapper;

    @Autowired
    private CommentExtMapper commentExtMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    //插入评论
    @Transactional
    @Override
    public ServerResponse insertComment(Comment comment, UserVO commentator) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_NOT_FOUND.getCode(), ResponseErrorCode.COMMENT_NOT_FOUND.getMsg());
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_PARAM_WRONG.getCode(), ResponseErrorCode.COMMENT_PARAM_WRONG.getMsg());
        }

        if (comment.getType().equals(CommentTypeEnum.POST.getType())) {
            //回复 动态
            Post post = postMapper.selectByPrimaryKey(comment.getParentId());
            if (post == null) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.POST_NOT_FOUND.getCode(), ResponseErrorCode.POST_NOT_FOUND.getMsg());
            }

            comment.setCommentCount(0L);
            comment.setLikeCount(0L);
            Integer insert = commentExtMapper.insert(comment);
            if (insert == 0) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_FAIL.getCode(), ResponseErrorCode.COMMENT_FAIL.getMsg());
            }

            //评论数
            post.setCommentCount(1L);
            postExtMapper.incCommentCount(post);

        } else if (comment.getType().equals(CommentTypeEnum.REVIEW.getType())) {
            //回复 影评
            Review review = reviewMapper.selectByPrimaryKey(comment.getParentId());
            if (review == null) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.REVIEW_NOT_FOUND.getCode(), ResponseErrorCode.REVIEW_NOT_FOUND.getMsg());
            }

            comment.setCommentCount(0L);
            comment.setLikeCount(0L);
            Integer insert = commentExtMapper.insert(comment);
            if (insert == 0) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_FAIL.getCode(), ResponseErrorCode.COMMENT_FAIL.getMsg());
            }

            //评论数
            review.setCommentCount(1L);
            reviewExtMapper.incCommentCount(review);

        } else if (comment.getType().equals(CommentTypeEnum.POST_COMMENT.getType())) {
            //回复 动态评论
            Comment postCommentCreator = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (postCommentCreator == null) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_NOT_FOUND.getCode(), ResponseErrorCode.COMMENT_NOT_FOUND.getMsg());
            }

            Post post = postMapper.selectByPrimaryKey(postCommentCreator.getParentId());
            if (post == null) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.POST_NOT_FOUND.getCode(), ResponseErrorCode.POST_NOT_FOUND.getMsg());
            }
            Integer insert = commentExtMapper.insert(comment);
            if (insert == 0) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_FAIL.getCode(), ResponseErrorCode.COMMENT_FAIL.getMsg());
            }

            //二级评论数
            Comment postComment = new Comment();
            postComment.setId(comment.getParentId());
            postComment.setCommentCount(1L);
            commentExtMapper.incCommentCount(postComment);

        } else if (comment.getType().equals(CommentTypeEnum.REVIEW_COMMENT.getType())) {
            //回复 影评评论
            Comment reviewCommentCreator = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (reviewCommentCreator == null) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_NOT_FOUND.getCode(), ResponseErrorCode.COMMENT_NOT_FOUND.getMsg());
            }

            Review review = reviewMapper.selectByPrimaryKey(reviewCommentCreator.getParentId());
            if (review == null) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.REVIEW_NOT_FOUND.getCode(), ResponseErrorCode.REVIEW_NOT_FOUND.getMsg());
            }

            Integer insert = commentExtMapper.insert(comment);
            if (insert == 0) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.COMMENT_FAIL.getCode(), ResponseErrorCode.COMMENT_FAIL.getMsg());
            }

            //二级评论数
            Comment reviewComment = new Comment();
            reviewComment.setId(comment.getParentId());
            reviewComment.setCommentCount(1L);
            commentExtMapper.incCommentCount(reviewComment);
        }


        return ServerResponse.createServerResponseBySuccess();
    }

    //查看评论
    @Override
    public ServerResponse selectComment(Long id, CommentTypeEnum type) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria()
                .andParentIdEqualTo(id)
                .andTypeEqualTo(type.getType());
        commentExample.setOrderByClause("gmt_create desc");

        List<Comment> commentList = commentMapper.selectByExample(commentExample);

        if (commentList.size() == 0) {
            return null;
        }

        Set<Long> commentators = commentList.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>();
        userIds.addAll(commentators);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));

        //转化成 CommentVO
        List<CommentVO> commentVOList = commentList.stream().map(comment -> {
                    CommentVO commentVO = new CommentVO();
                    BeanUtils.copyProperties(comment, commentVO);
                    commentVO.setGmtCreate(DateUtil.date2String(comment.getGmtCreate()));
                    commentVO.setGmtModified(DateUtil.date2String(comment.getGmtModified()));
                    commentVO.setUserName(userMap.get(comment.getCommentator()).getUsername());
                    commentVO.setUserAvatar(userMap.get(comment.getCommentator()).getAvatarUrl());
                    return commentVO;
                }
        ).collect(Collectors.toList());

        return ServerResponse.createServerResponseBySuccess(commentVOList);

    }
}
