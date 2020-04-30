package life.drift.movie.controller;

import life.drift.movie.common.CommentTypeEnum;
import life.drift.movie.common.Const;
import life.drift.movie.model.Movie;
import life.drift.movie.model.Review;
import life.drift.movie.model.User;
import life.drift.movie.service.ICommentService;
import life.drift.movie.service.IMovieService;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.UserVO;
import org.apache.commons.lang3.builder.EqualsExclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class MovieController {
    @Autowired
    private IMovieService movieService;

    @Autowired
    private ICommentService commentService;

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

    //写影评
    @RequestMapping(value = "movie/add_review/{movieId}")
    public ServerResponse addReview(@PathVariable("movieId") Long movieId,
                                    HttpSession session,
                                    @RequestParam("reviewContent") String reviewContent,
                                    @RequestParam("reviewScore") Double reviewScore,
                                    @RequestParam(value = "id", required = false) Long id) {
        // “id” 在 修改影评时 需要获取到，若是添加新的影评则不用
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);

        Review review = new Review();
        review.setMovieId(movieId);
        review.setReviewContent(reviewContent);
        review.setCreator(userInfo.getId());
        review.setUserId(userInfo.getId());
        review.setReviewScore(reviewScore);
        review.setId(id);
        ServerResponse serverResponse = movieService.addOrUpdateReview(review);
        return serverResponse;
    }

    //查看电影相关影评
    @RequestMapping(value = "movie/allReview/{movieId}")
    public ServerResponse findReview(@PathVariable("movieId") Long movieId) {
        ServerResponse serverResponse = movieService.selectReviewByMovieId(movieId);
        return serverResponse;
    }

    //查看 单条影评内容
    @RequestMapping(value = "movie/eachReview/{id}")
    public ServerResponse selectReviewById(@PathVariable("id") Long id) {
        ServerResponse serverResponse = movieService.selectReviewById(id);
        return serverResponse;
    }

    //查看 影评评论
    @RequestMapping(value = "/comment/review/{id}")
    public ServerResponse selectPostComment(@PathVariable("id") Long id) {
        ServerResponse serverResponse = commentService.selectComment(id, CommentTypeEnum.REVIEW);
        return serverResponse;
    }
}
