package com.gunner.controller.accredit;

import com.alibaba.fastjson.JSONObject;
import com.gunner.config.StaticAttribute;
import com.gunner.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("wxAuth")
public class WechatAuthTokenAndReceiveMessageController {
    private static final Logger logger = LoggerFactory.getLogger(WechatAuthTokenAndReceiveMessageController.class);

    @RequestMapping("login")
    public String wechatlogin() {
        String backUrl = "http://www.wlga.com.cn/wxAuth/callBack";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?"
                + "appid=" + StaticAttribute.appid
                + "&redirect_uri=" + URLEncoder.encode(backUrl)
                + "&response_type=code"
                + "&scope=" + "snsapi_base"
                + "&state=STATE#wechat_redirect";
        return "redirect:" + url;
    }

    /**
     * 微信授权毁回调地址
     * @param code
     * @throws IOException
     */
    @RequestMapping(value = "callBack")
    public void callBack(String code) throws IOException {

        //获取access_token openid
        String url = " https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + StaticAttribute.appid +
                "&secret=" + StaticAttribute.secret +
                "&code=" + code +
                "&grant_type=authorization_code ";

        JSONObject jsonObject = CommonUtil.doGetJson(url);
        String accessToken = jsonObject.getString("access_token");
        String openId = jsonObject.getString("openid");
        System.out.println(jsonObject.toJSONString());

        //获取用户信息通过登录后返回的用户AccessToken
        String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                "access_token=" + accessToken +
                "&openid=" + openId +
                "&lang=zh_CN";
        //获取用户信息通过全局的AccessToken
        String userInfoUrl ="https://api.weixin.qq.com/cgi-bin/user/info?"
                + "access_token=" + StaticAttribute.AccessToken
                + "&openid=" + openId
                + "&lang=" + "zh_CN";
        JSONObject infoJsonObject = CommonUtil.doGetJson(url);
        System.out.println(infoJsonObject.toJSONString());
    }
}
