package life.drift.movie.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import life.drift.movie.common.Const;
import life.drift.movie.model.User;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
// 控制器下所有方法的返回值都是 Json
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

    //注册
    @RequestMapping(value = "user/register")
    public ServerResponse register(User user) {
        ServerResponse serverResponse = userService.registerLogic(user);
        return serverResponse;
    }

    //修改信息
    @RequestMapping(value = "user/update")
    public ServerResponse updateInfo(User user, HttpSession session) {
        //判断用户登录
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);

        user.setId(userInfo.getId());

        ServerResponse serverResponse = userService.updateInfoLogic(user);

        if (serverResponse.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, serverResponse.getData());
        }
        return serverResponse;
    }

    //查看个人信息
    @RequestMapping(value = "user/{userId}")
    public ServerResponse selectByUserId(HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = userService.selectByUserId(userInfo.getId());
        return serverResponse;
    }

    //查看 想看的电影 列表
    @RequestMapping(value = "user/wishmovie")
    public ServerResponse findWishMovie(HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = userService.findWishMovie(userInfo.getId());
        return serverResponse;
    }

    //查看 我的动态
    @RequestMapping(value = "user/mypost")
    public ServerResponse findMyPost(HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse myPost = userService.findMyPost(userInfo.getId());
        return myPost;
    }

    //删除我的动态
    @RequestMapping(value = "user/mypost/delete/{postId}")
    public ServerResponse deletePost(@PathVariable("postId") Long postId,
                                       HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = userService.deletePostById(postId, userInfo.getId());
        return serverResponse;
    }

    //查看 我的影评
    @RequestMapping(value = "user/myreview")
    public ServerResponse findMyReview(HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = userService.selectReviewByUserId(userInfo.getId());
        return serverResponse;
    }

    //删除我的影评
    @RequestMapping(value = "user/myreview/delete/{reviewId}")
    public ServerResponse deleteReview(@PathVariable("reviewId") Long reviewId,
                                       HttpSession session) {
        UserVO userInfo = (UserVO) session.getAttribute(Const.CURRENT_USER);
        ServerResponse serverResponse = userService.deleteReviewById(reviewId, userInfo.getId());
        return serverResponse;
    }
}
