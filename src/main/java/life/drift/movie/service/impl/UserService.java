package life.drift.movie.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import life.drift.movie.exception.ResponseErrorCode;
import life.drift.movie.mapper.UserExtMapper;
import life.drift.movie.mapper.UserMapper;
import life.drift.movie.mapper.WishMovieExtMapper;
import life.drift.movie.mapper.WishMovieMapper;
import life.drift.movie.model.Movie;
import life.drift.movie.model.User;
import life.drift.movie.model.WishMovie;
import life.drift.movie.service.IMovieService;
import life.drift.movie.service.IUserService;
import life.drift.movie.utils.DateUtil;
import life.drift.movie.utils.MD5Util;
import life.drift.movie.utils.ServerResponse;
import life.drift.movie.vo.MovieVO;
import life.drift.movie.vo.UserVO;
import life.drift.movie.vo.WishMovieVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserExtMapper userExtMapper;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private WishMovieMapper wishMovieMapper;

    @Autowired
    private WishMovieExtMapper wishMovieExtMapper;

    //登录接口实现
    @Override
    public ServerResponse loginLogic(String username, String password) {
        //非空判断
        if (StringUtils.isBlank(username)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_EMPTY.getCode(), ResponseErrorCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(password)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PASSWORD_NOT_EMPTY.getCode(), ResponseErrorCode.PASSWORD_NOT_EMPTY.getMsg());
        }

        //查看用户名是否存在
        Integer count = userExtMapper.findByUsername(username);
        if (count == 0) {
            //用户名不存在
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_EXIST.getCode(), ResponseErrorCode.USERNAME_NOT_EXIST.getMsg());
        }

        //根据用户名和密码进行查询
        User user = userExtMapper.selectByUsernameAndPwd(username, MD5Util.getMD5Code(password));

        if (user == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PWD_ERROR.getCode(), ResponseErrorCode.PWD_ERROR.getMsg());
        }

        //返回结果

        return ServerResponse.createServerResponseBySuccess(convert(user));
    }

    private UserVO convert(User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setUsername(user.getUsername());
        userVO.setEmail(user.getEmail());
        userVO.setPhone(user.getPhone());
        userVO.setGmtCreate(DateUtil.date2String(user.getGmtCreate()));
        userVO.setGmtModified(DateUtil.date2String(user.getGmtModified()));
        userVO.setGender(user.getGender());
        userVO.setAvatarUrl(user.getAvatarUrl());

        return userVO;
    }

    //注册接口实现

    @Override
    public ServerResponse registerLogic(User user) {
        if (user == null) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PARAMETER_NOT_EMPTY.getCode(), ResponseErrorCode.PARAMETER_NOT_EMPTY.getMsg());
        }

        String username = user.getUsername();
        String password = user.getPassword();
        String gender = user.getGender();
        String phone = user.getPhone();
        String email = user.getEmail();

        //判断非空
        if (StringUtils.isBlank(username)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_NOT_EMPTY.getCode(), ResponseErrorCode.USERNAME_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(password)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PASSWORD_NOT_EMPTY.getCode(), ResponseErrorCode.PASSWORD_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(gender)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.GENDER_NOT_EMPTY.getCode(), ResponseErrorCode.GENDER_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(phone)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PHONE_NOT_EMPTY.getCode(), ResponseErrorCode.PHONE_NOT_EMPTY.getMsg());
        }
        if (StringUtils.isBlank(email)) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.EMAIL_NOT_EMPTY.getCode(), ResponseErrorCode.EMAIL_NOT_EMPTY.getMsg());
        }

        //判断存在
        Integer count = userExtMapper.findByUsername(username);
        if (count > 0) {
            //用户名已存在
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.USERNAME_EXIST.getCode(), ResponseErrorCode.USERNAME_EXIST.getMsg());
        }

        Integer phone_count = userExtMapper.findByPhone(phone);
        if (phone_count > 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.PHONE_EXIST.getCode(), ResponseErrorCode.PHONE_EXIST.getMsg());
        }

        Integer email_count = userExtMapper.findByEmail(email);
        if (email_count > 0) {
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.EMAIL_EXIST.getCode(), ResponseErrorCode.EMAIL_EXIST.getMsg());
        }

        //进行注册

        //密码加密
        user.setPassword(MD5Util.getMD5Code(user.getPassword()));

        Integer result = userMapper.insert(user);
        if (result == 0) {
            //注册失败
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.REGISTER_FAIL.getCode(), ResponseErrorCode.REGISTER_FAIL.getMsg());
        }

        return ServerResponse.createServerResponseBySuccess();

    }

    @Override
    public ServerResponse updateInfoLogic(User user) {

        int count = userExtMapper.updateByPrimaryKey(user);
        if (count == 0) {
            //修改失败
            return ServerResponse.createServerResponseByFail(ResponseErrorCode.UPDATE_FAIL.getCode(), ResponseErrorCode.UPDATE_FAIL.getMsg());
        }
        //修改成功后，将数据返回
        User updateUser = userMapper.selectByPrimaryKey(user.getId());
        UserVO userVO = convert(updateUser);

        return ServerResponse.createServerResponseBySuccess(userVO);
    }

    @Override
    public ServerResponse findWishMovie(Movie movie) {

        WishMovieVO wishMovieVO = getWishMovieVO();

        return ServerResponse.createServerResponseBySuccess(wishMovieVO);
    }

    public WishMovieVO getWishMovieVO() {
        WishMovieVO wishMovieVO = new WishMovieVO();
        List<WishMovie> wishMovieList = wishMovieExtMapper.selectAll();

        for (WishMovie wishMovie : wishMovieList) {
            wishMovieVO.setId(wishMovie.getId());
            wishMovieVO.setUserId(wishMovie.getUserId());
            wishMovieVO.setAddTime(DateUtil.date2String(wishMovie.getAddTime()));
            wishMovieVO.setUpdateTime(DateUtil.date2String(wishMovie.getUpdateTime()));
            wishMovieVO.setIsWanted(wishMovie.getIsWanted());

            //查询电影其他信息
            ServerResponse serverResponse = movieService.selectMovieById(wishMovie.getMovieId());
            MovieVO movieVO = (MovieVO) serverResponse.getData();

            wishMovieVO.setMovieId(wishMovie.getMovieId());
            wishMovieVO.setMovieName(movieVO.getMovieName());
            wishMovieVO.setMovieAvatar(movieVO.getMovieAvatar());
            wishMovieVO.setDirector(movieVO.getDirector());
            wishMovieVO.setActor(movieVO.getActor());
            wishMovieVO.setCountry(movieVO.getCountry());
            wishMovieVO.setScore(movieVO.getScore());
            wishMovieVO.setCategory(movieVO.getCategory());
            wishMovieVO.setShowTime(movieVO.getShowTime());

        }
        return wishMovieVO;
    }

}
