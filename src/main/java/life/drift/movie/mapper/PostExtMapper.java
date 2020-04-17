package life.drift.movie.mapper;

import life.drift.movie.model.Post;

import java.util.List;

public interface PostExtMapper {
    int insert(Post record);
    List<Post> selectAll();

    List<Post> selectMyPost(Long userId);
}