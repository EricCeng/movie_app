package life.drift.movie.mapper;

import life.drift.movie.model.Movie;
import life.drift.movie.model.Review;
import life.drift.movie.model.ReviewExample;
import life.drift.movie.model.WishMovie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewExtMapper {
    //查看 电影相关影评
    List<Review> selectReviewByMovieId(@Param("movieId") Long movieId);

    //查看 我的影评
    List<Review> selectReviewByUserId(@Param("userId") Long userId);

    //添加影评
    int insert(Review record);

    //查看精选影评
    List<Review> findSelectedReview();

    //删除影评
    int deleteMyReview(@Param("id") Long id, @Param("userId") Long userId);
}