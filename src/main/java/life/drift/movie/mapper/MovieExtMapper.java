package life.drift.movie.mapper;

import life.drift.movie.model.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieExtMapper {
    List<Movie> selectShowedMovie(Movie movie);

    List<Movie> selectUnShowedMovie(Movie movie);

    //搜索电影
    List<Movie> searchMovie(@Param("keyword") String keyword);

    //电影榜单
    List<Movie> movieChart();

    //影评数
    int incCommentCount(Movie record);
}
