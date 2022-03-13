package io.longtu.cloud_music.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeChatConfig {

    @Value("${wechat.mp.add-id}")
    private String appId;

    @Value("${wechat.mp.app-secret}")
    private String appSecret;

    @Bean
    WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        WxMpDefaultConfigImpl congfig = new WxMpDefaultConfigImpl();
        congfig.setAppId(appId);
        congfig.setSecret(appSecret);
        wxMpService.setWxMpConfigStorage(congfig);
        return wxMpService;
    }
}
