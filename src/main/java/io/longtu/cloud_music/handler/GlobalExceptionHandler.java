package io.longtu.cloud_music.handler;

import io.longtu.cloud_music.exception.BizException;
import io.longtu.cloud_music.common.ServerResponse;
import io.longtu.cloud_music.common.ResponseType;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ServerResponse bizExceptionHandler(BizException e) {
        return ServerResponse.createByError(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = WxErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse wxErrorExceptionHandler(WxErrorException e) {
        return ServerResponse.createByError(
                ResponseType.WECHAT_ERROR.getCode(),
                ResponseType.WECHAT_ERROR.getMessage(),
                e
        );
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServerResponse methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        return ServerResponse.createByError(
                ResponseType.BAD_REQUEST.getCode(),
                e.getBindingResult().getFieldError().getDefaultMessage()
        );
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ServerResponse accessDeniedExceptionHandler() {
        return ServerResponse.createByError(
                ResponseType.FORBIDDEN.getCode(),
                ResponseType.FORBIDDEN.getMessage()
        );
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ServerResponse exceptionHandler() {
        return ServerResponse.createByError(
                ResponseType.INTERNAL_SERVER_ERROR.getCode(),
                ResponseType.INTERNAL_SERVER_ERROR.getMessage()
        );
    }
}
