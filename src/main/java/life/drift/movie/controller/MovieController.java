package life.drift.movie.controller;

import life.drift.movie.common.Const;
import life.drift.movie.model.Movie;
import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class MovieController {
    @Autowired
    private IMovieService movieService;

    //正在上映的电影（近 30 天）
    @RequestMapping(value = "movie/showed")
    public ServerResponse showedMovie(Movie movie,
                                      @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        ServerResponse serverResponse = movieService.selectShowedMovie(movie, pageNum, pageSize);
        return serverResponse;
    }

    //即将上映的电影
    @RequestMapping(value = "movie/unshowed")
    public ServerResponse unShowedMovie(Movie movie,
                                        @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        ServerResponse serverResponse = movieService.selectUnShowedMovie(movie, pageNum, pageSize);
        return serverResponse;
    }

    //查看电影信息
    @RequestMapping(value = "movie/{id}")
    public ServerResponse selectMovie(@PathVariable("id") Long id) {
        ServerResponse serverResponse = movieService.selectMovieById(id);
        return serverResponse;
    }

    //添加 想看的电影
    @RequestMapping(value = "movie/collectwish/{movieId}")
    public ServerResponse collectWishMovie(@PathVariable("movieId") Long movieId,
                                           HttpSession session) {
        UserVO userVO = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = movieService.collectWishMovie(movieId, userVO.getId());
        return serverResponse;
    }
}
