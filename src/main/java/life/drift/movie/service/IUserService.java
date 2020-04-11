package life.drift.movie.service;

import life.drift.movie.utils.ServerResponse;

public interface IUserService {
    //登录
    ServerResponse loginLogic(String username, String password);

    //注册
    ServerResponse register
}
