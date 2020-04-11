package life.drift.movie.service.impl;

import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.UserExtMapper;
import life.drift.movie.model.User;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserExtMapper userExtMapper;

    //登录接口实现
    @Override
    public ServerResponse loginLogic(String username, String password) {
        //非空判断
        if (username == null || username.equals("")) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_NULL.getCode(), ResponseErrorCode.USERNAME_NOT_NULL.getMsg());
        }
        if (password == null || password.equals("")) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PASSWORD_NOT_NULL.getCode(), ResponseErrorCode.PASSWORD_NOT_NULL.getMsg());
        }

        //查看用户名是否存在
        Integer count = userExtMapper.findByUsername(username);
        if (count == 0) {
            //用户名不存在
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_EXIST.getCode(), ResponseErrorCode.USERNAME_NOT_EXIST.getMsg());
        }

        //根据用户名和密码进行查询
        User user = userExtMapper.selectByUsernameAndPwd(username, password);

        if (user == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PWD_ERROR.getCode(), ResponseErrorCode.PWD_ERROR.getMsg());
        }

        //返回结果
        return ServerResponse.createServerResponseBySuccess(user);
    }

    //注册接口实现

}
