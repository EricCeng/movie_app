package life.drift.movie.service;

import life.drift.movie.model.Movie;
import life.drift.movie.model.Review;
import life.drift.movie.utils.ServerResponse;

public interface IMovieService {
    //查询正在上映的电影
    ServerResponse selectShowedMovie(Movie movie, Integer pageNum, Integer pageSize);

    //查询即将上映的电影
    ServerResponse selectUnShowedMovie(Movie movie, Integer pageNum, Integer pageSize);

    //查看电影信息
    ServerResponse selectMovieById(Long id);

    //搜索电影
    ServerResponse searchMovie(String keyword, Integer pageNum, Integer pageSize);

    //添加 想看的电影
    ServerResponse collectWishMovie(Long movieId, Long userId);

    //写影评
    ServerResponse addOrUpdateReview(Review review);

    //查看 电影相关影评
    ServerResponse selectReviewByMovieId(Long movieId);

    //查看 单条影评内容
    ServerResponse selectReviewById(Long id);

    //查看 电影榜单
    ServerResponse findMovieChart();

}
