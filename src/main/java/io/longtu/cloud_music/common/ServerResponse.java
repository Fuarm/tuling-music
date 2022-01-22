package io.longtu.cloud_music.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.io.Serializable;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    private ServerResponse(Integer code) {
        this.code = code;
    }

    private ServerResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ServerResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    private ServerResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse(ResponseType.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse(ResponseType.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse(ResponseType.SUCCESS.getCode(), ResponseType.SUCCESS.getMessage(), data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse(ResponseType.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> createByError(Integer code) {
        return new ServerResponse(code);
    }

    public static <T> ServerResponse<T> createByError(Integer code, String msg) {
        return new ServerResponse(code, msg);
    }

    public static <T> ServerResponse<T> createByError(Integer code, String msg, T data) {
        return new ServerResponse(code, msg, data);
    }
}
