package life.drift.movie.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * 封装前端返回的统一实体类
 */
@Data
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> {
    private int status; // 0 表示接口调用成功
    private T data; // 将返回的数据封装到 data 中
    private String msg;

    private ServerResponse() {
    }

    public ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == 0;
    }

    public static <T> ServerResponse createServerResponseBySuccess() {
        return new ServerResponse();
    }

    public static <T> ServerResponse createServerResponseBySuccess(T data) {
        return new ServerResponse(0, data);
    }

    public static <T> ServerResponse createServerResponseBySuccess(T data, String msg) {
        return new ServerResponse(0, data, msg);
    }

    public static <T> ServerResponse createServerResponseByFail(int status) {
        return new ServerResponse(status);
    }

    public static <T> ServerResponse createServerResponseByFail(int status, String msg) {
        return new ServerResponse(status, null, msg);
    }
}
