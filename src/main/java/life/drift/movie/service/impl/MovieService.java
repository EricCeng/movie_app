package life.drift.movie.service.impl;

import life.drift.movie.mapper.MovieExtMapper;
import life.drift.movie.model.Movie;
import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private MovieExtMapper movieExtMapper;

    @Override
    public ServerResponse selectShowedMovie(Movie movie) {
        List<Movie> movieList = movieExtMapper.selectShowedMovie(movie);
        return ServerResponse.createServerResponseBySuccess(movieList);
    }
}
