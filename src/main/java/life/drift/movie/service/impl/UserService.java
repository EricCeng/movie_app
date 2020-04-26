package life.drift.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.*;
import life.drift.movie.model.*;
import life.drift.movie.service.IMovieService;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.MD5Util;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private WishMovieExtMapper wishMovieExtMapper;

    @Autowired
    private PostExtMapper postExtMapper;

    @Autowired
    private ReviewExtMapper reviewExtMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    //登录接口实现
    @Override
    public ServerResponse loginLogic(String username, String password) {
        //非空判断
        if (StringUtils.isBlank(username)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_EMPTY.getCode(), ResponseErrorCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(password)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PASSWORD_NOT_EMPTY.getCode(), ResponseErrorCode.PASSWORD_NOT_EMPTY.getMsg());
        }

        //查看用户名是否存在
        Integer count = userExtMapper.findByUsername(username);
        if (count == 0) {
            //用户名不存在
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_EXIST.getCode(), ResponseErrorCode.USERNAME_NOT_EXIST.getMsg());
        }

        //根据用户名和密码进行查询
        User user = userExtMapper.selectByUsernameAndPwd(username, MD5Util.getMD5Code(password));

        if (user == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PWD_ERROR.getCode(), ResponseErrorCode.PWD_ERROR.getMsg());
        }

        //返回结果

        return ServerResponse.createServerResponseBySuccess(convert(user));
    }

    private UserVO convert(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUsername(user.getUsername());
        userVO.setEmail(user.getEmail());
        userVO.setPhone(user.getPhone());
        userVO.setGmtCreate(DateUtil.date2String(user.getGmtCreate()));
        userVO.setGmtModified(DateUtil.date2String(user.getGmtModified()));
        userVO.setGender(user.getGender());
        userVO.setAvatarUrl(user.getAvatarUrl());

        return userVO;
    }

    //注册接口实现

    @Override
    public ServerResponse registerLogic(User user) {
        if (user == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PARAMETER_NOT_EMPTY.getCode(), ResponseErrorCode.PARAMETER_NOT_EMPTY.getMsg());
        }

        String username = user.getUsername();
        String password = user.getPassword();
        String gender = user.getGender();
        String phone = user.getPhone();
        String email = user.getEmail();

        //判断非空
        if (StringUtils.isBlank(username)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_EMPTY.getCode(), ResponseErrorCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(password)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PASSWORD_NOT_EMPTY.getCode(), ResponseErrorCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(gender)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.GENDER_NOT_EMPTY.getCode(), ResponseErrorCode.GENDER_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(phone)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PHONE_NOT_EMPTY.getCode(), ResponseErrorCode.PHONE_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(email)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.EMAIL_NOT_EMPTY.getCode(), ResponseErrorCode.EMAIL_NOT_EMPTY.getMsg());
        }

        //判断存在
        Integer count = userExtMapper.findByUsername(username);
        if (count > 0) {
            //用户名已存在
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_EXIST.getCode(), ResponseErrorCode.USERNAME_EXIST.getMsg());
        }

        Integer phone_count = userExtMapper.findByPhone(phone);
        if (phone_count > 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PHONE_EXIST.getCode(), ResponseErrorCode.PHONE_EXIST.getMsg());
        }

        Integer email_count = userExtMapper.findByEmail(email);
        if (email_count > 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.EMAIL_EXIST.getCode(), ResponseErrorCode.EMAIL_EXIST.getMsg());
        }

        //进行注册

        //密码加密
        user.setPassword(MD5Util.getMD5Code(user.getPassword()));

        Integer result = userExtMapper.insert(user);
        if (result == 0) {
            //注册失败
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.REGISTER_FAIL.getCode(), ResponseErrorCode.REGISTER_FAIL.getMsg());
        }

        return ServerResponse.createServerResponseBySuccess();

    }

    //更新用户信息
    @Override
    public ServerResponse updateInfoLogic(User user) {

        int count = userExtMapper.updateByPrimaryKey(user);
        if (count == 0) {
            //修改失败
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.UPDATE_FAIL.getCode(), ResponseErrorCode.UPDATE_FAIL.getMsg());
        }
        //修改成功后，将数据返回
        User updateUser = userMapper.selectByPrimaryKey(user.getId());
        UserVO userVO = convert(updateUser);

        return ServerResponse.createServerResponseBySuccess(userVO);
    }

    //查询用户信息
    @Override
    public ServerResponse selectByUserId(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return ServerResponse.createServerResponseBySuccess(convert(user));
    }

    //查看 想看的电影 列表
    @Override
    public ServerResponse findWishMovie(Long userId) {

        WishMovieListVO wishMovieVO = getWishMovieVO(userId);

        return ServerResponse.createServerResponseBySuccess(wishMovieVO);
    }

    //查看 我的动态
    @Override
    public ServerResponse findMyPost(Long userId) {
        PostListVO myPost = getMyPost(userId);
        return ServerResponse.createServerResponseBySuccess(myPost);
    }

    //删除 我的动态
    @Override
    public ServerResponse deletePostById(Long postId, Long userId) {
        int i = postExtMapper.deleteMyPost(postId, userId);
        if (i <= 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.DELETE_FAIL.getCode(), ResponseErrorCode.DELETE_FAIL.getMsg());
        }
        return ServerResponse.createServerResponseBySuccess();
    }

    //查看 我的影评
    @Override
    public ServerResponse selectReviewByUserId(Long userId) {
        ReviewListVO myReview = getMyReview(userId);
        return ServerResponse.createServerResponseBySuccess(myReview);
    }

    //删除我的影评
    @Override
    public ServerResponse deleteReviewById(Long reviewId, Long userId) {
        int i = reviewExtMapper.deleteMyReview(reviewId, userId);
        if (i <= 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.DELETE_FAIL.getCode(), ResponseErrorCode.DELETE_FAIL.getMsg());
        }
        return ServerResponse.createServerResponseBySuccess();
    }

    public ReviewListVO getMyReview(Long userId) {
        ReviewListVO reviewListVO = new ReviewListVO();
        List<Review> reviewList = reviewExtMapper.selectReviewByUserId(userId);

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

            reviewVOList.add(reviewVO);
        }

        reviewListVO.setReviewVOList(reviewVOList);

        return reviewListVO;
    }

    public WishMovieListVO getWishMovieVO(Long userId) {
        WishMovieListVO wishMovieListVO = new WishMovieListVO();
        List<WishMovie> wishMovieList = wishMovieExtMapper.selectAll(userId);

        List<WishMovieVO> wishMovieVOList = new ArrayList();

        for (WishMovie wishMovie : wishMovieList) {

            WishMovieVO wishMovieVO = new WishMovieVO();

            wishMovieVO.setId(wishMovie.getId());
            wishMovieVO.setUserId(wishMovie.getUserId());
            wishMovieVO.setAddTime(DateUtil.date2String(wishMovie.getAddTime()));
            wishMovieVO.setUpdateTime(DateUtil.date2String(wishMovie.getUpdateTime()));
            wishMovieVO.setIsWanted(wishMovie.getIsWanted());

            //查询电影其他信息
            ServerResponse serverResponse = movieService.selectMovieById(wishMovie.getMovieId());
            MovieVO movieVO = (MovieVO) serverResponse.getData();

            wishMovieVO.setMovieId(wishMovie.getMovieId());
            wishMovieVO.setMovieName(movieVO.getMovieName());
            wishMovieVO.setMovieAvatar(movieVO.getMovieAvatar());
            wishMovieVO.setDirector(movieVO.getDirector());
            wishMovieVO.setActor(movieVO.getActor());
            wishMovieVO.setCountry(movieVO.getCountry());
            wishMovieVO.setScore(movieVO.getScore());
            wishMovieVO.setCategory(movieVO.getCategory());
            wishMovieVO.setShowTime(movieVO.getShowTime());

            wishMovieVOList.add(wishMovieVO);

        }

        wishMovieListVO.setWishMovieVOList(wishMovieVOList);
        return wishMovieListVO;
    }

    public PostListVO getMyPost(Long userId) {
        PostListVO postListVO = new PostListVO();
        List<Post> postList = postExtMapper.selectMyPost(userId);

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

            ServerResponse serverResponse = selectByUserId(post.getUserId());
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
