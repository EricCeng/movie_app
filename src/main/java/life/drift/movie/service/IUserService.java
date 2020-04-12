package life.drift.movie.service;

import life.drift.movie.model.User;
import life.drift.movie.utils.ServerResponse;

public interface IUserService {
    //登录
    ServerResponse loginLogic(String username, String password);

    //注册
    ServerResponse registerLogic(User user);

    //修改信息
    ServerResponse updateInfoLogic(User user);
}
