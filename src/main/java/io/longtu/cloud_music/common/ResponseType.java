package io.longtu.cloud_music.common;

import lombok.Getter;

@Getter
public enum ResponseType {

    SUCCESS(200, "请求成功"),
    BAD_REQUEST(400, "请求错误"),
    USER_NOT_EXIST(400101, "用户不存在"),
    USER_NAME_DUPLICATE(4000102, "用户名不可用"),
    USER_PASSWORD_NOT_MATCH(4000103, "用户名或密码错误"),
    MUSIC_NOT_FOUND(400201, "歌曲不存在"),
    UNAUTHORIZED(401, "未登录"),
    FORBIDDEN(403, "无权限"),
    NOT_FOUND(404, "未找到"),
    INTERNAL_SERVER_ERROR(500, "系统错误"),
    USER_NOT_ENABLED(500101, "用户未启用"),
    USER_LOCKED(500102, "用户被锁定"),
    WECHAT_ERROR(500201, "获取微信系统信息失败");

    private final Integer code;

    private final String message;

    ResponseType(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
