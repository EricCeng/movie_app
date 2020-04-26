package life.drift.movie.mapper;

import life.drift.movie.model.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostExtMapper {
    int insert(Post record);
    List<Post> selectAll();

    List<Post> selectMyPost(Long userId);

    //查看精选动态
    List<Post> findSelectedPost();

    //删除动态
    int deleteMyPost(@Param("id") Long id, @Param("userId") Long userId);
}