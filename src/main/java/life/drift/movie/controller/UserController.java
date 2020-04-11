package life.drift.movie.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import life.drift.movie.common.Const;
import life.drift.movie.model.User;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
// 控制器下所有方法的返回值都是 Json
@RequestMapping(value = "/portal")
public class UserController {

    @Autowired
    private IUserService userService;

    //登录
    @RequestMapping(value = "/user/login")
    public ServerResponse<User> login(String username, String password, HttpSession session) {

        ServerResponse serverResponse = userService.loginLogic(username, password);
        if (serverResponse.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, serverResponse.getData());
        }
        return serverResponse;
    }
}
