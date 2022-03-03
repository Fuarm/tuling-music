package io.longtu.cloud_music.controller;

import io.longtu.cloud_music.common.ServerResponse;
import io.longtu.cloud_music.model.dto.TokenCreateDto;
import io.longtu.cloud_music.service.ITokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
@Api(tags = "Token 管理")
public class TokenController {

    ITokenService tokenService;

    @PostMapping()
    @ApiOperation("创建 Token")
    public ServerResponse<String> create(@RequestBody TokenCreateDto tokenCreateDto) {
        return ServerResponse.createBySuccess(
                "创建Token：ok",
                tokenService.create(tokenCreateDto)
        );
    }

    @Autowired
    public void setTokenService(ITokenService tokenService) {
        this.tokenService = tokenService;
    }
}
