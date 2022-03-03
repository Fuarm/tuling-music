package io.longtu.cloud_music.exception;

import cn.hutool.json.JSONUtil;
import io.longtu.cloud_music.common.ResponseType;
import io.longtu.cloud_music.common.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        ServerResponse serverResponse = ServerResponse.createByError(
                ResponseType.UNAUTHORIZED.getCode(),
                ResponseType.UNAUTHORIZED.getMessage()
        );
        response.getWriter().println(JSONUtil.parse(serverResponse));
        response.getWriter().flush();
    }
}

