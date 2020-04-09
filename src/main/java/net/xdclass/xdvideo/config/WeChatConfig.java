package net.xdclass.xdvideo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:application.properties")
public class WeChatConfig {
    /**
     * 公众号appid
     */
    @Value("${wxpay.appid}")
    private String appId;
    /**
     * 公众号密钥
     */
    @Value("${wxpay.appsecret}")
    private String appsecret;
    /**
     * 开放平台Appid
     */
    @Value("${wxopen.appid}")
    private String openAppId;
    /**
     * 开放平台appsercret
     */
    @Value("${wxopen.appsecret}")
    private String openAppSecret;
    /**
     * 开放平台回调url
     */
    @Value("${wxopen.redirect_url}")
    private String openRedirectUrl;
    /**
     * 微信开放平台二维码连接
     */
    private final static String OPEN_QRCODE_URL= "https://open.weixin.qq.com/connect/qrconnect?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_login&state=%s#wechat_redirect";
    public String getOpenAppId ( ){
        return openAppId;
    }
    public static String getOpenQrcodeUrl ( ){
        return OPEN_QRCODE_URL;
    }
    public void setOpenAppId ( String openAppId ){
        this.openAppId=openAppId;
    }

    public String getOpenAppSecret ( ){
        return openAppSecret;
    }

    public void setOpenAppSecret ( String openAppSecret ){
        this.openAppSecret=openAppSecret;
    }

    public String getOpenRedirectUrl ( ){
        return openRedirectUrl;
    }

    public void setOpenRedirectUrl ( String openRedirectUrl ){
        this.openRedirectUrl=openRedirectUrl;
    }

    public String getAppId ( ){
        return appId;
    }

    public void setAppId ( String appId ){
        this.appId=appId;
    }

    public String getAppsecret ( ){
        return appsecret;
    }

    public void setAppsecret ( String appsecret ){
        this.appsecret=appsecret;
    }
}
