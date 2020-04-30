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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


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

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private WishMovieMapper wishMovieMapper;

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
        BeanUtils.copyProperties(user, userVO);
        userVO.setGmtCreate(DateUtil.date2String(user.getGmtCreate()));
        userVO.setGmtModified(DateUtil.date2String(user.getGmtModified()));
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

        WishMovieExample wishMovieExample = new WishMovieExample();
        wishMovieExample.createCriteria()
                .andUserIdEqualTo(userId);
        wishMovieExample.setOrderByClause("add_time desc");

        List<WishMovie> wishMovieList = wishMovieMapper.selectByExample(wishMovieExample);

        Set<Long> targetMovie = wishMovieList.stream().map(wishMovie -> wishMovie.getMovieId()).collect(Collectors.toSet());
        List<Long> movieIds = new ArrayList<>();
        movieIds.addAll(targetMovie);

        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria()
                .andIdIn(movieIds);
        List<Movie> movies = movieMapper.selectByExample(movieExample);
        Map<Long, Movie> movieMap = movies.stream().collect(Collectors.toMap(movie -> movie.getId(), movie -> movie));

        List<WishMovieVO> wishMovieVOList = wishMovieList.stream().map(wishMovie -> {
            WishMovieVO wishMovieVO = new WishMovieVO();
            BeanUtils.copyProperties(wishMovie, wishMovieVO);

            wishMovieVO.setAddTime(DateUtil.date2String(wishMovie.getAddTime()));
            wishMovieVO.setUpdateTime(DateUtil.date2String(wishMovie.getUpdateTime()));

            wishMovieVO.setMovieName(movieMap.get(wishMovie.getMovieId()).getMovieName());
            wishMovieVO.setMovieAvatar(movieMap.get(wishMovie.getMovieId()).getMovieAvatar());
            wishMovieVO.setDirector(movieMap.get(wishMovie.getMovieId()).getDirector());
            wishMovieVO.setActor(movieMap.get(wishMovie.getMovieId()).getActor());
            wishMovieVO.setCountry(movieMap.get(wishMovie.getMovieId()).getCountry());
            wishMovieVO.setScore(movieMap.get(wishMovie.getMovieId()).getScore());
            wishMovieVO.setCategory(movieMap.get(wishMovie.getMovieId()).getCategory());
            wishMovieVO.setShowTime(DateUtil.date2String(movieMap.get(wishMovie.getMovieId()).getShowTime()));

            return wishMovieVO;
        }).collect(Collectors.toList());

        return ServerResponse.createServerResponseBySuccess(wishMovieVOList);
    }

    //查看 我的动态
    @Override
    public ServerResponse findMyPost(Long userId) {
        PostExample postExample = new PostExample();
        postExample.createCriteria()
                .andCreatorEqualTo(userId);
        postExample.setOrderByClause("create_time desc");

        List<Post> postList = postMapper.selectByExampleWithBLOBs(postExample);

        User user = userMapper.selectByPrimaryKey(userId);

        List<PostVO> postVOList = postList.stream().map(post -> {
            PostVO postVO = new PostVO();
            BeanUtils.copyProperties(post, postVO);
            postVO.setCreateTime(DateUtil.date2String(post.getCreateTime()));
            postVO.setUpdateTime(DateUtil.date2String(post.getUpdateTime()));
            postVO.setUserName(user.getUsername());
            postVO.setUserAvatar(user.getAvatarUrl());
            return postVO;
        }).collect(Collectors.toList());
        return ServerResponse.createServerResponseBySuccess(postVOList);
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
        ReviewExample reviewExample = new ReviewExample();
        reviewExample.createCriteria()
                .andCreatorEqualTo(userId);
        reviewExample.setOrderByClause("create_time desc");
        List<Review> reviewList = reviewMapper.selectByExampleWithBLOBs(reviewExample);

        Set<Long> targetMovie = reviewList.stream().map(review -> review.getMovieId()).collect(Collectors.toSet());
        List<Long> movieIds = new ArrayList<>();
        movieIds.addAll(targetMovie);

        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria()
                .andIdIn(movieIds);
        List<Movie> movies = movieMapper.selectByExample(movieExample);
        Map<Long, Movie> movieMap = movies.stream().collect(Collectors.toMap(movie -> movie.getId(), movie -> movie));

        List<ReviewVO> reviewVOList = reviewList.stream().map(review -> {
            ReviewVO reviewVO = new ReviewVO();
            BeanUtils.copyProperties(review, reviewVO);
            reviewVO.setCreateTime(DateUtil.date2String(review.getCreateTime()));
            reviewVO.setUpdateTime(DateUtil.date2String(review.getUpdateTime()));

            reviewVO.setMovieName(movieMap.get(review.getMovieId()).getMovieName());
            reviewVO.setMovieAvatar(movieMap.get(review.getMovieId()).getMovieAvatar());
            reviewVO.setDirector(movieMap.get(review.getMovieId()).getDirector());
            reviewVO.setActor(movieMap.get(review.getMovieId()).getActor());
            reviewVO.setCountry(movieMap.get(review.getMovieId()).getCountry());
            reviewVO.setScore(movieMap.get(review.getMovieId()).getScore());
            reviewVO.setCategory(movieMap.get(review.getMovieId()).getCategory());
            reviewVO.setShowTime(DateUtil.date2String(movieMap.get(review.getMovieId()).getShowTime()));

            return reviewVO;
        }).collect(Collectors.toList());
        return ServerResponse.createServerResponseBySuccess(reviewVOList);
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
}
