package life.drift.movie.service;

import life.drift.movie.model.Movie;
import life.drift.movie.utils.ServerResponse;

public interface IMovieService {
    //查询正在上映的电影
    ServerResponse selectShowedMovie(Movie movie);

    //查询即将上映的电影
}
