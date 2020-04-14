package life.drift.movie.controller;

import life.drift.movie.model.Movie;
import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private IMovieService movieService;

    @RequestMapping(value = "movie/showed")
    public ServerResponse showedMovie(Movie movie){
        ServerResponse serverResponse = movieService.selectShowedMovie(movie);
        return serverResponse;
    }
}
