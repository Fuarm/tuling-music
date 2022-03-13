package io.longtu.cloud_music.controller;


import io.longtu.cloud_music.common.ServerResponse;
import io.longtu.cloud_music.service.IWeChatService;
import io.swagger.annotations.Api;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/wechat")
@Api(tags = "微信相关接口")
public class WeChatController {

    private IWeChatService weChatService;

    @GetMapping("/auth_url")
    public ServerResponse<String> generateAuthUrl(@PathParam("redirectUrl") String redirectUrl) {
        return ServerResponse.createBySuccess(
                weChatService.generateAuthUrl(redirectUrl)
        );
    }

    @GetMapping("/user_info")
    public ServerResponse<WxOAuth2UserInfo> getUserInfo(@PathParam("code") String code) throws WxErrorException {
        return ServerResponse.createBySuccess(
                weChatService.getUserInfo(code)
        );
    }

    @Autowired
    public void setWeChatService(IWeChatService weChatService) {
        this.weChatService = weChatService;
    }
}
