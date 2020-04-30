package life.drift.movie.service;

import life.drift.movie.model.Movie;
import life.drift.movie.model.Review;
import life.drift.movie.model.User;
import life.drift.movie.utils.ServerResponse;

public interface IUserService {
    //登录
    ServerResponse loginLogic(String username, String password);

    //注册
    ServerResponse registerLogic(User user);

    //修改信息
    ServerResponse updateInfoLogic(User user);

    //查询用户信息
    ServerResponse selectByUserId(Long userId);

    //查看想看的电影列表
    ServerResponse findWishMovie(Long userId);

    //查看 我的动态
    ServerResponse findMyPost(Long userId);

    //删除动态
    ServerResponse deletePostById(Long postId, Long userId);

    //查看 我的影评
    ServerResponse selectReviewByUserId(Long userId);

    //删除影评
    ServerResponse deleteReviewById(Review review);

//    //查看单条影评
//    ServerResponse selectReviewById(Long postId);
}
