package io.longtu.cloud_music.exception;

import io.longtu.cloud_music.common.ResponseType;

public class BizException extends RuntimeException {

    private final Integer code;

    public BizException(ResponseType exceptionType) {
        super(exceptionType.getMessage());
        this.code = exceptionType.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
