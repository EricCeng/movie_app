package life.drift.movie.mapper;

import life.drift.movie.model.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieExtMapper {
    List<Movie> selectShowedMovie(Movie movie);
}
