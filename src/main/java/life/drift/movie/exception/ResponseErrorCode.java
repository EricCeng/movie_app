package life.drift.movie.exception;

public enum ResponseErrorCode {
    //封装 异常
    USERNAME_NOT_EMPTY(1, "用户名不能为空哦！"),
    PASSWORD_NOT_EMPTY(2, "密码不能为空哦！"),
    USERNAME_NOT_EXIST(3, "此用户名不存在哦！"),
    PWD_ERROR(4, "输入的密码错误哦！"),
    PARAMETER_NOT_EMPTY(5, "请填写完整信息哦！"),
    GENDER_NOT_EMPTY(6, "性别不能为空哦！"),
    PHONE_NOT_EMPTY(7, "手机号不能为空哦！"),
    EMAIL_NOT_EMPTY(8, "邮箱不能为空哦！"),
    USERNAME_EXIST(9, "此用户名已被注册哦！"),
    PHONE_EXIST(10, "此手机号已被注册哦！"),
    EMAIL_EXIST(11, "此邮箱已被注册哦！"),
    REGISTER_FAIL(12, "抱歉！注册过程中出现故障了，请再次尝试！"),
    NOT_LOGIN(13, "抱歉！您还未登录哦！"),
    UPDATE_FAIL(14, "抱歉！修改过程中出现故障了，请再次尝试！"),
    MOVIE_NOT_FOUND(15, "抱歉！您所查找的电影不存在哦！"),
    ADD_FAIL(16, "抱歉！添加过程中出现故障了，请再次尝试！"),
    POST_FAIL(17, "抱歉！发布过程中出现故障了，请再次尝试！"),
    DELETE_FAIL(18, "抱歉！删除过程中出现故障了，请再次尝试！"),
    COMMENT_NOT_FOUND(19, "抱歉！此评论不存在，请重新选择！"),
    COMMENT_PARAM_WRONG(20, "抱歉！请您重新选择需要回复的动态、影评或评论哦！"),
    COMMENT_FAIL(21, "抱歉！评论过程中出现故障了，请再次尝试！"),
    POST_NOT_FOUND(22, "抱歉！此动态不存在哦，请重新选择！"),
    REVIEW_NOT_FOUND(23, "抱歉！此影评不存在哦，请重新选择！"),
    CONTENT_IS_EMPTY(24, "抱歉！内容不能为空哦！"),
    NOTIFICATION_IS_EMPTY(25, "您目前没有任何通知哦，快去分享内容和大家一起交流吧！"),
    NOTIFICATION_NOT_FOUND(26, "您的消息好像不见了？"),

    ;

    private Integer code;
    private String msg;

    ResponseErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
