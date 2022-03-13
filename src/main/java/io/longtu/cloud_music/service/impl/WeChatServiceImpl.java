package io.longtu.cloud_music.service.impl;

import io.longtu.cloud_music.service.IWeChatService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.bean.oauth2.WxOAuth2AccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeChatServiceImpl implements IWeChatService {

    private WxMpService wxMpService;

    @Override
    public String generateAuthUrl(String redirectUrl) {
        return wxMpService.getOAuth2Service()
                .buildAuthorizationUrl(redirectUrl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
    }

    @Override
    public WxOAuth2UserInfo getUserInfo(String code) throws WxErrorException {
        WxOAuth2AccessToken wxOAuth2AccessToken = wxMpService.getOAuth2Service().getAccessToken(code);
        return wxMpService.getOAuth2Service().getUserInfo(wxOAuth2AccessToken, null);
    }

    @Autowired
    public void setWxMpService(WxMpService wxMpService) {
        this.wxMpService = wxMpService;
    }
}
