package life.drift.movie.service;

import life.drift.movie.model.Post;
import life.drift.movie.utils.ServerResponse;

public interface IHomeService {

    //添加动态
    ServerResponse insert(String postContent, Long userId);

    //查看所有动态
    ServerResponse findPost();
}
