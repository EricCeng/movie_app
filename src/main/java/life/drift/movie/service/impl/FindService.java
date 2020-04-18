package life.drift.movie.service.impl;

import life.drift.movie.mapper.PostExtMapper;
import life.drift.movie.mapper.ReviewExtMapper;
import life.drift.movie.model.Post;
import life.drift.movie.model.Review;
import life.drift.movie.service.IFindService;
import life.drift.movie.service.IMovieService;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindService implements IFindService {

    @Autowired
    private ReviewExtMapper reviewExtMapper;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IUserService userService;

    @Autowired
    private PostExtMapper postExtMapper;

    //查看 精选影评
    @Override
    public ServerResponse findSelectedReview() {
        ReviewListVO selectedReview = getSelectedReview();
        return ServerResponse.createServerResponseBySuccess(selectedReview);
    }

    //查看 精选动态
    @Override
    public ServerResponse findSelectedPost() {
        PostListVO selectedPost = getSelectedPost();
        return ServerResponse.createServerResponseBySuccess(selectedPost);
    }


    public ReviewListVO getSelectedReview() {
        ReviewListVO reviewListVO = new ReviewListVO();
        List<Review> reviewList = reviewExtMapper.findSelectedReview();

        List<ReviewVO> reviewVOList = new ArrayList();

        for (Review review : reviewList) {

            ReviewVO reviewVO = new ReviewVO();

            reviewVO.setId(review.getId());
            reviewVO.setUserId(review.getUserId());
            reviewVO.setIsSelected(review.getIsSelected());
            reviewVO.setReviewContent(review.getReviewContent());
            reviewVO.setReviewScore(review.getReviewScore());
            reviewVO.setCreateTime(DateUtil.date2String(review.getCreateTime()));
            reviewVO.setUpdateTime(DateUtil.date2String(review.getUpdateTime()));
            reviewVO.setCommentCount(review.getCommentCount());
            reviewVO.setLikeCount(review.getLikeCount());

            ServerResponse serverResponse = movieService.selectMovieById(review.getMovieId());
            MovieVO movieVO = (MovieVO) serverResponse.getData();

            reviewVO.setMovieId(review.getMovieId());
            reviewVO.setMovieName(movieVO.getMovieName());
            reviewVO.setMovieAvatar(movieVO.getMovieAvatar());
            reviewVO.setDirector(movieVO.getDirector());
            reviewVO.setActor(movieVO.getActor());
            reviewVO.setCountry(movieVO.getCountry());
            reviewVO.setScore(movieVO.getScore());
            reviewVO.setCategory(movieVO.getCategory());
            reviewVO.setShowTime(movieVO.getShowTime());

            ServerResponse serverResponse1 = userService.selectByUserId(review.getUserId());
            UserVO userVO = (UserVO) serverResponse1.getData();

            reviewVO.setUserId(review.getUserId());
            reviewVO.setUserName(userVO.getUsername());
            reviewVO.setUserAvatar(userVO.getAvatarUrl());

            reviewVOList.add(reviewVO);
        }

        reviewListVO.setReviewVOList(reviewVOList);

        return reviewListVO;
    }

    public PostListVO getSelectedPost() {
        PostListVO postListVO = new PostListVO();
        List<Post> postList = postExtMapper.findSelectedPost();

        List<PostVO> postVOList = new ArrayList();

        for (Post post : postList) {
            PostVO postVO = new PostVO();
            postVO.setId(post.getId());
            postVO.setPostContent(post.getPostContent());
            postVO.setCommentCount(post.getCommentCount());
            postVO.setLikeCount(post.getLikeCount());
            postVO.setCreateTime(DateUtil.date2String(post.getCreateTime()));
            postVO.setUpdateTime(DateUtil.date2String(post.getUpdateTime()));
            postVO.setIsSelected(post.getIsSelected());

            ServerResponse serverResponse = userService.selectByUserId(post.getUserId());
            UserVO userVO = (UserVO) serverResponse.getData();

            postVO.setUserId(post.getUserId());
            postVO.setUserName(userVO.getUsername());
            postVO.setUserAvatar(userVO.getAvatarUrl());

            postVOList.add(postVO);

        }

        postListVO.setPostVOList(postVOList);

        return postListVO;
    }


}
