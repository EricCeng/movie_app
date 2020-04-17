package life.drift.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.drift.movie.common.IsWantedCheckEnum;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.*;
import life.drift.movie.model.Movie;
import life.drift.movie.model.Review;
import life.drift.movie.model.WishMovie;
import life.drift.movie.service.IMovieService;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.MovieVO;
import life.drift.movie.vo.ReviewListVO;
import life.drift.movie.vo.ReviewVO;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
    private IUserService userService;

    @Override
    public ServerResponse selectShowedMovie(Movie movie, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //最近 30 天上映的电影
        List<Movie> showedMovies = movieExtMapper.selectShowedMovie(movie);
        List<MovieVO> movieVOList = new ArrayList<>();

        for (Movie showedMovie : showedMovies) {
            MovieVO movieVO = convert(showedMovie);
            movieVOList.add(movieVO);
        }

        PageInfo pageInfo = new PageInfo(showedMovies);
        pageInfo.setList(movieVOList);
        return ServerResponse.createServerResponseBySuccess(pageInfo);
    }

    @Override
    public ServerResponse selectUnShowedMovie(Movie movie, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Movie> unShowedMovies = movieExtMapper.selectUnShowedMovie(movie);
        List<MovieVO> movieVOList = new ArrayList<>();

        for (Movie unShowedMovie : unShowedMovies) {
            MovieVO movieVO = convert(unShowedMovie);
            movieVOList.add(movieVO);
        }

        PageInfo pageInfo = new PageInfo(unShowedMovies);
        pageInfo.setList(movieVOList);

        return ServerResponse.createServerResponseBySuccess(pageInfo);
    }

    //查看电影信息
    @Override
    public ServerResponse selectMovieById(Long id) {
        if (id == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.MOVIE_NOT_FOUND.getCode(), ResponseErrorCode.MOVIE_NOT_FOUND.getMsg());
        }
        Movie selectMovie = movieMapper.selectByPrimaryKey(id);

        MovieVO convert = convert(selectMovie);
        return ServerResponse.createServerResponseBySuccess(convert);
    }

    //搜索电影
    @Override
    public ServerResponse searchMovie(String keyword, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        List<Movie> movieList = movieExtMapper.searchMovie(keyword);
        List<MovieVO> movieVOList = new ArrayList<>();

        for (Movie movie : movieList) {
            MovieVO movieVO = convert(movie);
            movieVOList.add(movieVO);
        }

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
    @Override
    public ServerResponse addReview(Long movieId, Long userId, String reviewContent) {
        Review review = new Review();
        review.setMovieId(movieId);
        review.setUserId(userId);
        review.setReviewContent(reviewContent);
        int result = reviewExtMapper.insert(review);
        if (result <= 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.ADD_FAIL.getCode(), ResponseErrorCode.ADD_FAIL.getMsg());
        }

        return ServerResponse.createServerResponseBySuccess();
    }

    //查看 电影相关影评
    @Override
    public ServerResponse selectReviewByMovieId(Long movieId) {
        ReviewListVO allReview = getAllReview(movieId);
        return ServerResponse.createServerResponseBySuccess(allReview);
    }

    public ReviewListVO getAllReview(Long movieId) {
        ReviewListVO reviewListVO = new ReviewListVO();
        List<Review> reviewList = reviewExtMapper.selectReviewByMovieId(movieId);

        List<ReviewVO> reviewVOList = new ArrayList();

        for (Review review : reviewList) {

            ReviewVO reviewVO = new ReviewVO();

            reviewVO.setId(review.getId());
            reviewVO.setMovieId(review.getMovieId());
            reviewVO.setIsSelected(review.getIsSelected());
            reviewVO.setReviewContent(review.getReviewContent());
            reviewVO.setReviewScore(review.getReviewScore());
            reviewVO.setCreateTime(DateUtil.date2String(review.getCreateTime()));
            reviewVO.setUpdateTime(DateUtil.date2String(review.getUpdateTime()));
            reviewVO.setCommentCount(review.getCommentCount());
            reviewVO.setLikeCount(review.getLikeCount());

            ServerResponse serverResponse = userService.selectByUserId(review.getUserId());
            UserVO userVO = (UserVO) serverResponse.getData();

            reviewVO.setUserId(review.getUserId());
            reviewVO.setUserName(userVO.getUsername());
            reviewVO.setUserAvatar(userVO.getAvatarUrl());

            reviewVOList.add(reviewVO);
        }

        reviewListVO.setReviewVOList(reviewVOList);
        return reviewListVO;
    }

    private MovieVO convert(Movie movie) {
        MovieVO movieVO = new MovieVO();
        movieVO.setId(movie.getId());
        movieVO.setMovieName(movie.getMovieName());
        movieVO.setMovieAvatar(movie.getMovieAvatar());
        movieVO.setDirector(movie.getDirector());
        movieVO.setActor(movie.getActor());
        movieVO.setMovieContent(movie.getMovieContent());
        movieVO.setCountry(movie.getCountry());
        movieVO.setScore(movie.getScore());
        movieVO.setCategory(movie.getCategory());
        movieVO.setMovieCreate(DateUtil.date2String(movie.getMovieCreate()));
        movieVO.setMovieModified(DateUtil.date2String(movie.getMovieModified()));
        movieVO.setShowTime(DateUtil.date2String(movie.getShowTime()));
        movieVO.setMovieTime(movie.getMovieTime());
        movieVO.setCommentCount(movie.getCommentCount());

        return movieVO;
    }
}
