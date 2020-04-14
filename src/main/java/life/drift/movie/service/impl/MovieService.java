package life.drift.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.drift.movie.common.IsWantedCheckEnum;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.MovieExtMapper;
import life.drift.movie.mapper.MovieMapper;
import life.drift.movie.mapper.WishMovieExtMapper;
import life.drift.movie.model.Movie;
import life.drift.movie.model.WishMovie;
import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.MovieVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.plugin.services.WIExplorerBrowserService;

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
