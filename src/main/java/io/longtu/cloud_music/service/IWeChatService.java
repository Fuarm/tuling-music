package io.longtu.cloud_music.service;

import me.chanjar.weixin.common.bean.WxOAuth2UserInfo;
import me.chanjar.weixin.common.error.WxErrorException;

public interface IWeChatService {

    String generateAuthUrl(String redirectUrl);

    WxOAuth2UserInfo getUserInfo(String code) throws WxErrorException;
}
