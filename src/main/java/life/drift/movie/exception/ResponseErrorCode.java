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
    UPDATE_FAIL(14, "抱歉！修改信息过程中出现故障了，请再次尝试！"),
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