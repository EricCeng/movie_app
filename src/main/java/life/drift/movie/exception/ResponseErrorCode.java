package life.drift.movie.exception;

public enum ResponseErrorCode {
    //封装 异常
    USERNAME_NOT_NULL(1, "用户名不能为空哦！"),
    PASSWORD_NOT_NULL(2, "密码不能为空哦！"),
    USERNAME_NOT_EXIST(3, "此用户名不存在哦！"),
    PWD_ERROR(4, "输入的密码错误哦！"),
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
