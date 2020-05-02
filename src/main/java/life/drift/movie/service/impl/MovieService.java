package life.drift.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.drift.movie.common.IsWantedCheckEnum;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.*;
import life.drift.movie.model.*;
import life.drift.movie.service.IMovieService;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.MovieVO;
import life.drift.movie.vo.ReviewVO;
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
public class MovieService implements IMovieService {
    @Autowired
    private MovieExtMapper movieExtMapper;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private WishMovieExtMapper wishMovieExtMapper;

    @Autowired
    private ReviewExtMapper reviewExtMapper;

    @Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse selectShowedMovie(Movie movie, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //最近 30 天上映的电影
        List<Movie> showedMovies = movieExtMapper.selectShowedMovie(movie);
        List<MovieVO> movieVOList = showedMovies.stream().map(showedMovie -> {
            MovieVO movieVO = convert(showedMovie);
            return movieVO;
        }).collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo(showedMovies);
        pageInfo.setList(movieVOList);
        return ServerResponse.createServerResponseBySuccess(pageInfo);
    }

    @Override
    public ServerResponse selectUnShowedMovie(Movie movie, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Movie> unShowedMovies = movieExtMapper.selectUnShowedMovie(movie);
        List<MovieVO> movieVOList = unShowedMovies.stream().map(unshowedMovie -> {
            MovieVO movieVO = convert(unshowedMovie);
            return movieVO;
        }).collect(Collectors.toList());

        PageInfo pageInfo = new PageInfo(unShowedMovies);
        pageInfo.setList(movieVOList);

        return ServerResponse.createServerResponseBySuccess(pageInfo);
    }

    //查看电影信息
    @Override
    public ServerResponse selectMovieById(Long id) {

        Movie movie = movieMapper.selectByPrimaryKey(id);
        if (movie == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.MOVIE_NOT_FOUND.getCode(), ResponseErrorCode.MOVIE_NOT_FOUND.getMsg());
        }

        MovieVO convert = convert(movie);
        return ServerResponse.createServerResponseBySuccess(convert);
    }

    //搜索电影
    @Override
    public ServerResponse searchMovie(String keyword, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Movie> movieList = movieExtMapper.searchMovie(keyword);

        if (movieList.size() == 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.MOVIE_NOT_FOUND.getCode(), ResponseErrorCode.MOVIE_NOT_FOUND.getMsg());
        }

        List<MovieVO> movieVOList = movieList.stream().map(movie -> {
            MovieVO movieVO = convert(movie);
            return movieVO;
        }).collect(Collectors.toList());


        PageInfo pageInfo = new PageInfo(movieList);
        pageInfo.setList(movieVOList);

        return ServerResponse.createServerResponseBySuccess(pageInfo);
    }

    //添加想看的电影
    @Override
    public ServerResponse collectWishMovie(Long movieId, Long userId) {

        WishMovie wishMovie = new WishMovie();
        wishMovie.setMovieId(movieId);
        wishMovie.setUserId(userId);
        wishMovie.setIsWanted(IsWantedCheckEnum.MOVIE_WANTED.getCheck());

        int result = wishMovieExtMapper.insert(wishMovie);
        if (result <= 0) {
            //添加失败
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.ADD_FAIL.getCode(), ResponseErrorCode.ADD_FAIL.getMsg());
        }

        return ServerResponse.createServerResponseBySuccess();
    }

    //写影评
    @Transactional
    @Override
    public ServerResponse addOrUpdateReview(Review review) {

        Movie movie = movieMapper.selectByPrimaryKey(review.getMovieId());

        if (review.getId() == null) {
            review.setCommentCount(0L);
            review.setLikeCount(0L);
            int result = reviewExtMapper.insert(review);
            if (result <= 0) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.ADD_FAIL.getCode(), ResponseErrorCode.ADD_FAIL.getMsg());
            }
            movie.setCommentCount(1L);
            movieExtMapper.incCommentCount(movie);
        } else {
            Review updateReview = new Review();
            updateReview.setReviewContent(review.getReviewContent());
            updateReview.setReviewScore(review.getReviewScore());

            ReviewExample reviewExample = new ReviewExample();
            reviewExample.createCriteria()
                    .andIdEqualTo(review.getId());
            int i = reviewMapper.updateByExampleSelective(updateReview, reviewExample);
            if (i == 0) {
                return ServerResponse.createServerResponseByFail(ResponseErrorCode.UPDATE_FAIL.getCode(), ResponseErrorCode.UPDATE_FAIL.getMsg());
            }
        }

        Double avgScore = reviewExtMapper.avgScore(review.getMovieId());
        movie.setScore(avgScore);
        movieExtMapper.updateScore(movie);

        return ServerResponse.createServerResponseBySuccess();
    }

    //查看 电影相关影评
    @Override
    public ServerResponse selectReviewByMovieId(Long movieId) {
        ReviewExample reviewExample = new ReviewExample();
        reviewExample.createCriteria()
                .andMovieIdEqualTo(movieId);
        reviewExample.setOrderByClause("update_time desc");
        List<Review> reviewList = reviewMapper.selectByExampleWithBLOBs(reviewExample);

        if (reviewList.size() == 0) {
            return null;
        }
        Set<Long> creators = reviewList.stream().map(review -> review.getCreator()).collect(Collectors.toSet());
        List<Long> userIds = new ArrayList<>();
        userIds.addAll(creators);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(userIds);
        List<User> users = userMapper.selectByExample(userExample);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));

        List<ReviewVO> reviewVOList = reviewList.stream().map(review -> {
            ReviewVO reviewVO = new ReviewVO();
            BeanUtils.copyProperties(review, reviewVO);
            reviewVO.setCreateTime(DateUtil.date2String(review.getCreateTime()));
            reviewVO.setUpdateTime(DateUtil.date2String(review.getUpdateTime()));
            reviewVO.setUserName(userMap.get(review.getCreator()).getUsername());
            reviewVO.setUserAvatar(userMap.get(review.getCreator()).getAvatarUrl());
            return reviewVO;
        }).collect(Collectors.toList());

        return ServerResponse.createServerResponseBySuccess(reviewVOList);
    }

    //查看 单条影评内容
    @Override
    public ServerResponse selectReviewById(Long id) {
        Review review = reviewMapper.selectByPrimaryKey(id);
        if (review == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.REVIEW_NOT_FOUND.getCode(), ResponseErrorCode.REVIEW_NOT_FOUND.getMsg());
        }

        User user = userMapper.selectByPrimaryKey(review.getCreator());

        ReviewVO reviewVO = new ReviewVO();
        BeanUtils.copyProperties(review, reviewVO);
        reviewVO.setCreateTime(DateUtil.date2String(review.getCreateTime()));
        reviewVO.setUpdateTime(DateUtil.date2String(review.getUpdateTime()));
        reviewVO.setUserName(user.getUsername());
        reviewVO.setUserAvatar(user.getAvatarUrl());

        return ServerResponse.createServerResponseBySuccess(reviewVO);
    }

    //查看电影榜单 Top 250
    @Override
    public ServerResponse findMovieChart() {
        List<Movie> movieChart = movieExtMapper.movieChart();

        if (movieChart.size() == 0) {
            return null;
        }

        List<MovieVO> movieVOList = movieChart.stream().map(movie -> {
            MovieVO movieVO = new MovieVO();
            BeanUtils.copyProperties(movie, movieVO);
            movieVO.setMovieCreate(DateUtil.date2String(movie.getMovieCreate()));
            movieVO.setMovieModified(DateUtil.date2String(movie.getMovieModified()));
            movieVO.setShowTime(DateUtil.date2String(movie.getShowTime()));

            return movieVO;
        }).collect(Collectors.toList());

        return ServerResponse.createServerResponseBySuccess(movieVOList);
    }

    private MovieVO convert(Movie movie) {
        MovieVO movieVO = new MovieVO();
        BeanUtils.copyProperties(movie, movieVO);

        movieVO.setMovieCreate(DateUtil.date2String(movie.getMovieCreate()));
        movieVO.setMovieModified(DateUtil.date2String(movie.getMovieModified()));
        movieVO.setShowTime(DateUtil.date2String(movie.getShowTime()));


        return movieVO;
    }
}
