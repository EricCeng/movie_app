package life.drift.movie.controller;

import life.drift.movie.model.Review;
import life.drift.movie.service.IFindService;
import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindController {

    @Autowired
    private IFindService findService;

    @Autowired
    private IMovieService movieService;

    //精选影评
    @RequestMapping(value = "/find/selectedReview")
    public ServerResponse findSelectedReview() {
        ServerResponse selectedReview = findService.findSelectedReview();
        return selectedReview;
    }

    //精选动态
    @RequestMapping(value = "/find/selectedPost")
    public ServerResponse findSelectedPost() {
        ServerResponse selectedPost = findService.findSelectedPost();
        return selectedPost;
    }

    //查看电影榜单 Top 250
    @RequestMapping(value = "/find/chart")
    public ServerResponse fidnMovieChart() {
        ServerResponse movieChart = movieService.findMovieChart();
        return movieChart;
    }
}
