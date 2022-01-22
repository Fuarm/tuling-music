package io.longtu.cloud_music.common;

import lombok.Getter;

@Getter
public enum ResponseType {

    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "请求错误"),
    USER_NOT_EXIST(400100, "用户不存在"),
    UNAUTHORIZED(401, "未登录"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "未找到"),
    INTERNAL_SERVER_ERROR(500, "系统错误");

    private final Integer code;

    private final String message;

    ResponseType(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
