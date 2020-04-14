package life.drift.movie.controller;

import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private IMovieService movieService;

    @RequestMapping({"/", "/index"})
    public ServerResponse searchMovie(@RequestParam(name = "keyword", required = false) String keyword,
                                      @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        ServerResponse serverResponse = movieService.searchMovie(keyword, pageNum, pageSize);
        return serverResponse;
    }
}
