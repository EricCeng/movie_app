package life.drift.movie.mapper;

import life.drift.movie.model.*;
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

    //评论数
    Long incCommentCount(Review record);

    //计算影评数

    //计算评分总和
    Double avgScore(Long movieId);
}