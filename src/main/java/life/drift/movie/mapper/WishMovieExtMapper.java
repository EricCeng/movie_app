package life.drift.movie.mapper;

import life.drift.movie.model.WishMovie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WishMovieExtMapper {
    //添加想看电影
//    Integer collectWishMovie(@Param("movieId") Long movieId);
    int insert(WishMovie record);

    List<WishMovie> selectAll();
}
